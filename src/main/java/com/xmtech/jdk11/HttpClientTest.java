package com.xmtech.jdk11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;
import java.util.Map;

public class HttpClientTest {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("http://openjdk.java.net/"))
                                         .build();
        BodyHandler<?> callback = new CallBack();
        client.sendAsync(request, callback)
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join();
    }

    static class CallBack implements BodyHandler<String> {

        @Override
        public BodySubscriber<String> apply(ResponseInfo responseInfo) {
            HttpHeaders headers = responseInfo.headers();
            Map<String, List<String>> map = headers.map();
            map.forEach((k,v)->{
                String format = String.format("%s=%s", k, v);
                System.out.println(format);
            });
            return null;
        }
    }


}
