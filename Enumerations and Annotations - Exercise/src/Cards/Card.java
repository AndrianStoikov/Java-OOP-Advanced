package Cards;

import Cards.Enums.CardRank;
import Cards.Enums.CardSuit;

public class Card implements Comparable<Card>{
    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.suit.getPower() + this.rank.getPower();
    }

    @Override
    public String toString() {
        String name = rank.name() + " of " + suit.name();
        int power = this.rank.getPower() + this.suit.getPower();
        return String.format("%s", name);
    }

    @Override
    public int compareTo(Card card) {
        int score = this.rank.getPower() + this.suit.getPower();

        return Integer.compare(score, card.rank.getPower() + card.suit.getPower());
    }
}
