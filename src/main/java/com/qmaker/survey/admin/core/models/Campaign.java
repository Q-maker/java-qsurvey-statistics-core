package com.qmaker.survey.admin.core.models;

import com.qmaker.core.entities.Questionnaire;
import com.qmaker.core.interfaces.IDHolder;
import com.qmaker.core.interfaces.Itemizable;

import java.util.UUID;

//TODO prevoire une variable qui defini si les collecte doivent être accumulé ou écrasé celon un paramettre defini dans la collecte envoyé.
public class Campaign implements Itemizable, IDHolder {
    public final static String
            ATTEMPT_POLICY_BEST_SCORE = "attempt_policy_best_score",
            ATTEMPT_POLICY_NONE = "attempt_policy_none",
            ATTEMPT_POLICY_ONCE_ONLY = "attempt_policy_once_only";
    public String id = UUID.randomUUID().toString(), accountId, title, description, questionnaireId;
    long expireAt;
    String attemptPolicy;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public void setAttemptPolicy(String attemptPolicy) {
        this.attemptPolicy = attemptPolicy;
    }

    public String getAttemptPolicy() {
        return attemptPolicy;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public long getExpireAt() {
        return expireAt;
    }

    //    public void setQuestionnaireId(Questionnaire questionnaire) {
//        this.questionnaireId = questionnaire != null ? questionnaire.getId() : null;
//    }
}
