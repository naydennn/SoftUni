package GreedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Gold {
    private static long totalCurrency;
    private long totalGold;
    private List<String> items;

    public Gold() {
        this.totalGold = 0;
        items = new ArrayList<>();
    }

    public static long getTotalGold() {
        return totalCurrency;
    }

    public void addGold(String item, long currency) {
        this.totalGold += currency;
        totalCurrency += currency;
        this.items.add(item);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.items.isEmpty()) {
            sb.append("<Gold> $").append(this.totalGold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.totalGold).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
