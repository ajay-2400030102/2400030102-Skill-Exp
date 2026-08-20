package soa.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GatewayService {

	
DiscoveryClient DC;
    
    public GatewayService(DiscoveryClient DC) {
      this.DC = DC;
    }
    
    public Object invokeService(HttpMethod method, String serviceName, String operation, Object data)
    {
      List<ServiceInstance> serviceInstances = DC.getInstances(serviceName);
      if(serviceInstances.isEmpty())
        throw new RuntimeException("No services found");
      ServiceInstance instance = serviceInstances.get(0);
      String URL = String.format("%s/api/%s", instance.getUri(), operation);
      
      RestClient client = RestClient.create();

          if (method == HttpMethod.POST) 
              return client.post().uri(URL).body(data).retrieve().body(String.class);
          
          return client.get().uri(URL).retrieve().body(String.class);
    }
}
