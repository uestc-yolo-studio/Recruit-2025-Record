package com.yolo3;

public class Cat extends Feline{
    //猫的数量
    private static int numOfCat=0;

    //构造器
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
        numOfCat++;
    }
    public Cat(String name) {
        this.setName(name);
        numOfCat++;
    }
    public Cat() {
        numOfCat++;
    }

    //喂食猫
    public void feed(){
        System.out.println("It ate the fish you fed it. ");
    }

    //猫发声
    public void makeSound() {
        System.out.println("喵——");
    }

    //得到猫的数量
    public static int getNumOfCat() {
        return numOfCat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + getName() +
                ",age=" + getAge() +
                ", weight=" + getWeight() +
                '}';
    }
}
