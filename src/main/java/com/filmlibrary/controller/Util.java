package com.filmlibrary.controller;

import com.filmlibrary.entity.Docs;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Ivan Gordeev 06.06.2023
 */

public class Util {
    public Docs getFilmByParams(String params) throws IOException {
        HttpURLConnection connection = getConnection(params);
        int responseCode = connection.getResponseCode();
        Docs yourObject = getDocs(connection, responseCode);
        connection.disconnect();
        return yourObject;
    }


    // Парсим ответ сервера в объект
    private static Docs getDocs(HttpURLConnection connection, int responseCode) throws IOException {
        Docs yourObject;
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            StringBuilder response = getResponse(connection);
            Gson gson = new Gson();
            yourObject = gson.fromJson(response.toString(), Docs.class);
        } else {
            System.out.println("Ошибка: " + responseCode);
            throw new RuntimeException();
        }
        return yourObject;
    }

    // Получаем ответ от сервера и считываем его
    private static StringBuilder getResponse(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response;
    }

    // Получаем соединение
    private static HttpURLConnection getConnection(String params) throws IOException {
        String selectedFields = "id%20" +
                "movieLength%20" +
                "type%20" +
                "name%20" +
                "year%20" +
                "ageRating%20" +
                "rating%20" +
                "poster%20" +
                "genres%20" +
                "persons%20" +
                "videos";

        URL url = new URL("https://api.kinopoisk.dev/v1.3/movie?selectFields=" + selectedFields + "&" + params);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-API-KEY", "9YE49WE-DEH4SXQ-NHCGQ3A-ARCE1G7");
        connection.setRequestMethod("GET");
        return connection;
    }
}
