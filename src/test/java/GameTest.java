import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Game game1;
    Dealer dealer;
    Dealer dealer1;
    Player player1;
    Player player2;
    Player player3;
    Deck deck;
    PlayingCard playingCard;
    PlayingCard playingCard2;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        dealer1 = new Dealer();
        player1 = new Player("Jackson");
        player2 = new Player("Earthworm Jim");
        player3 = new Player("Mr Schecter");
        this.game = new Game(deck, dealer);
        this.game1 = new Game(deck, dealer1);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game1.addPlayer(player3);
        this.playingCard = new PlayingCard(Suit.HEARTS, Rank.ACE);
        this.playingCard2 = new PlayingCard(Suit.DIAMONDS, Rank.FIVE);
        this.player1.addCardToHand(playingCard);
        this.player1.addCardToHand(playingCard);
        this.player2.addCardToHand(playingCard2);
        this.player2.addCardToHand(playingCard);
        this.dealer.addCardToHand(playingCard2);
        this.dealer.addCardToHand(playingCard2);

    }

    @Test
    public void addPlayerToPlayerArray(){
        assertEquals(2, game.playerArrayLength());
    }

    @Test
    public void canDealToPlayersAndDealer(){
        game1.dealCardsToAllPlayers(2);
        assertEquals(2, player3.handCount());
        assertEquals(2, dealer1.handCount());

    }

    @Test
    public void getWinner_house(){
        assertEquals("House wins!", game.getWinner());
    }

    @Test
    public void getWinner_player(){
        player1.addCardToHand(playingCard2);
        player1.addCardToHand(playingCard2);
        player1.addCardToHand(playingCard2);
        player1.addCardToHand(playingCard);
        player1.addCardToHand(playingCard);
        player1.addCardToHand(playingCard);
        player1.addCardToHand(playingCard);
        assertEquals("Jackson", game.getWinner());
    }

    @Test
    public void canDealCardsToDealer(){
        game.dealerTwist();
        assertEquals(3, dealer.handCount());
    }
}
