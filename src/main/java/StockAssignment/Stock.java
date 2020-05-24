package StockAssignment;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    String stockName;
    List<StockOrder> buyOrders;
    List<StockOrder> sellOrders;

    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public List<StockOrder> getBuyOrders() {
        return buyOrders;
    }

    public List<StockOrder> getSellOrders() {
        return sellOrders;
    }

    void generateOrders()
    {
        List<StockOrder> buyOrders= new ArrayList<>();
        List<StockOrder> sellOrders= new ArrayList<>();
        for(int i=0; i<50; i++)
        {
            buyOrders.add(new StockOrder((int)(Math.random()*100)+51, (int)(Math.random()*50)));
            sellOrders.add(new StockOrder((int)(Math.random()*100)+41, (int)(Math.random()*50)));
        }
        this.buyOrders=buyOrders;
        this.sellOrders= sellOrders;
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        result.append("\n\nStock: ").append(stockName);
        result.append("\n\tBuy Orders: ");
        for(StockOrder stockOrder: buyOrders)
            result.append(stockOrder).append("\t");
        result.append("\n\tSell Orders: ");
        for(StockOrder stockOrder: sellOrders)
            result.append(stockOrder).append("\t");

        return result.toString();
    }
}
