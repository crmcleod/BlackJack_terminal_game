import java.util.ArrayList;

public class Dealer {

    private ArrayList<PlayingCard> dealerHand;
    
    public Dealer() {
        this.dealerHand = new ArrayList<PlayingCard>();
    }

    public void addCardToHand(PlayingCard playingCard){
        this.dealerHand.add(playingCard);
    }

    public int handCount(){return this.dealerHand.size();}

    public int score(){
        int scoreTotal = 0;
        for (PlayingCard playingCard : this.dealerHand){
            scoreTotal += playingCard.getValue();
        }
        return scoreTotal;
    }

}