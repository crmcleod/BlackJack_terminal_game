import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

        Deck deck;

        @Before
        public void before(){

            deck = new Deck();
        }

//        @Test
//        public void deckStartsEmpty(){
//            assertEquals(0, deck.getCardCount());
//        }

        @Test
        public void canFillDeck(){
            assertEquals(52, deck.getCardCount());
        }

        @Test
        public void canDealCard(){
            PlayingCard testPlayingCard = new PlayingCard(Suit.HEARTS, Rank.SIX);
            assertEquals(testPlayingCard.getClass().getName(), deck.dealCard().getClass().getName());
        }

        @Test
        public void dealingRemovesCard(){
            this.deck.dealCard();
            assertEquals(51, this.deck.getCardCount());
        }
}