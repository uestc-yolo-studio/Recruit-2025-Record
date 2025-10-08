// 宠物接口（抽象产品）
interface PetTmp {
    void showMyMessage();
}

// 魔法猫（具体产品）
class MagicCat implements PetTmp {
    @Override
    public void showMyMessage() {
        System.out.println("我是一只魔法猫");
    }
}

// 精灵狗（具体产品）
class SpiritDog implements PetTmp {
    @Override
    public void showMyMessage() {
        System.out.println("我是一只精灵狗");
    }
}

// 宠物工厂接口（抽象工厂）
interface PetFactory {
    PetTmp createPet(); // 返回类型统一为 Pet 接口
}

// 魔法猫工厂（具体工厂）
class MagicCatFactory implements PetFactory {
    @Override
    public PetTmp createPet() { // 与接口返回类型一致
        return new MagicCat();
    }
}

// 精灵狗工厂（具体工厂）
class SpiritDogFactory implements PetFactory {
    @Override
    public PetTmp createPet() { // 与接口返回类型一致
        return new SpiritDog();
    }
}

public class Factory_Pattern_Pet {
    public static void main(String[] args) {
        // 使用魔法猫工厂创建魔法猫
        PetFactory magicCatFactory = new MagicCatFactory();
        PetTmp magicCat = magicCatFactory.createPet();
        magicCat.showMyMessage(); // 输出：这是一只魔法猫

        // 使用精灵狗工厂创建精灵狗
        PetFactory spiritDogFactory = new SpiritDogFactory();
        PetTmp spiritDog = spiritDogFactory.createPet();
        spiritDog.showMyMessage(); // 输出：这是一只精灵狗
    }
}
