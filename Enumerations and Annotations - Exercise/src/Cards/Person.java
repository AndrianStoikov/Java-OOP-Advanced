package Cards;

import Cards.Enums.CardRank;
import Cards.Enums.CardSuit;

import java.util.ArrayList;
import java.util.List;


public class Person implements Comparable<Person> {
    private String name;
    private List<Card> cards;
    private Card maxCard;

    public Person(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.maxCard = new Card(CardRank.TWO, CardSuit.CLUBS);
    }

    public void addCard(Card card) {
        this.cards.add(card);
        if(card.getPower() > this.maxCard.getPower())
            this.maxCard = card;
    }

    public boolean isFull() {
        return this.cards.size() == 5;
    }

    public String getWinString() {
        return this.name + " wins with " + this.maxCard + ".";
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.maxCard.getPower(), person.maxCard.getPower());
    }
}
