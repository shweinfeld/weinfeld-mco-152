package weinfeld.cashier;

public class Cashier {
    private Cash register;

    public Cashier(Cash register) {
        this.register = register;
    }

    public Cash pay(double price, Cash payment) throws NotEnoughChangeException, NotEnoughPaymentException {

        Cash change = new Cash();

        double money = payment.getTotalMoney();

        double returnMoney = Math.round((money - price)*100.0)/100.0;

        if (price > money) {
            throw new NotEnoughPaymentException();
        }


        if (returnMoney >= 20.00) {
            int numTwentyDollars = (int) (returnMoney / 20);
            if (register.twentyDollars >= numTwentyDollars){
                change.twentyDollars += numTwentyDollars;
                register.twentyDollars -= numTwentyDollars;
                returnMoney -= (numTwentyDollars * 20);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.twentyDollars += register.twentyDollars;
                returnMoney -= (register.twentyDollars * 20);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.twentyDollars = 0;

            }

        }
        if (returnMoney >= 10.00) {

            int numTenDollars = (int) (returnMoney / 10);
            if(register.tenDollars >= numTenDollars){
                change.tenDollars += numTenDollars;
                register.tenDollars -= numTenDollars;
                returnMoney -= (numTenDollars * 10);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.tenDollars += register.tenDollars;
                returnMoney -= (register.tenDollars * 10);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.tenDollars = 0;
            }

        }
        if (returnMoney >= 5.00) {
            int numFiveDollars = (int) (returnMoney / 5);
            if(register.fiveDollars >= numFiveDollars){
                change.fiveDollars += numFiveDollars;
                register.fiveDollars -= numFiveDollars;
                returnMoney -= (numFiveDollars * 5);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.fiveDollars += register.fiveDollars;
                returnMoney -= (register.fiveDollars * 5);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.fiveDollars = 0;
            }

        }
        if (returnMoney >= 1.00) {
            int numOneDollar = (int) returnMoney;
            if(register.oneDollars >= numOneDollar){
                change.oneDollars += numOneDollar;
                register.oneDollars -= numOneDollar;
                returnMoney -= numOneDollar;
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.oneDollars += register.oneDollars;
                returnMoney -= register.oneDollars;
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.oneDollars = 0;
            }

        }
        if (returnMoney >= .25) {
            int numQuarters = (int) (returnMoney * 4);
            if(register.quarters >= numQuarters){
                change.quarters += numQuarters;
                register.quarters -= numQuarters;
                returnMoney -= (numQuarters * .25);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else{
                change.quarters += register.quarters;
                returnMoney -= (register.quarters *.25);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.quarters = 0;
            }


        }
        if (returnMoney >= .10) {
            int numDimes = (int) (returnMoney * 10);
            if(register.dimes >= numDimes){
                change.dimes += numDimes;
                register.dimes -= numDimes;
                returnMoney -= (numDimes * .10);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.dimes += register.dimes;
                returnMoney -= (register.dimes * .10);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.dimes = 0;
            }

        }
        if (returnMoney >= .05) {
            int numNickels = (int) (returnMoney * 20);
            if(register.nickels >= numNickels){
                change.nickels += numNickels;
                register.nickels -= numNickels;
                returnMoney -= (numNickels * .05);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.nickels += register.nickels;
                returnMoney -= (register.nickels * .05);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.nickels = 0;
            }


        }
        if (returnMoney >= .01){
            int numPennies = (int) (returnMoney * 100);
            if(register.pennies >= numPennies){
                change.pennies += numPennies;
                register.pennies -= numPennies;
                returnMoney -= (numPennies * .01);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
            }
            else {
                change.pennies += register.pennies;
                returnMoney -= (register.pennies * .01);
                returnMoney = Math.round((returnMoney)*100.0)/100.0;
                register.pennies = 0;
            }
        }

        if (Math.round(returnMoney*100.0)/100.0 != 0) {
            register.pennies += change.pennies;
            register.nickels += change.nickels;
            register.dimes += change.dimes;
            register.quarters += change.quarters;
            register.oneDollars += change.oneDollars;
            register.fiveDollars += change.fiveDollars;
            register.tenDollars += change.tenDollars;
            register.twentyDollars += change.twentyDollars;
            throw new NotEnoughChangeException();
        }

        register.pennies += payment.pennies;
        register.nickels += payment.nickels;
        register.dimes += payment.dimes;
        register.quarters += payment.quarters;
        register.oneDollars += payment.oneDollars;
        register.fiveDollars += payment.fiveDollars;
        register.tenDollars += payment.tenDollars;
        register.twentyDollars += payment.twentyDollars;

        return change;

    }
}
