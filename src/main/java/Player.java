import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<PlayingCard> hand;

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
}
