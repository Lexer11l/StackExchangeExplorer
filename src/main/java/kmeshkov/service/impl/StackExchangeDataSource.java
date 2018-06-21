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

    public String getTopics(Query query) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(query);
        String response = sendQueryAndGetResponse(requestBuilder.createRequest());
        LOGGER.info("Received response: " + response);
        return response;
    }

    private String sendQueryAndGetResponse(String query) throws IOException {
        HttpGet get = new HttpGet(query);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        LOGGER.info("Got response from remote service. Status code is " + statusCode);
        if (statusCode < 200 || statusCode > 226){
            StringBuilder message = "Status code: " + response.getStatusLine().getStatusCode() + ". " + response.getStatusLine().getReasonPhrase();
            if (statusCode == 400);
                message.append("<br>").append(new BasicResponseHandler().handleResponse(response));
            throw new IOException(message.toString());
        }
        return new BasicResponseHandler().handleResponse(response);
    }

}
