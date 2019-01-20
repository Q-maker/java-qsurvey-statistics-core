package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.entities.CopySheet;

import java.util.List;

public class Collect {
    public final SurveyResult surveyResult;
    public final List<SurveySheetResult> surveySheetResultList;

    public Collect(SurveyResult surveyResult, List<SurveySheetResult> surveySheetResults) {
        this.surveyResult = surveyResult;
        this.surveySheetResultList = surveySheetResults;
    }

    public static Collect from(CopySheet copySheet) {
        return new Collect(null, null);
    }

}
