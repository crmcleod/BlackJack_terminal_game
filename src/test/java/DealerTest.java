import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;

    @Before
    public void before(){
        this.dealer = new Dealer();
    }

    @Test
    public void addPlayerToPlayerArray(){
        Player player = new Player("Alex");
        this.dealer.addPlayer(player);
        assertEquals(1, dealer.playerArrayLength());
    }

}
