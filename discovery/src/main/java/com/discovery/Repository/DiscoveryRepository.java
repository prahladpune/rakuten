package com.discovery.Repository;

import com.discovery.models.ServiceRecord;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class DiscoveryRepository {

    Map<String, Set<ServiceRecord>> registry = new ConcurrentHashMap<>();

    public void registerService(String serviceName, String serviceURL) {
        Set<ServiceRecord> serviceInstance = new HashSet<>();
        serviceInstance.add(new ServiceRecord(serviceURL, true, LocalDateTime.now()));
        registry.putIfAbsent(serviceName, serviceInstance);
    }

    public List<String> getURLs(String serviceName) {
        return registry.getOrDefault(serviceName, new HashSet<>()).stream().filter(ServiceRecord::isStatus).map(ServiceRecord::getUrl).collect(Collectors.toList());
    }

    public void update(String serviceName, String serviceURL) {

        Set<ServiceRecord> serviceRecords = registry.getOrDefault(serviceName, new HashSet<>());
        for(ServiceRecord serviceRecord:  serviceRecords){
            if(serviceRecord.getUrl().equals(serviceURL)){
                serviceRecord.setStatus(true);
                serviceRecord.setTimestamp(LocalDateTime.now());
            }
        }
    }

    public void replicate(String serviceName, List<ServiceRecord> records){

    }

    public void updateStatus() {
        for(Map.Entry<String, Set<ServiceRecord>> entry: registry.entrySet()){
            for(ServiceRecord record: entry.getValue()){
                if(Duration.between(LocalDateTime.now(), record.getTimestamp()).getSeconds()>30){
                    record.setStatus(false);
                }
            }
        }
    }
}
