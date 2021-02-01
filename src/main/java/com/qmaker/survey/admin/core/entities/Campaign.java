package com.qmaker.survey.admin.core.entities;

import com.qmaker.core.interfaces.IDHolder;
import com.qmaker.core.interfaces.Itemizable;

import java.util.UUID;

//TODO prevoire une variable qui defini si les collecte doivent être accumulé ou écrasé celon un paramettre defini dans la collecte envoyé.
public class Campaign implements Itemizable, IDHolder {
    public String
            id = UUID.randomUUID().toString(),
            accountId,
            title,
            description,
            questionnaireId,
            questionnaireSignature;
    int questionnaireVersion;
    long createdAt, endingAt, expireAt;
    int maxAllowedAttemptCount;

    public int getQuestionnaireVersion() {
        return questionnaireVersion;
    }

    public String getQuestionnaireSignature() {
        return questionnaireSignature;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getEndingAt() {
        return endingAt;
    }

    public int getMaxAllowedAttemptCount() {
        return maxAllowedAttemptCount;
    }

    public void setQuestionnaireSignature(String questionnaireSignature) {
        this.questionnaireSignature = questionnaireSignature;
    }

    public void setQuestionnaireVersion(int questionnaireVersion) {
        this.questionnaireVersion = questionnaireVersion;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setEndingAt(long endingAt) {
        this.endingAt = endingAt;
    }

    public void setMaxAllowedAttemptCount(int maxAllowedAttemptCount) {
        this.maxAllowedAttemptCount = maxAllowedAttemptCount;
    }

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
