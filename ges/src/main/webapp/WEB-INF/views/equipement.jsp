<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- Added /jsp before jstl -->

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">

            <h1>Equipements</h1>

            <div class="backwhite">

                <c:forEach items="${listEquipement}" var="equipement">

                        <p>${equipement.id_equipement}</p>

                        <p>Ylo</p>

                </c:forEach>
            </div>
            

            

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
