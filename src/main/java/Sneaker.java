import java.math.BigDecimal;

public class Sneaker {
    private String title;
    private String currency;
    private BigDecimal price;
    private String url;

    public Sneaker(String title, String currency, BigDecimal price, String url) {
        this.title = title;
        this.currency = currency;
        this.price = price;
        this.url = url;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return "Sneaker{" +
                "\ntitle='" + title + '\'' +
                "\ncurrency='" + currency + '\'' +
                "\nprice=" + price +
                "\nurl='" + url + '\'' +
                "\n}";
    }
}
