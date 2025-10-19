package com.petadoption.managers;

import com.petadoption.entities.*;
import com.petadoption.services.AdoptionService;
import java.util.List;
import java.util.Scanner;

/**
 * 处理领养相关操作的管理类。
 * 为系统中的领养管理提供用户界面。
 */
public class AdoptionManager {
    /**
     * 领养服务实例。
     */
    private final AdoptionService adoptionService;
    /**
     * 控制台输入扫描器。
     */
    private final Scanner scanner;

    /**
     * 构造函数，初始化领养服务实例和控制台输入扫描器。
     * @param adoptionService 领养服务实例。
     */
    public AdoptionManager(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
        this.scanner = new Scanner(System.in);
    }

    public void processAdoption() {
        System.out.print("Enter pet ID to adopt: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter adopter ID: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        adoptionService.adoptPet(petId, adopterId);
        System.out.println("Adoption processed successfully!");
    }

    public void viewAdoptionRecords() {
        List<AdoptionRecord> records = adoptionService.getAllAdoptionRecords();
        System.out.println("\nAdoption Records:");
        for (AdoptionRecord record : records) {
            System.out.println(record);
        }
    }

    public void viewAdoptionHistoryByPet() {
        System.out.print("Enter pet ID to view adoption history: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<AdoptionRecord> records = adoptionService.getAdoptionRecordsByPet(petId);
        System.out.println("\nAdoption History for Pet ID " + petId + ":");
        for (AdoptionRecord record : records) {
            System.out.println(record);
        }
    }

    public void viewAdoptionHistoryByAdopter() {
        System.out.print("Enter adopter ID to view adoption history: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<AdoptionRecord> records = adoptionService.getAdoptionRecordsByAdopter(adopterId);
        System.out.println("\nAdoption History for Adopter ID " + adopterId + ":");
        for (AdoptionRecord record : records) {
            System.out.println(record);
        }
    }
}
