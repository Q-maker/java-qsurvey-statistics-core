package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.CopySheet;

public class SurveyResult {
    //TODO voire dans quel mesure le result doit contenir le component supporté qui a joué ce questionnaire.
    public String id, campaingId, copySheetId, authorId, authorFullName, readerName;
    public int composedQuestionCount, consultedQuestionCount, totalQuestionCount,
            successCount, maxSucessCount, faildCount, score, marks, maxMarks, marksAddedCount, marksSubstractedCount;
    public long timePast, totalAllowedTime;
    CopySheet copySheet;

    public boolean isTimeOut() {
        return timePast >= totalAllowedTime;
    }

    public SurveyResult from(CopySheet copySheet) {
        return null;
    }
}
