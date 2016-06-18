package ir.ac.sbu.neo4jproject.controller;

import ir.ac.sbu.neo4jproject.node.NodeHelper;
import ir.ac.sbu.neo4jproject.util.Helper;
import ir.ac.sbu.neo4jproject.util.Response;
import ir.ac.sbu.neo4jproject.util.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddFilmController", urlPatterns = {"/AddFilmController"})
public class AddFilmController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        String filmName = Helper.getRequestString(request, Tag.FILM_NAME);
        NodeHelper.createFilmNode(filmName);
        response.sendRedirect(Tag.FIRST_PAGE);
    }

}
