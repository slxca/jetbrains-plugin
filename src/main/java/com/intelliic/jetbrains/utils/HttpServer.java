package com.intelliic.jetbrains.utils;

import com.intelliic.jetbrains.service.IntelliicPersistent;
import com.intellij.openapi.application.ApplicationInfo;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer {
    private static com.sun.net.httpserver.HttpServer server;

    public static void startHttpServer() {
        try {
            server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(63345), 0);
            server.createContext("/", new RootHandler());
            server.createContext("/connect", new ConnectHandler());
            server.start();
        } catch (IOException ignore) {}
    }

    public static void stopHttpServer() {
        try {
            server.stop(0);
        } catch (Exception ignore) {}
    }

    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            ApplicationInfo applicationInfo = ApplicationInfo.getInstance();
            String response = String.format("{\"name\":\"%s\", \"version\":\"%s\"}", applicationInfo.getVersionName(), applicationInfo.getFullVersion());
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class ConnectHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String key = reader.readLine();
            IntelliicPersistent.getInstance().setToken(key);
            exchange.sendResponseHeaders(200, -1);
            exchange.close();
        }
    }
}
