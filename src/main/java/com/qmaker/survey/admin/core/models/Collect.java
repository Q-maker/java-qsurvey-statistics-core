package com.qmaker.survey.admin.core.models;

import com.qmaker.core.engines.Component;
import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.utils.Bundle;
import com.qmaker.survey.core.entities.Survey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO trouver une meilleur structure pour la class de collecte.
public class Collect {
    String id, campaignId, questionnaireId;
    HashMap<String, String> form;
    HashMap<String, String> extras;
    SurveyResult result;
    List<SurveySheetResult> sheetResults;
    long lastModified = System.currentTimeMillis();
    String rawData;

    Collect() {

    }

    public Collect(String collectId, SurveyResult result, List<SurveySheetResult> surveySheetResults) {
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

    public List<SurveySheetResult> getSheetResults() {
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

    public static Collect from(Campaign campaign, CopySheet copySheet) {
        return from(campaign.getId(), copySheet);
    }

    public static Collect from(String campaignId, CopySheet copySheet) {
        SurveyResult result = new SurveyResult(copySheet);
        List<SurveySheetResult> surveySheetResults = new ArrayList();
        Collect collect = new Collect(copySheet.getId(), result, surveySheetResults);
        collect.campaignId = campaignId;
        collect.rawData = copySheet.toString();
        collect.result.setCollectId(collect.getId());
        handleCopySheetExtras(collect, copySheet.getExtras());
        handleCopySheetSheets(collect, copySheet.getSheets());
        return collect;
    }

    private static void handleCopySheetSheets(Collect collect, List<CopySheet.Sheet> sheets) {
        collect.result.totalQuestionCount = sheets.size();
        SurveySheetResult sheetResult;
        for (CopySheet.Sheet sheet : sheets) {
            sheetResult = new SurveySheetResult(collect.result, sheet);
            collect.sheetResults.add(sheetResult);
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
