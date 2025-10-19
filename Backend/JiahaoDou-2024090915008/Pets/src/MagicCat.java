//此题为完成题目封装相关内容所建，不参与后续继承题目
public class MagicCat {
    //实例属性
    private String name;
    private int age;
    private String mood;
    private String color;

    //静态属性
    /**
     * 静态私有化变量，外部不能被随意更改，只用于构造方法统计数量
     * 执行一次构造方法后，说明多了一个对象，count++
     */
    private static int count = 0;

    //构造方法
    public MagicCat(String name, int age, String mood, String color) {
        this.name = name;
        this.age = age;
        this.mood = mood;
        this.color = color;

        count++;
    }
    public MagicCat(){
        count++;
    }

    public MagicCat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getter和setter方法
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


    //实例方法
    public void eat(){
        System.out.println("吃东西");
    }
    public void sleep(){
        System.out.println("睡觉");
    }


    //静态方法，得到当前类的对象（动物）数量
    public static int getCount(){
        return count;
    }
}
