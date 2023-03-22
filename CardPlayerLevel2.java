import java.util.*;

public class CardPlayerLevel2 extends CardPlayer {
   public CardPlayerLevel2(String name, int score, ArrayList<Card> hand) {
      super(name, score, hand);
   }
   @Override
   public Card chooseCard(ArrayList<Card> cardsPlayedThisRound, ArrayList<Card> cardsPlayedPreviousRounds) {
      // If you have the two of clubs, play the two of clubs
      int indexTwoClubs = this.getHand().indexOf(new Card("2", "clubs", 2));
      if(indexTwoClubs >= 0) {
         return playCard(indexTwoClubs);
      }
      
      // If you're the starting player
      else if(cardsPlayedThisRound.size() == 0) {
         // TODO add optimization
         Collections.sort(getHand());
         return playCard(0);
      }
      
      else {
         // If you aren't the starting player, get the suit of the round
         String suit = cardsPlayedThisRound.get(0).getSuit();
         ArrayList<Card> cardsOfSuit = getCardsBySuit(getHand(), suit);
         
         // Check if you have the queen of spades
         int indexQueenSpades = this.getHand().indexOf(new Card("Q", "spades", 12));
         if(suit.equals("spades")) {
            // If the suit is spades and you have the queen, play her if they've already played the king or ace
            if(indexQueenSpades >= 0) {
               cardsOfSuit.remove(new Card("Q", "spades", 12));
               if(cardsPlayedThisRound.indexOf(new Card("K","spades",13)) >= 0 || cardsPlayedThisRound.indexOf(new Card("A","spades",14)) >= 0) {
                  return playCard(indexQueenSpades);
               }
            }
         }
         
         // If you have cards of the suit and people have played hearts, play your lowest. Otherwise play your highest.
         if (cardsOfSuit.size() > 0){
            if(getCardsBySuit(cardsPlayedThisRound, "hearts").size() > 0) {
               return playCard(findPosOfCardInHand(cardsOfSuit.get(0)));
            }
            else {
               return playCard(findPosOfCardInHand(cardsOfSuit.get(cardsOfSuit.size()-1)));
            }
         }
         
         // If you don't have any cards of the suit and you have the queen of spades, play her. Otherwise if you have hearts, play hearts. Otherwise, play anything.
         else {
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
}