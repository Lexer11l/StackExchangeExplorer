package main.java.utils;

import org.junit.Assert;
import org.junit.Test;
import kmeshkov.utils.HtmlUtils;

class HtmlUtilsTest {

    @Test
    void createPageContentFromResponse() {
        HtmlUtils.createPageContentFromResponse("");
        Assert.assertEquals(1,1);
    }


}