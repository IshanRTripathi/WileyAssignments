package StockAssignment;

import java.util.List;

/*
How Matching Orders Works
Matching the orders of buyers and sellers is the primary work of specialists and market makers in the exchanges.
The matches happen when compatible buy orders and sell orders for the same security are submitted in close proximity
of price and time. Generally, a buy order and a sell order are compatible if the maximum price of the buy order matches
or exceeds the minimum price of the sell order. From there, the computerized, order-matching systems of different
exchanges use a variety of methods to prioritize orders for matching.

Quick, accurate order matching is the critical component of an exchange. Investors, particularly active investors
and day traders, will look for ways to minimize inefficiencies in trading from every possible source. A slow
order-matching system may cause buyers or sellers to execute trades at less-than-ideal prices, eating into investors’
profits. If some order-matching protocols tend to favor buyers, and others favor sellers, these methods become
exploitable. This is one of the areas where High Frequency Trading was able to improve efficiency. Exchanges aim to
prioritize trades in a way that benefits buyers and sellers equally so as to maximize order volume--the life blood of
the exchange.
*/
public class StockMatcher {
    static List<StockOrder> buyOrders;
    static List<StockOrder> sellOrders;
    static  void matchBuyersAndSellers(Stock stock){
        buyOrders= stock.getBuyOrders();
        sellOrders= stock.getSellOrders();
    }
    static void getMinimumOrderPricePerStock(){
        int minBuy=Integer.MAX_VALUE, minSell=Integer.MAX_VALUE;

        for(StockOrder order: buyOrders)
        {
            minBuy= Math.min(minBuy, order.price);
        }
        for(StockOrder order: sellOrders)
        {
            minSell= Math.min(minSell, order.price);
        }
        System.out.println("Minimum buy order @"+minBuy+
                "\tMinimum sell order @:"+minSell);
    }
    static void getMaximumOrderPricePerStock(){
        int maxBuy=0, maxSell=0;

        for(StockOrder order: buyOrders)
        {
            maxBuy= Math.max(maxBuy, order.price);
        }
        for(StockOrder order: sellOrders)
        {
            maxSell= Math.max(maxSell, order.price);
        }
        System.out.println("Maximum buy order @"+maxBuy+
                "\tMaximum sell order @:"+maxSell);
    }
    static void getAverageOrderPricePerStock(){
        double avgBuy=0, avgSell=0;

        for(StockOrder order: buyOrders)
        {
            avgBuy+= order.price;
        }
        for(StockOrder order: sellOrders)
        {
            avgSell+= order.price;
        }
        avgBuy= (double) (avgBuy/buyOrders.size());
        avgSell= (double) (avgSell/sellOrders.size());
        System.out.println("Average buy order @"+avgBuy+
                "\tAverage sell order @:"+avgSell);
    }
}
