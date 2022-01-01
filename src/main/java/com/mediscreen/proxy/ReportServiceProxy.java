package com.mediscreen.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Report", url = "localhost:7933")
public interface ReportServiceProxy {


}
