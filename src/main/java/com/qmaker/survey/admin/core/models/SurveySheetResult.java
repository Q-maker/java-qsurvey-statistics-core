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
    public String id, surveyResultId, authorId, authorDisplayName;
    public boolean composed, prospected;
    public int propositionCount, answerMaxSuccessCount, answerSuccessCount,
            answerFailedCount, score, marks, maxMars, marksAddedCount,
            marksSubtractedCount;
    public long elapsedTime, totalTimeAllowed;
    HashMap<String, String> extras;
    HashMap<String, Boolean> selectedAnswerState = new HashMap<>();
    HashMap<String, Boolean> successAnswerState = new HashMap<>();

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

        this.totalTimeAllowed = sheet.getExtra(CopySheet.Sheet.EXTRA_TIME_ALLOWED, Integer.class);
        this.score = sheet.getExtra(CopySheet.EXTRA_SCORE, Integer.class);
        this.marks = sheet.getExtra(CopySheet.EXTRA_MARKS, Integer.class);
        this.maxMars = sheet.getExtra(CopySheet.EXTRA_MAX_MARKS, Integer.class);
        this.elapsedTime = sheet.getExtra(Exercise.EXTRA_ELAPSED_TIME, Integer.class);
        if (sheet.hasExtras()) {
            this.extras = new HashMap();
            for (String key : sheet.getExtras().keySet()) {
                this.extras.put(key, sheet.getStringExtra(key));
            }
        }
        List<Qcm.Proposition> examineAnswer = QcmUtils.getPropositionsWithTruth(sheet, true);
        this.answerMaxSuccessCount = examineAnswer.size();

//        if (config.isRandomEnable() && qcm.isPropositionRandomizable()) {
//
//        } else {
        int index = 0;
        Qcm.Proposition originalProposition;
        for (Qcm.Proposition proposition : sheet.getPropositions()) {
            originalProposition = qcm.getProposition(index);
            this.successAnswerState.put(originalProposition.toString(), proposition.sameAs(originalProposition));
            this.selectedAnswerState.put(originalProposition.toString(), proposition.getTruth());
            index++;
//            }
        }


    }
}
