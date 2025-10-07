/**
 * 处理宠物相关操作的管理类。
 * 为领养系统中的宠物管理提供用户界面。
 */
package com.petadoption.managers;

import com.petadoption.entities.Pet;
import com.petadoption.services.AdoptionService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

/**
 * 主要的宠物管理操作管理类。
 */
public class PetManager {
    /**
     * 领养服务实例。
     */
    private final AdoptionService adoptionService;
    /**
     * 用户输入扫描器。
     */
    private final Scanner scanner;

    /**
     * 构造函数，初始化领养服务和用户输入扫描器。
     * @param adoptionService 领养服务实例。
     */
    public PetManager(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
        this.scanner = new Scanner(System.in);
    }

    public void addPet() {
        Pet pet = new Pet();
        System.out.print("Enter pet name: ");
        pet.setName(scanner.nextLine());
        
        System.out.print("Enter pet species: ");
        pet.setSpecies(scanner.nextLine());
        
        System.out.print("Enter pet age: ");
        pet.setAge(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        
        adoptionService.addPet(pet);

        System.out.println("Pet added successfully!");
    }

    public void updatePet() {
        System.out.print("Enter pet ID to update: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Pet pet = adoptionService.getPetById(petId);
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }

        System.out.print("Enter new pet name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            pet.setName(name);
        }

        System.out.print("Enter new pet species (leave blank to keep current): ");
        String species = scanner.nextLine();
        if (!species.isEmpty()) {
            pet.setSpecies(species);
        }

        System.out.print("Enter new pet age (leave blank to keep current): ");
        String agestr = scanner.nextLine();
        if (!agestr.isEmpty()) {
            int age = Integer.parseInt(agestr);
            pet.setAge(age);
        }

        adoptionService.updatePet(pet);
        System.out.println("Pet updated successfully!");
    }
    public void removePet() {
        System.out.print("Enter pet ID to remove: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Pet pet = adoptionService.getPetById(petId);
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }
        
        adoptionService.removePet(petId);
        System.out.println("Pet removed successfully!");
    }

    public void listPets() {
        List<Pet> pets = adoptionService.getAllPets();
        if(pets.isEmpty()) {
            System.out.println("No pets found in the system.");
            return;
        }
        System.out.println("\nAll "+pets.size()+" Pets:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public void listAvailablePets() {
        List<Pet> availablePets = adoptionService.getAvailablePets();
        if(availablePets.isEmpty()) {
            System.out.println("No available pets for adoption.");
            return;
        }
        System.out.println("\n"+availablePets.size()+" available Pets for Adoption:");
        for (Pet pet : availablePets) {
            System.out.println(pet);
        }
    }
}
