import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;
import java.util.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScraper{


    public static void main(String [] args) throws IOException{


        String url = "https://www.amazon.ca/s?k=amazon+sneakers&gclid=CjwKCAjwmKLzBRBeEiwACCVihrzFhO_gp4wkrEre5CIWltqn5UXvrOgi6k_BtY1px5XbUtoQB2I_8xoChz0QAvD_BwE&hvadid=208376711758&hvdev=c&hvlocphy=9000668&hvnetw=g&hvqmt=e&hvrand=4121515407479575209&hvtargid=kwd-298621553182&hydadcr=23340_9622020&tag=googcana-20&ref=pd_sl_zzpjnbpxw_e";

        /*
        try{

        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        */

        Document page = Jsoup.connect("url").userAgent("Jsoup Scraper").get();

        String sneakerSelector = ".aok-inline-block.zg-item > .a-link-normal";

        Elements sneakerSelections = page.select(sneakerSelector);
        ArrayList<String> sneakerTypes = new ArrayList<>();

        for (Element e:sneakerSelections){
            sneakerTypes.add(e.text());
        }

        for (String sneaker:sneakerTypes){
            System.out.println(sneaker);
        }
    }
}
