public class PlayingCard {

    private Suit suit;
    private Rank rank;

    public PlayingCard(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getValue() { return this.rank.getValue();}

    public String cardName() { return String.format("%s of %s", this.rank.getRankString(), this.suit.getSuitString());}
}
