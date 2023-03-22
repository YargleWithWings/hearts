import java.util.ArrayList;
import java.lang.Math;

public class TestDeck
{
    public static void main(String[] args)
    {
        // Create a new deck, then print it
        Deck deck1 = new Deck();
        System.out.println(deck1 + "\n");

        // Shuffle the deck, then test printing it again
        deck1.shuffle();
        System.out.println(deck1 + "\n");

        // Deal a card, then print that card. Repeat 12 more times.
        for(int i = 0; i<13; i++) {
            System.out.print(deck1.dealTopCard());
        }
        System.out.println("\n");

        // Print deck again, this time with 39 cards
        System.out.println(deck1 + "\n");

        // Deal a card, then print that card. Repeat 12 more times.
        for(int i = 0; i<13; i++) {
            System.out.print(deck1.dealTopCard());
        }
        System.out.println("\n");

        // Print deck again, this time with 26 cards
        System.out.println(deck1 + "\n");

        // Deal a card, then print that card. Repeat 12 more times.
        for(int i = 0; i<13; i++) {
            System.out.print(deck1.dealTopCard());
        }
        System.out.println("\n");

        // Print deck again, this time with 13 cards
        System.out.println(deck1 + "\n");

        // Deal a card, then print that card. Repeat 12 more times.
        for(int i = 0; i<13; i++) {
            System.out.print(deck1.dealTopCard());
        }
        System.out.println("\n");

        // Print deck again, this time with 0 cards
        System.out.println(deck1 + "\n");
        
        // Initialize a new deck
        Deck deck2 = new Deck();

        // Pick a random card from the deck
        Card cardToTest = deck2.getCard((int)(Math.random() * 52));
        System.out.println("random card from new deck " + cardToTest.toString());

        // Pick a random location in the deck to look at
        int location = (int)(Math.random() * 52);

        // Compare the card at location *location* with the test card to see if they match 52000 times
        int numFound = 0;
        for(int i = 0; i< 52000; i++){
            if(deck2.getCard(location).equals(cardToTest)){
                numFound++;
            }
            deck2.shuffle();
        }
        System.out.println("Found " + cardToTest +  " at location " + location + " in the deck " + numFound + " times out of 52000 shuffles.");
        

      ArrayList<Card> myDeck = new ArrayList<Card>();
      String[] names = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
      String[] suits = {"clubs", "spades", "hearts", "diamonds"};
      int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};         
     // check default constructor
      Deck deck = new Deck();
      System.out.println("Deck deck = new Deck();");
      System.out.println("  deck -> " + deck);
    
     // check setDeck() method
      for (int i=3; i>=0; i--) {
         for (int j=12; j>=0; j--) {
            Card card = new Card(names[j],suits[i],ranks[j]); 
            myDeck.add(card);   // ArrayList add() method 
         }
      }
      System.out.println("\nCode that creates myDeck ...");
      System.out.println("  myDeck -> " + myDeck);
  
      deck.setDeck(myDeck);
      System.out.println(myDeck);
      System.out.println("  deck.setDeck(myDeck);");
      System.out.println("  deck -> " + deck);
    
      System.out.println("  deck.getDeck() -> " + deck.getDeck());
    }
}