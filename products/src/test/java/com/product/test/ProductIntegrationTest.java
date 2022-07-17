package com.product.test;

import com.product.test.model.Product;
import com.product.test.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ProductIntegrationTest.class)
public class ProductIntegrationTest {

    @Autowired
    private ProductConfig config;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private WebTestClient client;   
}
