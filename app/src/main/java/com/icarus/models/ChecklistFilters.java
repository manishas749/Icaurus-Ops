package com.icarus.models;

/**
 * Created by Monika Rana on 1/3/2019.
 */

public class ChecklistFilters {
    private StringCheckBox filterByType, filterByStatus, filterByDepartment;
    private SortChecklistBy sortBy;

    public StringCheckBox getFilterByType() {
        return filterByType;
    }

    public void setFilterByType(StringCheckBox filterByType) {
        this.filterByType = filterByType;
    }

    public StringCheckBox getFilterByStatus() {
        return filterByStatus;
    }

    public void setFilterByStatus(StringCheckBox filterByStatus) {
        this.filterByStatus = filterByStatus;
    }

    public StringCheckBox getFilterByDepartment() {
        return filterByDepartment;
    }

    public void setFilterByDepartment(StringCheckBox filterByDepartment) {
        this.filterByDepartment = filterByDepartment;
    }

    public SortChecklistBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortChecklistBy sortBy) {
        this.sortBy = sortBy;
    }
}
