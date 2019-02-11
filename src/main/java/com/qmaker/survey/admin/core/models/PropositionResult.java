package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.Qcm;

public class PropositionResult {
    boolean selected, truth;
    int value, points;

    PropositionResult() {

    }

    public PropositionResult(Qcm.Proposition submitted, Qcm.Proposition original) {
        this.selected = submitted.getTruth();
        this.truth = original.getTruth();
        this.value = (truth ? 1 : 0) | (selected ? 2 : 0);
        //TODO s'assurer qu'il est possble de configurer la note maw et min
        this.points = submitted.sameAs(original) ? original.getExtras().getInt(Qcm.Proposition.EXTRA_POINTS, 1) : original.getExtras().getInt(Qcm.Proposition.EXTRA_POINTS, 0);
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
