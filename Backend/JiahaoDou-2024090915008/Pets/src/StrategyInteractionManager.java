// StrategyInteractionManager.java
public class StrategyInteractionManager {
    private static final StrategyInteractionManager INSTANCE = new StrategyInteractionManager();
    private InteractionStrategy currentStrategy;
    
    private StrategyInteractionManager() {
        // 默认策略
        this.currentStrategy = new FriendlyPlayStrategy();
    }
    
    public static StrategyInteractionManager getInstance() {
        return INSTANCE;
    }
    
    // 设置策略
    public void setInteractionStrategy(InteractionStrategy strategy) {
        this.currentStrategy = strategy;
        System.out.println("互动策略已切换！");
    }
    
    // 执行互动
    public void performInteraction(String pet1, String pet2) {
        System.out.println("=== 宠物互动开始 ===");
        currentStrategy.interact(pet1, pet2);
        System.out.println("=== 互动结束 ===\n");
    }
    
    // 快速切换策略的方法
    public void switchToFriendly() {
        setInteractionStrategy(new FriendlyPlayStrategy());
    }
    
    public void switchToCompetition() {
        setInteractionStrategy(new FoodCompetitionStrategy());
    }
}