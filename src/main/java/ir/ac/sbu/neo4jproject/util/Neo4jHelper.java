package ir.ac.sbu.neo4jproject.util;

import ir.ac.sbu.neo4jproject.node.NodeType;
import java.util.Iterator;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.StringLogger;

public class Neo4jHelper {

    private static final GraphDatabaseService graphdb;

    static {
        String path = "//Users//apple//Documents//Neo4j//default.graphdb";
        GraphDatabaseFactory dbfactoryy = new GraphDatabaseFactory();
        graphdb = dbfactoryy.newEmbeddedDatabase(path);
    }

//    public static GraphDatabaseService getGraphDb() {
//        if (graphdb == null) {
//            String path = "//Users//apple//Documents//Neo4j//default.graphdb";
//            GraphDatabaseFactory dbfactoryy = new GraphDatabaseFactory();
//            graphdb = dbfactoryy.newEmbeddedDatabase(path);
//        }
//        return graphdb;
//    }

    public static Transaction createTransation() {
        Transaction tx = graphdb.beginTx();
        return tx;
    }

    public static void commitTransaction(Transaction tx) {
        tx.success();
    }

    public static Node createNode(NodeType type) {
        return graphdb.createNode(type);
    }

    public static void setProperty(Node node, String propertyName, String propertyValue) {
        node.setProperty(propertyName, propertyValue);
    }

    public static void setProperty(Relationship relationship, String propertyName, String propertyValue) {
        relationship.setProperty(propertyName, propertyValue);
    }

    public static Relationship createRelationship(Node fromNode, Node toNode, RelationshipType type) {
        return fromNode.createRelationshipTo(toNode, type);
    }

    public static ExecutionResult getQueryResult(String query) {
        ExecutionEngine engine = new ExecutionEngine(graphdb, StringLogger.SYSTEM);
        ExecutionResult result;
        result = engine.execute(query);
        System.out.println("getQueryResult " + result.dumpToString());
        return result;
    }
}
