package com.viktor.vblog.servlet.time;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.viktor.vblog.api.ApiClient;
import com.viktor.vblog.api.data.TimeApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "timeServlet", value = "/time-servlet")
public class TimeServlet extends HttpServlet {
    final ApiClient<TimeApi> client= new ApiClient<>("http://worldtimeapi.org/api/timezone/Europe/Belgrade");
    final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(ow.writeValueAsString(client.sendGET()));
        resp.getWriter().flush();
    }
}
