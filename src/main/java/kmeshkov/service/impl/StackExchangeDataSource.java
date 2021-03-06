package kmeshkov.service.impl;

import kmeshkov.model.Query;
import kmeshkov.service.DataSource;
import kmeshkov.utils.RequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class StackExchangeDataSource implements DataSource {
    private final static Logger LOGGER = Logger.getLogger(StackExchangeDataSource.class);
    HttpClient client = HttpClientBuilder.create().build();


    public String getTopics(Query query) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(query);
        String response = sendQueryAndGetResponse(requestBuilder.createRequest());
        LOGGER.info("Received response: " + response);
        return response;
    }

    private String sendQueryAndGetResponse(String query) throws IOException {
        HttpGet get = new HttpGet(query);
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        LOGGER.info("Got response from remote service. Status code is " + statusCode);
        if (statusCode < 200 || statusCode > 226){
            StringBuilder message = new StringBuilder("Status code: ")
                    .append(response.getStatusLine().getStatusCode()).append(". ")
                    .append(response.getStatusLine().getReasonPhrase()).append("<br>");
            if (statusCode == 400) {
                String errorMessage = new BasicResponseHandler().handleEntity(response.getEntity());
                LOGGER.warn("Bad request: " + errorMessage);
                message.append("<br>")
                        .append(errorMessage)
                        .append("<br>");
            }
            throw new IOException(message.toString());
        }
        return new BasicResponseHandler().handleResponse(response);
    }

}
