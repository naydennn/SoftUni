package CardsWithPower;

public class Card {
    private String rankOfCard;
    private String suitOfCard;
    private int powerOfCard;

    public Card(String rankOfCard, String suitOfCard) {
        this.rankOfCard = rankOfCard;
        this.suitOfCard = suitOfCard;
        this.powerOfCard = setPowerOfCard();
    }

    public int setPowerOfCard() {
        return Ranks.valueOf(rankOfCard).getPower() + Suits.valueOf(suitOfCard).getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rankOfCard, this.suitOfCard, powerOfCard);
    }
}
