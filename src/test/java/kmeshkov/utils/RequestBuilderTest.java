package kmeshkov.utils;

import kmeshkov.model.Query;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static kmeshkov.controller.TestConstantStrings.GET_FULL_REQUEST_URL;
import static kmeshkov.controller.TestConstantStrings.GET_REQUEST_BASE_URL;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Logger.class)
public class RequestBuilderTest {

    private static Logger mockLog;

    @Before
    public void setUp() {
        mockStatic(Logger.class);
        mockLog = mock(Logger.class);
        when(Logger.getLogger(any(Class.class))).thenReturn(mockLog);
    }

    @Test
    public void createRequestFromEmptyQueryTest() {
        RequestBuilder requestBuilder = new RequestBuilder(new Query());
        assertEquals(GET_REQUEST_BASE_URL,(requestBuilder.createRequest()));
    }

    @Test
    public void createRequestFromFullQueryTest() throws ParseException {
        RequestBuilder requestBuilder = new RequestBuilder(createFullQuery());
        assertEquals(GET_FULL_REQUEST_URL, requestBuilder.createRequest());
    }


    private static Query createFullQuery() throws ParseException {
        Query query = new Query();
        query.setPage("1");
        query.setPageSize("10");
        query.setIntitle("java");
        query.setSortingOrder("desc");
        query.setSortBy("activity");
        query.setQueryResult("empty result");
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = format.parse("1970-01-01");
        Date toDate = format.parse("1970-01-02");
        query.setFromDate(fromDate);
        query.setToDate(toDate);
        return query;
    }

}