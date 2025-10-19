public class Tiger extends Feline implements  Hunter{

    private boolean isProjected;


    public Tiger() {
        super();
    }

    public Tiger(String name, int age, String mood, String color, boolean isClimbing, boolean isProjected) {
        super(name, age, mood, color, isClimbing);
        this.isProjected = isProjected;
    }

    public Tiger(String name, int age) {
        super(name, age);
    }

    @Override
    public void hunt() {
        System.out.println("可以捕捉自己想要的猎物");
    }

    @Override
    public void kill() {
        System.out.println("可以杀死自己想要的猎物");
    }
    @Override
    public void introduction() {
        System.out.println("我是一只老虎");
    }
}
