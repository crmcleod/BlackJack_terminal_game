import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<PlayingCard> hand;
    private boolean isBust;
    private boolean isStuck;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<PlayingCard>();
        this.isBust = false;
        this.isStuck = false;
    }

    public void addCardToHand(PlayingCard playingCard){
        if (isStuck == false) {
        this.hand.add(playingCard);}
    }

    public String getCardRankString(int index){
        return hand.get(index).getRankString();
    }

    public int getCardValue(int index){
        return hand.get(index).getValue();
    }

    public boolean checkIfBlackJack(){
        boolean blackJack = false;
        if ((getCardRankString(0).equals("Ace") && getCardValue(1) == 10) ||
                (getCardRankString(1).equals("Ace") && getCardValue(0) == 10)){
            blackJack = true;}
        return blackJack;
    }

    public void twist(PlayingCard playingCard){
        addCardToHand(playingCard);
    }

    public void stick(){
        this.isStuck = true;
    }

    public int handCount(){
        return this.hand.size();
    }

    public String getName() {
        return name;
    }

    public PlayingCard getCardFromHand(int i){
        return hand.get(i);
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
