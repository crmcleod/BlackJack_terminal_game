import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<PlayingCard> hand;
    private Dealer dealer;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<PlayingCard>();
    }

    public void addCardToHand(PlayingCard playingCard){
        this.hand.add(playingCard);
    }

    public int handCount(){
        return this.hand.size();
    }

    public String getName() {
        return name;
    }

    public int score(){
        int scoreTotal = 0;
        for (PlayingCard playingCard : this.hand){
            scoreTotal += playingCard.getValue();
        }
        return scoreTotal;
    }
}
