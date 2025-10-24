package com.yolo3;

public class Dog extends Canine{
    //狗的数量
    private static int numOfDog=0;

    //构造器
    public Dog(String name, int age, double weight) {
        super(name, age, weight);
        numOfDog++;
    }
    public Dog(String name) {
        this.setName(name);
        numOfDog++;
    }
    public Dog() {
        numOfDog++;
    }

    //喂食狗
    public void feed(){
        System.out.println("It ate the bone you fed it. ");
    }

    //狗发声
    public void makeSound(){
        System.out.println("汪——");
    }

    //狗游泳
    public void swim(){
        System.out.println("Dog can swim.");
    }

    //得到狗的数量
    public static int getNumOfDog() {
        return numOfDog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name=" + getName() +
                ",age=" + getAge() +
                ", weight=" + getWeight() +
                '}';
    }
}
