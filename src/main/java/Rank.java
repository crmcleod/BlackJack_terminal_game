public enum Rank {

    ACE(1,11, "Ace"),
    TWO(2,2, "Two"),
    THREE(3,3, "Three"),
    FOUR(4,4, "Four"),
    FIVE(5,5, "Five"),
    SIX(6, 6,"Six"),
    SEVEN(7, 7,"Seven"),
    EIGHT(8, 8, "Eight"),
    NINE(9, 9,"Nine"),
    TEN(10, 10, "Ten"),
    JACK(10, 10, "Jack"),
    QUEEN(10, 10,"Queen"),
    KING(10, 10, "King");

    private final int value;
    private final int altValue;
    private final String rankString;

    Rank(int value, int altValue, String rankString){
        this.value = value;
        this.altValue = altValue;
        this.rankString = rankString;
    }

    public int getValue(){
        return this.value;
    }

    public String getRankString(){
        return this.rankString;
    }
}
