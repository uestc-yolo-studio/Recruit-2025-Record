public class InteractionManager {
    // 1. 私有静态实例，类加载时就创建
    private static final InteractionManager INSTANCE = new InteractionManager();

    // 2. 私有构造器，防止外部创建实例
    private InteractionManager() {
        System.out.println("交互管理器初始化完成！");
    }

    // 3. 公共静态方法，提供全局访问点
    public static InteractionManager getInstance() {
        return INSTANCE;
    }

    // 业务方法
    public void startInteraction() {
        System.out.println("开始宠物互动...");
    }
}
