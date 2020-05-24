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
    void matchBuyersAndSellers(Stock stock){
        List<StockOrder> buyOrders= stock.getBuyOrders();
        List<StockOrder> sellOrders= stock.getSellOrders();

    }
    void getMinimumOrderPricePerStock(){}
    void getMaximumOrderPricePerStock(){}
    void getAverageOrderPricePerStock(){}
}
