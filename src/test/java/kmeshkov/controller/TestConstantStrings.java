package kmeshkov.controller;

public abstract class TestConstantStrings {
    public static final String MESSAGE_HEADER = "Unanswered topics marked with gray color <br><table border=1><TR align=center><TD><b>Title</b></TD><TD><b>Author name</b></TD><TD><b>Creation date</b></TD><TD><b>Tags</b></TD></TR>";
    public static final String EMPTY_RESPONSE = "{\"items\":[]}";
    public static final String RESPONSE = "{\"items\":[{\"tags\":[\"java\",\"android\",\"ios\",\"encryption\",\"rsa\"],\"owner\":{\"reputation\":116,\"user_id\":1682691,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/816189626535cddb992548183236d1c4?s=128&d=identicon&r=PG\",\"display_name\":\"mrpink\",\"link\":\"https://stackoverflow.com/users/1682691/mrpink\"},\"is_answered\":false,\"view_count\":4409,\"answer_count\":3,\"score\":23,\"last_activity_date\":1529413281,\"creation_date\":1348214308,\"last_edit_date\":1502177734,\"question_id\":12526452,\"link\":\"https://stackoverflow.com/questions/12526452/difference-between-pkcs1-padding-rsa-encryption-ios-objc-and-java\",\"title\":\"Difference between PKCS1-padding/RSA encryption ios objc and java\"}]}";
    public final static String GET_REQUEST_BASE_URL = "http://api.stackexchange.com/2.2/search?site=stackoverflow";
    public final static String GET_FULL_REQUEST_URL ="http://api.stackexchange.com/2.2/search?site=stackoverflow&intitle=java&sort=activity&order=desc&pagesize=10&pagesize=10&fromdate=-10800&todate=75600";
    public final static String ERROR_RESPONSE = "Did not received response from service.<br>There was some problems with query <br>Response have status:null";
    public final static String COMPLETE_TABLE_ROW_FROM_RESPONSE = "<TR bgcolor=gray><TD><a href=https://stackoverflow.com/questions/12526452/difference-between-pkcs1-padding-rsa-encryption-ios-objc-and-java>Difference between PKCS1-padding/RSA encryption ios objc and java</a></TD><TD><a href=https://stackoverflow.com/users/1682691/mrpink>mrpink</a></TD><TD>2012-09-21 11:58:28</TD><TD>[java, android, ios, encryption, rsa]</TD></TR></table>";

}
