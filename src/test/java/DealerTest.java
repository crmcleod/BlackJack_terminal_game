import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer(deck);
        player1 = new Player("Jackson");
        player2 = new Player("Earthworm Jim");
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
    }

    @Test
    public void addPlayerToPlayerArray(){
        assertEquals(2, dealer.playerArrayLength());
    }

    @Test
    public void canDealToAllPlayers(){
        dealer.dealCardsToAllPlayers(2);
        assertEquals(2, player1.handCount());
        assertEquals(2, player2.handCount());

    }

}
