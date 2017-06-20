
import java.time.LocalTime;
import java.util.Date;

public class News {
    private String title;
    private LocalTime time;
    private String source;


    public News(String title, LocalTime time, String source) {

        this.title = title;
        this.time = time;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
