<!-- W2-D3-S6 content.jsp-->



<%@include file="/libs/foundation/global.jsp" %>

    <div id="main">
        <div class="container_16">
     <% com.adobe.training.core.RepositoryService repositoryService = sling.getService(com.adobe.training.core.RepositoryService.class); %>
            Hello, my name is <%= repositoryService.getRepositoryName()%>
            <div class="grid_16">
                <cq:include path="carousel" resourceType="foundation/components/carousel"/>
            </div>
            <div class="grid_12 body_container">
                <cq:include path="lead" resourceType="geometrixx/components/lead"/>
                <cq:include path="par" resourceType="foundation/components/parsys"/>
            </div>
            <div class="grid_4 right_container">
                <cq:include path="rightpar" resourceType="foundation/components/parsys"/>
            </div>
            <div class="clear"></div>
        </div>
    </div>

<!-- W2-D3-S6 content.jsp ends-->
