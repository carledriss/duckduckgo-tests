package org.example.core.api;

import io.restassured.response.Response;

public final class RequestManager {

    private RequestManager() {
    }

    public static Response getResponseWithLogger(final Response response) {
        response.then()
                .log().status()
                .log().body();
        return response;
    }
}
