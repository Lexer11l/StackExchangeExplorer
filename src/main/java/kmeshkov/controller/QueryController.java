package kmeshkov.controller;

import kmeshkov.model.Query;
import kmeshkov.utils.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import kmeshkov.service.DataSource;

import java.io.IOException;

@Controller
public class QueryController {

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("query", new Query());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/sendQuery")
    public ModelAndView sendQuery(Query query) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            String topicsAsJson = dataSource.getTopics(query);
            String pageContent = HtmlUtils.createPageContentFromResponse(topicsAsJson);
            query.setQueryResult(pageContent);
        } catch (IOException e) {
            query.setQueryResult("There was some problems with query <br>");
        }
        modelAndView.setViewName("queryResults");
        modelAndView.addObject("query",query);
        return modelAndView;
    }

}
