[toc]

# 人生第一个项目：宠物领养中心

## 分析需求与设计功能

+ 注册（新增用户）
+ 查看可以领养的宠物列表
+ 查看用户信息
+ 查看领养记录
+ 申请领养宠物

## 数据库设计

### 宠物表（pets）

+ pet_id
+ species
+ name
+ age
+ is_adopted

### 用户表（users）

+ user_id
+ `username`
+ phone
+ address

### 领养记录表（adoptions）

+ adopt_id
+ user_id(外键)
+ pet_id(外键)
+ adopt_time

### 创建数据库

```sql
-- 宠物表
CREATE TABLE pets (
pet_id INT PRIMARY KEY AUTO_INCREMENT,
species varchar(20) NOT NULL,
name VARCHAR(50) NOT NULL,
age INT NOT NULL,
is_adopted TINYINT(1) DEFAULT 0
 );
 
 -- 用户表
 CREATE TABLE users (
 user_id int PRIMARY KEY AUTO_INCREMENT,
 username VARCHAR(50) NOT NULL,
 phone VARCHAR(20) NOT NULL,
 address VARCHAR(50) NOT NULL
 ); 
 
 -- 领养记录表
 CREATE TABLE adoptions(
 adopt_id INT PRIMARY KEY AUTO_INCREMENT,
 pet_id INT,
 user_id INT,
 adopt_time DATETIME DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
 FOREIGN KEY (user_id) REFERENCES users(user_id)
  );
```

## 项目结构

```
PetAdoptationCenter
|— src/
|	|— entity(实体包)
|	|— util(工具包类) ---> 存放通用工具代码，用来干事情
| 	|— dao(数据访问) ---> 与数据库交互，增删查改
|	|— service(业务逻辑) ---> 处理业务(宠物管理，用户管理，申请领养流程)
|	|— main(控制台窗口) ---> 与用户交互
|- lib ---> JDBC驱动
```

## 源代码

### entity包

#### Pet类

```java
package Entity;

public class Pet {
    private int petId;
    private String species;
    private String name;
    private int age;
    private boolean isAdopted;

    public Pet(){

    }

    public Pet(String species, String name, int age, boolean isAdopted) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.isAdopted = isAdopted;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }
}

```

#### User类

```java
package Entity;

public class User {
    private int userId;
    private String username;
    private String phone;
    private String address;

    public User() {
    }

    public User(String username, String phone, String address) {
        this.username = username;
        this.phone = phone;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

```

#### Adoption类

```java
package Entity;

import java.sql.Timestamp;
import java.util.Date;

public class Adoption {
    private int adoptId;
    private int petId;
    private int userId;
    private Timestamp adoptTime;

    public Adoption() {
    }

        public Adoption(int petId, int userId,Timestamp adoptTime) {
        this.petId = petId;
        this.userId = userId;
        this.adoptTime = adoptTime;
    }

    public int getAdoptId() {
        return adoptId;
    }

    public void setAdoptId(int adoptId) {
        this.adoptId = adoptId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Timestamp adoptTime) {
        this.adoptTime = adoptTime;
    }
}

```

### Util包

#### DBUtil

```java
package Util;

import java.sql.*;

public class DBUtil {
    private DBUtil(){}
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/yxc";
    private static final String username = "root";
    private static final String password  = "123456";
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("mysql驱动加载失败");
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,username,password);
    }
    public static void close(Connection conn,PreparedStatement pstmn,ResultSet rs) {
        try{
            if(rs != null){
                rs.close();
            }
            if(pstmn != null){
                pstmn.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

```

### DAO包

#### PetDAO类

```java
package DAO;

import Entity.Pet;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PetDAO {
    //增加一个新宠物
    public void addPet(Pet p){
        String sql = "insert into pets(species,name,age,is_adopted) value(?,?,?,?);";
        Connection conn = null;
        PreparedStatement pstmn = null;
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setString(1,p.getSpecies());
            pstmn.setString(2,p.getName());
            pstmn.setInt(3,p.getAge());
            pstmn.setBoolean(4,p.isAdopted());
            pstmn.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,null);
        }
    }
    //查询所有可以领养的宠物，存在集合中
    public ArrayList<Pet> getAvailablePet(){
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "select * from pets where is_adopted = 0;";
        Connection conn = null;
        PreparedStatement pstmn = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            rs = pstmn.executeQuery();
            while (rs.next()){
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setSpecies(rs.getString("species"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                pet.setAdopted(rs.getBoolean("is_adopted"));
                pets.add(pet);
                /*System.out.println("pet_id:" + rs.getInt("pet_id"));
                System.out.println("species:" + rs.getString("species"));
                System.out.println("name:" + rs.getString("name"));
                System.out.println("age:" + rs.getInt("age"));
                System.out.println();*/
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,rs);
        }
        return pets;
    }
    //根据id查询宠物
    public Pet getPetById(int petId){
        String sql = "select * from pets where pet_id = ?;";
        Connection conn = null;
        PreparedStatement pstmn = null;
        ResultSet rs = null;
        Pet pet = new Pet();
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setInt(1,petId);
            rs = pstmn.executeQuery();
            if(rs.next()){
                pet.setPetId(rs.getInt("pet_id"));
                pet.setSpecies(rs.getString("species"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                pet.setAdopted(rs.getBoolean("is_adopted"));
            } else {
                pet = null;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,rs);
        }
        return pet;
    }
}

```

#### UserDAO类

```java
package DAO;

import Entity.User;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
    //增加一个用户
    public void addUser(User user){
        String sql = "insert into users(username,phone,address) value(?,?,?);";
        Connection conn = null;
        PreparedStatement pstmn = null;
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setString(1,user.getUsername());
            pstmn.setString(2, user.getPhone());
            pstmn.setString(3,user.getAddress());
            pstmn.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,null);
        }
    }
    //根据用户名查询用户
    public User getUserByUsername(String name){
        Connection conn = null;
        PreparedStatement pstmn = null;
        ResultSet rs = null;
        String sql = "select * from users where username = ?;";
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setString(1,name);
            rs = pstmn.executeQuery();
            if(rs.next()) {
                User user = new User(rs.getString("username"),
                        rs.getString("phone"),rs.getString("address"));
                user.setUserId(rs.getInt("user_id"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,rs);
        }
        return null;
    }
}

```

#### AdoptionDAO类

```java
package DAO;

import Entity.Adoption;
import Entity.User;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class AdoptionDAO {
    //增加一个领养记录
    public void addAdoptation(Adoption adoption){
        String sql = "insert into adoptions(user_id,pet_id,adopt_time) value(?,?,?);";
        String sql1 = "update pets set is_adopted = 1 where pet_id = ?;";
        Connection conn = null;
        PreparedStatement pstmn = null;
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setInt(1,adoption.getUserId());
            pstmn.setInt(2,adoption.getPetId());
            pstmn.setTimestamp(3,adoption.getAdoptTime());
            pstmn.executeUpdate();
            pstmn = conn.prepareStatement(sql1);
            pstmn.setInt(1,adoption.getPetId());
            pstmn.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,null);
        }
    }
    //根据用户id查询领养记录
    public ArrayList<Adoption> getAdoptionByUserId(int userId){
        String sql = "select * from adoptions where user_id = ?;";
        Connection conn = null;
        PreparedStatement pstmn = null;
        ResultSet rs = null;
        ArrayList<Adoption> adoptions = new ArrayList<>();
        try{
            conn = DBUtil.getConnection();
            pstmn = conn.prepareStatement(sql);
            pstmn.setInt(1,userId);
            rs = pstmn.executeQuery();
            while(rs.next()){
                Adoption adoption = new Adoption();
                adoption.setAdoptId(rs.getInt("adopt_id"));
                adoption.setUserId(rs.getInt("user_id"));
                adoption.setPetId(rs.getInt("pet_id"));
                adoption.setAdoptTime(rs.getTimestamp("adopt_time"));
                adoptions.add(adoption);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,pstmn,rs);
        }
        return adoptions;
    }
}

```

### Service包

#### PetService类

```java
package Service;

import DAO.PetDAO;
import Entity.Pet;

import java.util.ArrayList;

public class PetService {
    private PetDAO petDAO = new PetDAO();
    public void addNewPet(Pet pet){
        petDAO.addPet(pet);
    }
    public void getAvailablePet(){
        ArrayList<Pet> pets = petDAO.getAvailablePet();
        if(pets.isEmpty()){
            System.out.println("当前没有可以领养的宠物");
        } else {
            for(Pet pet : pets){
                System.out.println("宠物id:" + pet.getPetId());
                System.out.println("种类:" + pet.getSpecies());
                System.out.println("名字:" + pet.getName());
                System.out.println("年龄:" + pet.getAge());
                System.out.println();
            }
        }
    }
}

```

#### UserService类

```java
package Service;

import DAO.UserDAO;
import Entity.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public void addNewUser(User user){
        User user1 = userDAO.getUserByUsername(user.getUsername());
        if(user1 != null){
            System.out.println("用户已经存在");
        } else {
            userDAO.addUser(user);
        }
    }
    public void getUser(String name){
        User user = userDAO.getUserByUsername(name);
        if(user == null){
            System.out.println("未找到用户");
        } else {
            System.out.println("用户id：" + user.getUserId());
            System.out.println("姓名：" + user.getUsername());
            System.out.println("电话：" + user.getPhone());
            System.out.println("地址：" + user.getAddress());
        }
    }
}

```

#### AdoptionService类

```java
package Service;

import DAO.AdoptionDAO;
import DAO.PetDAO;
import DAO.UserDAO;
import Entity.Adoption;
import Entity.Pet;
import Entity.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class AdoptionService {
    AdoptionDAO adoptionDAO = new AdoptionDAO();
    PetDAO petDAO = new PetDAO();
    UserDAO userDAO = new UserDAO();
    public void getAdoption(String username){
        User user =  userDAO.getUserByUsername(username);
        if(user == null){
            System.out.println("用户不存在");
            return;
        }
        ArrayList<Adoption> adoptions = adoptionDAO.getAdoptionByUserId(user.getUserId());
        if(adoptions.isEmpty()){
            System.out.println("无领养记录");
        } else {
            System.out.println("用户名：" + username);
            for(Adoption adoption : adoptions) {
                Pet pet = petDAO.getPetById(adoption.getPetId());
                System.out.println("领养id:" + adoption.getAdoptId());
                System.out.println("宠物id:" + adoption.getPetId());
                System.out.println("宠物名:" + pet.getName());
                System.out.println("领养时间:" + adoption.getAdoptTime());
                System.out.println();
            }
        }
        /*for (int i = 0; i < adoptions.size(); i++) {
            System.out.println("adopt_id:" + adoptions.get(i).getAdoptId());
            System.out.println("user_id:" + adoptions.get(i).getUserId());
            System.out.println("pet_id:" + adoptions.get(i).getPetId());
            System.out.println("adopt_time:" + adoptions.get(i).getAdoptTime());
            System.out.println();
        }*/
    }
    public void addNewAdoption(int petId,String username){
        User user = userDAO.getUserByUsername(username);
        Pet pet = petDAO.getPetById(petId);
        if(user == null){
            System.out.println("用户不存在，请重新注册");
            return ;
        }
        if(pet == null){
            System.out.println("宠物不存在");
            return ;
        }
        if(pet.isAdopted()){
            System.out.println("宠物已经被领养,请领养其他宠物");
            return ;
        }
        Adoption adoption = new Adoption(pet.getPetId(),user.getUserId(),new Timestamp(System.currentTimeMillis()));
        adoptionDAO.addAdoptation(adoption);
        System.out.println("名字：" + pet.getName() + " 种类：" + pet.getSpecies() + " 年龄：" + pet.getAge() + " 成为了你的宠物");
    }
}

```

### Main

```java
import Entity.Adoption;
import Entity.Pet;
import Entity.User;
import Service.AdoptionService;
import Service.PetService;
import Service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎来到宠物领养中心");
        while(true){
            System.out.println("请选择您的服务：");
            System.out.println("1.注册");
            System.out.println("2.查看可领养的宠物列表");
            System.out.println("3.查看个人信息");
            System.out.println("4.查看个人领养记录");
            System.out.println("5.申请领养宠物");
            System.out.println("6.退出");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op){
                case 1:
                    login();
                    break;
                case 2:
                    checkAvailablePet();
                    break;
                case 3:
                    checkPersonalInfo();
                    break;
                case 4:
                    checkPersonalAdoptionRecord();
                    break;
                case 5:
                    AdoptPet();
                    break;
                case 6:
                    System.out.println("期待你的下次到来!");
                    return ;
                default:
                    System.out.println("无法找到服务，请重新输入");
                    break;
            }
        }

    }
    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String username = sc.next();
        System.out.println("请输入你的电话号码：");
        String phone = sc.next();
        System.out.println("请输入你的住址：");
        String address = sc.next();
        User user = new User(username,phone,address);
        UserService userService = new UserService();
        userService.addNewUser(user);
    }
    public static void checkAvailablePet()
    {
        PetService petService = new PetService();
        petService.getAvailablePet();

    }
    public static void checkPersonalInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String username = sc.next();
        UserService userService = new UserService();
        userService.getUser(username);
    }
    public static void checkPersonalAdoptionRecord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String username = sc.next();
        AdoptionService adoptionService = new AdoptionService();
        adoptionService.getAdoption(username);
    }
    public static void AdoptPet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String username = sc.next();
        System.out.println("请输入你要领养的宠物的id：");
        int petId = sc.nextInt();
        AdoptionService adoptionService =new AdoptionService();
        adoptionService.addNewAdoption(petId,username);
    }
}
```







