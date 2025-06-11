import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map;

public class StockTicker {
    private NavigableMap<String, Double> stocks;

    public StockTicker() {
        this.stocks = new TreeMap<>();
    }

    public void addStock(String symbol, double price) {
        stocks.put(symbol, price);
    }

    public double getStockPrice(String symbol) {
        return stocks.get(symbol);
    }

    public static void main(String[] args) {
        StockTicker ticker = new StockTicker();

        ticker.addStock("AAPL", 150.0);
        ticker.addStock("GOOG", 3000.0);
        ticker.addStock("MSFT", 250.0);

        System.out.println("Stock ticker:");
        for (Map.Entry<String, Double> entry : ticker.stocks.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Highest priced stock: " + ticker.stocks.lastEntry());
        System.out.println("Lowest priced stock: " + ticker.stocks.firstEntry());

        System.out.println("Stocks priced above 200.0:");
        for (Map.Entry<String, Double> entry : ticker.stocks.tailMap("AAPL", true).entrySet()) {
            if (entry.getValue() > 200.0) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}