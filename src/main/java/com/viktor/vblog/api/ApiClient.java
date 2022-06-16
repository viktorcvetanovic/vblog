package com.viktor.vblog.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static javafx.css.StyleOrigin.USER_AGENT;

@Data
@RequiredArgsConstructor
public class ApiClient<T> {

    private final String apiUrl;

    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> typeParameterClass;


    public  T sendGET() throws IOException {
        URL obj = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if(responseCode != HttpURLConnection.HTTP_OK){
            throw new HTTPException(responseCode);
        }

        return objectMapper.convertValue(con,typeParameterClass);
    }

    // dont use this we can easily convert from bytes to class thanks to jackson :)
    @Deprecated
    private String convertToString(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
    return  response.toString();
    }

}
