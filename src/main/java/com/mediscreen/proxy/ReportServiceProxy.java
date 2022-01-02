package com.mediscreen.proxy;

import com.mediscreen.dto.ReportEntriesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Report", url = "localhost:7933")
public interface ReportServiceProxy {

    @GetMapping(value="/generateReport")
    String generateReport(ReportEntriesDto entries);
}
