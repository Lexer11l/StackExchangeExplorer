package kmeshkov.utils;

public abstract class StringConstants {
    public final static String TABLE_HEADER = "Unanswered topics marked with gray color <br><table border=1><TR align=center><TD><b>Title</b></TD><TD><b>Author name</b></TD><TD><b>Creation date</b></TD><TD><b>Tags</b></TD></TR>";
    public final static String TABLE_ROW_TEMPLATE = "<TR bgcolor=%s><TD><a href=%s>%s</a></TD><TD><a href=%s>%s</a></TD><TD>%s</TD><TD>%s</TD></TR>";
    public final static String GET_REQUEST_BASE_URL = "http://api.stackexchange.com/2.2/search?site=stackoverflow";
}
