package com.yolo3;

public class MagicalDragon extends Pet implements Flyable,Healable{
    //枚举元素属性
    public enum element{light, darkness, water, fire}

    //魔龙是否有双翼
    private boolean haveWing;

    //魔龙的属性
    public element element;

    //魔龙的数量
    private static int numOfMagicalDragon=0;

    //构造器
    public MagicalDragon(String name, int age, double weight, boolean haveWing,element element) {
        super(name, age, weight);
        this.haveWing = haveWing;
        this.element = element;
        numOfMagicalDragon++;
    }
    public MagicalDragon(String name) {
        this.setName(name);
        numOfMagicalDragon++;
    }
    public MagicalDragon() {
        numOfMagicalDragon++;
    }

    //getter and setter
    public boolean isHaveWing() {
        return haveWing;
    }
    public void setHaveWing(boolean haveWing) {
        this.haveWing = haveWing;
    }
    public element getElement() {
        return element;
    }
    public void setElement(element element) {
        this.element = element;
    }

    //得到魔龙的数量
    public static int getNumOfMagicalDragon() {
        return numOfMagicalDragon;
    }

    //魔龙发声
    public void makeSound(){
        System.out.println("吼——");
    }

    //喂食魔龙
    public void feed(){
        System.out.println("It ate the meat you fed it. ");
    }

    //魔龙自愈
    public void heal(){
        System.out.println("It healed by itself. ");
    }

    //魔龙起飞
    public void fly(){
        if(this.haveWing){
            System.out.println(this.element+" dragon can fly.");
        }else{
            System.out.println("It can't fly.");
        }
    }

    //魔龙施法
    void dragonCastSpells(){
        if(this.element==element.light){
            System.out.println("The light dragon emits a beam of light.");
        }
        else if(this.element==element.darkness){
            System.out.println("The darkness dragon conjures a black hole.");
        }else if(this.element==element.fire){
            System.out.println("The fire dragon spits a fireball.");
        }else if(this.element==element.water) {
            System.out.println("The water dragon slams with a huge wave.");
        }else{
            System.out.println("Error.");
        }
    }

    @Override
    public String toString() {
        return "MagicalDragon{" +
                "name=" + getName() +
                ",age=" + getAge() +
                ", weight=" + getWeight() +
                "haveWing=" + haveWing +
                ", element=" + element +
                '}';
    }
}
