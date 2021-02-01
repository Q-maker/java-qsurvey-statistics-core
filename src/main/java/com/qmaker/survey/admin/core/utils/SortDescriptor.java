package com.qmaker.survey.admin.core.utils;

import java.util.ArrayList;
import java.util.List;

public class SortDescriptor {
    static  final int DIRECTION_ASCENDANT = 0, DIRECTION_DESCENDANT = 1;
    static final String FIELD_SORT_ASC = "sort", FIELD_SORT_DESC = "desc";
    List<String> _sort = new ArrayList<>();
    List<String> _desc = new ArrayList<>();


    public SortDescriptor orderByProperties(List<String> properties, int direction) {
        if (direction == DIRECTION_ASCENDANT) {
            _sort.addAll(properties);
        } else {
            _desc.addAll(properties);
        }
        return this;
    }

    public  SortDescriptor orderByProperty(String property, int direction) {
        _sort.add(property);
        return this;
    }

    public  SortDescriptor orderByPropertyAsc(String property) {
        _sort.add(property);
        return this;
    }

    public  SortDescriptor orderByPropertyDesc(String property) {
        _desc.add(property);
        return this;
    }

    public  String getOrderingLiteral(int direction) {
        List<String> sort = direction == DIRECTION_ASCENDANT ? _sort : _desc;
        String out = "";
        int index = 0;
        for (String item : sort) {
            out += item;
            if (index < sort.size() - 1) {
                out += ",";
            }
            index++;
        }
        return out;
    }
}
