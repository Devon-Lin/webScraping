import org.jsoup.Jsoup;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class WebScraper{

    private static final String URL = "https://www.amazon.ca/s?k=amazon+sneakers&gclid=CjwKCAjwmKLzBRBeEiwACCVihrzFhO_gp4wkrEre5CIWltqn5UXvrOgi6k_BtY1px5XbUtoQB2I_8xoChz0QAvD_BwE&hvadid=208376711758&hvdev=c&hvlocphy=9000668&hvnetw=g&hvqmt=e&hvrand=4121515407479575209&hvtargid=kwd-298621553182&hydadcr=23340_9622020&tag=googcana-20&ref=pd_sl_zzpjnbpxw_e";

    public static void main(String [] args) throws IOException {

        List<Sneaker> sneakers = getSneakers(URL);

        sneakers.forEach(System.out::println);
    }

    private static List<Sneaker> getSneakers(String url) throws IOException {
        return Jsoup.connect(url).get()
                .select(".sg-col-inner")
                .stream()
                .filter(i -> !i.select(".a-price-fraction").isEmpty())
                .map(i ->
                        new Sneaker(
                                i.selectFirst(".s-image").attr("alt"),
                                i.selectFirst(".a-price-symbol").text(),
                                BigDecimal.valueOf(Double.parseDouble(i.selectFirst(".a-price-whole").text() + i.selectFirst(".a-price-fraction").text())),
                                "https://amazon.ca" + i.select(".a-link-normal").attr("href")
                        )
                ).collect(Collectors.toList());
    }
}
