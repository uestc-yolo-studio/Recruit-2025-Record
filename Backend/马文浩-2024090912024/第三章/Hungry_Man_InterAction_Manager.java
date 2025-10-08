public class Hungry_Man_InterAction_Manager {
    // 饿汉式实例
    private static final Hungry_Man_InterAction_Manager instance = new Hungry_Man_InterAction_Manager();
    // 私有构造方法，防止外部创建实例
    private Hungry_Man_InterAction_Manager() {}
    // 提供获取实例的方法
    public static Hungry_Man_InterAction_Manager getInstance() {
        return instance;
    }
    // 互动策略接口
    interface InteractionStrategy {
        void interact();
    }
}
