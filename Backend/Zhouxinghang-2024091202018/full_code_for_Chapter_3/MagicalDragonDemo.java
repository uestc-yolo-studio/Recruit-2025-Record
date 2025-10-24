package com.yolo3;

public class MagicalDragonDemo {
    public static void main(String[] args) {
        MagicalDragon dragon=new MagicalDragon();

        //设置属性
        dragon.setName("Jack");
        dragon.setAge(1000);
        dragon.setWeight(100000.00);
        dragon.setHaveWing(true);
        dragon.setElement(dragon.element.fire);

        //发出动作
        dragon.heal();
        dragon.fly();
        dragon.dragonCastSpells();

        System.out.println(MagicalDragon.getNumOfMagicalDragon());
    }
}
