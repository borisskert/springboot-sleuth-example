package de.borisskert.springbootsleuthexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Simple Resource to retrieve the Trace-Id
 */
@RestController
public class TraceResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceResource.class);

    private final TraceService service;

    @Autowired
    public TraceResource(TraceService service) {
        this.service = service;
    }

    @RequestMapping("/traceId")
    public ResponseEntity<String> traceId() {
        LOGGER.info("Testing traceId");

        return ResponseEntity.of(
                service.traceId()
        );
    }
}
