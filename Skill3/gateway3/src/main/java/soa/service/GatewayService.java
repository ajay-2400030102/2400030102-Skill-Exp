package soa.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GatewayService {

    private final DiscoveryClient DC;
    private int current = 0;

    public GatewayService(DiscoveryClient DC) {
        this.DC = DC;
    }

    // GET service
    public Object invokeService(String service, String endpoint) {

        List<ServiceInstance> services = DC.getInstances(service);

        if (services == null || services.isEmpty()) {
            return "Service not available: " + service;
        }

        if (current >= services.size()) {
            current = 0;
        }

        ServiceInstance instance = services.get(current);

        current = (current + 1) % services.size();

        String url = instance.getUri().toString() + "/" + endpoint;

        System.out.println("Gateway calling: " + url);

        RestClient client = RestClient.create();

        return client.get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }

    // POST service
    public Object invokePostService(String service, String endpoint, Object data) {

        List<ServiceInstance> services = DC.getInstances(service);

        if (services == null || services.isEmpty()) {
            return "Service not available: " + service;
        }

        if (current >= services.size()) {
            current = 0;
        }

        ServiceInstance instance = services.get(current);

        current = (current + 1) % services.size();

        String url = instance.getUri().toString() + "/" + endpoint;

        System.out.println("Gateway calling: " + url);

        RestClient client = RestClient.create();

        return client.post()
                .uri(url)
                .body(data)
                .retrieve()
                .body(String.class);
    }
}