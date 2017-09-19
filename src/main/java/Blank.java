

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * @author garyab2
 *
 */
public class Blank {
/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countPrince(String passage) {
        int count = 0;
        for(int i = 0; i<passage.length()-6;i++) {
            if(passage.substring(i, i+6).equalsIgnoreCase("princess")) {// &&
                    //!Character.isLetter(passage.charAt(i-1)) &&
                   // !Character.isLetter(passage.charAt(i+7))) {
                count++;
            }
        }
        return count;
    }
    /**
     * Main method for Blank class.
     */
    public static void main(String[] args) {
        String page = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(page.split(" ").length);
        System.out.println(countPrince(page));
    }

}
