public class PetFactory {
    // 使用枚举确保类型安全
    public enum PetType {
        Tiger, Feline
    }
    
    // 工厂方法
    public static Pet createPet(PetType type, String name, int age) {
        switch (type) {
            case Tiger:
                return new Tiger(name, age);
            case Feline:
                return new Feline(name, age);
            default:
                throw new IllegalArgumentException("未知的宠物类型: " + type);
        }
    }
    
    // 便捷方法
    public static Pet createSpiritDog(String name, int age) {
        return createPet(PetType.Tiger, name, age);
    }
    
    public static Pet createRobotHamster(String name, int age) {
        return createPet(PetType.Feline, name, age);
    }
}