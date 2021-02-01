package com.qmaker.survey.admin.core.entities;

import com.qmaker.core.interfaces.IDHolder;
import com.qmaker.core.utils.Bundle;

public class Participant implements IDHolder {
    String id;
    String identityId;
    String campaignId;
    boolean locked = false;
    Bundle identityBundle;
    AttemptInfo attemptInfo;

    public String getId() {
        return id;
    }

    public String getIdentityId() {
        return identityId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public boolean isLocked() {
        return locked;
    }

    public Bundle getIdentityBundle() {
        return identityBundle;
    }

    public AttemptInfo getAttemptInfo() {
        return attemptInfo;
    }

    public static class AttemptInfo {
        int attemptCount;
        int attemptLeft;
        long lastCollectDeviceTime;
        long lastCollectSeverTime;
        long lastIdentificationDeviceTime;
        long lastIdentificationServerTime;

        public int getAttemptCount() {
            return attemptCount;
        }

        public int getAttemptLeft() {
            return attemptLeft;
        }

        public long getLastCollectDeviceTime() {
            return lastCollectDeviceTime;
        }

        public long getLastCollectSeverTime() {
            return lastCollectSeverTime;
        }

        public long getLastIdentificationDeviceTime() {
            return lastIdentificationDeviceTime;
        }

        public long getLastIdentificationServerTime() {
            return lastIdentificationServerTime;
        }
    }

}
