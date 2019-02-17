package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Exercise;
import com.qmaker.core.entities.Qcm;
import com.qmaker.core.utils.Bundle;

import java.util.HashMap;
import java.util.Map;

import istat.android.base.tools.TextUtils;

public class SurveySheetResult {
    String qcmId;
    String id, surveyResultId, authorId, authorDisplayName, questionDescription;
    boolean composed, prospected;
    int propositionCount, maxSuccessCount, successCount,
            failedCount, score, marks, maxMars;
    long elapsedTime, totalTimeAllowed;
    HashMap<String, String> extras;
    HashMap<String, PropositionResult> propositionResults = new HashMap<>();

    SurveySheetResult() {

    }

    public SurveySheetResult(SurveyResult result, CopySheet.Sheet sheet) {
        this.surveyResultId = result.id;
        this.authorId = result.authorId;
        this.authorDisplayName = result.authorDisplayName;
        this.composed = sheet.composed;
        this.prospected = sheet.prospected;
        this.propositionCount = sheet.getPropositionCount();
        this.qcmId = sheet.getId();

        this.totalTimeAllowed = sheet.getExtras().getInt(Qcm.EXTRA_ALLOWED_TIME, 0);
        this.score = sheet.getExtras().getInt(CopySheet.EXTRA_SCORE, 0);
        this.marks = sheet.getExtras().getInt(CopySheet.EXTRA_MARKS, 0);
        this.maxMars = sheet.getExtras().getInt(CopySheet.EXTRA_MAX_MARKS, 0);
        this.elapsedTime = sheet.getExtras().getLong(Exercise.EXTRA_ELAPSED_TIME, 0);
        Bundle sheetExtras = sheet.getExtras();
        if (sheet.hasExtras()) {
            this.extras = new HashMap(sheetExtras);
        }
        //TODO il ya un cas particulier ou une personne peut renseigner plusieurs proposition avec le même labael, et des valeur de vérité différente.
        //Cela a pour cause que les deux Proposition ont même signature mais n'ont pas la même valeur de vérité.
        for (Qcm.Proposition submittedProposition : sheet.getPropositions()) {
            this.propositionResults.put(submittedProposition.getSignature() + "", new PropositionResult(submittedProposition));
        }
        this.maxSuccessCount = sheetExtras.getInt(CopySheet.EXTRA_MAX_SUCCESS_COUNT);
        this.successCount = sheetExtras.getInt(CopySheet.EXTRA_SUCCESS_COUNT);
        this.failedCount = sheetExtras.getInt(CopySheet.EXTRA_FAILED_COUNT);

        if (!TextUtils.isEmpty(sheet.getQuestion().getLabel())) {
            this.questionDescription = sheet.getQuestion().getLabel();
        } else if (!sheet.getUriMap().isEmpty()) {
            for (Map.Entry<String, String> entry : sheet.getUriMap().entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    this.questionDescription = entry.getKey() + ">" + entry.getValue();
                    return;
                }
            }
        }
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public String getId() {
        return id;
    }

    public String getSurveyResultId() {
        return surveyResultId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public boolean isComposed() {
        return composed;
    }

    public boolean isProspected() {
        return prospected;
    }

    public int getPropositionCount() {
        return propositionCount;
    }

    public int getMaxSuccessCount() {
        return maxSuccessCount;
    }

    public int getSuccessCount() {
        return successCount;
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

    public int getMaxMars() {
        return maxMars;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public long getTotalTimeAllowed() {
        return totalTimeAllowed;
    }

    public HashMap<String, String> getExtras() {
        return extras;
    }

    public HashMap<String, PropositionResult> getPropositionResults() {
        return propositionResults;
    }

}
