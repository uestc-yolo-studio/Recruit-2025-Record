package com.yolo3;

public class InteractionManagerDemo {
    public static void main(String[] args) {
        // 创建宠物
        PetIncubator catIncubator = IncubatorFactory.getIncubator("Cat");
        Pet cat = catIncubator.hatchPet("咪咪");

        PetIncubator dogIncubator = IncubatorFactory.getIncubator("Dog");
        Pet dog = dogIncubator.hatchPet("旺财");

        PetIncubator magicalDragonIncubator = IncubatorFactory.getIncubator("MagicalDragon");
        Pet magicalDragon = magicalDragonIncubator.hatchPet("杰克");

        // 获取交互管理器实例
        InteractionManager manager = InteractionManager.getInstance();

        // 使用默认策略（玩耍）
        manager.handleInteraction(dog, magicalDragon);

        // 切换到竞争策略
        manager.setStrategy(new CompeteStrategy());
        manager.handleInteraction(dog, cat);

        // 临时使用争斗策略处理一次交互
        manager.handleInteractionWithStrategy(cat, dog, new FightStrategy());

        // 再次使用当前策略（竞争）
        manager.handleInteraction(dog, cat);
    }
}

