package com.saireddy.spring_security2.service;

import com.saireddy.spring_security2.model.Mobiles;
import com.saireddy.spring_security2.repo.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {
    @Autowired
    private MobileRepo repo;

    public List<Mobiles> getAllMobiles() {
        return repo.findAll();
    }

    public  Mobiles getMobileById(long mobileId){
       Optional<Mobiles> mobile =  repo.findById(mobileId);
       if(mobile.isPresent()){
           return mobile.get();
       }
       else {
             throw  new RuntimeException();
        }
    }

    public Mobiles addMobiles(Mobiles mobiles) {
        repo.save(mobiles);
        return mobiles;
    }

    public Mobiles updateMobiles(long mobileId, Mobiles mobiles) {
        Mobiles existingMobile = repo.findById(mobileId).orElseThrow(()-> new  RuntimeException());
        existingMobile.setMobileId(mobiles.getMobileId());
        existingMobile.setMobileName(mobiles.getMobileName());
        existingMobile.setMobilePrice(mobiles.getMobilePrice());
        repo.save(existingMobile);
        return existingMobile;
    }

    public void deleteMobile(long mobileId) {
        repo.findById(mobileId).orElseThrow(() -> new RuntimeException());
        repo.deleteById(mobileId);
    }
}
