interface InteractionStrategy {
    void interact();
}
// 友好玩耍策略
class PlayStrategy implements InteractionStrategy {
    @Override
    public void interact() {
        System.out.println("宠物友好玩耍");
    }
}
// 争抢食物策略
class CompeteStrategy implements InteractionStrategy {
    @Override
    public void interact() {
        System.out.println("宠物争抢食物");
    }
}
public class Interaction_Manager_Having_Interface {
    private InteractionStrategy strategy;
    public void setStrategy(InteractionStrategy strategy) {
        this.strategy = strategy;
    }
    public void interact() {
        strategy.interact();
    }

}
