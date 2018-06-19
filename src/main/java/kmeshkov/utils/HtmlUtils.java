package kmeshkov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import kmeshkov.model.Topic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlUtils {

    private final static String TABLE_ROW_TEMPLATE = "<TR bgcolor=%s><TD><a href=%s>%s</a></TD><TD><a href=%s>%s</a></TD><TD>%s</TD></TR>";
    private final static String TABLE_HEADER = "<TR align=center><TD><b>Title</b></TD><TD><b>Author name</b></TD><TD><b>Creation date</b></TD></TD>";

    public static String createPageContentFromResponse(String response){
        StringBuilder result = new StringBuilder("<table border=1>");
        result.append(TABLE_HEADER);

        JSONObject object = new JSONObject(response);
        JSONArray array = object.getJSONArray("items");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>)
                (jsonElement, type, jsonDeserializationContext) -> new Date(1000*jsonElement.getAsLong()));
        Gson gson = builder.create();
        for (int i = 0; i<array.length();i++) {
            String json = array.getJSONObject(i).toString();
            Topic topic = gson.fromJson(json, Topic.class);
            String tableRowFromTopic = HtmlUtils.topicToTableRow(topic);
            result.append(tableRowFromTopic);
        }
        result.append("</table>");
        return result.toString();
    }

    private static String topicToTableRow(Topic topic){
        return String.format(TABLE_ROW_TEMPLATE, topic.isAnswered()? "white":"gray", topic.getLink(), topic.getTitle(), topic.getOwner().getLink(), topic.getOwner().getName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(topic.getCreationDate()));
    }


}
