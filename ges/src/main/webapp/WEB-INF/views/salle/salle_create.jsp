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

            <h1>Ajout d'une nouvelle salle</h1>
            <div class="box">
                <!-- form start -->
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/salle_create?role=${role}">
                     <div class="box-body">
                        <div class="form-group">
                            <label for="numero" class="col-sm-2 control-label">Numero de salle</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="numero" name="numero"  placeholder="Numero" pattern=".{3,}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="etage" class="col-sm-2 control-label">Etage</label>

                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="etage" name="etage" placeholder="0" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Capacite</label>

                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="capacite" name="capacite" placeholder="0">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="utilite" class="col-sm-2 control-label">Utilite</label>
            
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="utilite" name="utilite" placeholder="0">
                            </div>
                        </div>                             	
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103)" class="btn btn-primary btn-lg" type="submit">Ajouter</button>
                    </div>
                    <!-- /.box-footer -->
                </form>
            </div>	

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
