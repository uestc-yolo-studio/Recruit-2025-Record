package com.petadoption.entities;

import com.petadoption.entities.Adopter;
import java.util.List;

public interface AdopterDAO {
    void insert(Adopter adopter);
    void update(Adopter adopter);
    void delete(int id);
    Adopter selectById(int id);
    List<Adopter> selectAll();
}