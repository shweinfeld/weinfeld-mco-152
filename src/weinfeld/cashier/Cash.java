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

    public int getTotalMoneyPieces() {
        return pennies + nickels + dimes + quarters + oneDollars + fiveDollars + tenDollars + twentyDollars;
    }

}