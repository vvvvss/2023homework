

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {
        KeelungSightsCrawler crawler = null;
        try {
            crawler = new KeelungSightsCrawler();
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("error");
            System.exit(0);
        }
        Sight[] sights = crawler.getItems("七堵");
        for (Sight s : sights) {
            System.out.println(s);
        }
    }
}