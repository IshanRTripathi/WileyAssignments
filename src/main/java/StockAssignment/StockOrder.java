package StockAssignment;

public class StockOrder {
    int price;
    int numberOfShares;

    public StockOrder(int price, int numberOfShares) {
        this.price = price;
        this.numberOfShares = numberOfShares;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}
