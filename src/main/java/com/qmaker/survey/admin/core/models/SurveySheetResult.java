package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Exercise;
import com.qmaker.core.entities.QSummary;
import com.qmaker.core.entities.Qcm;
import com.qmaker.core.utils.QcmUtils;

import java.util.HashMap;
import java.util.List;

public class SurveySheetResult {
    int questionSignature;
    public  String id, surveyResultId, authorId, authorDisplayName;
    public boolean composed, prospected;
    public int propositionCount, answerMaxSuccessCount, answerSuccessCount,
            answerFailedCount, score, marks, maxMars, pointAddedCount,
            pointSubtractedCount;
    public long elapsedTime, totalTimeAllowed;
    HashMap<String, String> extras;
    HashMap<String, PropositionResult> propositionResults = new HashMap<>();

    SurveySheetResult() {

    }

    public SurveySheetResult(QSummary.Config config, SurveyResult result, CopySheet.Sheet sheet, Qcm qcm) {
        this.questionSignature = sheet.getQuestion().getSignature();
        this.surveyResultId = result.id;
        this.authorId = result.authorId;
        this.authorDisplayName = result.authorDisplayName;
        this.composed = sheet.composed;
        this.prospected = sheet.prospected;
        this.propositionCount = sheet.getPropositionCount();

        this.totalTimeAllowed = sheet.getExtras().getInt(CopySheet.Sheet.EXTRA_TIME_ALLOWED, 0);
        this.score = sheet.getExtras().getInt(CopySheet.EXTRA_SCORE, 0);
        this.marks = sheet.getExtras().getInt(CopySheet.EXTRA_MARKS, 0);
        this.maxMars = sheet.getExtras().getInt(CopySheet.EXTRA_MAX_MARKS, 0);
        this.elapsedTime = sheet.getExtras().getLong(Exercise.EXTRA_ELAPSED_TIME, 0);
        if (sheet.hasExtras()) {
            this.extras = new HashMap();
            for (String key : sheet.getExtras().keySet()) {
                this.extras.put(key, sheet.getStringExtra(key));
            }
        }
        List<Qcm.Proposition> examineAnswer = QcmUtils.getPropositionsWithTruth(sheet, true);

        int index = 0;
        Qcm.Proposition originalProposition;
        for (Qcm.Proposition submittedProposition : sheet.getPropositions()) {
            originalProposition = qcm.getProposition(index);
            this.propositionResults.put(originalProposition.getSignature() + "", new PropositionResult(submittedProposition, originalProposition));
            index++;
        }
        this.answerMaxSuccessCount = examineAnswer.size();
    }

    public int getQuestionSignature() {
        return questionSignature;
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

    public int getAnswerMaxSuccessCount() {
        return answerMaxSuccessCount;
    }

    public int getAnswerSuccessCount() {
        return answerSuccessCount;
    }

    public int getAnswerFailedCount() {
        return answerFailedCount;
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

    public int getPointAddedCount() {
        return pointAddedCount;
    }

    public int getPointSubtractedCount() {
        return pointSubtractedCount;
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
