package com.petadoption.entities;


import com.petadoption.entities.Pet;
import java.util.List;

public interface PetDAO {
    void insert(Pet pet);
    void update(Pet pet);
    void delete(int id);
    Pet selectById(int id);
    List<Pet> selectAll();
}