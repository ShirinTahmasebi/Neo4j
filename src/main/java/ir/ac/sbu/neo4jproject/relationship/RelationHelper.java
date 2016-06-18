package ir.ac.sbu.neo4jproject.relationship;

import ir.ac.sbu.neo4jproject.util.Neo4jHelper;
import ir.ac.sbu.neo4jproject.util.Tag;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

public class RelationHelper {

    public static void createRelationWithProperties(Node fromNode, Node toNode, String rate) {
        try {
            Transaction t = Neo4jHelper.createTransation();
            Relationship relation = fromNode.createRelationshipTo(toNode, RelationType.See);
            relation.setProperty(Tag.RELATION_RATE, rate);
            Neo4jHelper.commitTransaction(t);
        } catch (Exception e) {

        }
    }

}
