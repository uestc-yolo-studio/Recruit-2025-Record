package com.petadoption.Mapper;

import com.petadoption.entities.Adopter;

import java.util.List;

public interface AdopterMapper {
    void addAdopter(Adopter adopter);
    void updateAdopter(Adopter adopter);
    void removeAdopter(int id);
    Adopter getAdopterById(int id);
    List<Adopter> getAllAdopters();
}
