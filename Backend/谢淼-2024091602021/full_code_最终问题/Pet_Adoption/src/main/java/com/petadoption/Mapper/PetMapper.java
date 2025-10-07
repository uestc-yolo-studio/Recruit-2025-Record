package com.petadoption.Mapper;

import com.petadoption.entities.Pet;

import java.util.List;

public interface PetMapper {
    List<Pet> getAllPets();
    List<Pet> getAvailablePets();
    void removePet(int id);
    void addPet(Pet pet);
    Pet getPetById(int id);
    void updatePet(Pet pet);
    void updateStatus(Pet pet);
}
