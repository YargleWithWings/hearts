import java.util.*;

public class CardSharkA extends CardPlayer
{

   public CardSharkA(String name, int score, ArrayList<Card> hand) {
      super(name,score,hand); 
   }
   
   public Card chooseCard (ArrayList<Card> played, ArrayList<Card> allplayed) {
      Card fcard = new Card("2", "clubs", 2);
      Card qscard = new Card("Q", "spades", 12);
      //start game 
      if (allplayed.size() < 1 && super.getHand().indexOf(fcard) != -1) {
         return playCard(super.getHand().indexOf(fcard));
      
      }
      //first player in round
      else if (allplayed.size() > 0 && played.size() == 0) {
         int randnum = (int) (Math.random() * (super.getHand().size()));
         return playCard(randnum);
      }
      
      else {
         String fsuit = played.get(0).getSuit();
         ArrayList<Card> suitmatch = new ArrayList<Card>();
         ArrayList<Card> heartmatch = new ArrayList<Card>();
         for (Card c: super.getHand()) {
            if (c.getSuit().equals(fsuit)) {
               suitmatch.add(c);
            }
            if(c.getSuit().equals("hearts")){
               heartmatch.add(c);
            }     
         }
         
         //if suit matches, try to play card smaller than the first card played 
         if (suitmatch.size() > 0) {
            Card min = suitmatch.get(0);
            for (int x = 0; x < suitmatch.size(); x++) {
               if (suitmatch.get(x).getRank() < min.getRank()) {
                  min = suitmatch.get(x);
               }
            }
            return (playCard(super.getHand().indexOf(min)));
         }
         
         //if suit does not match and have Q of spades, play it  
         else if (super.getHand().indexOf(qscard) != -1) {
            return (playCard(super.getHand().indexOf(qscard)));
         }
         
         //if no suit match or Q of spades play highest heart
         else if (heartmatch.size() > 0) {
            Card highheartcard = heartmatch.get(0);
            //System.out.println(highheartcard); //
            Card maxheart = heartmatch.get(0);
            for (int x = 0; x < heartmatch.size(); x++) {
               if (heartmatch.get(x).getRank() > maxheart.getRank()) {
                  maxheart = heartmatch.get(x);
               }
            }            
            return (playCard(super.getHand().indexOf(maxheart))); 
         } 
         
         //if no suit or heart matches, play the highest card left
         else {
            Card max = super.getHand().get(0);
            for (int x = 0; x < heartmatch.size(); x++) {
               if (super.getHand().get(x).getRank() > max.getRank()) {
                  max = super.getHand().get(x);
               }
            }            
            return (playCard(super.getHand().indexOf(max))); 
         } 
      }
   }

}
