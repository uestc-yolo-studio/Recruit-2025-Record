package com.petadoption.mapper;

import com.petadoption.entities.Pet;

import java.util.List;

public interface PetMapper {
     void addPet(Pet pet);
     void updatePet(Pet pet);
     void removePet(int id);
     Pet getPetById(int id);
     List<Pet> getAllPets();
     List<Pet> getAvailablePets();
}
