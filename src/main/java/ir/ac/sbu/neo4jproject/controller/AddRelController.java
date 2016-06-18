package ir.ac.sbu.neo4jproject.controller;

import ir.ac.sbu.neo4jproject.relationship.RelationHelper;
import ir.ac.sbu.neo4jproject.util.Helper;
import ir.ac.sbu.neo4jproject.util.Neo4jHelper;
import ir.ac.sbu.neo4jproject.util.Response;
import ir.ac.sbu.neo4jproject.util.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import scala.collection.Iterator;

@WebServlet(name = "AddRelController", urlPatterns = {"/AddRelController"})
public class AddRelController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        String userName = Helper.getRequestString(request, Tag.RELATION_USER_NAME);
        String filmName = Helper.getRequestString(request, Tag.RELATION_FILM_NAME);
        String rate = Helper.getRequestString(request, Tag.RELATION_RATE);

        Node filmNode = getNode("match (n:Movie) where n.name = '" + filmName + "' return n", "n");
        Node userNode = getNode("match (n:Person) where n.name = '" + userName + "' return n", "n");
        RelationHelper.createRelationWithProperties(userNode, filmNode, rate);
        
        response.sendRedirect(Tag.FIRST_PAGE);
    }

    private Node getNode(String query, String column) {
        ExecutionResult res = Neo4jHelper.getQueryResult(query);
        Iterator<Node> nodes = res.columnAs(column);
        if (nodes.hasNext()) {
            Node node = nodes.next();
            return node;
        }
        return null;
    }
}
