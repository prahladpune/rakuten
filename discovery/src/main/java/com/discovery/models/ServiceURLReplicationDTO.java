package com.discovery.models;

import java.io.Serializable;
import java.util.List;

public class ServiceURLReplicationDTO implements Serializable {
    String serviceName;
    List<ServiceRecord> serviceRecords;
}
