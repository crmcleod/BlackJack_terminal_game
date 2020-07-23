import java.util.ArrayList;

public class Dealer {
    private ArrayList<Player> playerList;

    public Dealer(){
        this.playerList = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public int playerArrayLength(){
        return this.playerList.size();
    }

//    public PlayingCard dealCard(){
//        this.deck.dealCard();
//    }


}
