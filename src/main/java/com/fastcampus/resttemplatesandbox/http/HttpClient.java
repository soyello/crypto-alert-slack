package com.fastcampus.resttemplatesandbox.http;

import com.fastcampus.resttemplatesandbox.exception.UpbitClientException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpClient {

    private final RestTemplate restTemplate;

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getData(String uri, HttpMethod httpMethod, HttpHeaders headers) {
        try {
            return restTemplate.exchange(uri, httpMethod, new HttpEntity<>(headers), new ParameterizedTypeReference<String>() {
            }).getBody();
        } catch (RestClientException e) {
            log.error("에러", e);
            throw new UpbitClientException(e.getMessage());
        }
    }
}
