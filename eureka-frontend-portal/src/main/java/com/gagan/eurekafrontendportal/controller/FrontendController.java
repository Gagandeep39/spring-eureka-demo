/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-01 02:27:37
 * @modify date 2020-05-01 02:27:37
 * @desc [description]
 */
package com.gagan.eurekafrontendportal.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FrontendController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/doctors")
    public String getDoctors(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        // Gets the nstance using the host name to process the request
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("DOCTOR-SERVICE", false);
        // Fetch the instance from the instance object
        String baseUrl = instanceInfo.getHomePageUrl();
        log.info("Home page Url: " + baseUrl);
        return restTemplate.getForObject(baseUrl + "/location", String.class);
    }

    @GetMapping("/diseases")
    public String getDiseases(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        // Gets the nstance using the host name to process the request
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("DISEASE-SERVICE", false);
        // Fetch the instance from the instance object
        String baseUrl = instanceInfo.getHomePageUrl();
        log.info("Home page Url: " + baseUrl);
        return restTemplate.getForObject(baseUrl + "/location", String.class);
    }

    
}