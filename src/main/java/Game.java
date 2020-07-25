import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList;
    Deck deck;
    Dealer dealer;

    public Game(Deck deck, Dealer dealer) {
        this.playerList = new ArrayList<Player>();
        this.deck = deck;
        this.dealer = dealer;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public int playerArrayLength() {
        return this.playerList.size();
    }

    public void dealCardsToAllPlayers(int noOfCards) {
        dealCardsToDealer(noOfCards);
        for (Player player : this.playerList) {
            for (int i = 0; i < noOfCards; i++) {
                PlayingCard playingCard = deck.dealCard();
                player.addCardToHand(playingCard);
            }
        }
    }

    public void dealCardsToDealer(int noOfCards){
        for (int i = 0; i < noOfCards; i++){
            PlayingCard dealerCard = deck.dealCard();
            dealer.addCardToHand(dealerCard);
        }
    }

    public String getWinner() {
        int highScore = dealer.score();
        String winner = "House wins!";
        for (Player player : this.playerList) {
            if (player.score() > highScore) {
                highScore = player.score();
                winner = player.getName();
            }
        }
        return winner;
    }

}
