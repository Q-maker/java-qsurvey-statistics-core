package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Qcm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveySheetResult {
    //TODO doit t'il contenir aussi le nm du reader et le coosant utilisé pour le jouer?
    public String id, suveyResultId, questionId, authorId, authorFullName;
    public boolean composedState, consultedState;
    public int propsitionCount, answerMaxSuccessCount, answerSuccessCount,
            answserFaiedCount, score, marks, maxMars, marksAddedCount,
            marksSubtractedCount;
    public long timePast, totalTimeAllowed;

    HashMap<String, Boolean> selectedAnswerState = new HashMap<>();
    HashMap<String, Boolean> successAnswerState = new HashMap<>();

    public static SurveySheetResult from(Qcm qcm) {
        return null;
    }

    public static List<SurveySheetResult> list(CopySheet copySheet) {
        List<SurveySheetResult> results = new ArrayList<>();
        List<Qcm> sheets = copySheet.getSheets();
        SurveySheetResult result;
        for (Qcm sheet : sheets) {
            result = from(sheet);
            if (result != null) {
                results.add(result);
            }
        }
        return results;
    }
}
