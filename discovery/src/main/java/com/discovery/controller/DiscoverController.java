package com.discovery.controller;

import com.discovery.models.ServiceURLReplicationDTO;
import com.discovery.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/services")
public class DiscoverController {

    @Autowired
    private DiscoveryService discoveryService;

    @PostMapping("/register-service")
    public void registerService(@RequestParam String service, @RequestParam String url) {

        discoveryService.registerService(service, url);
    }

    @GetMapping("/get-service-urls")
    public ResponseEntity<List<String>> getServiceUrls(@RequestParam String service) {

        List<String> serviceUrls = discoveryService.getServiceUrls(service);

        return ResponseEntity.status(HttpStatus.OK).body(serviceUrls);
    }

    @PutMapping("/health-check")
    public void healthCheck(@RequestParam String service, @RequestParam String url) {
        discoveryService.updateStatus(service, url);
    }

    @PostMapping("/replicate")
    public void replicate(@RequestBody List<ServiceURLReplicationDTO> serviceURLReplicationDTOList) {
        //replicate the data peer to peer
    }

}
