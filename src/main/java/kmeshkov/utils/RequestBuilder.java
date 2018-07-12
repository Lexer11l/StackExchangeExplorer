package kmeshkov.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kmeshkov.model.Query;
import org.apache.log4j.Logger;


import static java.util.Objects.isNull;
import static kmeshkov.utils.StringConstants.GET_REQUEST_BASE_URL;
import static org.springframework.util.StringUtils.isEmpty;

public class RequestBuilder {
    private final static Logger LOGGER = Logger.getLogger(RequestBuilder.class);

    private StringBuilder request;
    private Query query;

    public RequestBuilder(Query query) {
        this.query = query;
        this.request = new StringBuilder(GET_REQUEST_BASE_URL);
    }

    public String createRequest() {
        if (!isEmpty(query.getIntitle())) {
            addIntitleParameter();
        }
        if (!isEmpty(query.getSortBy())) {
            addSortParameter();
        }
        if (!isEmpty(query.getSortingOrder())) {
            addSortOrderParameter();
        }
        if (!isEmpty(query.getPage())) {
            addPageParameter();
        }
        if (!isEmpty(query.getPageSize())) {
            addPageSizeParameter();
        }
        if (!isNull(query.getFromDate())) {
            addFromDateParameter();
        }
        if (!isNull(query.getToDate())) {
            addToDateParameter();
        }
        LOGGER.info("We built request: " + request);
        return request.toString();
    }

    private void addIntitleParameter() {
        String value = query.getIntitle().replace(" " , "%20");
        request.append("&intitle=").append(value);
    }

    private void addSortParameter() {
        request.append("&sort=").append(query.getSortBy());
    }

    private void addSortOrderParameter() {
        request.append("&order=").append(query.getSortingOrder());
    }

    private void addPageParameter() {
        request.append("&page=").append(query.getPage());
    }

    private void addPageSizeParameter() {
        request.append("&pagesize=").append(query.getPageSize());
    }

    private void addToDateParameter() {
        request.append("&todate=").append(query.getToDate().getTime() / 1000);
    }

    private void addFromDateParameter() {
        request.append("&fromdate=").append(query.getFromDate().getTime() / 1000);
    }    
}
