import java.util.ArrayList;

public class Dealer {

    private ArrayList<PlayingCard> dealerHand;
    private boolean isBust;
    private String startingCard1;
    private String startingCard2;

    public Dealer() {
        this.dealerHand = new ArrayList<PlayingCard>();
        this.isBust = false;
        this.startingCard1 = "Hidden";
        this.startingCard2 = "";
    }

    public void addCardToHand(PlayingCard playingCard){
        this.dealerHand.add(playingCard);
    }

    public int handCount(){return this.dealerHand.size();}

    public boolean checkIfBust(){
        return isBust;
    }

    public int score(){
        int scoreTotal = 0;
        for (PlayingCard playingCard: dealerHand){
            scoreTotal += playingCard.getValue();
        }
        if (scoreTotal < 21){
            return scoreTotal;}
        else if (scoreTotal > 21){
            isBust = true;
        }
        return scoreTotal;
    }

    public String getCard(int index){
       return dealerHand.get(index).cardName();
    }

    public String getCardRankString(int index){
        return dealerHand.get(index).getRankString();
    }

    public int getCardValue(int index){
        return dealerHand.get(index).getValue();
    }

    public boolean checkIfBlackJack(){
        boolean blackJack = false;
        if ((getCardRankString(0).equals("Ace") && getCardValue(1) == 10) ||
                (getCardRankString(1).equals("Ace") && getCardValue(0) == 10)){
                    blackJack = true;}
        return blackJack;
    }

    public String showStartingHand(){
        startingCard2 = getCard(1);
        return String.format("Card 1 is %s : Card 2 is %s", startingCard1, startingCard2);
    }

    public void showHiddenCard(){
        startingCard1 = getCard(0);
    }

    public String showCurrentHand(){
        startingCard2 = getCard(1);
        return String.format("Card 1 is %s : Card 2 is %s", startingCard1, startingCard2);
    }


}