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
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">

            <h1>Salles</h1>

            <form class="form-horizontal" method="post"
				action="${pageContext.request.contextPath}/salle?id=${user.id}">
				<a class="btn btn-info" href="${pageContext.request.contextPath}/salle_create">
					<i class="fa fa-play"></i>
                    Ajouter
				</a> 
			</form>

            <div class="form-group">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/salle?numero=0">
                   <label for="first_name" >Rechercher par Numero</label>
                   <input type="text" id="research" name="research" placeholder="Numero de salle">
                   <button type="submit" href="#" class="btn btn-info">Rechercher</button>
               </form>
            </div>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box">
                            <div class="box-body no-padding">
                                <table class="table table-striped table-hover" id="dataTable">
                                    <tr class="backwhite backgrey" style="color: white">
                                        <th>Numero</th>
                                        <th>Etage</th>
                                        <th>Capacite</th>
                                        <th>Utilite</th>
                                        <th>Disponible</th>
                                        <th>Date de creation</th>
                                        <th>Action</th>
                                    </tr>
                                    <c:forEach items="${listeSalle}" var="salle">
                                        <tr>
                                            <td>${salle.numero}</td>
                                            <td>${salle.etage}</td>
                                            <td>${salle.capacite}</td>
                                            <td>${salle.utilite}</td>
                                            <c:if test="${salle.disponibilite_salle==1}">
                                                <td>Oui</td>
                                            </c:if>
                                            <c:if test="${salle.disponibilite_salle==0}">
                                                <td>Non</td>
                                            </c:if>
                                            <td>${salle.date_acquisition_salle}</td>
                                            <td>
                                                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/salle?numero=${salle.numero}">
                                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/salle_update?numero=${salle.numero}"  title="editer"
                                                    style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                                        <i  style="color: orange" class="fa fa-edit"></i>
                                                    </a>
                                                    <button type="submit" class="btn btn-danger" href="#"title="supprimer"
                                                        style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                                        <i  style="color: red" class="fa fa-trash"></i>
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                    <!-- /.col -->
                </div>
            </section>
     
            

        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
