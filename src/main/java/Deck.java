import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<PlayingCard> cards;

    public Deck(){
        this.cards = new ArrayList<PlayingCard>();

            for (Suit cardSuit : Suit.values()){
                for (Rank cardRank : Rank.values()){
                    PlayingCard playingCard = new PlayingCard(cardSuit, cardRank);
                    this.cards.add(playingCard);
                }
            }
           Collections.shuffle(this.cards);
        }


    public int getCardCount(){
        return this.cards.size();
    }


    public PlayingCard dealCard(){
        return cards.remove(0);
    }
}
