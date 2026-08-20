package soa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import soa.service.GatewayService;

@RestController
public class GatewayController {

    private final GatewayService GS;

    public GatewayController(GatewayService GS) {
        this.GS = GS;
    }

    @GetMapping("/{service}/{endpoint}")
    public Object getService(
            @PathVariable String service,
            @PathVariable String endpoint) {

        return GS.invokeService(service, endpoint);
    }
}