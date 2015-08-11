<!-- W2-D5-S5 Importer.jsp -->



<%@page import="javax.jcr.*,javax.jcr.query.*,java.util.*,
			com.day.cq.commons.jcr.JcrUtil"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@include file="/libs/foundation/global.jsp"%>
<html>
<head>
<title>Campaigns Update</title>
</head>
<body>
<%
    String q = "/jcr:root/content/campaigns/geometrixx//*" +
			"[@sling:resourceType='foundation/components/parsys']";
    Query query = currentNode.getSession().getWorkspace().getQueryManager()
			.createQuery(q, "xpath");
    NodeIterator result = query.execute().getNodes();
    int counter = 0;
    while (result.hasNext()) {
        Node n = result.nextNode();
        Node newTextNode = JcrUtil.createUniqueNode(n, "newtext", 
			"nt:unstructured", currentNode.getSession());
        newTextNode.setProperty("sling:resourceType", 
			"foundation/components/text");
        newTextNode.setProperty("text", "<p>even more text</p>");
        newTextNode.setProperty("textIsRich", "true");
        counter++;
    }
    currentNode.getSession().save();
    out.println("Added nodes: " + counter);
%>
</body>
</html>

<!-- W2-D5-S5 Importer.jsp ends-->


