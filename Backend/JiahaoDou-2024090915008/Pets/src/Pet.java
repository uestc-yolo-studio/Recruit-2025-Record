import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pet {
    //实例属性
    private String name;
    private int age;
    private String mood;
    private String color;

    private static int count = 0;

    public Pet(String name, int age, String mood, String color) {
        this.name = name;
        this.age = age;
        this.mood = mood;
        this.color = color;
        count++;
    }
    public Pet(){
        count++;
    }

    public Pet(String name, int age) {
         this.name = name;
         this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat(){
        System.out.println("吃东西");
    }
    public void sleep(){
        System.out.println("睡觉");
    }

    public void introduction(){
        System.out.println("我是一只宠物");
    }
    public static int getCount(){
        return count;
    }


    //测试一下三种Comparator的使用
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("小猫", 1, "normal", "white"));
        pets.add(new Pet("小狗", 2, "normal", "black"));
        pets.add(new Pet("小兔子", 3, "normal", "brown"));

        //匿名内部类
        Collections.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Pet pet : pets){
            System.out.print(pet.getAge() + " ");
        }

        //打乱集合
        Collections.shuffle(pets);

        //Lambda表达式
        Collections.sort(pets,(p1, p2) -> p1.getAge() - p2.getAge());
        for (Pet pet : pets){
            System.out.print(pet.getAge() + " ");
        }

        Collections.shuffle( pets);

        //方法引用
        pets.sort(Comparator.comparing(Pet::getAge));
        for (Pet pet : pets){
            System.out.print(pet.getAge() + " ");
        }

    }
}
