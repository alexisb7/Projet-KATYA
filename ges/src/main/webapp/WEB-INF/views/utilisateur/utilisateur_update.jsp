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
        <c:set var="role" value="${role}"></c:set>
        <c:set var="eleve" value="${eleve}"></c:set>
        <c:set var="secretaire" value="${secretaire}"></c:set>
        <c:set var="admin" value="${admin}"></c:set>
        <c:if test="${role==eleve}">
            <%@ include file="/WEB-INF/views/common/sidebar_restraint.jsp" %>
        </c:if>
        <c:if test="${role==secretaire}">
            <%@ include file="/WEB-INF/views/common/sidebar_restraint.jsp" %>
        </c:if>
        <c:if test="${role==admin}">
            <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        </c:if>
        <div class="content-wrapper backwhite">

           <h1>Mise a jour d'utilisateurs</h1>
           <div class="box">
            <!-- form start -->
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/utilisateur_update?role=${role}">
                 <div class="box-body">
                    <div class="form-group">
                        <label for="id" class="col-sm-2 control-label">Identifiant</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="id" name="id"  value="${user.id_utilisateur}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>

                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mdp" class="col-sm-2 control-label">Mot de passe</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="mdp" name="mdp" value="${user.mdp}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nom" class="col-sm-2 control-label">Nom</label>
        
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nom" name="nom" value="${user.nom_utilisateur}" required>
                        </div>
                    </div>       
                    <div class="form-group">
                        <label for="nom" class="col-sm-2 control-label">Role</label>
        
                        <div class="col-sm-10">
                            <select class="form-control" id="role" name="statut">
                                <option value="Eleve">
                                    Eleve
                                </option>
                                <option value="Responsable">
                                    Responsable
                                </option>
                                <option value="Secretaire">
                                    Secretaire
                                </option>
                            </select>
                        </div>
                    </div>                        	
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    <button style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103)" class="btn btn-primary btn-lg" type="submit">Modifier</button>
                </div>
                <!-- /.box-footer -->
            </form>
        </div>
        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>