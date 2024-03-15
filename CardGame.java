import java.util.ArrayList;

public class CardGame {
   private Deck deckOfCards;
   private String nameOfGame;
   private ArrayList<CardPlayer> players;
   private int numberOfPlayers;
   private int currentPlayer;

   public CardGame(String nameOfGame, int numberOfPlayers, String[] names, int currentPlayer) {
      deckOfCards = new Deck();
      this.nameOfGame = nameOfGame;
      this.numberOfPlayers = numberOfPlayers;
      this.currentPlayer = currentPlayer;
      players = new ArrayList<CardPlayer>();

      players.add(new CardSharkA(names[0], 0, new ArrayList<Card>()));
      for (int i = 1; i<numberOfPlayers; i++) {
         players.add(new CardPlayer(names[i], 0, new ArrayList<Card>()));
      }
   }

   public Deck getDeckOfCards() {
      return deckOfCards;
   }

   public String getNameOfGame() {
      return nameOfGame;
   }

   public ArrayList<CardPlayer> getPlayers() {
      return players;
   }

   public int getNumberOfPlayers() {
      return numberOfPlayers;
   }

   public int getCurrentPlayer() {
      return currentPlayer;
   }

   public void setDeckOfCards(Deck deckOfCards) {
      this.deckOfCards = deckOfCards;
   }

   public void setNameOfGame(String nameOfGame) {
      this.nameOfGame = nameOfGame;
   }

   public void setPlayers(ArrayList<CardPlayer> players) {
      this.players = players;
   }

   public void setNumberOfPlayers(int numberOfPlayers) {
      this.numberOfPlayers = numberOfPlayers;
   }

   public void setCurrentPlayer(int currentPlayer) {
      this.currentPlayer = currentPlayer;
   }

   public void deal(int numCards, int playerIndex) {
      for (int i = 0; i < numCards; i++) {
         players.get(playerIndex).addCard(deckOfCards.dealTopCard());
      }
   }

   public void playGame() {
      // Initialize my lists of cards
      ArrayList<Card> cardsPlayedThisRound = new ArrayList<Card>();
      ArrayList<Card> cardsPlayedPreviousRounds = new ArrayList<Card>();

      // Pick the starting player based on the 2 of clubs
      setCurrentPlayerToStartingPlayer();
      int startingPlayer = currentPlayer;

      // Play 13 rounds
      for (int i = 0; i < 13; i++) {

         // For each round, go through each player
         for (int j = 0; j < numberOfPlayers; j++) {
            currentPlayer = (j + startingPlayer) % numberOfPlayers;

            // Have the player choose a card, then play it and add it to
            // cardsPlayedThisRound
            cardsPlayedThisRound
                  .add(players.get(currentPlayer).chooseCard(cardsPlayedThisRound, cardsPlayedPreviousRounds));
         }
         checkRound(cardsPlayedThisRound, startingPlayer);
         int whoTookRound = pickWhoTakesRound(startingPlayer, cardsPlayedThisRound);
         players.get(whoTookRound).takeCards(cardsPlayedThisRound);
         startingPlayer = whoTookRound;
         cardsPlayedPreviousRounds.addAll(cardsPlayedThisRound);
         cardsPlayedThisRound.clear();
      }

      // Update each players score
      for (CardPlayer player : players) {
         player.updateScore(scoreForGame(player.getTakenCards()));
         player.clearTakenCards();
      }

   }

   public int pickWhoTakesRound(int playerThatLed, ArrayList<Card> cardsPlayedThisRound) {
      String suitThatWeCareAbout = cardsPlayedThisRound.get(0).getSuit();
      int highestValueOfSuit = cardsPlayedThisRound.get(0).getRank();
      int indexToReturn = playerThatLed;

      for (int i = 1; i < cardsPlayedThisRound.size(); i++) {
         Card card = cardsPlayedThisRound.get(i);
         if (card.getSuit().equals(suitThatWeCareAbout) && card.getRank() > highestValueOfSuit) {
            indexToReturn = (i + playerThatLed) % numberOfPlayers;
         }
      }
      return indexToReturn;
   }

   public int scoreForGame(ArrayList<Card> cardsToScore) {
      int score = 0;
      for (Card card : cardsToScore) {
         if (card.getSuit().equals("hearts")) {
            score++;
         } else if (card.getSuit() == "spades" && card.getRank() == 12) {
            score += 13;
         }
      }
      return score;
   }

   public void setCurrentPlayerToStartingPlayer() {
      for (int i = 0; i < players.size(); i++) {
         if (players.get(i).getHand().contains(new Card("2", "clubs", 2))) {
            currentPlayer = i;
         }
      }
   }

   public String toString() {
      String toReturn = "***" + nameOfGame + "***" + "\n";
      for (CardPlayer player : players) {
         toReturn += player + "\n";
      }
      toReturn += "deck -> " + deckOfCards;
      return toReturn;
   }

   static int errorsInCheckRound;

   public void checkRound(ArrayList<Card> round, int startingPlayer) {
      if (errorsInCheckRound < 5) {
         // System.out.print(startingPlayer + " ");
         String roundSuit = round.get(0).getSuit(); // Suit that was led
         for (int i = 1; i < round.size(); i++) { // for all other cards played in the round
            if (!round.get(i).getSuit().equals(roundSuit)) {
               CardPlayer player = players.get((i + startingPlayer) % round.size());
               for (Card c : player.getHand()) { // check each card in that players hand
                  if (c.getSuit().equals(roundSuit)) {
                     System.out.println("*** DID NOT FOLLOW SUIT ***\n  round=" + round + "\n  played=" + round.get(i)
                           + "\n  hand=" + player.getHand());
                     errorsInCheckRound++;
                     break;
                  }
               }
            }
         }
      }
   }

}