package StockAssignment;

public class StockOrder {
    int price;
    int numberOfShares;

    public StockOrder(int price, int numberOfShares) {
        this.price = price;
        this.numberOfShares = numberOfShares;
    }

    @Override
    public String toString() {
        return "{ price=" + price + " numberOfShares=" + numberOfShares + " }";
    }
}
