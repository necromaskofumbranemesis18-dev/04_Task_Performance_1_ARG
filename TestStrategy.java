
package teststrategy;

// INTERFACE PAYMENT
interface Payment {
    public void pay(double amount);
}

//ONLINE IMPLEMENTS PAYMENTS
class Online implements Payment {
    private String email;
    private String password;
    
    public Online(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid using online account: " + amount);
    }
}

//MOBILE IMPLEMENTS PAYMENTS
class Mobile implements Payment {
    private String number;
    private int pin;
    
    public Mobile(String number, int pin) {
        this.number = number;
        this.pin = pin;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid using mobile wallet: " + amount );
    }
}

//CLASS CART
class Cart {
    private double amount;
    
    public Cart(double amount) {
        this.amount = amount;
    }
    
    
    public void pay(Payment mode) {
        mode.pay(amount);
    }
}

// DISPLAY VALUE FIR TEST STRATEGY
public class TestStrategy {
    public static void main(String[] args) {
        Cart cart = new Cart(1512.75);
        
        cart.pay(new Online("kevp@gmail.com", "incognito@2468"));
        
        cart = new Cart(375.25);
        cart.pay(new Mobile("09123456789", 1234));
    }
}
