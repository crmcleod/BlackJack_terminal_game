import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    Deck deck;
    Player player1;
    Player player2;
    Game game;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        player1 = new Player("Jackson");
        player2 = new Player("Earthworm Jim");
        this.game = new Game(deck, dealer);
        game.addPlayer(player1);
        game.addPlayer(player2);
    }
}
