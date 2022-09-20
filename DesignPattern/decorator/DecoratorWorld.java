package designpattern.decorator;

public class DecoratorWorld {
    public static void main(String[] args) {

        Beverage order1 = new Decaf();
        order1 = new Mocha(order1);
        order1 = new Cream(order1);

        System.out.println(order1.cost());
        System.out.println(order1.getDescription());


    }
}

abstract class Beverage {
    public String description;

    public String getDescription(){
        return "음료수!";
    }
    public abstract double cost();
}
class Espresso extends Beverage {

    public Espresso() {
        description = "에스프레소";
    }
    @Override
    public double cost() {
        return 1000;
    }
}
class Decaf extends Beverage {

    public Decaf() {
        description = "디카페인";
    }
    @Override
    public double cost() {
        return 3000;
    }
}

abstract class CondimentDecorator extends Beverage {

    Beverage beverage;
    public abstract String getDescription();

}

class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.6;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "/모카 추가";
    }
}

class Cream extends CondimentDecorator {
    public Cream(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost(){
        return beverage.cost() + 0.1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "/크림 추가";
    }
}


