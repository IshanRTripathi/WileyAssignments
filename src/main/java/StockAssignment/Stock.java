package StockAssignment;

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
        for(int i=0; i<50; i++)
        {
            this.buyOrders.add(new StockOrder((int)(Math.random()*100), (int)(Math.random()*50)));
            this.sellOrders.add(new StockOrder((int)(Math.random()*100), (int)(Math.random()*50)));
        }
    }
}
