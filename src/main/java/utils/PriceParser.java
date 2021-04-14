package utils;

public class PriceParser {
    public static String androidParsePriceUSD(String priceString) {
        return priceString.substring(0, priceString.length() - 2).replaceAll("\\s","");
    }

    public static String iosParsePriceUSD(String priceString) {
        return priceString.substring(1);
    }
}
