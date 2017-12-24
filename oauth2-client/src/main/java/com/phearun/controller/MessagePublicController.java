package com.phearun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.phearun.configuration.component.ApiURL;

@RestController
@RequestMapping("/public/messages")
public class MessagePublicController {

    private RestTemplate restTemplate;
    private ApiURL apiURL;

    @Autowired
    public MessagePublicController(RestTemplate restTemplate, ApiURL apiURL) {
        this.restTemplate = restTemplate;
        this.apiURL = apiURL;
    }

    @GetMapping
    public JsonNode message(){
        return restTemplate.getForObject(apiURL.publicMessage, JsonNode.class);
    }

    @GetMapping("/{id}")
    public JsonNode findMessage(@PathVariable Integer id){
        return restTemplate.getForObject(String.format("%s/%s", apiURL.publicMessage, id), JsonNode.class);
    }

}
