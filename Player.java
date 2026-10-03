import java.util.Scanner;

public class Player {
    private String name;
    private boolean status;
    private boolean active;
    private Hand hand;
    private int betAmount;
    private int balance;

    //player constructor
    public Player(String name, boolean status, int betAmount){
        this.name = name;
        this.status = status;
        this.active = status;
        this.hand = new Hand();
        this.betAmount = betAmount;
        this.balance = 100;
    }

    public String getName(){
        return name;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    //activity for specific round
    public boolean getActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public Hand getHand(){
        return hand;
    }
    public int getBalance(){
        return balance;
    }
    public void addWinnings() {
        balance = balance + (betAmount * 2);
    }

    public int getPlayerBet() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(name + " how much would you like to bet?: ");
            this.betAmount = scanner.nextInt();

            if (betAmount > 0 && betAmount <= balance) {
                this.balance = this.balance - betAmount;
                System.out.println("New account balance: " + balance + "$");
                return betAmount;
            } else {
                System.out.println("Invalid bet.");
            }
        }
    }
    public int getBetAmount(){
        return betAmount;
    }
    public String yourChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hit, Stay, Double: ");
        String choice = scanner.nextLine();
        return choice;
    }
    public void resettingRound(){
        hand.clearHand(); // fully clears hand
        active = status;
        betAmount = 0;
    }
    //needed for doubling bet choice
    public boolean doubleBet(){
        if (betAmount <= balance){
            this.balance = this.balance - betAmount;
            betAmount = betAmount * 2;
            return true;
        }
        else {
            System.out.println("You don't have enough money to double your bet.");
            return false;
        }
    }
}
