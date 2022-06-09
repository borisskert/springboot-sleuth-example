package de.borisskert.springbootsleuthexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TraceResourceTest {

    @Autowired
    private WebTestClient client;

    @Test
    void shouldRespondNewTraceId() throws Exception {
        client.get()
                .uri("/traceId")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void shouldRespondWithSpecifiedTraceId() throws Exception {
        client.get()
                .uri("/traceId")
                .header("x-b3-traceid", "222f3b00a283c75a")
                .header("x-b3-spanid", "222f3b00a283c75b")
                .exchange()
                .expectBody(String.class)
                .isEqualTo("222f3b00a283c75a");
    }
}
