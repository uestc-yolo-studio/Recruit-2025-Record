 import java.util.Random;
     
     public class PetStoreOpening {
         public static void main(String[] args) {
             Random random = new Random();
             int choice = random.nextInt(2); // 随机选择 0, 1, 或 2
     
             Pet newCompanion; // 使用你的宠物始祖类
     
             // TODO: 根据随机数choice，为newCompanion实例化一只具体的宠物 (如MagicCat, SpiritDog, BabyDragon)
             switch (choice) {
                 case 0:
                      newCompanion = new Feline();
                     break;
                 case 1:
                      newCompanion = new Tiger();
                     break;
                 default://骗一下编译器，不然后边会报可能未初始化的错误，其实不骗也可以，运行不会报错的
                     newCompanion = new Tiger();
                     break;
             }


             // TODO: 使用instanceof判断newCompanion的真实形态，并向玩家宣布
             // 例如: "恭喜你，获得了一只神奇的魔法猫！"
             /**
              *这里刚开始确实忽略了一个重点，就是前者是后者类型或者是后者类型的子类均为true，所以编译器提醒我了
              */

             if(newCompanion instanceof Tiger) {
                 System.out.println("恭喜你得到了一个老虎");
             }else{
                 System.out.println("恭喜你得到了一个猫科动物");
             }
             // TODO: 调用一个被子类重写的方法 (如makeSound())，展现多态的魅力
             // newCompanion.makeSound(); // 魔法猫会“喵~”，灵魂犬会“汪！”，幼龙会“嗷~”
             newCompanion.introduction();
         }
     }