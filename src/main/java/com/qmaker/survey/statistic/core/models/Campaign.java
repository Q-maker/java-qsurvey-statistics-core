package com.qmaker.survey.statistic.core.models;

import com.qmaker.core.interfaces.IDHolder;
import com.qmaker.core.interfaces.Itemizable;

public class Campaign implements Itemizable, IDHolder {
    public String id, accountId, title, description;

    @Override
    public CharSequence getTitle() {
        return title;
    }

    @Override
    public CharSequence getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }
}
