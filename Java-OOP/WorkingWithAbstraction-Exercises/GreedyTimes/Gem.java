package GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Gem {
    private static long totalAmount;
    private long totalGems;
    private Map<String, Long> gems;

    public Gem() {
        this.gems = new HashMap<>();
    }

    public static long getTotalAmount() {
        return totalAmount;
    }

    public boolean addGem(String item, long currency) {
        if (totalGems + currency <= Gold.getTotalGold()) {
            totalGems += currency;
            gems.putIfAbsent(item, 0L);
            gems.put(item, gems.get(item) + currency);
            totalAmount += currency;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!gems.isEmpty()) {
        sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            gems.entrySet().stream().sorted((first, second) -> {
                int result = second.getKey().compareTo(first.getKey());
                if (result == 0) {
                    result = first.getValue().compareTo(second.getValue());
                }
                return result;
            }).forEach(item -> {
                sb.append("##").append(item.getKey()).append(" - ").append(item.getValue()).append(System.lineSeparator());
            });
        }
        return sb.toString();
    }
}
