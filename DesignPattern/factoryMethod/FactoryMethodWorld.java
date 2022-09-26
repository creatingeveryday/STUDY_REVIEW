package designpattern.factory;

import java.util.ArrayList;
import java.util.List;

public class FactoryMethodWorld {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore laStore = new LAPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("내가 주문한 피자는? "+ pizza.getName());

        pizza = laStore.orderPizza("cheese");
        System.out.println("너가 주문한 피자는? "+ pizza.getName());

    }
}

abstract class PizzaStore {
    abstract Pizza createPizza(String type); //팩토리 메서드에서 Pizza 인스턴스를 만든다.

    Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {


    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new NYCheesePizza();
        } else if (type.equals("greek")) {
            pizza = new NYPepperoniPizza();
        }
        return pizza;
    }
}
class LAPizzaStore extends PizzaStore {


    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new LACheesePizza();
        } else if (type.equals("greek")) {
            pizza = new LAPepperoniPizza();
        }
        return pizza;
    }
}


abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();
    void prepare(){
        System.out.println("준비중"+name);
        System.out.println("도우를 돌리는중~ ");
        System.out.println("소스를 뿌리는중~ ");
        System.out.println("토핑을 올리는 중~ ");
        for ( String topping : toppings){
            System.out.println(" "+topping);
        }
    }
    void bake(){
        System.out.println("170도에서 20분간 굽기");
    }
    void cut() {
        System.out.println("피자를 동그랗게 자르기");
    }
    void box() {
        System.out.println("상자에 피자 담기");
    }

    String getName(){
        return name;
    }


}

class NYCheesePizza extends Pizza {
    public NYCheesePizza() {
        name = "뉴옥스타일치즈피자";
        dough = "씬 크러스트 도우";
        sauce = "마리나라 소스";

        toppings.add("잘게썬 리아 치즈");
    }
}

class NYPepperoniPizza extends Pizza {

    public NYPepperoniPizza() {
        name = "뉴옥스타일페퍼로니피자";
        dough = "씬 크러스트 도우";
        sauce = "페퍼로니 햄소스  소스";

        toppings.add("잘게썬 리아 치즈");
    }
}
class LACheesePizza extends Pizza {

    public LACheesePizza() {
        name = "LA 스타일 치즈피자";
        dough = "크러스트 도우";
        sauce = "토마토 소스";

        toppings.add("모짤렐라 치즈");
        toppings.add("양파 많이");
    }
}

class LAPepperoniPizza extends Pizza {

    public LAPepperoniPizza() {
        name = "LA 스타일 페퍼로니 피자";
        dough = "크러스트 도우";
        sauce = "셀리 소스";

        toppings.add("모짤렐라 치즈");
        toppings.add("햄 많이");
    }
}

