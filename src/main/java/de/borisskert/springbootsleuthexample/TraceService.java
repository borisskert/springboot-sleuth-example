package de.borisskert.springbootsleuthexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.TraceContext;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Just a service to get the Trace-Id from the injected {@link Tracer}
 */
@Service
public class TraceService {

    private final Tracer tracer;

    @Autowired
    public TraceService(Tracer tracer) {
        this.tracer = tracer;
    }

    public Optional<String> traceId() {
        return Optional.ofNullable(tracer.currentSpan())
                .map(Span::context)
                .map(TraceContext::traceId);
    }
}
