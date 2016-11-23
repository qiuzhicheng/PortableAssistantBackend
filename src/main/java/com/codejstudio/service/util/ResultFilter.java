package com.codejstudio.service.util;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Alias("resultFilter")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultFilter<T> implements Serializable {

    private static final long serialVersionUID = 5472321653620726832L;

    @JsonIgnore
    private int currentPage = 1;

    @JsonIgnore
    private int limit = 20;

    @JsonIgnore
    private int skip = 0;

    @JsonProperty("count")
    private int totalCount;

    @JsonIgnore
    private boolean havaNextPage;

    @JsonIgnore
    private boolean havePrePage;

    @JsonIgnore
    private int navigatorSize;

    @JsonProperty("results")
    private List<T> items;

    @JsonIgnore
    private T where;

    @JsonIgnore
    public int getPageCount() {
        int pageCount = 0;
        if (limit != 0) {
            pageCount = totalCount / limit;
            if (totalCount % limit != 0)
                pageCount++;
        }

        return pageCount;
    }

    public int getCurrentPage() {
        currentPage = currentPage < getPageCount() ? currentPage : getPageCount();
        currentPage = currentPage < 1 ? 1 : currentPage;

        return currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    @JsonIgnore
    public boolean isHaveNextPage() {
        havaNextPage = false;
        if ((getPageCount() > 1) && (getPageCount() > getCurrentPage()))
            havaNextPage = true;
        return havaNextPage;
    }

    @JsonIgnore
    public boolean isHavePrePage() {
        havePrePage = false;
        if ((getPageCount() > 1) && (currentPage > 1))
            havePrePage = true;
        return havePrePage;
    }

    @JsonIgnore
    private int getNavigatorIndex(boolean isBegin) {
        int beginNavigatorIndex = getCurrentPage() - navigatorSize / 2;
        int endNavigatorIndex = getCurrentPage() + navigatorSize / 2;
        beginNavigatorIndex = beginNavigatorIndex < 1 ? 1 : beginNavigatorIndex;
        endNavigatorIndex = endNavigatorIndex < getPageCount() ? endNavigatorIndex : getPageCount();
        while ((endNavigatorIndex - beginNavigatorIndex) < navigatorSize
                && (beginNavigatorIndex != 1 || endNavigatorIndex != getPageCount())) {
            if (beginNavigatorIndex > 1)
                beginNavigatorIndex--;
            else if (endNavigatorIndex < getPageCount())
                endNavigatorIndex++;
        }

        if (isBegin)
            return beginNavigatorIndex;
        else
            return endNavigatorIndex;
    }

    @JsonIgnore
    public int getBeginNavigatorIndex() {
        return getNavigatorIndex(true);
    }

    @JsonIgnore
    public int getEndNavigatorIndex() {
        return getNavigatorIndex(false);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        this.setWhere(null);
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.skip = (this.currentPage - 1) * this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        this.skip = (this.currentPage - 1) * this.limit;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public T getWhere() {
        return where;
    }

    public void setWhere(T where) {
        this.where = where;
    }
}
