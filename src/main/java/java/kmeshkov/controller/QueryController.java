package java.kmeshkov.controller;

import java.kmeshkov.model.Query;
import java.kmeshkov.utils.HtmlUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.kmeshkov.service.DataSource;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;


@Controller
public class QueryController {
    private final static Logger LOGGER = Logger.getLogger(QueryController.class);

    @Autowired
    DataSource dataSource;

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("query", new Query());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/queryResults")
    public ModelAndView sendQuery(Query query) {
        String pageContent;
        LOGGER.debug("Got query: " + query.toString());
        try {
            String topicsAsJson = dataSource.getTopics(query);
            pageContent = HtmlUtils.createPageContentFromResponse(topicsAsJson);
        } catch (IOException e) {
            LOGGER.warn("Got exception from remote service: {}", e);
            pageContent = "Did not received response from service.<br>" +
                    "There was some problems with query <br>" +
                    "Response have status:" + e.getMessage();
        }
        return new ModelAndView("queryResults", "queryResult", pageContent);
    }

}
