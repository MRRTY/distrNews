

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLConnection;
        import java.sql.Time;
        import java.time.LocalTime;
        import java.util.*;

/**
 * Created by Greg on 17.05.2017.
 */
public class SegodnyaNews implements WebNews {
    private Set<News> news;
    private URL url;

    public SegodnyaNews() throws MalformedURLException {
        this(new URL("http://ukr.segodnya.ua/pub/data/right_tape_ukr.html"));
    }

    public SegodnyaNews(URL url) {
        this.url = url;
        news = new HashSet<>();
        toList(loadNews());
    }

    @Override
    public Set<News> getNews() {
        return news;
    }


    private String loadNews() {
        StringBuilder sb = new StringBuilder();
        try {

            URLConnection urlCon = Headers.setHeaders(url);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));) {


                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    sb.append(inputLine);
                return sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void toList(String s){

        s = s.substring(s.indexOf("<ul>"));

        while (s.indexOf("<li") != -1){
            parseLi(s.substring(s.indexOf("<li"),s.indexOf("</li>")+5));

            s = s.substring(s.indexOf("</li>")+5);

        }

    }
    private void parseLi(String s){
        String title;
        LocalTime time;
        String source;
        time = LocalTime.parse(s.substring(s.indexOf("<span class=\"time\">")+19,s.indexOf("</span>")));
        s = s.substring(s.indexOf("</span>")+7);
        source = s.substring(s.indexOf("<a href=")+9,s.indexOf("\">"));
        s = s.substring(s.indexOf("\">"));
        if(s.indexOf("<span") == -1)
            title = s.substring(2, s.indexOf("</a>"));
        else
            title = s.substring(2,s.indexOf("<span"));
        news.add(new News(title,time,source));

    }
}

