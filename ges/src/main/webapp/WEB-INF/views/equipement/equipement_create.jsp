<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- Added /jsp before jstl -->

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

            <h1>Ajout d'un nouvel equipement</h1>

            <div class="backwhite">
                <div class="box">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipement_create?role=${role}">
                        <div class="box-body">
                                <div class="form-group">
                                    <label for="nom_equipement" class="col-sm-2 control-label">Nom de l'equipement</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nom_equipement" name="nom_equipement" placeholder="Nom de l'equipement" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="zone_stockage" class="col-sm-2 control-label">Zone de stockage</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="zone_stockage" name="zone_stockage" placeholder="Zone de stockage" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="etat" class="col-sm-2 control-label">Etat de l'equipement</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="etat" name="etat" placeholder="Etat de l'equipement" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="date_acquisition" class="col-sm-2 control-label">Date d'acquisition</label>

                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="date_acquisition" name="date_acquisition" placeholder="Date d'acquisition" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="description" class="col-sm-2 control-label">Description</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="description" name="description" placeholder="Description" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lien_documentation" class="col-sm-2 control-label">Lien documentation</label>

                                    <div class="col-sm-10">
                                        <input type="url" value="https://www.epf.fr/" class="form-control" id="lien_documentation" name="lien_documentation" pattern="https://.*" placeholder="http://example.com" required>
                                    </div>
                                </div>
                        </div>
                        

                        <div class="box-footer">
                            <button style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103)" class="btn btn-primary btn-lg" type="submit">Ajouter</button>
                        </div>

                    </form>
                </div>

            </div>
            

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
