class MagicMonkey {
    private String name;
    private int age;
    private int hungerLevel = 100;

    public MagicMonkey(String name, int age) {
        this.name = name;
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Error");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 自定义的喂食交互方法
    public void feed(Food food) {
        System.out.println("给" + name + "喂食" + food.getName());
        hungerLevel -= food.getEnergyValue();
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        System.out.println(name + "现在的饱食度：" + hungerLevel);
    }
}