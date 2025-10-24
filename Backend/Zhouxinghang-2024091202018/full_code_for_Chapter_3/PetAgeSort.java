package com.yolo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetAgeSort{
    public static void main(String[] args) {
        //创建实例
        PetIncubator dogIncubator = IncubatorFactory.getIncubator("Dog");
        Pet dog = dogIncubator.hatchPet();
        dog.setAge(7);
        PetIncubator catIncubator = IncubatorFactory.getIncubator("Cat");
        Pet cat = catIncubator.hatchPet();
        cat.setAge(4);
        PetIncubator magicalDragonIncubator = IncubatorFactory.getIncubator("MagicalDragon");
        Pet magicalDragon = magicalDragonIncubator.hatchPet();
        magicalDragon.setAge(114514);

        // 创建Pet列表
        List<Pet> Pets= new ArrayList<>();
        Pets.add(dog);
        Pets.add(cat);
        Pets.add(magicalDragon);

        System.out.println("排序前: " + Pets);

        // 1. 使用匿名内部类方式排序
        List<Pet> Pets1 = new ArrayList<>(Pets);
        Collections.sort(Pets1, new Comparator<Pet>() {
            @Override
            public int compare(Pet p1, Pet p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        System.out.println("匿名内部类排序后: " + Pets1);

        // 2. 使用Lambda表达式方式排序
        List<Pet> Pets2 = new ArrayList<>(Pets);
        Collections.sort(Pets2, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Lambda表达式排序后: " + Pets2);

        // 3. 使用方法引用方式排序
        List<Pet> Pets3 = new ArrayList<>(Pets);
        // 因为是int类型，使用comparingInt更高效
        Collections.sort(Pets3, Comparator.comparingInt(Pet::getAge));
        System.out.println("方法引用排序后: " + Pets3);
    }
}

