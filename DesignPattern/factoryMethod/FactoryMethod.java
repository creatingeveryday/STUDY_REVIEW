abstract class Coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "this coffee is "+ this.getPrice();
    }
}

class Latte extends Coffee {

    private int price;

    public Latte(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        
        return this.price;
    }
}

class Espresso extends Coffee {

    private int price; 

    public Espresso(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class CoffeeFactory {
    public static Coffee getCoffee(String type, int price){
        if("Latte".equalsIgnoreCase(type)){
            return new Latte(price);
        }
        if("Espresso".equalsIgnoreCase(type)){
            return new Espresso(price);
        }
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 7000);
        Coffee espresso = CoffeeFactory.getCoffee("Espresso", 9000);

        //latte.toString :   "this coffee is 7000"
        //espresso.toString :   "this coffee is 9000"
    }
}
