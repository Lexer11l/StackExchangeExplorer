package kmeshkov.controller;

import kmeshkov.model.Query;
import kmeshkov.service.DataSource;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static kmeshkov.controller.TestConstantStrings.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Logger.class)
public class QueryControllerTest {

    private static Logger mockLog;

    @InjectMocks
    private QueryController queryController;

    @Mock
    private DataSource dataSource;


    @Before
    public void setUp() {
        mockStatic(Logger.class);
        mockLog = mock(Logger.class);
        when(Logger.getLogger(any(Class.class))).thenReturn(mockLog);
    }

    @Test
    public void indexTest() {
        ModelAndView expected = new ModelAndView("searchPage", "query", new Query());
        ModelAndView actual = queryController.index();
        Assert.assertEquals(expected.getViewName(), actual.getViewName());
        Assert.assertEquals(expected.getModelMap().toString(), actual.getModelMap().toString());
    }

    @Test
    public void sendEmptyQueryTest() throws IOException {
        when(dataSource.getTopics(any(Query.class))).thenReturn(EMPTY_RESPONSE);
        ModelAndView actual = queryController.sendQuery(new Query());
        ModelAndView expected = new ModelAndView("queryResults", "queryResult", MESSAGE_HEADER + "</table>");
        Assert.assertEquals(expected.getViewName(), actual.getViewName());
        Assert.assertEquals(expected.getModelMap().toString(), actual.getModelMap().toString());
    }

    @Test
    public void sendFullQueryTest() throws IOException {
        when(dataSource.getTopics(any(Query.class))).thenReturn(RESPONSE);
        ModelAndView actual = queryController.sendQuery(new Query());
        ModelAndView expected = new ModelAndView("queryResults", "queryResult",
                MESSAGE_HEADER + COMPLETE_TABLE_ROW_FROM_RESPONSE);
        Assert.assertEquals(expected.getViewName(), actual.getViewName());
        Assert.assertEquals(expected.getModelMap().toString(), actual.getModelMap().toString());
    }

    @Test
    public void sendErrorResponseQueryTest() throws IOException {
        when(dataSource.getTopics(any(Query.class))).thenThrow(IOException.class);
        ModelAndView actual = queryController.sendQuery(new Query());
        ModelAndView expected = new ModelAndView("queryResults", "queryResult", ERROR_RESPONSE);
        Assert.assertEquals(expected.getViewName(), actual.getViewName());
        Assert.assertEquals(expected.getModelMap().toString(), actual.getModelMap().toString());
    }
}