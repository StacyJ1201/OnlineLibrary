package com.synergisticit.actuator.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="dinesh")
public class CustomEndPoint {

    @ReadOperation
    public String hi(){
        return "Hello Benjamin";
    }
}
