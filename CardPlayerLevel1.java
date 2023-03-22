import java.util.ArrayList;
import java.util.Collections;

public class CardPlayerLevel1 extends CardPlayer {
    public CardPlayerLevel1(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    @Override
    public Card chooseCard(ArrayList<Card> cardsPlayedThisRound, ArrayList<Card> cardsPlayedPreviousRounds) {
        int indexTwoClubs = this.getHand().indexOf(new Card("2", "clubs", 2));
        if(indexTwoClubs >= 0) {
            return playCard(indexTwoClubs);
        }
        if(cardsPlayedThisRound.size() == 0) {
            return playCard((int)(Math.random() * getHand().size()));
        }
        else {
            String suit = cardsPlayedThisRound.get(0).getSuit();
            ArrayList<Card> cardsOfSuit = getCardsBySuit(getHand(), suit);
            if(cardsOfSuit.size() > 0) {
                return playCard(findPosOfCardInHand(cardsOfSuit.get((int)(Math.random() * cardsOfSuit.size()))));
            }
            int indexQueenSpades = this.getHand().indexOf(new Card("Q", "spades", 12));
            if(indexQueenSpades >= 0) {
                return playCard(indexQueenSpades);
            }
            ArrayList<Card> hearts = getCardsBySuit(getHand(), "hearts");
            Collections.sort(hearts, Collections.reverseOrder());
            if(hearts.size() > 0) {
                return playCard(findPosOfCardInHand(hearts.get(0)));
            }
            else {
                return playCard((int)(Math.random() * getHand().size()));
            }
        }
    }
}