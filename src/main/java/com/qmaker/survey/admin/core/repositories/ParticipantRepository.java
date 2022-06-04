package com.qmaker.survey.admin.core.repositories;

import com.qmaker.survey.admin.core.entities.Participant;
import com.qmaker.survey.admin.core.utils.PageDescriptor;
import com.qmaker.survey.admin.core.utils.SortDescriptor;

import java.util.HashMap;
import java.util.List;

public interface ParticipantRepository {

    Participant findById(String id);

    Participant findByIdentityId(String campaignId, String identityId);

    List<Participant> findByCampaignId(String campaignId, PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    boolean deleteByIdentityId(String campaignId, String identityId);

    boolean deleteById(String id);

    boolean exists(String id);
}
