import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Game game = new Game(deck, dealer);

        System.out.println("Welcome to Babs' Casino. Would you like to play BlackJack? (y/n)");

        String input = scanner.next();
        if (input == "n") {
            System.exit(0);
        }
        System.out.println("How many players would you like to start with?");
        String inputPlayerNo = scanner.next();
        int players = parseInt(inputPlayerNo);

        for (int i = 0; i < players; i++) {
            String prompt = String.format("Gambler %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }
        game.dealCardsToAllPlayers(2);
        System.out.println("Dealer's hand: ");
        System.out.println(dealer.showStartingHand());
        System.out.println("------------");


        for (Player player : game.getPlayerList()) {
            System.out.println("------------");
            String output = String.format("%s's hand:", player.getName());
            System.out.println(output);
            for (int i = 0; i < player.handCount(); i++) {
                System.out.println(player.getCardFromHand(i).cardName());}
            String stickTwistQ = String.format("%s would you like to stick or twist? (s/t)", player.getName());
            String stickTwist = "t";
            while (stickTwist.equals("t")){
                String score = String.format("Your score is %s", player.score());
                System.out.println(score);
                System.out.println("------------");
                if(player.checkIfBust()==true){
                    System.out.println("Bust! Sorry.");
                    System.out.println("------------");

                    stickTwist = "s";
                } else {
                System.out.println(stickTwistQ);
                stickTwist = scanner.next();
                if (stickTwist.equals("t")) {
                    player.twist(deck.dealCard());
                    for (int i = 0; i < player.handCount(); i++) {
                        System.out.println(player.getCardFromHand(i).cardName());
                        }
                    }
                }
            }
        }

        System.out.println("Dealer shows other card:");
        dealer.showHiddenCard();
        System.out.println(dealer.showCurrentHand());
        if (dealer.score() <16){
            System.out.println("The dealer will draw again:"); }

        game.dealerTwist();
        for (int i = 0; i < dealer.handCount(); i++) {
            System.out.println(dealer.getCard(i));}

        String winner = String.format("%s is the winner!", game.getWinner());
        System.out.println(winner);

        String inputEnd = scanner.next();

    }}
