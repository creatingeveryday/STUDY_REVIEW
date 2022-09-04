package designpattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item banana = new Item("banana", 1000);
        Item apple = new Item("apple", 2000);

        cart.addItem(banana);
        cart.addItem(apple);

        cart.pay(new KAKAOCardStrategy("myName","12345","123","10/01"));
        cart.pay(new NAVERCardStrtegy("aaa@mail.com","mailps"));

    }
    
}

interface PaymentStrategy {
    public void pay(int amount); 
}

class KAKAOCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv; 
    private String dateOfExpiry;

    public KAKAOCardStrategy(String name, String cardNumber, String cvv, String expirtyDate){
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = expirtyDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid using KAKAOCard");
    }
}

class NAVERCardStrtegy implements PaymentStrategy {
    private String emailId; 
    private String password;

    public NAVERCardStrtegy(String emailId, String password){
        this.emailId = emailId;
        this.password = password;
    }
 
    @Override
    public void pay(int amount) {
        System.out.println(amount+ "paid using NAVERCard");
    }

}
    
class Item {
    private String name; 
    private int price;
    
    public Item(String name, int cost){
        this.name = name;
        this.price = cost;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}



class ShoppingCart {
    List<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }
    
    public void removeItem(Item item){
        this.items.remove(item);
    }
    
    public int calculateTotal() {
        int sum = 0; 
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
    
    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
