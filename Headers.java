
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Greg on 17.05.2017.
 */
public class Headers {
    public static URLConnection setHeaders(URL url) throws IOException {
        URLConnection urlCon = url.openConnection();
            /*urlCon.setRequestProperty("Cookie",
                    "__utma=183793058.1279868489.1494081929.1494883928.1494915953.3;" +
                    " __utmb=183793058.1.10.1494915953;"+
                    "__utmc=183793058;" +
                    "__utmt=1;" +
                    "__utmv=183793058.|1=Users=Unregistered=1^2=Gender=n=1^3=Age=0=1" +
                    "__utmz=183793058.1494883928.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)" +
                    "can_https=1" +
                    "category=c_13" +
                    "categoryUpdateTime=1497475930247" +
                    "pcity=303010783" +
                    "scr=9" +
                    "sfr=9" +
                    "snr=9" +
                    "tmp=YGVoMCAnOiUwbmBkaCA+JzQ8OzBuYGdoPjw8Iw--" +
                    "tracknew=1490864043215967.1494915955.4" +
                    "uid=1CpM/VkN4YwjTRyeBkdnAg==" +
                    "un_lang=ua" +
                    "un_news_region=9 ");
                    */
        urlCon.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        urlCon.setRequestProperty("Accept-Language","ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
        urlCon.setRequestProperty("Cache-Control","max-age=0");
        urlCon.setRequestProperty("Connection","keep-alive");
        urlCon.setRequestProperty("Host","www.ukr.net");
        urlCon.setRequestProperty("Upgrade-Insecure-Requests","1");
        urlCon.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
        return urlCon;
    }
}

