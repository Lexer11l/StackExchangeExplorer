package kmeshkov.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Query {
    
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Pattern(regexp = "[\\W]+")
    private String intitle;
    private String queryResult;
    private String page;
    private String pageSize;
    private String sortBy;
    private String sortingOrder;
    private Date fromDate;
    private Date toDate;

    public String getIntitle() {
        return intitle;
    }

    public String getQueryResult() {
        return queryResult;
    }

    public String getPage() {
        return page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setIntitle(String intitle) {
        this.intitle = intitle;
    }

    public void setQueryResult(String queryResult) {
        this.queryResult = queryResult;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


    @Override
    public String toString() {
        return "Query{" +
                "intitle='" + intitle + '\'' +
                ", queryResult='" + queryResult + '\'' +
                ", page='" + page + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", sortingOrder='" + sortingOrder + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}

