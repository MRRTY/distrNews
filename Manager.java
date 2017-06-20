import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Greg on 20.05.2017.
 */
public class Manager implements Runnable {
    public Set<WebNews> webNews = new HashSet<WebNews>();
    @Override
    public void run() {
        Thread t = Thread.currentThread();

        try {
            webNews.add(new SegodnyaNews());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Set<News> allNews = new HashSet<News>();
        for (WebNews w: webNews){
            allNews.addAll(w.getNews());
        }
        while (true){

            StringBuilder sb = new StringBuilder();

            for (News n : allNews){
                sb.append(n.getTime()).append(n.getTitle()).append(n.getSource()).append("\n");
                System.out.print(n.getTime()+" ");
                System.out.print(n.getTitle()+" ");
                System.out.println(n.getSource());
            }
            for(String s : Main.recepients) {
                Messager messager = new Messager("tcpoleg@gmail.com", s, "localhost", sb.toString());
                messager.send();
            }
            try {
                synchronized (t) {
                    t.wait(600_000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
