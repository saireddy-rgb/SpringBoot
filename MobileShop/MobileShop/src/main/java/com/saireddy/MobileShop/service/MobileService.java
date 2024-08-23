package com.saireddy.MobileShop.service;

import com.saireddy.MobileShop.model.Mobiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MobileService {
    List<Mobiles> getAllMobiles();
//    Mobiles getMobileById();
    Mobiles updateMobileDetails();
    Mobiles addNewMobiles();
    Boolean DeleteMobiles();
}
