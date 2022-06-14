<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <!-- Include Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Style -->
    </head>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar_not_connected.jsp" %>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/home">
            <div class="content-wrapper backwhite">
                <div style="position:absolute;top:100px">
                    <h1 style="text-align:center;">Bienvenue sur la plateforme de gestion des salles de projet et des equipements de l'EPF</h1>
                <p style="text-align:center;font-size:25px;margin-top:50px;">Veuillez vous identifier ci-dessous :</p>
                    <p style="margin-left:24px;text-align:center;font-size:25px;margin-top:50px;">Identifiant : 
                        <input style="margin-left:20px;" type="text" id="id" name="id" placeholder="Identifiant" required>
                    </p>
                    <p style="text-align:center;margin-top:30px;font-size:25px;">Mot de passe : 
                        <input style="margin-left:20px;" type="password" id="mdp" name="mdp" placeholder="Mot de passe" minlength="8" required>
                    </p>
                    <button style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top:50px;margin-left:550px;" type="submit" class="btn btn-primary btn-lg">Me connecter</button>
                    <c:set var="erreurMdp" value="${erreurMdp}"></c:set>
                    <c:set var="erreurId" value="${erreurId}"></c:set>
                    <c:if test="${erreurId==true}">
                        <p style="text-align:center;margin-top:30px;font-size:25px;color:red;">
                            Erreur d'identifiant. Veuillez reessayer avec un autre identifiant de connexion.
                        </p>
                    </c:if>
                    <c:if test="${erreurMdp==true}">
                        <p style="text-align:center;margin-top:30px;font-size:25px;color:red;">
                            Erreur de mot passe. Veuillez reessayer avec un autre mot de passe pour cet identifiant.
                        </p>
                    </c:if>
                </div>
            </div>
        </form>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
