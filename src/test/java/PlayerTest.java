import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player1;
    Player player2;
    PlayingCard playingCard;
    PlayingCard playingCard2;
    PlayingCard playingCard3;
    PlayingCard playingCard4;
    Dealer dealer;
    Deck deck;
    Game game;

    @Before
    public void before(){
        this.player1 = new Player("Harrison");
        this.player2 = new Player("Tommy Pickles");
        this.playingCard = new PlayingCard(Suit.HEARTS, Rank.ACE);
        this.playingCard2 = new PlayingCard(Suit.DIAMONDS, Rank.FIVE);
        this.playingCard3 = new PlayingCard(Suit.DIAMONDS, Rank.JACK);
        this.playingCard4 = new PlayingCard(Suit.DIAMONDS, Rank.ACE);
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
        player1.addCardToHand(playingCard2);
        player2.addCardToHand(playingCard2);
        player2.addCardToHand(playingCard2);
        player2.addCardToHand(playingCard2);
        player2.addCardToHand(playingCard2);
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

    @Test
    public void canTwist(){
        this.player1.addCardToHand(playingCard2);
        this.player1.twist(playingCard2);
        assertEquals(3, player1.handCount());
    }

    @Test
    public void canStick(){
        this.player1.stick();
        this.player1.twist(playingCard2);
        this.player1.twist(playingCard2);
        this.player1.twist(playingCard2);
        assertEquals(1, player1.handCount());
    }
    @Test
    public void blackJackTrue(){
        player1.addCardToHand(playingCard3);
        player1.addCardToHand(playingCard4);
        assertTrue(player1.checkIfBlackJack());
    }

    @Test
    public void blackJackTrueCardsSwapped(){
        player1.addCardToHand(playingCard3);
        assertEquals(true, player1.checkIfBlackJack());
    }

    @Test
    public void blackJackFalse(){
        player1.addCardToHand(playingCard);
        player1.addCardToHand(playingCard4);
        assertFalse(player1.checkIfBlackJack());
    }

}
