package kmeshkov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import kmeshkov.model.Topic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import static kmeshkov.utils.StringConstants.TABLE_HEADER;
import static kmeshkov.utils.StringConstants.TABLE_ROW_TEMPLATE;

public class HtmlUtils {

    public static String createPageContentFromResponse(String response) {
        StringBuilder result = new StringBuilder(TABLE_HEADER);
        JSONObject object = new JSONObject(response);
        JSONArray array = object.getJSONArray("items");
        Gson gson = createAndConfigGson();
        for (int i = 0; i < array.length(); i++) {
            String json = array.getJSONObject(i).toString();
            Topic topic = gson.fromJson(json, Topic.class);
            String tableRowFromTopic = HtmlUtils.topicToTableRow(topic);
            result.append(tableRowFromTopic);
        }
        result.append("</table>");
        return result.toString();
    }

    private static String topicToTableRow(Topic topic) {
        return String.format(TABLE_ROW_TEMPLATE, topic.isAnswered() ? "white" : "gray",
                topic.getLink(), topic.getTitle(), topic.getOwner().getLink(), topic.getOwner().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(topic.getCreationDate()),
                topic.getTags());
    }
    private static Gson createAndConfigGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>)
                (jsonElement, type, jsonDeserializationContext) -> new Date(1000 * jsonElement.getAsLong()));
        return builder.create();
    }
}
