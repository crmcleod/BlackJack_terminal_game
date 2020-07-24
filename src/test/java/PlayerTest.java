import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Player player2;
    private PlayingCard playingCard;
    private PlayingCard playingCard2;
    private Dealer dealer;
    private Deck deck;

    @Before
    public void before(){
        this.player = new Player("Harrison");
        this.player2 = new Player("Tommy Pickles");
        this.playingCard = new PlayingCard(Suit.HEARTS, Rank.ACE);
        this.playingCard2 = new PlayingCard(Suit.DIAMONDS, Rank.FIVE);
        this.player.addCardToHand(playingCard);
        this.dealer = new Dealer(deck);

    }

    @Test
    public void getName() {
        assertEquals("Harrison", this.player.getName());
    }

    @Test
    public void handCount() {
        assertEquals(1, player.handCount());
    }

    @Test
    public void getScoreInHand_oneCard(){
        assertEquals(1, player.score());
    }

    @Test
    public void getScoreInHand_multipleCards(){
        this.player.addCardToHand(playingCard2);
        assertEquals(6, player.score());
    }

    @Test
    public void getWinner(){
        dealer.addPlayer(player);
        dealer.addPlayer(player2);
        this.player2.addCardToHand(playingCard2);
        assertEquals("Tommy Pickles", dealer.getWinner());
        System.out.println(dealer.getWinner());
    }
}
