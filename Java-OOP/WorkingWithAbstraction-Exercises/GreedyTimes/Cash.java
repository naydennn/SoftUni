package GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Cash {
    private long totalCash;
    private Map<String, Long> cash;

    public Cash() {
        cash = new HashMap<>();
    }

    public boolean addCash(String item, long currency) {
        if (totalCash + currency <= Gem.getTotalAmount()) {
            totalCash += currency;
            cash.putIfAbsent(item, 0L);
            cash.put(item, cash.get(item) + currency);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!cash.isEmpty()) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            cash.entrySet().stream().sorted((first, second) -> {
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
