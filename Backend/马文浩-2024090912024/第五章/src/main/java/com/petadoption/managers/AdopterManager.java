/**
 * 处理领养人相关操作的管理类。
 * 为领养系统中的领养人管理提供用户界面。
 */
package com.petadoption.managers;

import com.petadoption.entities.Adopter;
import com.petadoption.services.AdoptionService;
import java.util.List;
import java.util.Scanner;

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
    public AdopterManager(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
        this.scanner = new Scanner(System.in);
    }

    public void addAdopter() {
        Adopter adopter = new Adopter();
        System.out.print("Enter adopter name: ");
        adopter.setName(scanner.nextLine());
        
        System.out.print("Enter adopter phone: ");
        adopter.setPhone(scanner.nextLine());
        
        System.out.print("Enter adopter address: ");
        adopter.setAddress(scanner.nextLine());
        
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

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            adopter.setName(name);
        }

        System.out.print("Enter new phone (leave blank to keep current): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            adopter.setPhone(phone);
        }

        System.out.print("Enter new address (leave blank to keep current): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            adopter.setAddress(address);
        }

        adoptionService.updateAdopter(adopter);
        System.out.println("Adopter updated successfully!");
    }

    public void removeAdopter() {
        System.out.print("Enter adopter ID to remove: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        adoptionService.removeAdopter(adopterId);
        System.out.println("Adopter removed successfully!");
    }

    public void listAdopters() {
        List<Adopter> adopters = adoptionService.getAllAdopters();
        System.out.println("\nRegistered Adopters:");
        for (Adopter adopter : adopters) {
            System.out.println(adopter);
        }
    }
}
