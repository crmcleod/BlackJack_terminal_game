import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {
    Dealer dealer;
    PlayingCard playingCard1;
    PlayingCard playingCard2;
    PlayingCard playingCard3;
    PlayingCard playingCard4;

    @Before
    public void before(){
        dealer = new Dealer();
        playingCard1 = new PlayingCard(Suit.SPADES, Rank.NINE);
        playingCard2 = new PlayingCard(Suit.SPADES, Rank.JACK);
        playingCard3 = new PlayingCard(Suit.SPADES, Rank.ACE);
        playingCard4 = new PlayingCard(Suit.SPADES, Rank.JACK);
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
        dealer.showHiddenCard();
        assertEquals("Card 1 is Nine of Spades : Card 2 is Jack of Spades", dealer.showCurrentHand());
    }

    @Test
    public void blackJackTrue(){
        dealer.addCardToHand(playingCard3);
        dealer.addCardToHand(playingCard4);
        assertTrue(dealer.checkIfBlackJack());
    }

    @Test
    public void blackJackTrueCardsSwapped(){
        dealer.addCardToHand(playingCard4);
        dealer.addCardToHand(playingCard3);
        assertTrue(dealer.checkIfBlackJack());
    }

    @Test
    public void blackJackFalse(){
        dealer.addCardToHand(playingCard1);
        dealer.addCardToHand(playingCard4);
        assertFalse(dealer.checkIfBlackJack());
    }
}
