package weinfeld.cashier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CashierTest {

    @Test
    public void pay() {

        //given
        Cash register = new Cash();
        register.pennies = 100;
        register.quarters = 100;
        Cashier cashier = new Cashier(register);
        double price = 2.49;
        Cash payment = new Cash();
        payment.oneDollars = 3;

        //when
        Cash change = cashier.pay(price, payment);

        //then
        assertEquals(2, change.quarters);
        assertEquals(1, change.pennies);
        assertEquals(98, register.quarters);
        assertEquals(99, register.pennies);
        assertEquals(3, register.oneDollars);

    }
}