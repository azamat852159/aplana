package task4_2;

import java.util.ArrayList;
import java.util.List;

public class CreateGift {
    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.print();
    }
}

abstract class   sweets{
    private String name;
    private int weight;
    private int price;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}

class Gift{
    private List<sweets> list;

    Gift() {
        this.list = new ArrayList<>();
        this.list.add(new Jellybean("Jelly",2,100));
        this.list.add(new gum("Spanch-Bob",1,20));
        this.list.add(new Candy("Crash",3,150));
    }

    public void print(){
        System.out.println("Общий вес подарка = " + list.stream().mapToInt(sweets::getWeight).sum());
        System.out.println("Общая стоимость подарка = " + list.stream().mapToInt(sweets::getPrice).sum());
        list.forEach(x-> System.out.println(x.toString()));
    }

}

class Jellybean extends sweets {
    String name;
    int weight;
    int price;

    @Override
    public String toString() {
        return "Jellybean{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public Jellybean(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;

    }
}

class gum extends sweets {
    String name;
    int weight;
    int price;

    @Override
    public String toString() {
        return "gum{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public gum(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}

class Candy extends sweets {
    String name;
    int weight;
    int price;

    public Candy(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
