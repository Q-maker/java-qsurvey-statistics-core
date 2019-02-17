package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.Author;
import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Test;
import com.qmaker.core.utils.Bundle;

//TODO voir si il serait judicieux de a travers une petite magouille, exposer le displayName remplis dans la Survey.Form
public class SurveyResult {
    //TODO voire dans quel mesure le this doit contenir le component supporté qui a joué ce questionnaire.
    String id, collectId, questionnaireId, copySheetId, authorId, authorDisplayName, readerName;
    int composedQuestionCount, prospectedQuestionCount, totalQuestionCount,
            successCount, maxSuccessCount, failedCount, score, marks, maxMarks, pointAddedCount, pointSubtractedCount;
    long elapsedTime, allowedTime, timeLeft;
    boolean questionnaireRandomized;

    public SurveyResult() {

    }

    public SurveyResult(CopySheet copySheet) {
        this.id = copySheet.getId();//TODO revoir quel est le meilleur ID a donne ra cet entité.
        this.copySheetId = copySheet.getId();
        this.elapsedTime = copySheet.getElapsedTime();
        this.readerName = copySheet.getStringExtra(Test.EXTRA_READER_NAME);
        this.allowedTime = copySheet.getAllowedTime();
        this.timeLeft = copySheet.getTimeLeft();
        this.questionnaireId = copySheet.getQuestionnaireId();
        this.questionnaireRandomized = copySheet.isQuestionnaireRandomized();
        this.totalQuestionCount = copySheet.getSheetCount();
        Bundle copySheetExtras = copySheet.getExtras();
        this.successCount = copySheetExtras.getInt(CopySheet.EXTRA_SUCCESS_COUNT);
        this.failedCount = copySheetExtras.getInt(CopySheet.EXTRA_FAILED_COUNT);
        this.maxSuccessCount = copySheetExtras.getInt(CopySheet.EXTRA_MAX_SUCCESS_COUNT);

        this.score = copySheetExtras.getInt(CopySheet.EXTRA_SCORE);
        this.marks = copySheetExtras.getInt(CopySheet.EXTRA_MARKS);
        this.maxMarks = copySheetExtras.getInt(CopySheet.EXTRA_MAX_MARKS);

        this.pointAddedCount = copySheetExtras.getInt(CopySheet.EXTRA_POINTS_ADDED);
        this.pointSubtractedCount = copySheetExtras.getInt(CopySheet.EXTRA_POINTS_SUBTRACTED);

        this.prospectedQuestionCount = copySheet.getProspectedExerciseCount();
        this.composedQuestionCount = copySheet.getComposedExerciseCount();
        Author author = copySheet.getAuthor();
        if (author != null) {
            this.authorId = author.getId();
            this.authorDisplayName = author.getDisplayName();
        }
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public boolean isTimeOut() {
        return elapsedTime >= allowedTime;
    }

    public String getId() {
        return id;
    }

    public boolean isQuestionnaireRandomized() {
        return questionnaireRandomized;
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

    public int getPointAddedCount() {
        return pointAddedCount;
    }

    public int getPointSubtractedCount() {
        return pointSubtractedCount;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public long getAllowedTime() {
        return allowedTime;
    }
}
