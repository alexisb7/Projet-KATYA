<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <!-- Include Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Style -->
        <div class="content-wrapper backwhite">

            <h1>Modifier l'equipement</h1>
            <h2>Equipement ${equipement.nom_equipement}</h2>
            <div class="box">
                <!-- form start -->
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipement_update">
                     <div class="box-body">
                        <div class="form-group">
                            <label for="nom_equipement_up" class="col-sm-2 control-label">Nom</label>
                            
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nom_equipement_up" name="nom_equipement_up" value="${equipement.nom_equipement}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zone_stockage_up" class="col-sm-2 control-label">Zone de stockage</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="zone_stockage_up" name="zone_stockage_up" value="${equipement.zone_stockage}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="etat_up" class="col-sm-2 control-label">Etat de l'equipement</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="etat_up" name="etat_up" value="${equipement.etat}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="disponibilite_equipement_up" class="col-sm-2 control-label">Disponibilite de l'equipement</label>
            
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="disponibilite_equipement_up" name="disponibilite_equipement_up" value="${equipement.disponibilite_equipement}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date_acquisition_up" class="col-sm-2 control-label">Date d'acquisition</label>

                            <div class="col-sm-10">
                                <input type="date" class="form-control" id="date_acquisition_up" name="date_acquisition_up" value="${equipement.date_acquisition}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description_up" class="col-sm-2 control-label">Description de l'equipement</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="description_up" name="description_up" value="${equipement.description}">
                            </div>
                        </div>                             	
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button type="submit" class="btn btn-info pull-right">Modifier</button>
                    </div>
                    <!-- /.box-footer -->
                </form>
            </div>	

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
