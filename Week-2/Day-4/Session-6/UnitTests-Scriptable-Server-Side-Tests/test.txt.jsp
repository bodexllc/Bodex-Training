<%@include file = "/libs/foundation/global.jsp" %>

<%

if (pageManager != null) {
    %> TEST PASSED <%
} else {
    %> no pageManager on request <%
}


%>