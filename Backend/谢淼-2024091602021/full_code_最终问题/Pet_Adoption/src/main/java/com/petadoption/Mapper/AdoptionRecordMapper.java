package com.petadoption.Mapper;

import com.petadoption.entities.AdoptionRecord;

import java.util.List;

public interface AdoptionRecordMapper {
    void adoptPet(AdoptionRecord record);
    void updateRecord(AdoptionRecord record);
    AdoptionRecord getRecordById(int recordId);
    List<AdoptionRecord> getAllAdoptionRecords();
    List<AdoptionRecord> getAdoptionRecordsByPet(int pet_id);
    List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopter_id);
}
