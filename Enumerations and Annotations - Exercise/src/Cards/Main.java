package Cards;

import Cards.Enums.CardRank;
import Cards.Enums.CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Card> deck = new HashMap<>();

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                Card card = new Card(rank, cardSuit);
                deck.put(card.toString(), card);
            }
        }

        Person person = new Person(Console.readLine());
        Person person1 = new Person(Console.readLine());

        while (!person.isFull()) {
            addCardToPerson(Console, deck, person);
        }

        while (!person1.isFull()) {
            addCardToPerson(Console, deck, person1);
        }

        if(person.compareTo(person1) > 0)
            System.out.println(person.getWinString());
        else
            System.out.println(person1.getWinString());
    }

    private static void addCardToPerson(BufferedReader console,
                                        HashMap<String, Card> deck, Person person1)
            throws IOException {
        String name = console.readLine();

        if (cardIsInValid(name)) {
            if (cardIsInTheDeck(deck, name)) {
                Card card = deck.get(name);
                deck.remove(name);
                person1.addCard(card);
            } else {
                System.out.println("Card is not in the deck.");
            }
        } else {
            System.out.println("No such card exists.");
        }


    }

    private static boolean cardIsInValid(String name) {
        try {
            String[] types = name.split(" of ");
            String rank = types[0];
            String suit = types[1];
            CardRank.valueOf(rank);
            CardSuit.valueOf(suit);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private static boolean cardIsInTheDeck(HashMap<String, Card> deck, String card) {
        return deck.get(card) != null;
    }
}
