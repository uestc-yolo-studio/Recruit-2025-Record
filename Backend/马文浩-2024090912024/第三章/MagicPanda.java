public class MagicPanda {
    // 内在属性：名字、年龄、饥饿值
    String name;
    int age;
    int hungerValue;
    int petLoyalty;

    // 构造器
    public MagicPanda(String petName, int petAge, int petHungerValue) {
        name = petName;
        age = petAge;
        hungerValue = petHungerValue;
        petLoyalty = 50;
    }

    // 外在行为：吃饭（吃饭后饥饿值降低，忠诚度增加）
    public void eat() {
        System.out.println(name + "正在吃饭~");
        hungerValue -= 20;
        petLoyalty += 10;
        System.out.println(name + "吃饭后，饥饿值变为：" + hungerValue);
        System.out.println(name + "玩耍后，忠诚度变为：" + petLoyalty);
    }

    // 外在行为：玩耍（玩耍后饥饿值升高,忠诚度增加）
    public void playWithMe() {
        System.out.println(name + "正在玩耍~");
        hungerValue += 10;
        petLoyalty += 10;
        System.out.println(name + "玩耍后，饥饿值变为：" + hungerValue);
        System.out.println(name + "玩耍后，忠诚度变为：" + petLoyalty);
    }
}
