## Problem: 
Implementing a Stock Ticker

## Description: 
Create a program that demonstrates the use of NavigableMap to implement a stock ticker.

## Input:

Stock symbols and prices: {"AAPL", 150.0}, {"GOOG", 3000.0}, {"MSFT", 250.0}

## Output:

Stock ticker:

AAPL = 150.0

GOOG = 3000.0

MSFT = 250.0

Highest priced stock: GOOG = 3000.0

Lowest priced stock: AAPL = 150.0

Stocks priced above 200.0:

GOOG = 3000.0

MSFT = 250.0

## Code Answer:
```Java
import java.util.NavigableMap;
import java.util.TreeMap;

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
```

File Name: StockTicker.java

This program demonstrates the use of NavigableMap to implement a stock ticker. The StockTicker class uses a TreeMap to store stock symbols and prices. The addStock method adds a new stock to the ticker, and the getStockPrice method retrieves a stock price by symbol. The program prints the stock ticker, the highest and lowest priced stocks, and the stocks priced above 200.0.

Note: NavigableMap is a collection that stores key-value pairs in a sorted order, and it provides methods for navigating and searching the elements in the map. It is useful for implementing sorted dictionaries, phonebooks, and other similar data structures.