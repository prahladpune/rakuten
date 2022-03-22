package com.discovery.service;

import com.discovery.Repository.DiscoveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoveryService {

    @Autowired
    private DiscoveryRepository discoveryRepository;

    public void registerService(String service, String url) {

        discoveryRepository.registerService(service, url);

    }

    public List<String> getServiceUrls(String service) {

        return discoveryRepository.getURLs(service);

    }

    public void updateStatus(String service, String url) {
        discoveryRepository.update(service, url);
    }

    //this will be called from the cron job which updates the status of the instances
    // which have not sent the status in 30 secs
    public void updateStatus() {
        discoveryRepository.updateStatus();
    }
}
