/**
 * 处理领养人相关操作的管理类。
 * 为领养系统中的领养人管理提供用户界面。
 */
package com.petadoption.managers;

import com.petadoption.entities.Adopter;
import com.petadoption.services.AdoptionService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;
/**
 * 主要的领养人管理操作管理类。
 */
public class AdopterManager {
    /**
     * 领养服务实例。
     */
    private final AdoptionService adoptionService;
    /**
     * 控制台输入扫描器。
     */
    private final Scanner scanner;

    /**
     * 构造函数，初始化领养服务和控制台输入扫描器。
     * @param adoptionService 领养服务实例。
     */
    //把AdoptionServiceImpl传入
    public AdopterManager(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
        this.scanner = new Scanner(System.in);
    }

    public void addAdopter() throws IOException {
        Adopter adopter = new Adopter();
        System.out.print("Enter adopter name: ");
        adopter.setName(scanner.nextLine());
        
        System.out.print("Enter adopter phone: ");
        String phone=scanner.nextLine();
        if(!phone.matches("1[3-9]\\d{9}")){
            System.out.println("Phone number invalid!");
            return;
        }
        adopter.setPhone(phone);
        
        System.out.print("Enter adopter address: ");
        adopter.setAddress(scanner.nextLine());

        System.out.print("Enter adopter password: ");
        String pw=scanner.nextLine();
        if(pw.length()<6||pw.length()>20){
            System.out.println("Password invalid,must be at least 6 characters and 20 characters at most!");
            return;
        }
        System.out.print("Ensure your password:");
        String pw2=scanner.nextLine();
        if(!pw.equals(pw2)){
            System.out.println("Passwords do not match!");
            return;
        }
        adopter.setPassword(pw);

        adoptionService.addAdopter(adopter);
        System.out.println("Adopter added successfully!");
    }

    public void updateAdopter() {
        System.out.print("Enter adopter ID to update: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Adopter adopter = adoptionService.getAdopterById(adopterId);
        if (adopter == null) {
            System.out.println("Adopter not found!");
            return;
        }

        System.out.print("Verify password to update adopter info:");
        String pw=scanner.nextLine();
        if(!adopter.verifyPassword(pw)){
            System.out.println("Password incorrect!");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            adopter.setName(name);
        }

        System.out.print("Enter new phone (leave blank to keep current): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            if(!phone.matches("1[3-9]\\d{9}")){
                System.out.println("Phone number invalid!");
                return;
            }
            adopter.setPhone(phone);
        }

        System.out.print("Enter new address (leave blank to keep current): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            adopter.setAddress(address);
        }

        System.out.print("Enter new password (leave blank to keep current): ");
        String pw2 = scanner.nextLine();
        if (!pw2.isEmpty()) {
            if(pw2.length()<6||pw2.length()>20){
                System.out.println("Password invalid,must be at least 6 characters and 20 characters at most!");
                return;
            }
            System.out.print("Ensure your password:");
            String pw3=scanner.nextLine();
            if(!pw2.equals(pw3)){
                System.out.println("Passwords do not match!");
                return;
            }
            adopter.setPassword(pw2);
        }

        adoptionService.updateAdopter(adopter);
        System.out.println("Adopter updated successfully!");
    }

    public void removeAdopter() {
        System.out.print("Enter adopter ID to remove: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if(adoptionService.getAdopterById(adopterId)==null){
            System.out.println("Adopter not found!");
            return;
        }

        adoptionService.removeAdopter(adopterId);
        System.out.println("Adopter removed successfully!");
    }

    public void listAdopters() {
        List<Adopter> adopters = adoptionService.getAllAdopters();
        if(adopters.isEmpty()){
            System.out.println("No adopters found!");
            return;
        }
        System.out.println("\nAll "+adopters.size()+" registered Adopters:");
        for (Adopter adopter : adopters) {
            System.out.println(adopter);
        }
    }
}
