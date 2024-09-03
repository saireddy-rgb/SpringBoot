package com.saireddy.spring_security2.controller;

import com.saireddy.spring_security2.model.Mobiles;
import com.saireddy.spring_security2.service.MobileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobileController {
    @Autowired
    private MobileService service;

    @GetMapping("/mobiles")
    public List<Mobiles> getAllMobiles(){
        return service.getAllMobiles();
    }

    @GetMapping("/mobiles/{mobileId}")
    public Mobiles getMobileById(@PathVariable long mobileId){
        return service.getMobileById(mobileId);
    }
    @PostMapping("/mobiles")
    public Mobiles addMobile(@RequestBody Mobiles mobiles){
        service.addMobiles(mobiles);
        return mobiles;
    }

    @PutMapping("/mobiles/{mobileId}")
        public Mobiles updateMobile(@PathVariable long mobileId, @RequestBody Mobiles mobiles){
        service.updateMobiles(mobileId,mobiles);
        return mobiles;
    }

    @DeleteMapping("/mobiles/{mobileId}")
        public  String deleteMobile(@PathVariable long mobileId){
        service.deleteMobile(mobileId);
        return "mobile "+mobileId+" deleted succesfully";
    }
}