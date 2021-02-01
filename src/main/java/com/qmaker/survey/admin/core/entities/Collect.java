package com.qmaker.survey.admin.core.entities;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.interfaces.IDHolder;

public class Collect implements IDHolder {
    String id;
    Participant participant;
    CopySheet copySheet;

    Collect() {

    }

    public Collect(String id, Participant participant, CopySheet copySheet) {
        this.id = id;
        this.participant = participant;
        this.copySheet = copySheet;
    }

    public CopySheet getCopySheet() {
        return copySheet;
    }

    public Participant getParticipant() {
        return participant;
    }

    @Override
    public String getId() {
        return id;
    }
}
