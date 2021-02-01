package com.qmaker.survey.admin.core.utils;

public class PageDescriptor {
    public static final String FIELD_PAGE = "page",
            FIELD_ITEM_PER_PAGE = "item_per_page",
            FIELD_LIMIT = "limit";
    int page = 0;
    int itemPerPage = 0;
    int limit = 0;


    PageDescriptor index(int index) {
        PageDescriptor pageDescriptor = new PageDescriptor();
        pageDescriptor.page = index;
        pageDescriptor.itemPerPage = this.itemPerPage;
        pageDescriptor.limit=limit;
        return pageDescriptor;
    }

    public PageDescriptor next() {
        return this.index(page + 1);
    }

    public PageDescriptor  previous() {
        return this.index(page - 1);
    }
}
