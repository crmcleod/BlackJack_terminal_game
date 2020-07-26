import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    PlayingCard playingCard1;
    PlayingCard playingCard2;

    @Before
    public void before(){
        dealer = new Dealer();
        playingCard1 = new PlayingCard(Suit.SPADES, Rank.NINE);
        playingCard2 = new PlayingCard(Suit.SPADES, Rank.JACK);
    }

    @Test
    public void showStartingHand(){
        dealer.addCardToHand(playingCard1);
        dealer.addCardToHand(playingCard2);
        assertEquals("Card 1 is Hidden : Card 2 is Jack of Spades", dealer.showStartingHand());
    }

    @Test
    public void showBothStartingCards(){
        dealer.addCardToHand(playingCard1);
        dealer.addCardToHand(playingCard2);
        System.out.println(dealer.showStartingHand());
        dealer.showHiddenCard();
        System.out.println(dealer.showCurrentHand());
        assertEquals("Card 1 is Nine of Spades : Card 2 is Jack of Spades", dealer.showCurrentHand());
    }
}
