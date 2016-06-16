package ir.ac.sbu.mavenproject1.util;

import javax.servlet.http.HttpServletResponse;

public class Response {

    public static void initialize(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
}
