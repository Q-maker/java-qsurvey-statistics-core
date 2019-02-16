package com.qmaker.survey.admin.core.models;

import com.qmaker.core.engines.Component;
import com.qmaker.core.entities.Author;
import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Qcm;
import com.qmaker.core.entities.Questionnaire;
import com.qmaker.core.utils.Bundle;
import com.qmaker.core.utils.QcmUtils;
import com.qmaker.survey.core.entities.Survey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO trouver une meilleur structure pour la class de collecte.
public class Collect {
    final static String TEST_EXTRA_READER_NAME = "qmaker_reader_name";
    String id, campaignId, questionnaireId;
    HashMap<String, String> form;
    HashMap<String, String> extras;
    SurveyResult result;
    HashMap<String, SurveySheetResult> sheetResults;
    long lastModified = System.currentTimeMillis();
    String rawData;

    Collect() {

    }

    public Collect(String collectId, SurveyResult result, HashMap<String, SurveySheetResult> surveySheetResults) {
        this.result = result;
        this.result.collectId = collectId;
        this.sheetResults = surveySheetResults;
        this.id = collectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public long notifyModified() {
        this.lastModified = System.currentTimeMillis();
        return this.lastModified;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public SurveyResult getResult() {
        return result;
    }

    public HashMap<String, SurveySheetResult> getSheetResults() {
        return sheetResults;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public HashMap<String, String> getForm() {
        return form;
    }

    public HashMap<String, String> getExtras() {
        return new HashMap(extras);
    }

    public String getRawData() {
        return rawData;
    }

    public static Collect from(Campaign campaign, Questionnaire questionnaire, CopySheet copySheet) {
        return from(campaign.getId(), questionnaire, copySheet);
    }

    public static Collect from(String campaignId, Questionnaire questionnaire, CopySheet copySheet) {
        SurveyResult result = new SurveyResult();
        HashMap<String, SurveySheetResult> surveySheetResults = new HashMap();
        result.id = copySheet.getId();//TODO revoir quel est le meilleur ID a donne ra cet entité.
        result.copySheetId = copySheet.getId();
        result.elapsedTime = copySheet.getElapsedTime();
        result.readerName = copySheet.getStringExtra(TEST_EXTRA_READER_NAME);
        result.totalAllowedTime = questionnaire.getConfig().getDuration();
        result.questionnaireId = questionnaire.getId();
        Author author = copySheet.getAuthor();
        if (author != null) {
            result.authorId = author.getId();
            result.authorDisplayName = author.getDisplayName();
        }
        Collect collect = new Collect(copySheet.getId(), result, surveySheetResults);
        collect.campaignId = campaignId;
        collect.rawData = copySheet.toString();
        handleCopySheetExtras(collect, copySheet.getExtras());
        handleCopySheetSheets(collect, copySheet.getSheets(), questionnaire);
        return collect;
    }

    private static void handleCopySheetSheets(Collect collect, List<CopySheet.Sheet> sheets, Questionnaire questionnaire) {
        collect.result.totalQuestionCount = sheets.size();
        SurveySheetResult sheetResult;
        HashMap<String, Qcm> idQcmMap = QcmUtils.toIdQcmMap(questionnaire.getQcms());
        Qcm qcm;
        for (CopySheet.Sheet sheet : sheets) {
            //TODO si qcm est null lancer une exception intégrityexception, le questionnaire en remote et local ne sont pas pareil.
            qcm = idQcmMap.get(sheet.getId());
            sheetResult = new SurveySheetResult(collect.result, sheet, qcm);
            collect.sheetResults.put(sheet.getId(), sheetResult);
            if (sheet.composed) {
                collect.result.composedQuestionCount++;
            }
            if (sheet.prospected) {
                collect.result.prospectedQuestionCount++;
            }
            collect.result.pointAddedCount += sheetResult.pointAddedCount;
            collect.result.pointSubtractedCount += sheetResult.pointSubtractedCount;
            collect.result.pointAddedCount += sheetResult.pointAddedCount;
            collect.result.successCount += sheetResult.answerSuccessCount;
            collect.result.failedCount += sheetResult.answerFailedCount;
            collect.result.maxSuccessCount += sheetResult.answerMaxSuccessCount;
            collect.result.marks += sheetResult.marks;
            collect.result.maxMarks += sheetResult.maxMars;
            collect.result.score = collect.result.marks > 0 ? collect.result.marks : 0;
        }
    }

    private static void handleCopySheetExtras(Collect collect, Bundle bundle) {
        collect.extras = new HashMap();
        collect.form = new HashMap();
        String prefixToIgnore = Survey.getPropertyNameFor(Survey.FIELD_FORM) + ".";
        for (String key : bundle.keySet()) {
            if (key.startsWith(Survey.getPropertyNameFor(Survey.FIELD_FORM))) {
                collect.form.put(toSafeKey(key.replace(prefixToIgnore, "")), bundle.getString(key));
            } else if (!key.startsWith(Component.PREFIX_NAMESPACE + Survey.NAMESPACE)) {
                collect.extras.put(toSafeKey(key), bundle.getString(key));
            }
        }
    }

    private static String toSafeKey(String key) {
        return key.replaceAll("/|\\.|#|\\$|\\[|\\]", "_");
    }


}
