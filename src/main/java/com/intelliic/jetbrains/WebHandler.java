package com.intelliic.jetbrains;

import com.google.gson.JsonObject;
import com.intellij.openapi.application.ApplicationInfo;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WebHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {

        ApplicationInfo applicationInfo = ApplicationInfo.getInstance();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", applicationInfo.getVersionName());
        jsonObject.addProperty("version", applicationInfo.getFullVersion());

        t.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        t.sendResponseHeaders(200, jsonObject.toString().getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(jsonObject.toString().getBytes());
        os.close();
    }
}
