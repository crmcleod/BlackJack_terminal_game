import java.util.ArrayList;

public class Dealer {

    private ArrayList<Player> playerList;
    Deck deck;

    public Dealer(Deck deck) {
        this.playerList = new ArrayList<Player>();
        this.deck = deck;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public int playerArrayLength() {
        return this.playerList.size();
    }

    public void dealCardsToAllPlayers(int noOfCards) {
        for (Player player : this.playerList) {
            for (int i = 0; i < noOfCards; i++) {
                PlayingCard playingCard = deck.dealCard();
                player.addCardToHand(playingCard);
            }
        }
    }

    public String getWinner() {
        int highScore = 0;
        String winner = "";
        for (Player player : this.playerList) {
            if (player.score() > highScore) {
                highScore = player.score();
                winner = player.getName();
            }
        }
        return winner;
    }
}