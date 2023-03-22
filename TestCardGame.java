
public class TestCardGame {
    public static void main(String[] args) {
        String[] players = {"Player0","Player1","Player2","Player3"};
        CardGame game = new CardGame("hearts", 4, players, 0);
        int numRoundsToPlay = 10_000;
        for(int i = 0; i<numRoundsToPlay; i++) {
            game.getDeckOfCards().initializeDeck();
            game.getDeckOfCards().shuffle();
            for(int j = 0; j<players.length; j++) {
                game.deal(13, j);
            }
            game.playGame();
        }

        int totalBadPoints = 26*numRoundsToPlay;
        System.out.println("Total Number of Bad Points = " + totalBadPoints);
        for(int k = 0; k<players.length; k++) {
            System.out.printf("%s %2d   ",game.getPlayers().get(k).getName(),game.getPlayers().get(k).getScore());
            System.out.println(" " + Math.round((game.getPlayers().get(k).getScore() / (double) totalBadPoints)*100) + "%");
        }
    }
}
