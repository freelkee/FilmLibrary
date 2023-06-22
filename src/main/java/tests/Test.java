package tests;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Ivan Gordeev 27.05.2023
 */

public class Test {
    public static void main(String[] args) {
        try {
            // Создание URL-адреса сервера
            String encode = URLEncoder.encode("Форсаж", StandardCharsets.UTF_8);
            String selectedFields = "id%20name%20type";

//            URL url = new URL("https://api.kinopoisk.dev/v1.3/movie?selectFields=" + selectedFields + "&id=" + 342);
            URL url = new URL("https://api.kinopoisk.dev/v1.3/movie?selectFields=" + selectedFields + "&name=" + encode);

            // Открытие соединения
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Установка параметра заголовка
            connection.setRequestProperty("X-API-KEY", "9YE49WE-DEH4SXQ-NHCGQ3A-ARCE1G7");

            // Установка метода запроса (GET)
            connection.setRequestMethod("GET");

            // Проверка кода ответа
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Чтение данных с сервера
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                Gson gson = new Gson();
//                Film media = gson.fromJson(response.toString(), Film.class);
                Docs docs = gson.fromJson(response.toString(), Docs.class);
                System.out.println(docs);


            } else {
                System.out.println("Ошибка: " + responseCode);
            }

            // Закрытие соединения
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

