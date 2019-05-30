import java.util.*;

public class ClientAfter {
    public static void main(String[] args) {
        StockTrade stock = new StockTrade();
        BuyStockOrder bsc = new BuyStockOrder (stock);
        SellStockOrder ssc = new SellStockOrder (stock);
        Agent agent = new Agent();

        agent.placeOrder(bsc); // Buy Shares
        agent.placeOrder(ssc); // Sell Shares
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