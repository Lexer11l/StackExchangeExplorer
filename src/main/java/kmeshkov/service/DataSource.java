package kmeshkov.service;

import kmeshkov.model.Query;

import java.io.IOException;

public interface DataSource {
    String getTopics(Query query) throws IOException;
}
