import java.util.*;

public class ClientAfter {
    public static void main(String[] args) {
        StockTrade stock = new StockTrade();
        Agent agent = new Agent();

        agent.placeOrder(stock::buy); // Buy Shares
        agent.placeOrder(stock::sell); // Sell Shares
     }
}

class Agent{
    private List ordersQueue = new ArrayList();

    void placeOrder(Order order){
        ordersQueue.add(order);
        order.execute();
    }
}

class StockTrade {
    public void buy() {
        System.out.println("You want to buy stocks");
    }

    public void sell() {
        System.out.println("You want to sell stocks ");
    }

}
@FunctionalInterface
interface Order{
    public void execute();
}

class SellStockOrder implements Order{
    private StockTrade stock;

    public SellStockOrder(StockTrade stock){
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}

class BuyStockOrder implements Order{
    private StockTrade stock;

    public BuyStockOrder(StockTrade stock){
        this.stock = stock;
    }

    public void execute() {
        stock.buy();

    }
}