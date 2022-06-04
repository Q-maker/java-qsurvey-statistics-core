package com.qmaker.survey.admin.core.repositories;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.survey.admin.core.errors.RepositoryException;
import com.qmaker.survey.admin.core.utils.PageDescriptor;
import com.qmaker.survey.admin.core.utils.SortDescriptor;

import java.util.HashMap;
import java.util.List;

public interface CopySheetRepository {
    CopySheet findById(String id) throws RepositoryException;

    List<CopySheet> findAllByQuestionnaireId(String questionnaireId, PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    List<CopySheet> findAllByQuestionnaireSignature(String questionnaireSignature, PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    List<CopySheet> findAll(PageDescriptor pageDescriptor, SortDescriptor sortDescriptor, HashMap<String, Object> filterMap);

    boolean deleteById(String id);

    int deleteAll();

    boolean exists(String id);
}
