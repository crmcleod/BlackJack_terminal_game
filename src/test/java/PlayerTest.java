import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;
    private Player player2;
    private PlayingCard playingCard;
    private PlayingCard playingCard2;
    private Dealer dealer;
    private Deck deck;
    private Game game;

    @Before
    public void before(){
        this.player1 = new Player("Harrison");
        this.player2 = new Player("Tommy Pickles");
        this.playingCard = new PlayingCard(Suit.HEARTS, Rank.ACE);
        this.playingCard2 = new PlayingCard(Suit.DIAMONDS, Rank.FIVE);
        this.player1.addCardToHand(playingCard);
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.game = new Game(deck, dealer);

    }

    @Test
    public void getName() {
        assertEquals("Harrison", this.player1.getName());
    }

    @Test
    public void handCount() {
        assertEquals(1, player1.handCount());
    }

    @Test
    public void getScoreInHand_oneCard(){
        assertEquals(1, player1.score());
    }

    @Test
    public void getScoreInHand_multipleCards(){
        this.player1.addCardToHand(playingCard2);
        assertEquals(6, player1.score());
    }

    @Test
    public void getWinner(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        this.player2.addCardToHand(playingCard2);
        assertEquals("Tommy Pickles", game.getWinner());
    }

    @Test
    public void isBustStartsFalse(){
        assertEquals(false, player1.checkIfBust());
    }

    @Test
    public void isBust_true(){
        this.player1.addCardToHand(playingCard2);
        this.player1.addCardToHand(playingCard2);
        this.player1.addCardToHand(playingCard2);
        this.player1.addCardToHand(playingCard2);
        this.player1.addCardToHand(playingCard2);
        assertEquals(26, player1.score());
        assertEquals(true, player1.checkIfBust());
    }
}
