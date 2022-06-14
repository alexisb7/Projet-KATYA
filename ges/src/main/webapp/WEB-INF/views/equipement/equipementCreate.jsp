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

            <h1>Ajout d'un nouvel equipement</h1>

            <div class="backwhite">
                <div class="box">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipementCreate">
                        <div class="box-body">
                                <div class="form-group">
                                    <label for="Nom_equipement" class="col-sm-2 control-label">Nom de l'equipement</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="Nom_equipement" name="Nom_equipement" placeholder="Nom de l'equipement" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="Zone_stockage" class="col-sm-2 control-label">Zone de stockage</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="Zone_stockage" name="Zone_stockage" placeholder="Zone de stockage" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="etat" class="col-sm-2 control-label">Etat de l'equipement</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="etat" name="etat" placeholder="Etat de l'equipement" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="disponibilite_equipement" class="col-sm-2 control-label">Disponibilite de l'equipement</label>

                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" id="disponibilite_equipement" name="disponibilite_equipement" placeholder="Disponibilite de l'equipement" required>
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
                        </div>
                        

                        <div class="box-footer">
                            <button type="submit" class="btn btn-info pull-right">Ajouter le nouvel equipement</button>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/equipement/equipement">Retour a la liste des equipements</a>
                        </div>

                    </form>
                </div>

            </div>
            

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
