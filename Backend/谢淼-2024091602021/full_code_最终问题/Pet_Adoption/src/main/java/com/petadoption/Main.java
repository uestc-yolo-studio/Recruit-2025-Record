/**
 * 宠物领养管理系统的主要类。
 * 提供主菜单和应用程序的入口点。
 */
package com.petadoption;

import com.petadoption.Mapper.AdopterMapper;
import com.petadoption.Mapper.AdoptionRecordMapper;
import com.petadoption.Mapper.PetMapper;
import com.petadoption.managers.*;
import com.petadoption.impl.AdoptionServiceImpl;
import com.petadoption.services.AdoptionService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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
    private static PetManager petManager;

    /**
     * 领养者管理器。
     */
    private static AdopterManager adopterManager;

    /**
     * 领养流程管理器。
     */
    private static AdoptionManager adoptionManager;
    //获取sqlsession
    private static SqlSession sqlSession;
    /**
     * 应用程序的入口点。
     * 
     * @param args 命令行参数。
     */
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象，用它来执行sql
        sqlSession = sqlSessionFactory.openSession();
        //3.执行sql
        PetMapper petmapper = sqlSession.getMapper(PetMapper.class);
        AdopterMapper adoptermapper = sqlSession.getMapper(AdopterMapper.class);
        AdoptionRecordMapper adoptionrecordmapper = sqlSession.getMapper(AdoptionRecordMapper.class);
        //4.释放资源
        AdoptionService adoptionService = new AdoptionServiceImpl(petmapper, adoptermapper, adoptionrecordmapper);
        petManager = new PetManager(adoptionService);
        adopterManager = new AdopterManager(adoptionService);
        adoptionManager = new AdoptionManager(adoptionService);
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
                    sqlSession.close();
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
                    sqlSession.commit();
                    break;
                case 2:
                    petManager.updatePet();
                    sqlSession.commit();
                    break;
                case 3:
                    petManager.removePet();
                    sqlSession.commit();
                    break;
                case 4:
                    petManager.listPets();
                    sqlSession.commit();
                    break;
                case 5:
                    petManager.listAvailablePets();
                    sqlSession.commit();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleAdopterMenu() throws IOException {
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
                    sqlSession.commit();
                    break;
                case 2:
                    adopterManager.updateAdopter();
                    sqlSession.commit();
                    break;
                case 3:
                    adopterManager.removeAdopter();
                    sqlSession.commit();
                    break;
                case 4:
                    adopterManager.listAdopters();
                    sqlSession.commit();
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
            System.out.println("5. Update Adoption Record");
            System.out.println("6. Back");
            System.out.print("\nChoose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    adoptionManager.processAdoption();
                    sqlSession.commit();
                    break;
                case 2:
                    adoptionManager.viewAdoptionRecords();
                    sqlSession.commit();
                    break;
                case 3:
                    adoptionManager.viewAdoptionHistoryByPet();
                    sqlSession.commit();
                    break;
                case 4:
                    adoptionManager.viewAdoptionHistoryByAdopter();
                    sqlSession.commit();
                    break;
                case 5:
                    adoptionManager.updateAdoptionRecord();
                    sqlSession.commit();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
