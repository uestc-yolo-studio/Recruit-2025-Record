/**
 * 宠物领养管理系统的主要类。
 * 提供主菜单和应用程序的入口点。
 */
package com.petadoption;

import com.petadoption.entities.Pet;
import com.petadoption.entities.Adopter;
import com.petadoption.managers.*;
import com.petadoption.impl.AdoptionServiceImpl;
import com.petadoption.services.AdoptionService;

import java.util.Scanner;

/**
 * 宠物领养管理系统的主要类。
 */
public class Main {
    /**
     * 控制台输入扫描器。
     */
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * 宠物领养服务。
     */
    private static AdoptionService adoptionService = new AdoptionServiceImpl();
    
    /**
     * 宠物管理器。
     */
    private static PetManager petManager = new PetManager(adoptionService);
    
    /**
     * 领养者管理器。
     */
    private static AdopterManager adopterManager = new AdopterManager(adoptionService);
    
    /**
     * 领养流程管理器。
     */
    private static AdoptionManager adoptionManager = new AdoptionManager(adoptionService);

    /**
     * 应用程序的入口点。
     * 
     * @param args 命令行参数。
     */
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\nPet Adoption Management System");
            System.out.println("1. Pet Management");
            System.out.println("2. Adopter Management");
            System.out.println("3. Adoption Process");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    handlePetMenu();
                    break;
                case 2:
                    handleAdopterMenu();
                    break;
                case 3:
                    handleAdoptionMenu();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handlePetMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\nPet Management");
            System.out.println("1. Add Pet");
            System.out.println("2. Update Pet");
            System.out.println("3. Remove Pet");
            System.out.println("4. List All Pets");
            System.out.println("5. List Available Pets");
            System.out.println("6. Back");
            System.out.print("\nChoose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    petManager.addPet();
                    break;
                case 2:
                    petManager.updatePet();
                    break;
                case 3:
                    petManager.removePet();
                    break;
                case 4:
                    petManager.listPets();
                    break;
                case 5:
                    petManager.listAvailablePets();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleAdopterMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\nAdopter Management");
            System.out.println("1. Add Adopter");
            System.out.println("2. Update Adopter");
            System.out.println("3. Remove Adopter");
            System.out.println("4. List All Adopters");
            System.out.println("5. Back");
            System.out.print("\nChoose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    adopterManager.addAdopter();
                    break;
                case 2:
                    adopterManager.updateAdopter();
                    break;
                case 3:
                    adopterManager.removeAdopter();
                    break;
                case 4:
                    adopterManager.listAdopters();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleAdoptionMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\nAdoption Process");
            System.out.println("1. Process Adoption");
            System.out.println("2. View All Adoption Records");
            System.out.println("3. View Adoption History by Pet");
            System.out.println("4. View Adoption History by Adopter");
            System.out.println("5. Back");
            System.out.print("\nChoose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    adoptionManager.processAdoption();
                    break;
                case 2:
                    adoptionManager.viewAdoptionRecords();
                    break;
                case 3:
                    adoptionManager.viewAdoptionHistoryByPet();
                    break;
                case 4:
                    adoptionManager.viewAdoptionHistoryByAdopter();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
