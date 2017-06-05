import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;


/**
 * @author dpMelian
 */

public class Main {
    public static void main(String[] args) {
        System.out.print("Insert a country: ");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        String capital = "";

        try{
            Document doc = Jsoup.connect("https://www.countries-ofthe-world.com/capitals-of-the-world.html").get();
            Elements elements = doc.select("td");
            for(int i = 0; i < elements.size(); i++){
                String str = elements.get(i).toString();
                if(str.contains(">" + country)){
                    capital = elements.get(i+1).toString();
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(country + "'s capital is: " + Jsoup.parse(capital).text());
        scanner.close();
    }
}