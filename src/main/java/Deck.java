import java.util.ArrayList;

public class Deck {

    private ArrayList<PlayingCard> cards;

    public Deck(){
        this.cards = new ArrayList<PlayingCard>();
    }

    public int getCardCount(){
        return this.cards.size();
    }


    public ArrayList<PlayingCard> fillDeck() {
        for (Suit cardSuit : Suit.values()){
            for (Rank cardRank : Rank.values()){
                PlayingCard playingCard = new PlayingCard(cardSuit, cardRank);
                this.cards.add(playingCard);
                System.out.println(playingCard.getSuit().getString());
            }
        }
        return cards;
    }
}
