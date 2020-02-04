package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Qcm;

import java.util.Map;

import istat.android.base.tools.TextUtils;

public class PropositionResult {
    boolean selected, truth;
    int value;
    String description;

    PropositionResult() {

    }

    public PropositionResult(Qcm.Proposition submitted) {
        this.selected = submitted.getTruth();
        this.truth = submitted.getExtras().getBoolean(CopySheet.Sheet.EXTRA_PROPOSITION_TRUTH, false);
        this.value = (truth ? 1 : 0) | (selected ? 2 : 0);
        if (!TextUtils.isEmpty(submitted.getLabel())) {
            this.description = submitted.getLabel();
        } else {
            this.description = submitted.getSignature() + "";
        }
    }

    public String getDescription() {
        return description;
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

}
