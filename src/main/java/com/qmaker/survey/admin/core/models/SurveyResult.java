package com.qmaker.survey.admin.core.models;

public class SurveyResult {
    //TODO voire dans quel mesure le result doit contenir le component supporté qui a joué ce questionnaire.
    public String id, collectId, questionnaireId, copySheetId, authorId, authorDisplayName, readerName;
    public int composedQuestionCount, prospectedQuestionCount, totalQuestionCount,
            successCount, maxSuccessCount, failedCount, score, marks, maxMarks, marksAddedCount, marksSubtractedCount;
    public long elapsedTime, totalAllowedTime;

    public boolean isTimeOut() {
        return elapsedTime >= totalAllowedTime;
    }

    public String getId() {
        return id;
    }

    public String getCollectId() {
        return collectId;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public String getCopySheetId() {
        return copySheetId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public String getReaderName() {
        return readerName;
    }

    public int getComposedQuestionCount() {
        return composedQuestionCount;
    }

    public int getProspectedQuestionCount() {
        return prospectedQuestionCount;
    }

    public int getTotalQuestionCount() {
        return totalQuestionCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getMaxSuccessCount() {
        return maxSuccessCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public int getScore() {
        return score;
    }

    public int getMarks() {
        return marks;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public int getMarksAddedCount() {
        return marksAddedCount;
    }

    public int getMarksSubtractedCount() {
        return marksSubtractedCount;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public long getTotalAllowedTime() {
        return totalAllowedTime;
    }
}
