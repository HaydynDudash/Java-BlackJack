import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //building casino with players
        Casino casino = new Casino();
        casino.numOfPlayers();
        casino.getStatus();
        ArrayList<Player> players = casino.getPlayers();

        //creating new deck and give deck to dealer to do his job
        Deck deck = new Deck();
        Dealer dealer = new Dealer(players, deck);
        while(players.size() > 0) {
            deck.createDeck();
            deck.shuffleDeck();

            //clears everything
            casino.resetPlayersForRounds();
            dealer.clearHand();
            //gets players for new round
            casino.choosePlayerForNextRound();
            boolean anyPlayersLeft = false;

           //check if everyone is playing
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getStatus()) {
                    anyPlayersLeft = true; //if you can still bet there is players
                }
            }
            //if no one has money or wants to play
            if (!anyPlayersLeft){
                System.out.println("No players are playing this round.");
                break;
            }
            //dealer deals his hand
            dealer.dealerHand();
            dealer.showDealerCard();
            //loop for betting
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getStatus()){
                    players.get(i).getPlayerBet();
                }
            }
           //player chooses from dealer hand
            dealer.dealCards();
            dealer.playerChoice();
            dealer.dealerPlay();
            System.out.println("Dealer's final hand:");
            dealer.showDealerHand();

            //win
            casino.winner(dealer);
            System.out.println();
            System.out.println("End of round.");

        }
        System.out.println("No players remaining. The game is over.");


    }
}
