import java.util.ArrayList;
import java.util.Scanner;

public class Casino {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();
    private int numOfPeople;

    public ArrayList<Player> getPlayers(){
        return players;
    }
    //how many players are in
    public int numOfPlayers() {
        int maxPeople = 20;
        System.out.println("How many people are playing: ");
        this.numOfPeople = scanner.nextInt();
        scanner.nextLine();

        //for invalid number of players
        if (numOfPeople < 1 || numOfPeople > maxPeople) {
            System.out.println("Invalid number of players try again: ");
            numOfPeople = scanner.nextInt();
            scanner.nextLine();
        }
        return numOfPeople;
    }
    //are players playing
        public void getStatus() {
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            players.add(new Player(name, true,0));

            }
        }
        // win conditions
    public void winner(Dealer dealer){
        for (int i = players.size() - 1; i >= 0; i--){
            Player player = players.get(i);

            if (player.getBetAmount() > 0) {
                int playerValue = player.getHand().getValue();
                int dealerValue = dealer.getHandValue();
                System.out.println(player.getName() + "'s hand value: " + playerValue);
                System.out.println("Dealer's hand value: " + dealerValue);

                //lose condition: over 21
                if (playerValue > 21) {
                    System.out.println(player.getName() + " busted. Dealer wins.");
                }
                //win condition: dealer over 21
                else if (dealerValue > 21) {
                    System.out.println(player.getName() + " wins.");
                    player.addWinnings();
                }
                //win condition: score higher than dealer
                else if (playerValue > dealerValue) {
                    System.out.println(player.getName() +" wins.");
                    player.addWinnings();
                }
                //dealer wins ties
                else {
                    System.out.println("Dealer wins.");
                }
                System.out.println("New balance: " + player.getBalance() + "$"); //update balance

            }
            //players with no more money
            if (player.getBalance() == 0) {
                System.out.println(player.getName() + " is out of money.");
                players.remove(i); //removes specific item from array list
            }
        }

    }
    public void resetPlayersForRounds(){
        for (int i = 0; i < players.size(); i++) {
            players.get(i).resettingRound();
        }
    }
    //asks if players want to play next round
    public void choosePlayerForNextRound() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < players.size(); i++){
            Player player = players.get(i);

            System.out.println(player.getName() + " are you in this round?");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Yes")){
                player.setStatus(true);
                player.setActive(true);
            }
            else {
                player.setStatus(false);
                player.setActive(false);
            }
        }
    }
}
