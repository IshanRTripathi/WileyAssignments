package StockAssignment;

import java.util.ArrayList;
import java.util.List;

public class StockExchange {
    static List<Integer> sharePrices;
    static List<Stock> stockList;

    public static void main(String[] args) {
        sharePrices= new ArrayList<>();
        generateSharePrices(sharePrices);
        double averageSharePrice= getAverageSharePrice(sharePrices);
        int minimumSharePrice= getMinimumSharePrice(sharePrices);
        int maximumSharePrice= getMaximumSharePrice(sharePrices);

        System.out.println("Average Share Price: "+averageSharePrice+
                "\nMinimum Share Price: "+minimumSharePrice+
                "\nMaximum Share Price: "+maximumSharePrice);
//        sharePrices.forEach(System.out::println);
        List<String> stockNames= new ArrayList<>(){{
            add("NYSE:O");
            add("NSE:BAJFINANCE");
            add("BOM");
            add("NYSE:GE");
            add("NYSE:NEW");
            add("NASDAQ:L");
            add("NYSE:Q");add("NYSE:OS");add("NYSE:P");add("NYSE:LO");add("NYSE:WW");add("NYSE:K");add("NYSE:X");add("NYSE:B");add("NYSE:U");
            add("NYSE:GB");
            add("NSE:ABBV");
            add("BOM:OPPO");
            add("NYSE:DIGITAL");
            add("NYSE:NHUW");
            add("NASDAQ:LPP");
            add("BYSE:Q");add("BYSE:QQQ");add("BYSE:ASD");add("BYSE:NJK");add("BYSE:MKO");add("BYSE:QSQ");add("BYSE:Q=OIL");add("BYSE:Q=LIOO");add("BYSE:BULL");
        }};

        for(String stockName: stockNames)
        {
            Stock stock= new Stock(stockName);
            stock.generateOrders();
            stockList.add(stock);
        }
    }

    private static int getMaximumSharePrice(List<Integer> sharePrices) {
        int maximum= 0;
        for (int x:sharePrices) {
            if(x>maximum)
                maximum=x;
        }
        return maximum;
    }

    private static int getMinimumSharePrice(List<Integer> sharePrices) {
        int minimum= 0;
        for (int x:sharePrices) {
            if(x<minimum)
                minimum=x;
        }
        return minimum;
    }

    private static double getAverageSharePrice(List<Integer> sharePrices) {
        int sum=0;
        for(int x: sharePrices)
            sum+=x;
        return (double) sum/sharePrices.size();
    }

    private static void generateSharePrices(List<Integer> sharePrices) {
        for(int i=0; i<100; i++)
            sharePrices.add((int)(Math.random()*100));
    }
}
