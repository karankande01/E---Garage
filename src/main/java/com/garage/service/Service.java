package com.garage.service;

import com.garage.model.Garage;
import com.garage.model.Visitor;
import com.garage.model.VisitorHistory;
import com.garage.repository.GarageRepository;
import com.garage.repository.VisitorHistoryRepository;
import com.garage.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private VisitorHistoryRepository visitorHistoryRepository;

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public void saveGarage(Garage garage) {
        garageRepository.saveAndFlush(garage);
    }

    public Garage getGarageById(int id){
        Optional<Garage> optional = garageRepository.findById(id);
        Garage garage = null;
        if(optional.isPresent()){
            garage = optional.get();
        }else {
            throw new RuntimeException("Garage not found for Id ::"+ id);
        }
        return garage;
    }

    public void deleteGarage(int id) {
        garageRepository.deleteById(id);
    }

    public void saveVisitor(Visitor visitor) {
        visitorRepository.saveAndFlush(visitor);
    }

    public void deleteVisitor(int id) {
        Visitor visitor = visitorRepository.getById(id);
        VisitorHistory visitorHistory = new VisitorHistory(visitor.getName(), visitor.getEmail(), visitor.getMessage());
        visitorHistoryRepository.saveAndFlush(visitorHistory);
        visitorRepository.deleteById(id);
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
