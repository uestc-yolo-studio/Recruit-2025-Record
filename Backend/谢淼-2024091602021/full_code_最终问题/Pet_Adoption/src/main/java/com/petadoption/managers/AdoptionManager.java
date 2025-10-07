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
        AdoptionRecord adoptionRecord = new AdoptionRecord();
        System.out.print("Enter pet ID to adopt: ");
        adoptionRecord.setPet_id(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter adopter ID: ");
        adoptionRecord.setAdopter_id(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        adoptionRecord.setStatus(AdoptionRecord.Status.APPLYING);
        adoptionService.adoptPet(adoptionRecord);
        System.out.println("Adoption processed successfully!");
    }

    public void updateAdoptionRecord() {
        System.out.print("Enter adoption record ID to update: ");
        int recordId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        AdoptionRecord adoptionRecord =adoptionService.getRecordById(recordId);
        if(adoptionRecord==null){
            System.out.println("Adoption record not found!");
            return;
        }
        System.out.println("choose new status:\n1.APPLYING\n2.APPROVED\n3.COMPLETED\n4.CANCELLED\n");
        int c=scanner.nextInt();
        switch(c){
            case 1-> {
                adoptionRecord.setStatus(AdoptionRecord.Status.APPLYING);
            }
            case 2-> {
                adoptionRecord.setStatus(AdoptionRecord.Status.APPROVED);
            }
            case 3-> {
                adoptionRecord.setStatus(AdoptionRecord.Status.COMPLETED);
                Pet tp=adoptionService.getPetById(adoptionRecord.getPet_id());
                tp.setAdopt_status(true);
                adoptionService.updateStatus(tp);
            }
            case 4 -> {
                adoptionRecord.setStatus(AdoptionRecord.Status.CANCELLED);
                Pet tp=adoptionService.getPetById(adoptionRecord.getPet_id());
                tp.setAdopt_status(false);
                adoptionService.updateStatus(tp);
            }
            default -> System.out.println("Invalid option!");
        }
        adoptionService.updateRecord(adoptionRecord);
        System.out.println("Adoption record updated successfully!");
    }

    public void viewAdoptionRecords() {
        List<AdoptionRecord> records = adoptionService.getAllAdoptionRecords();
        if(records.isEmpty()) {
            System.out.println("No adoption records found.");
            return;
        }
        System.out.println("\n"+records.size()+" adoption Records:");
        for (AdoptionRecord record : records) {
            System.out.println(record);
        }
    }

    public void viewAdoptionHistoryByPet() {
        System.out.print("Enter pet ID to view adoption history: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<AdoptionRecord> records = adoptionService.getAdoptionRecordsByPet(petId);
        if(records.isEmpty()) {
            System.out.println("No adoption records found for this pet.");
            return;
        }
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
        if(records.isEmpty()) {
            System.out.println("No adoption records found for this adopter.");
            return;
        }
        System.out.println("\nAdoption History for Adopter ID " + adopterId + ":");
        for (AdoptionRecord record : records) {
            System.out.println(record);
        }
    }
}
