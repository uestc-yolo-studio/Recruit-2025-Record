package com.petadoption.mapper;

import com.petadoption.entities.AdoptionRecord;

import java.util.List;

public interface AdoptionMapper {

     List<AdoptionRecord> getAllAdoptionRecords();

     List<AdoptionRecord> getAdoptionRecordsByPet(int petId);

     void addAdoptionRecord(AdoptionRecord adoptionRecord);
}

