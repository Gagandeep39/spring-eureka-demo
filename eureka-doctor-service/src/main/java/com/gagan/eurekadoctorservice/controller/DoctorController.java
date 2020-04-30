/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-01 00:39:43
 * @modify date 2020-05-01 00:39:43
 * @desc [description]
 */
package com.gagan.eurekadoctorservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DoctorController {

    @Value("${spring.application.name: no name}")
    private String appName;

    @Value("${server.port: no port}")
    private String portNo;

    @GetMapping("/doctors")
    public String doctors(){
        return "List of Doctors";
    }

    @GetMapping(value="/location")
    public String getServiceLocation() {
        return appName + ":" + portNo;
    }
    
    
}