package com.mediscreen.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Patient", url = "localhost:7911")
public interface PatientServiceProxy {


}
