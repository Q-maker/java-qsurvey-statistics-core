package com.qmaker.survey.admin.core;

import com.qmaker.core.entities.CopySheet;
import com.qmaker.core.entities.Qcm;
import com.qmaker.core.entities.Questionnaire;
import com.qmaker.core.utils.MockUps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        String key="[bonjour]#les ami$1.2";
        key=key.replaceAll("/|\\.|#|\\$|\\[|\\]", "_");
        System.out.println(key);
    }


    @Test
    public void testCreateSurveyResultList() {
        Questionnaire questionnaire = MockUps.questionnaire7();
        List<Qcm> qcms0 = questionnaire.getQcms();
        List<Qcm> sheets = new ArrayList<>(questionnaire.getQcms());
        Collections.shuffle(sheets);
        HashMap<String, Qcm> map = toIdSheetMap(qcms0);
        for (Qcm qcm : qcms0) {
            Qcm sheet = map.get(qcm.getId());
            if (sheet != null) {

            }
        }
    }


    private <T extends Qcm> HashMap<String, T> toIdSheetMap(List<T> sheets) {
        HashMap<String, T> map = new HashMap<>();
        for (T sheet : sheets) {
            map.put(sheet.getId(), sheet);
        }
        return map;
    }


}