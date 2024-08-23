package com.saireddy.MobileShop.service.impl;

import com.saireddy.MobileShop.Repo.MobileRepo;
import com.saireddy.MobileShop.model.Mobiles;
import com.saireddy.MobileShop.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileRepo repo;

    @Override
    public List<Mobiles> getAllMobiles() {
       return repo.findAll();
    }
//
//    @Override
//    public Mobiles getMobileById() {
//        return List.of();
//    }

    @Override
    public Mobiles updateMobileDetails() {
        return null;
    }

    @Override
    public Mobiles addNewMobiles() {
        return null;
    }

    @Override
    public Boolean DeleteMobiles() {
        return null;
    }
}
