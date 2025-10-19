

// 抽象父类 Pet
abstract class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + "在吃饭");
    }

    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    public abstract void makeSound();
}

// 猫科子类 Feline
class Feline extends Pet {
    public Feline(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("喵喵");
    }
}

// 犬科子类
class Canine extends Pet {
    public Canine(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("汪汪");
    }
}

// 具体的猫类
class Cat extends Feline {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void sleepAlltheDay() {
        System.out.println("小猫咪天天睡觉");
    }
}

// 具体的狗类
class Dog extends Canine implements Flyable, Swimmable, Healable {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void beAGuard() {
        System.out.println("看家护院");
    }

    @Override
    public void fly() {
        System.out.println("一只有翅膀的狗");
    }

    @Override
    public void swim() {
        System.out.println("狗狗可以在水里游泳啦");
    }
    @Override
    public void heal() {
        System.out.println("狗狗得到了治愈能力");

    }
}
public class Extends {
        public static void main(String[] args) {
            Cat cat = new Cat("咪咪", 2);
            cat.eat();        // 调用父类（Pet）的 eat 方法
            cat.sleep();      // 调用父类（Pet）的 sleep 方法
            cat.makeSound();  // 调用子类（Feline）重写的 makeSound 方法
            cat.sleepAlltheDay(); // 调用 Cat 类特有的方法

            Dog dog = new Dog("旺财", 3);
            dog.eat();        // 调用父类（Pet）的 eat 方法
            dog.sleep();      // 调用父类（Pet）的 sleep 方法
            dog.makeSound();  // 调用子类（Canine）重写的 makeSound 方法
            dog.beAGuard(); // 调用 Dog 类特有的方法
        }
}