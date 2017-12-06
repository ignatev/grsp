package ru.grsp.integration.report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @GetMapping(path = "/getAllReports")
    public GrspReport getAllReports() {
        return new GrspReport("name");
    }
}
