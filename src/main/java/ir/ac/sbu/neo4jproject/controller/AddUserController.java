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

@WebServlet(name = "AddUserController", urlPatterns = {"/AddUserController"})
public class AddUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        String userName = Helper.getRequestString(request, Tag.USER_NAME);
        NodeHelper.createUserNode(userName);
        response.sendRedirect(Tag.FIRST_PAGE);
    }
}
