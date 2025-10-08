package com.petadoption.entities;

import com.petadoption.entities.AdoptionRecord;
import java.util.List;

public interface AdoptionRecordDAO {
    void insert(AdoptionRecord record);
    List<AdoptionRecord> selectAll();
    List<AdoptionRecord> selectByPetId(int petId);
    List<AdoptionRecord> selectByAdopterId(int adopterId);
}
