package org.example.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public final class RequestSpec {

    private RequestSpec() {
    }

    private static RequestSpecification getRequestWithLogger(final RequestSpecification requestSpecification) {
        return requestSpecification
                .log().method()
                .log().uri()
                .log().params()
                .log().body();
    }

    public static RequestSpecification getRequestSpec() {
        return getRequestWithLogger(new RequestSpecBuilder()
                .setBaseUri("https://api.duckduckgo.com")
                .setRelaxedHTTPSValidation()
                .build());
    }

}