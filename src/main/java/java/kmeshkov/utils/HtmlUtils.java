package java.kmeshkov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import java.kmeshkov.model.Topic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlUtils {
    private final static String TABLE_HEADER = "<TR align=center><TD><b>Title</b></TD><TD><b>Author name</b></TD><TD><b>Creation date</b></TD><TD><b>Tags</b></TD></TR>";
    private final static String TABLE_ROW_TEMPLATE = "<TR bgcolor=%s><TD><a href=%s>%s</a></TD><TD><a href=%s>%s</a></TD><TD>%s</TD><TD>%s</TD></TR>";


    public static String createPageContentFromResponse(String response) {
        StringBuilder result = new StringBuilder("Unanswered topics marked with gray color <br>");
        result.append("<table border=1>");
        result.append(TABLE_HEADER);

        JSONObject object = new JSONObject(response);
        JSONArray array = object.getJSONArray("items");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>)
                (jsonElement, type, jsonDeserializationContext) -> new Date(1000 * jsonElement.getAsLong()));
        Gson gson = builder.create();
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
        return String.format(TABLE_ROW_TEMPLATE, topic.isAnswered() ? "white" : "gray", topic.getLink(), topic.getTitle(), topic.getOwner().getLink(), topic.getOwner().getName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(topic.getCreationDate()), topic.getTags());
    }


    public final static String e = "{\"items\":[{\"tags\":[\"java\",\"android\",\"ios\",\"encryption\",\"rsa\"],\"owner\":{\"reputation\":116,\"user_id\":1682691,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/816189626535cddb992548183236d1c4?s=128&d=identicon&r=PG\",\"display_name\":\"mrpink\",\"link\":\"https://stackoverflow.com/users/1682691/mrpink\"},\"is_answered\":false,\"view_count\":4409,\"answer_count\":3,\"score\":23,\"last_activity_date\":1529413281,\"creation_date\":1348214308,\"last_edit_date\":1502177734,\"question_id\":12526452,\"link\":\"https://stackoverflow.com/questions/12526452/difference-between-pkcs1-padding-rsa-encryption-ios-objc-and-java\",\"title\":\"Difference between PKCS1-padding/RSA encryption ios objc and java\"},{\"tags\":[\"java\",\"hadoop\",\"permissions\",\"hdfs\"],\"owner\":{\"reputation\":12,\"user_id\":7678831,\"user_type\":\"registered\",\"accept_rate\":0,\"profile_image\":\"https://www.gravatar.com/avatar/40dc625f24054a1ff6a4e62323feddc7?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"J. Doe\",\"link\":\"https://stackoverflow.com/users/7678831/j-doe\"},\"is_answered\":false,\"view_count\":9,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529413259,\"creation_date\":1529409583,\"last_edit_date\":1529413259,\"question_id\":50927906,\"link\":\"https://stackoverflow.com/questions/50927906/permission-denied-accessing-hdfs-via-hadoop-java-api\",\"title\":\"Permission denied accessing HDFS via Hadoop java API\"},{\"tags\":[\"android\",\"reactjs\",\"react-native\"],\"owner\":{\"reputation\":803,\"user_id\":6180782,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/bq9GQ.png?s=128&g=1\",\"display_name\":\"Irshad Ahmed\",\"link\":\"https://stackoverflow.com/users/6180782/irshad-ahmed\"},\"is_answered\":false,\"view_count\":2,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529413234,\"creation_date\":1529413234,\"question_id\":50929133,\"link\":\"https://stackoverflow.com/questions/50929133/could-not-determine-java-version-from-10-0-1-react-native\",\"title\":\"Could not determine java version from 10.0.1 react native\"},{\"tags\":[\"java\",\"windows\",\"java.kmeshkov.service\",\"amqp\",\"bus\"],\"owner\":{\"reputation\":6,\"user_id\":7446161,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/ae5115af1ea56bbdb3427b528ac6cf5a?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"garim\",\"link\":\"https://stackoverflow.com/users/7446161/garim\"},\"is_answered\":false,\"view_count\":75,\"answer_count\":2,\"score\":0,\"last_activity_date\":1529412813,\"creation_date\":1491303644,\"question_id\":43205327,\"link\":\"https://stackoverflow.com/questions/43205327/service-bus-on-windows-server-1-1-using-java-and-amqp-1-0-message-size-issue\",\"title\":\"Service Bus on Windows Server (1.1) using Java and AMQP 1.0 Message Size Issue\"},{\"tags\":[\"java\",\"json\"],\"owner\":{\"reputation\":9,\"user_id\":9495884,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/Cr4cl.jpg?s=128&g=1\",\"display_name\":\"Tusar\",\"link\":\"https://stackoverflow.com/users/9495884/tusar\"},\"is_answered\":true,\"view_count\":64,\"answer_count\":4,\"score\":0,\"last_activity_date\":1529412786,\"creation_date\":1529392823,\"last_edit_date\":1529412786,\"question_id\":50922671,\"link\":\"https://stackoverflow.com/questions/50922671/replacing-json-string-with-another-string-in-java\",\"title\":\"Replacing JSON string with another string in java\"},{\"tags\":[\"java\",\"firebird\",\"jaybird\"],\"owner\":{\"reputation\":27,\"user_id\":3036384,\"user_type\":\"registered\",\"accept_rate\":50,\"profile_image\":\"https://graph.facebook.com/1580041312/picture?type=large\",\"display_name\":\"asirvent\",\"link\":\"https://stackoverflow.com/users/3036384/asirvent\"},\"is_answered\":true,\"view_count\":591,\"answer_count\":1,\"score\":2,\"last_activity_date\":1529412719,\"creation_date\":1385469019,\"last_edit_date\":1529412719,\"question_id\":20217153,\"link\":\"https://stackoverflow.com/questions/20217153/convert-in-java-dos437-to-utf8\",\"title\":\"convert in Java DOS437 to UTF8\"},{\"tags\":[\"java\",\"jsp\",\"servlets\"],\"owner\":{\"reputation\":17,\"user_id\":6018576,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/44994793a57e06c14909b93af4106f40?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Ramesh\",\"link\":\"https://stackoverflow.com/users/6018576/ramesh\"},\"is_answered\":false,\"view_count\":17,\"answer_count\":1,\"score\":-1,\"last_activity_date\":1529412704,\"creation_date\":1529412326,\"question_id\":50928812,\"link\":\"https://stackoverflow.com/questions/50928812/java-dynamic-web-application-back-button-doesnt-work-in-browser\",\"title\":\"Java dynamic web application - back button doesn&#39;t work in browser\"},{\"tags\":[\"java\",\"eclipse\",\"apache-poi\",\"docx\"],\"owner\":{\"reputation\":3,\"user_id\":9955677,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/0974010273aa679d749c272ffa59d85d?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Amar Malik\",\"link\":\"https://stackoverflow.com/users/9955677/amar-malik\"},\"is_answered\":false,\"view_count\":9,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529412652,\"creation_date\":1529412652,\"question_id\":50928926,\"link\":\"https://stackoverflow.com/questions/50928926/open-password-protected-docx-file-using-java\",\"title\":\"open password protected docx file using java\"},{\"tags\":[\"java\",\"oracle\",\"amazon-web-services\",\"amazon-ec2\"],\"owner\":{\"reputation\":1,\"user_id\":9962053,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/bfd879cf5e3a198521fa256f1520dac1?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Snehal\",\"link\":\"https://stackoverflow.com/users/9962053/snehal\"},\"is_answered\":false,\"view_count\":10,\"answer_count\":0,\"score\":-2,\"last_activity_date\":1529412628,\"creation_date\":1529412628,\"question_id\":50928913,\"link\":\"https://stackoverflow.com/questions/50928913/i-have-on-premises-java-application-using-java-i-want-to-connect-to-oracle-db-w\",\"title\":\"I have on premises Java application. Using Java I want to connect to Oracle DB which is installed on AWS EC2 Instance.How can I connect to it\"},{\"tags\":[\"java\",\"node.js\",\"encryption\",\"aes\"],\"owner\":{\"reputation\":139,\"user_id\":3380496,\"user_type\":\"registered\",\"accept_rate\":86,\"profile_image\":\"https://i.stack.imgur.com/BPoOO.jpg?s=128&g=1\",\"display_name\":\"Chaitanya Joshi\",\"link\":\"https://stackoverflow.com/users/3380496/chaitanya-joshi\"},\"is_answered\":false,\"view_count\":30,\"answer_count\":1,\"score\":0,\"last_activity_date\":1529412615,\"creation_date\":1529392018,\"question_id\":50922462,\"link\":\"https://stackoverflow.com/questions/50922462/aes-cbc-pkcs5padding-iv-decryption-in-nodejs-encrypted-in-java\",\"title\":\"AES/CBC/PKCS5PADDING IV - Decryption in NodeJs (Encrypted in Java)\"},{\"tags\":[\"java\",\"json\",\"csv\",\"jar\"],\"owner\":{\"reputation\":25,\"user_id\":2852154,\"user_type\":\"registered\",\"accept_rate\":50,\"profile_image\":\"https://www.gravatar.com/avatar/1ba0bf3ad4afbd80c7d1dc015b8b9894?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Hari surya prakash Turangi\",\"link\":\"https://stackoverflow.com/users/2852154/hari-surya-prakash-turangi\"},\"is_answered\":true,\"view_count\":618,\"answer_count\":1,\"score\":0,\"last_activity_date\":1529412581,\"creation_date\":1518714171,\"last_edit_date\":1518718684,\"question_id\":48812591,\"link\":\"https://stackoverflow.com/questions/48812591/parse-csv-data-and-convert-to-nested-json-java\",\"title\":\"Parse csv data and convert to nested json java\"},{\"tags\":[\"java\",\"arrays\",\"algorithm\",\"multidimensional-array\"],\"owner\":{\"reputation\":1107,\"user_id\":3734457,\"user_type\":\"registered\",\"accept_rate\":96,\"profile_image\":\"https://www.gravatar.com/avatar/de6e5134d8a12fdcbd9cd3b204d70203?s=128&d=identicon&r=PG\",\"display_name\":\"Jan Slominski\",\"link\":\"https://stackoverflow.com/users/3734457/jan-slominski\"},\"is_answered\":true,\"view_count\":44,\"answer_count\":1,\"score\":-1,\"last_activity_date\":1529412563,\"creation_date\":1529410509,\"question_id\":50928200,\"link\":\"https://stackoverflow.com/questions/50928200/efficient-way-to-trim-2d-array-in-java\",\"title\":\"Efficient way to trim 2d array in Java\"},{\"tags\":[\"java\",\"datetime\"],\"owner\":{\"reputation\":149,\"user_id\":1374664,\"user_type\":\"registered\",\"accept_rate\":93,\"profile_image\":\"https://i.stack.imgur.com/3g98V.jpg?s=128&g=1\",\"display_name\":\"LNyarla\",\"link\":\"https://stackoverflow.com/users/1374664/lnyarla\"},\"is_answered\":true,\"view_count\":30,\"answer_count\":2,\"score\":1,\"last_activity_date\":1529412556,\"creation_date\":1529411151,\"last_edit_date\":1529412289,\"question_id\":50928418,\"link\":\"https://stackoverflow.com/questions/50928418/unexpected-result-when-summing-java-dates\",\"title\":\"Unexpected result when summing java Dates\"},{\"tags\":[\"java\",\"spring\",\"maven\",\"nexus\",\"artifactory\"],\"owner\":{\"reputation\":266,\"user_id\":5367593,\"user_type\":\"registered\",\"accept_rate\":20,\"profile_image\":\"https://i.stack.imgur.com/JzNcs.png?s=128&g=1\",\"display_name\":\"Rezwan\",\"link\":\"https://stackoverflow.com/users/5367593/rezwan\"},\"is_answered\":false,\"view_count\":12,\"answer_count\":1,\"score\":-1,\"last_activity_date\":1529412331,\"creation_date\":1529411938,\"question_id\":50928686,\"link\":\"https://stackoverflow.com/questions/50928686/maven-repository-manager-nexus-vs-artifactory-for-java-dependencies\",\"title\":\"Maven Repository Manager - Nexus vs Artifactory for Java Dependencies\"},{\"tags\":[\"java\",\"image\",\"android-studio\",\"android-imagebutton\",\"recyclerview-layout\"],\"owner\":{\"reputation\":1,\"user_id\":9962001,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/926cf9bb484176ba1d49972cef203a32?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Emma\",\"link\":\"https://stackoverflow.com/users/9962001/emma\"},\"is_answered\":false,\"view_count\":8,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529412263,\"creation_date\":1529412263,\"question_id\":50928790,\"link\":\"https://stackoverflow.com/questions/50928790/how-can-i-use-the-already-installed-android-imagebuttons-in-java-class\",\"title\":\"How can I use the already installed android ImageButtons in java class?\"},{\"tags\":[\"reporting-services\",\"ssrs-2012\",\"apache-httpclient-4.x\",\"ssrs-2016\",\"ssrs-2017\"],\"owner\":{\"reputation\":1,\"user_id\":9946353,\"user_type\":\"registered\",\"profile_image\":\"https://lh4.googleusercontent.com/-ksdWSKJY7GU/AAAAAAAAAAI/AAAAAAAAAAA/j9rax3gXuwg/photo.jpg?sz=128\",\"display_name\":\"Latha Nagandla\",\"link\":\"https://stackoverflow.com/users/9946353/latha-nagandla\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529412224,\"creation_date\":1529407939,\"last_edit_date\":1529412224,\"question_id\":50927396,\"link\":\"https://stackoverflow.com/questions/50927396/sql-server-2016-generate-%c3%af-bom-funny-character-while-accessing-through-java\",\"title\":\"SQL Server 2016 Generate &#239;&#187;&#191; (BOM/Funny) Character while accessing through JAVA Proxy\"},{\"tags\":[\"java\",\"elasticsearch\",\"elk-stack\"],\"owner\":{\"reputation\":364,\"user_id\":8793412,\"user_type\":\"registered\",\"accept_rate\":88,\"profile_image\":\"https://www.gravatar.com/avatar/e4ad839e2ce8147a73c523b738bd6145?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Karthikeyan\",\"link\":\"https://stackoverflow.com/users/8793412/karthikeyan\"},\"is_answered\":false,\"view_count\":17,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529412210,\"creation_date\":1529407324,\"last_edit_date\":1529412210,\"question_id\":50927198,\"link\":\"https://stackoverflow.com/questions/50927198/indexing-base64-in-elasticsearch-via-java-code\",\"title\":\"Indexing base64 in elasticsearch via java code\"},{\"tags\":[\"java\",\"inheritance\",\"constructor\"],\"owner\":{\"reputation\":16,\"user_id\":9183546,\"user_type\":\"registered\",\"profile_image\":\"https://lh4.googleusercontent.com/--gtSTff3D4k/AAAAAAAAAAI/AAAAAAAAADY/OsCNxM9OmJI/photo.jpg?sz=128\",\"display_name\":\"Edward\",\"link\":\"https://stackoverflow.com/users/9183546/edward\"},\"is_answered\":true,\"view_count\":45,\"answer_count\":3,\"score\":1,\"last_activity_date\":1529412130,\"creation_date\":1529401628,\"last_edit_date\":1529403586,\"question_id\":50925302,\"link\":\"https://stackoverflow.com/questions/50925302/about-constructor-initialize-sequence-when-using-inheritance-in-java\",\"title\":\"About constructor initialize sequence when using inheritance in Java\"},{\"tags\":[\"java\",\"mongodb\",\"intellij-idea\"],\"owner\":{\"reputation\":21,\"user_id\":8370915,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/94U9K.jpg?s=128&g=1\",\"display_name\":\"invzbl3\",\"link\":\"https://stackoverflow.com/users/8370915/invzbl3\"},\"is_answered\":false,\"view_count\":35,\"answer_count\":0,\"score\":1,\"last_activity_date\":1529412052,\"creation_date\":1529350999,\"last_edit_date\":1529412052,\"question_id\":50916467,\"link\":\"https://stackoverflow.com/questions/50916467/how-to-connect-to-atlas-cluster-correctly-via-java-driver\",\"title\":\"How to connect to Atlas cluster correctly via Java driver?\"},{\"tags\":[\"java\",\"arraylist\"],\"owner\":{\"reputation\":22,\"user_id\":9113430,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/d8caa65df52b2dcf60f51b4efeb1e266?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"ArcherEmiya\",\"link\":\"https://stackoverflow.com/users/9113430/archeremiya\"},\"is_answered\":true,\"view_count\":32,\"accepted_answer_id\":50928438,\"answer_count\":4,\"score\":-2,\"last_activity_date\":1529412005,\"creation_date\":1529411090,\"question_id\":50928398,\"link\":\"https://stackoverflow.com/questions/50928398/java-compare-two-list-of-string-if-they-have-common-value-and-return-the-how-m\",\"title\":\"Java - Compare Two List of String if they have common value and return the how many item is the same\"},{\"tags\":[\"jvm\",\"jvm-crash\"],\"owner\":{\"reputation\":22,\"user_id\":4985197,\"user_type\":\"registered\",\"accept_rate\":100,\"profile_image\":\"https://www.gravatar.com/avatar/759a1bc7576ed9825d6e6551e76e2ed9?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Javacodeman113\",\"link\":\"https://stackoverflow.com/users/4985197/javacodeman113\"},\"is_answered\":true,\"view_count\":1120,\"accepted_answer_id\":49962876,\"answer_count\":2,\"score\":1,\"last_activity_date\":1529411762,\"creation_date\":1524370431,\"question_id\":49962437,\"link\":\"https://stackoverflow.com/questions/49962437/unrecognized-vm-option-useparnewgc-error-could-not-createPageContentFromResponse-the-java-virtual\",\"title\":\"Unrecognized VM option &#39;UseParNewGC&#39; , Error: Could not createPageContentFromResponse the Java Virtual Machine\"},{\"tags\":[\"java\",\"multithreading\",\"observable\"],\"owner\":{\"reputation\":1,\"user_id\":4416267,\"user_type\":\"registered\",\"profile_image\":\"https://graph.facebook.com/100003211783196/picture?type=large\",\"display_name\":\"Paddy Smoki\",\"link\":\"https://stackoverflow.com/users/4416267/paddy-smoki\"},\"is_answered\":false,\"view_count\":52,\"answer_count\":0,\"score\":-8,\"last_activity_date\":1529411526,\"creation_date\":1529409706,\"last_edit_date\":1529411526,\"question_id\":50927941,\"link\":\"https://stackoverflow.com/questions/50927941/java-increase-the-value-of-an-int-everytime-another-int-gets-increased\",\"title\":\"Java - Increase the Value of an int, everytime another int gets increased\"},{\"tags\":[\"kotlin\"],\"owner\":{\"reputation\":67,\"user_id\":9949315,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/3ae16b9d75e4766c1b4f451084d4fbbd?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Maxim\",\"link\":\"https://stackoverflow.com/users/9949315/maxim\"},\"is_answered\":false,\"view_count\":33,\"answer_count\":1,\"score\":0,\"last_activity_date\":1529411173,\"creation_date\":1529402788,\"question_id\":50925729,\"link\":\"https://stackoverflow.com/questions/50925729/is-it-possible-to-inject-pure-java-code-into-kotlin\",\"title\":\"Is it possible to inject pure Java code into Kotlin?\"},{\"tags\":[\"java\",\"spring\",\"mongodb\",\"graph\",\"spring-data-mongodb\"],\"owner\":{\"reputation\":4482,\"user_id\":1040718,\"user_type\":\"registered\",\"accept_rate\":57,\"profile_image\":\"https://i.stack.imgur.com/u0SVy.jpg?s=128&g=1\",\"display_name\":\"cybertextron\",\"link\":\"https://stackoverflow.com/users/1040718/cybertextron\"},\"is_answered\":true,\"view_count\":474,\"answer_count\":1,\"score\":1,\"last_activity_date\":1529411084,\"creation_date\":1480911687,\"last_edit_date\":1529411084,\"question_id\":40967046,\"link\":\"https://stackoverflow.com/questions/40967046/mongodb-cannot-use-a-complex-object-as-a-key-value-java\",\"title\":\"MongoDB Cannot use a complex object as a key value Java\"},{\"tags\":[\"java\",\"encryption\",\"memory-management\"],\"owner\":{\"reputation\":1,\"user_id\":7054822,\"user_type\":\"registered\",\"profile_image\":\"https://graph.facebook.com/1105979826105983/picture?type=large\",\"display_name\":\"Burza VonVitale Ale\",\"link\":\"https://stackoverflow.com/users/7054822/burza-vonvitale-ale\"},\"is_answered\":false,\"view_count\":13,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529411024,\"creation_date\":1529411024,\"question_id\":50928376,\"link\":\"https://stackoverflow.com/questions/50928376/java-encoding-with-my-custom-cipher\",\"title\":\"Java, encoding with my custom cipher\"},{\"tags\":[\"java\",\"date\"],\"owner\":{\"reputation\":140,\"user_id\":9273148,\"user_type\":\"registered\",\"accept_rate\":75,\"profile_image\":\"https://www.gravatar.com/avatar/04b81b581c2f76b5ef4c87adacb3c485?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Tanvi Jaywant\",\"link\":\"https://stackoverflow.com/users/9273148/tanvi-jaywant\"},\"is_answered\":true,\"view_count\":57,\"accepted_answer_id\":50911467,\"answer_count\":1,\"score\":0,\"last_activity_date\":1529410453,\"creation_date\":1529330809,\"last_edit_date\":1529331261,\"question_id\":50911327,\"link\":\"https://stackoverflow.com/questions/50911327/how-to-find-start-of-3-months-before-today-in-java\",\"title\":\"How to find start of 3 months before today in Java?\"},{\"tags\":[\"eclipse\"],\"owner\":{\"reputation\":1,\"user_id\":9961859,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/59cc621d7ea748184322911b0a2f92bc?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"OMID\",\"link\":\"https://stackoverflow.com/users/9961859/omid\"},\"is_answered\":false,\"view_count\":8,\"answer_count\":0,\"score\":-2,\"last_activity_date\":1529410251,\"creation_date\":1529410251,\"question_id\":50928119,\"link\":\"https://stackoverflow.com/questions/50928119/tcp-send-java-code-and-tcp-receive-c-code-in-eclipse\",\"title\":\"TCP send Java code and TCP receive C code in Eclipse\"},{\"tags\":[\"spring-integration\",\"spring-integration-dsl\"],\"owner\":{\"reputation\":404,\"user_id\":5236494,\"user_type\":\"registered\",\"profile_image\":\"https://lh3.googleusercontent.com/-WaZqgKx5WE8/AAAAAAAAAAI/AAAAAAAAAxM/dtUd0ZcIJsM/photo.jpg?sz=128\",\"display_name\":\"Shubham Agarwal\",\"link\":\"https://stackoverflow.com/users/5236494/shubham-agarwal\"},\"is_answered\":false,\"view_count\":4,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529409752,\"creation_date\":1529409752,\"question_id\":50927963,\"link\":\"https://stackoverflow.com/questions/50927963/acceptoncefilelistfilter-is-overriding-simplepatternfilelistfilter-in-spring-int\",\"title\":\"AcceptOnceFileListFilter is overriding SimplePatternFileListFilter in Spring Integration JAVA DSL\"},{\"tags\":[\"java\",\"xml-parsing\",\"domexception\"],\"owner\":{\"reputation\":174,\"user_id\":8684704,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/MnnRQ.jpg?s=128&g=1\",\"display_name\":\"Santhosh\",\"link\":\"https://stackoverflow.com/users/8684704/santhosh\"},\"is_answered\":false,\"view_count\":15,\"answer_count\":1,\"score\":0,\"last_activity_date\":1529409258,\"creation_date\":1529405949,\"last_edit_date\":1529408963,\"question_id\":50926764,\"link\":\"https://stackoverflow.com/questions/50926764/namespace-error-while-converting-java-to-xml\",\"title\":\"Namespace error while converting Java to XML\"},{\"tags\":[\"java\",\"authentication\",\"ntlm\"],\"owner\":{\"reputation\":1,\"user_id\":9903416,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/ea930d53b6439afaf16949dd3ee109b4?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Abhinav6593\",\"link\":\"https://stackoverflow.com/users/9903416/abhinav6593\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":0,\"last_activity_date\":1529409216,\"creation_date\":1529409216,\"question_id\":50927789,\"link\":\"https://stackoverflow.com/questions/50927789/ntlm-authentication-using-java\",\"title\":\"NTLM Authentication using Java\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":298}";
}