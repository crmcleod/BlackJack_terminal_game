import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<PlayingCard> hand;
    private boolean isBust;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<PlayingCard>();
        this.isBust = false;
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

    public boolean checkIfBust(){
        return isBust;
    }

    public int score(){
        int scoreTotal = 0;
        for (PlayingCard playingCard : hand){
            scoreTotal += playingCard.getValue();
        }
        if (scoreTotal <= 21){
        return scoreTotal;}
        else if (scoreTotal > 21){
            this.isBust = true;
        }
        return scoreTotal;
    }
}
