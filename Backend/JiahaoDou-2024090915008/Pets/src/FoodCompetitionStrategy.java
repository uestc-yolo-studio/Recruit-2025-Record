public class FoodCompetitionStrategy implements InteractionStrategy {
    @Override
    public void interact(String pet1, String pet2) {
        System.out.println(pet1 + " 和 " + pet2 + " 在争抢食物！🍖");
    }
}