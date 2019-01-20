package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.CopySheet;

import java.util.HashMap;

public class SurveySheetResult {
    //TODO doit t'il contenir aussi le nm du reader et le coosant utilisé pour le jouer?
    public String id, suveyResultId, questionId, authorId, authorFullName;
    public boolean composedState, consultedState;
    public int propsitionCount, answerMaxSuccessCount, answerSuccessCount,
            answserFaiedCount, score, marks, maxMars, marksAddedCount,
            marksSubstractedCount;
    public long timePast, totalTimeAllowed;

    HashMap<String, Boolean> selectedAnswerState = new HashMap<>();
    HashMap<String, Boolean> successAnswerState = new HashMap<>();

    public SurveyResult from(CopySheet copySheet) {
        return null;
    }

}
