package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.Author;
import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Qcm;

import java.util.List;

public class Collect {
    String collectId;
    final SurveyResult surveyResult;
    final List<SurveySheetResult> surveySheetResultList;

    public Collect(String collectId, SurveyResult surveyResult, List<SurveySheetResult> surveySheetResults) {
        this.surveyResult = surveyResult;
        this.surveySheetResultList = surveySheetResults;
        this.collectId = collectId;
    }

    public String getCollectId() {
        return collectId;
    }

    public SurveyResult getSurveyResult() {
        return surveyResult;
    }

    public List<SurveySheetResult> getSurveySheetResultList() {
        return surveySheetResultList;
    }

    public String getCampaignId() {
        return surveyResult != null ? surveyResult.campaignId : null;
    }

    public static Collect from(String campaignId, CopySheet copySheet) {
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
        result.timeLeft = copySheet.getTimeLeft();


        List<Qcm> sheets = copySheet.getSheets();

        result.totalQuestionCount=sheets.size();



        return new Collect(copySheet.getId(), result, SurveySheetResult.list(copySheet));
    }

}
