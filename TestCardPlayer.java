import java.util.ArrayList;

public class TestCardPlayer {
    public static void main(String[] args) {
        /* 
        // Declare and print the new card player, Kara
        CardPlayer kara = new CardPlayer("Kara Jones", 0, new ArrayList<Card>());
        System.out.println("New CardPlayer --> " + kara);

        // Add 6 new cards to Kara's hand
        kara.addCard(new Card("3", "diamonds", 3));
        kara.addCard(new Card("A", "hearts", 14));
        kara.addCard(new Card("6", "spades", 6));
        kara.addCard(new Card("7", "spades", 7));
        kara.addCard(new Card("2", "clubs", 2));
        kara.addCard(new Card("3", "clubs", 3));

        // Print Kara again
        System.out.println("After adding 6 specific cards, print kara --> " + kara);

        // Play card at index 5
        System.out.println("Played " + kara.playCard(5) + " at index 5");

        // Uptate score to 27
        kara.setScore(27);
        System.out.println("Updated score to 27");

        // Print Kara
        System.out.println("Player --> " + kara);

        // Set cards played this round
        ArrayList<Card> cardsPlayedThisRound = new ArrayList<Card>();
        ArrayList<Card> cardsPlayedThisGame = new ArrayList<Card>();
        System.out.println("Cards played this round --> " + cardsPlayedThisRound);
        System.out.println("Cards played this game --> " + cardsPlayedThisGame);

        // Choose card to start with
        System.out.println("Chose card " + kara.chooseCard(cardsPlayedThisRound, cardsPlayedThisGame));

        // Print Kara
        System.out.println("Player --> " + kara);

        // Update cards played this round to include a spade
        cardsPlayedThisRound.add(new Card("10","spades",10));
        System.out.println("Cards played this round -->  " + cardsPlayedThisRound);

        // Choose card
        System.out.println("Randomly chosen spade = " + kara.chooseCard(cardsPlayedThisRound, cardsPlayedThisGame));
        System.out.println("Player --> " + kara);

        // Update cards played this round to a club
        cardsPlayedThisRound.clear();
        cardsPlayedThisRound.add(new Card("9", "clubs", 9));
        System.out.println("Cards played this round updated --> " + cardsPlayedThisRound);

        // Choose card
        System.out.println("Randomly chosen (heart) is " + kara.chooseCard(cardsPlayedThisRound, cardsPlayedThisGame));
        System.out.println("Player --> " + kara);

        // clear cards played this round, then print a (hopefully) random card
        cardsPlayedThisRound.clear();
        System.out.println("Randomly chosen card = " + kara.chooseCard(cardsPlayedThisRound, cardsPlayedThisGame));
    */
    Card[] deck = { /*new Card("3", "clubs", 3),*/ new Card("2", "clubs", 2), new Card("7", "spades", 7),
                new Card("A", "hearts", 14), new Card("6", "spades", 6), new Card("3", "diamonds", 3), 
                new Card("3", "hearts", 3), new Card("Q", "spades", 12) };

        ArrayList<Card> deck2 = new ArrayList<Card>();
        for (Card card : deck) {
            deck2.add(card);
        }

        CardPlayerLevel2 person = new CardPlayerLevel2("Kara Jones", 0, deck2);
        System.out.println("New CardPlayer -> " + person);
        // System.out.println("Played " + person.playCard(6) + " at index 5");
        ArrayList<Card> round = new ArrayList<Card>();
        ArrayList<Card> previousRound = new ArrayList<Card>();
        System.out.println("Starting a game: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        round.add(new Card("10", "spades", 10));
        System.out.println("Playing card to follow 10 of spades: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);

        round.clear();
        round.add(new Card("9", "clubs", 9));
        System.out.println("Playing card to follow 9 of clubs (should be the queen): " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        System.out.println(
                "Playing card to follow 9 of clubs (should be the highest heart): " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);

        round.clear();
        System.out.println("Playing a random card: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        System.out.println("Playing a random card: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
    }
}
