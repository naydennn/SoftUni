package GreedyTimes;

public class Bag {
    private long capacity;
    private int currentCapacity;
    private Gold gold;
    private Gem gems;
    private Cash cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.gold = new Gold();
        this.gems = new Gem();
        this.cash = new Cash();
    }

    public void addItem(String item, long currency) {
        if (hasFreeSpace(currency)) {
            if (item.equalsIgnoreCase("GOLD")) {
                this.currentCapacity += currency;
                gold.addGold(item, currency);
            } else if (item.length() == 3) {
                if (cash.addCash(item, currency)){
                    this.currentCapacity += currency;

                }
            } else if (item.toLowerCase().contains("gem")) {
                if (gems.addGem(item, currency)) {
                    this.currentCapacity += currency;
                }
            }
        }
    }

    private boolean hasFreeSpace(long capacity) {
        return this.currentCapacity + capacity <= this.capacity;
    }

    @Override
    public String toString() {
        return this.gold.toString() +
                this.gems.toString() +
                this.cash.toString();
    }
}
