package weinfeld.cashier;

public class Cash {

    protected int pennies;
    protected int nickels;
    protected int dimes;
    protected int quarters;
    protected int oneDollars;
    protected int fiveDollars;
    protected int tenDollars;
    protected int twentyDollars;

    public String getTotalMoneyPieces() {
        return "P: " + pennies +
                ", N: " + nickels +
                ", D: " + dimes +
                ", Q: " + quarters +
                ", $1: " + oneDollars +
                ", $5 " + fiveDollars +
                ", $10: " + tenDollars +
                ", $20: " + twentyDollars;
    }
    public double getTotalMoney() {
        return pennies*.01 +
                nickels*.05 +
                dimes*.1 +
                quarters*.25 +
                oneDollars +
                fiveDollars*5 +
                tenDollars*10 +
                twentyDollars*20;
    }

    public void reset() {
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
        oneDollars = 0;
        fiveDollars = 0;
        tenDollars = 0;
        twentyDollars = 0;
    }

}