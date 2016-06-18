package ir.ac.sbu.neo4jproject.node;

import ir.ac.sbu.neo4jproject.util.Helper;
import ir.ac.sbu.neo4jproject.util.Neo4jHelper;
import ir.ac.sbu.neo4jproject.util.Tag;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

public class NodeHelper {

    public static void setUserNodeProperties(Node node, String userName) {
        node.setProperty(Tag.USER_ID, Helper.generateUniqueId());
        node.setProperty(Tag.USER_NAME, userName);
    }

    public static void createUserNode(String userName) {
        try {
            Transaction t = Neo4jHelper.createTransation();
            Node node = Neo4jHelper.createNode(NodeType.Person);
            setUserNodeProperties(node, userName);
            Neo4jHelper.commitTransaction(t);
        } catch (Exception e) {

        }
    }

    public static void setFilmNodeProperties(Node node, String filmName) {
        node.setProperty(Tag.FILM_ID, Helper.generateUniqueId());
        node.setProperty(Tag.FILM_NAME, filmName);
    }

    public static void createFilmNode(String filmName) {
        try {
            Transaction t = Neo4jHelper.createTransation();
            Node node = Neo4jHelper.createNode(NodeType.Movie);
            setFilmNodeProperties(node, filmName);
            Neo4jHelper.commitTransaction(t);
        } catch (Exception e) {

        }
    }
}
