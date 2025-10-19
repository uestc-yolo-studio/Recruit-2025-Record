public class Feline extends Pet {

    private boolean isClimbing;

    public Feline() {
        super();
    }

    public Feline(String name, int age, String mood, String color, boolean isClimbing ) {
        super(name, age, mood, color);
        this.isClimbing = isClimbing;
    }

    public Feline(String name, int age) {
        super(name, age);
    }


    @Override
     public void introduction() {
        System.out.println("我是一只猫科动物");
    }
}
