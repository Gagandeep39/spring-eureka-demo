/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-01 02:05:59
 * @modify date 2020-05-01 02:05:59
 * @desc [description]
 */

package com.gagan.eurekapatientservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Value("${spring.application.name: no name}")
    private String appName;

    @Value("${server.port: no port}")
    private String portNo;

    @GetMapping("/patients")
    public String showPatient() {
        return "patients";
    }

    @GetMapping(value = "/location")
    public String getServiceLocation() {
        return appName + ":" + portNo;
    }

}