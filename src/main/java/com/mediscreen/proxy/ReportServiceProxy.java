package com.mediscreen.proxy;

import com.mediscreen.dto.ReportEntriesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Report", url = "localhost:7933")
public interface ReportServiceProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/generateReport", consumes = "application/json")
    String generateReport(ReportEntriesDto entries);

    @RequestMapping(method = RequestMethod.POST, value = "/getReport", consumes = "application/json")
    String getReport(ReportEntriesDto entries);
}
