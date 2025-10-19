public class MagicMonkeyTest {
    public static void main(String[] args) {
        MagicMonkey jiji = new MagicMonkey("小黑", 2);
        Food fish = new Food("鱼", 30);
        jiji.feed(fish);
    }
}
