package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.Author;
import com.qmaker.core.entities.CopySheet;

public class SurveyResult {
    //TODO voire dans quel mesure le result doit contenir le component supporté qui a joué ce questionnaire.
    public String id, campaignId, copySheetId, authorId, authorDisplayName, readerName;
    public int composedQuestionCount, consultedQuestionCount, totalQuestionCount,
            successCount, maxSuccessCount, failedCount, score, marks, maxMarks, marksAddedCount, marksSubtractedCount;
    public long timeLeft, totalAllowedTime;
    CopySheet copySheet;

    public boolean isTimeOut() {
        return timeLeft >= totalAllowedTime;
    }

    public String getId() {
        return id;
    }

    public String getCampaignId() {
        return campaignId;
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

    public int getConsultedQuestionCount() {
        return consultedQuestionCount;
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

    public long getTimeLeft() {
        return timeLeft;
    }

    public long getTotalAllowedTime() {
        return totalAllowedTime;
    }

    public CopySheet getCopySheet() {
        return copySheet;
    }

    public static SurveyResult from(String campaignId, CopySheet copySheet) {
        SurveyResult result = new SurveyResult();
        result.id = copySheet.getId();//TODO revoir quel est le meilleur ID a donne ra cet entité.
        result.campaignId = campaignId;
        result.copySheetId = copySheet.getId();
        Author author = copySheet.getAuthor();
        if (author != null) {
            result.authorId = author.getId();
            result.authorDisplayName = author.getDisplayName();
        }
        result.copySheet = copySheet;
        return result;
    }
}
