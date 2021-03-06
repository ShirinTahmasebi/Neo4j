<%@page import="org.neo4j.graphdb.Relationship"%>
<%@page import="ir.ac.sbu.neo4jproject.node.NodeType"%>
<%@page import="ir.ac.sbu.neo4jproject.util.Tag"%>
<%@page import="scala.collection.Iterator"%>
<%@page import="org.neo4j.graphdb.Node"%>
<%@page import="org.neo4j.cypher.ExecutionResult"%>
<%@page import="ir.ac.sbu.neo4jproject.util.Neo4jHelper"%>
<html dir="rtl" lang="fa">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
        <link rel="stylesheet" type="text/css" href="css/table_style.css">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body  class= "table-body">
        <%@ include file="menu.jsp" %> 
        <div style="height:50px;"></div>
        <div style="margin:20px auto" class="container" >
            <div class="table-responsive">
                <table id="recommendsTable"class="table hover" collapsing="0" width="100%" >
                    <thead>
                        <tr>
                            <th style="text-align:right; padding-right:25px;">نام&nbspکاربر</th>
                            <th style="text-align:right; padding-right:25px">نام&nbspفیلم</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  ExecutionResult res = Neo4jHelper.getQueryResult(
                                    "match (userone:Person) - [rel1:See]-> (film:Movie) "
                                            + "<- [rel2:See] - (usertwo:Person), (usertwo) "
                                            + "- [:See]-> (films:Movie) where rel1.rate = "
                                            + "rel2.rate return userone, films");
                            Iterator<Node> userNodes = res.columnAs("userone");
                            Iterator<Node> movieNodes = res.columnAs("films");
                            if (userNodes.hasNext()) {
                                Node user = userNodes.next();
                                while (movieNodes.hasNext()) {
                                    Node movie = movieNodes.next();
                        %>
                        <tr>
                            <td><%=user.getProperty(Tag.USER_NAME)%></td>
                            <td><%=movie.getProperty(Tag.FILM_NAME)%></td>
                        </tr>

                        <%}
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>