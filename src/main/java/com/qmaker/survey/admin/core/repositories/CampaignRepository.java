package com.qmaker.survey.admin.core.repositories;

import com.qmaker.survey.admin.core.entities.Campaign;
import com.qmaker.survey.admin.core.errors.RepositoryException;
import com.qmaker.survey.admin.core.utils.PageDescriptor;
import com.qmaker.survey.admin.core.utils.SortDescriptor;

import java.util.HashMap;
import java.util.List;

public interface CampaignRepository {
    Campaign findById(String id) throws RepositoryException;

    List<Campaign> findAllByQuestionnaireId(String questionnaireId, PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    List<Campaign> findAllByQuestionnaireSignature(String questionnaireSignature, PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    List<Campaign> findAll(PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    boolean deleteById(String id);

    boolean exists(String id);
}
