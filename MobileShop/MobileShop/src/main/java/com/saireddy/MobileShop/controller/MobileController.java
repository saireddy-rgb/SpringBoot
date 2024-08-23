package com.saireddy.MobileShop.controller;

import com.saireddy.MobileShop.model.Mobiles;
import com.saireddy.MobileShop.service.impl.MobileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobileController {


    @Autowired
     MobileServiceImpl service;

    @GetMapping("/mobiles")
    public List<Mobiles> getAllMobiles(){
       return service.getAllMobiles();
    }

}
