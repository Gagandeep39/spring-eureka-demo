/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-01 02:02:53
 * @modify date 2020-05-01 02:02:53
 * @desc [description]
 */
package com.gagan.eurekadiseaseservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiseaseController {

    @Value("${spring.application.name: no name}")
    private String appName;

    @Value("${server.port: no port}")
    private String portNo;

    @GetMapping("/diseases")
    public String showDisease(){
        return "List of disease";
    }

    @GetMapping(value="/location")
    public String getServiceLocation() {
        return appName + ":" + portNo;
    }

}