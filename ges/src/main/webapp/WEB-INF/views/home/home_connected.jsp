<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/home">
            <div class="content-wrapper backwhite">
                <div style="position:absolute;top:100px">
                    <h1 style="text-align:center;">Bienvenue sur la plateforme de gestion des salles de projet et des equipements de l'EPF</h1>
                    <p style="text-align:center;font-size:25px;margin-top:70px;">
                        <img style="margin-right:20px;" src="resources/stockage/connection.png"/>
                        Vous etes bien connecte en tant que ${id}</p>
                    <button name="deconnected" value="yes" type="submit" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top:70px;margin-left:530px;" class="btn btn-primary btn-lg">Me deconnecter</button>
                </div>
            </div>
        </form>
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>