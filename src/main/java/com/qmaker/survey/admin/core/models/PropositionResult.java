package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.Qcm;

import java.util.Map;

import istat.android.base.tools.TextUtils;

public class PropositionResult {
    boolean selected, truth;
    int value, points;
    String description;

    PropositionResult() {

    }

    public PropositionResult(Qcm.Proposition submitted, Qcm.Proposition original) {
        this.selected = submitted.getTruth();
        this.truth = original.getTruth();
        this.value = (truth ? 1 : 0) | (selected ? 2 : 0);
        //TODO s'assurer qu'il est possble de configurer la note maw et min
        this.points = submitted.sameAs(original) ? original.getExtras().getInt(Qcm.Proposition.EXTRA_POINTS, 1) : original.getExtras().getInt(Qcm.Proposition.EXTRA_POINTS, 0);
        if (!TextUtils.isEmpty(submitted.getLabel())) {
            this.description = submitted.getLabel();
        }
//        else if (!submitted.getUriMap().isEmpty()) {
//            for (Map.Entry<String, String> entry : submitted.getUriMap().entrySet()) {
//                if (!TextUtils.isEmpty(entry.getValue())) {
//                    this.description = entry.getKey() + ">" + entry.getValue();
//                    return;
//                }
//            }
//        }
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isTruth() {
        return truth;
    }

    public int getValue() {
        return value;
    }

    public int getPoints() {
        return points;
    }

}
