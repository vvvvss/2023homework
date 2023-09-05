
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class KeelungSightsCrawler {

    public static ArrayList<Sight> sightList;
    public KeelungSightsCrawler() throws IOException {
        sightList = new ArrayList<>();
        String blogUrl = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        Document doc = Jsoup.connect(blogUrl).get();
        Elements contents = doc.select("div.box > ul li a");
        for(Element content : contents){
            Document docChild = Jsoup.connect(content.attr("abs:href")).get();
            sightList.add(new Sight(
                    docChild.select(".h1").text(),
                    docChild.select("[class = bc_last] > a").text(),
                    docChild.select("[property = rdfs:label").text(),
                    docChild.select("[class = gpic] > img").attr("data-src"),
                    docChild.select("#point_area > [itemprop = description]").attr("content"),
                    docChild.select("[property = vcard:street-address]").text()
                    )
            );
        }
    }
    public Sight[] getItems(String place){
        ArrayList<Sight> tmpSightList = new ArrayList<>();
        for(Sight sight : sightList){
            if(sight.getZone().contains(place)){
                tmpSightList.add(sight);
            }
        }
        return tmpSightList.toArray(new Sight[0]);
    }
}