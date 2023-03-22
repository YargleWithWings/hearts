import java.util.ArrayList;
import java.util.Collections;

public class CardPlayer extends Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> takenCards = new ArrayList<Card>();

    public CardPlayer(String name, int score, ArrayList<Card> hand) {
        super(name, score);
        this.hand = hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand.clear();
        this.hand.addAll(hand);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setTakenCards(ArrayList<Card> takenCards) {
        this.takenCards.clear();
        this.takenCards.addAll(takenCards);
    }

    public void clearTakenCards() {
        takenCards.clear();
    }

    public ArrayList<Card> getTakenCards() {
        return this.takenCards;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void takeCards(ArrayList<Card> takenCards) {
        this.takenCards.addAll(takenCards);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public int findPosOfCardInHand(Card card) {
        for(int i = 0; i<hand.size(); i++) {
            if(hand.get(i).equals(card)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Card> getCardsBySuit(ArrayList<Card> cards, String suit) {
        ArrayList<Card> toReturn = new ArrayList<Card>();
        for(Card item : cards) {
            if(item.getSuit().equals(suit)) {
                toReturn.add(item);
            }
        }
        Collections.sort(toReturn);
        return toReturn;
    }

    public Card chooseCard(ArrayList<Card> cardsPlayedThisRound, ArrayList<Card> cardsPlayedPreviousRounds) {
        int indexTwoClubs = this.hand.indexOf(new Card("2", "clubs", 2));
        if(indexTwoClubs >= 0) {
            return playCard(indexTwoClubs);
        }
        if(cardsPlayedThisRound.size() == 0) {
            return playCard((int)(Math.random() * hand.size()));
        }
        else {
            String suit = cardsPlayedThisRound.get(0).getSuit();
            ArrayList<Card> cardsOfSuit = getCardsBySuit(hand, suit);
            if(cardsOfSuit.size() > 0) {
                return playCard(findPosOfCardInHand(cardsOfSuit.get((int)(Math.random() * cardsOfSuit.size()))));
            }
            ArrayList<Card> hearts = getCardsBySuit(hand, "hearts");
            if(hearts.size() > 0) {
                return playCard(findPosOfCardInHand(hearts.get((int)(Math.random() * hearts.size()))));
            }
            else {
                return playCard((int)(Math.random() * hand.size()));
            }
        }
    }

    public ArrayList<Card> getCardsLessThanOrEqualToValue(ArrayList<Card> cards, int maxValue) {
        ArrayList<Card> toReturn = new ArrayList<Card>();
        for(int i = 0; i<cards.size(); i++) {
            if(cards.get(i).getRank() <= maxValue) {
                toReturn.add(cards.get(i));
            }
        }
        Collections.sort(toReturn, Collections.reverseOrder());
        return toReturn;
    }

    public int findMinimumOfSuit(ArrayList<Card> cards, String suit) {
        int minValue = 0;
        int locMinValue = -1;
        for(int i = 0; i<cards.size(); i++) {
            if(cards.get(i).getSuit().equals(suit) && cards.get(i).getRank() > minValue) {
                locMinValue = i;
            }
        }
        return locMinValue;
    }

    public String toString() {
        Collections.sort(hand);
        return super.getName() + " (" + super.getScore() + ") " + this.getHand();
    }

}