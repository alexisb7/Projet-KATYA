<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">

            <h1>Salles_update</h1>
            <h2>Salle ${salle.numero}</h2>
            <div class="box">
                <!-- form start -->
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/salle_update">
                     <div class="box-body">
                        <div class="form-group">
                            <label for="etage" class="col-sm-2 control-label">Etage</label>

                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="etage" name="etage" value="${salle.etage}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Capacite</label>

                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="capacite" name="capacite" value="${salle.capacite}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="utilite" class="col-sm-2 control-label">Utilite</label>
            
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="utilite" name="utilite" value="${salle.utilite}">
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
