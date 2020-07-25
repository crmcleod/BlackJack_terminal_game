import java.util.ArrayList;

public class Dealer {

    private ArrayList<PlayingCard> dealerHand;
    private boolean isBust;

    public Dealer() {
        this.dealerHand = new ArrayList<PlayingCard>();
        this.isBust = false;
    }

    public void addCardToHand(PlayingCard playingCard){
        this.dealerHand.add(playingCard);
    }

    public int handCount(){return this.dealerHand.size();}

    public int score(){
        int scoreTotal = 0;
        for (PlayingCard playingCard : dealerHand){
            scoreTotal += playingCard.getValue();
        }
        if (scoreTotal < 21){
            return scoreTotal;}
        else if (scoreTotal > 21){
            isBust = true;
        }
        return scoreTotal;
    }

}