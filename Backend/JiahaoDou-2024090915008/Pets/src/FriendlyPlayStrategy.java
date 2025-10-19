public class FriendlyPlayStrategy implements InteractionStrategy {
    @Override
    public void interact(String pet1, String pet2) {
        System.out.println(pet1 + " 和 " + pet2 + " 正在友好地玩耍！🎮");
    }
}
