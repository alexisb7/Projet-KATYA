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
            <h1>Modification d'une reservation d'equipement</h1>
            <div class="box">
                <!-- form start -->
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/reservation_equipement_update?role=${role}">
                     <div class="box-body">
                        <div class="form-group">
                            <label for="equipement" class="col-sm-2 control-label">Equipement</label>

                            <div class="col-sm-10">
                                <select class="form-control" id="id_equipement" name="id_equipement">
                                    <c:forEach items = "${listEquipement}" var="equip">
										<c:if test="${equip.id_equipement==resa.id_equipement}">
											<option value="${equip.id_equipement}">
                                        		${equip.nom_equipement}
                                        	</option>
										</c:if>
									</c:forEach>
                                </select>
                            </div>
                        </div>
                              
                        <div class="form-group">
                            <label for="id_user" class="col-sm-2 control-label">Utilisateur</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="id_user" name="id_user">
                                    <c:forEach items = "${listUser}" var="user">
										<c:if test="${user.id_utilisateur==resa.id_utilisateur}">
											<option value="${user.id_utilisateur}">
                                        		${user.nom_utilisateur}
                                        	</option>
										</c:if>
									</c:forEach>
                                </select>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="etat" class="col-sm-2 control-label">Etat de validation</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="etat" name="etat">
                                    <c:if test="${resa.etat_validation==1}">
                                        <option value="1">
                                            Valide 
                                        </option>
                                        <option value="0">
                                            Non valide 
                                        </option>
								    </c:if>
                                    <c:if test="${resa.etat_validation==0}">
                                        <option value="0">
                                            Non valide 
                                        </option>
                                        <option value="1">
                                            Valide 
                                        </option>
								    </c:if>   
                                </select>
                            </div>
                        </div> 	
                        <div class="form-group">
                            <label for="date" class="col-sm-2 control-label">Date</label>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" id="date" name="date" value="${resa.date}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="heure_debut" class="col-sm-2 control-label">Heure de debut</label>
                            <div class="col-sm-10">
                                <input type="time" class="form-control" id="heure_debut" name="heure_debut" value="${resa.heure_debut}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="heure_fin" class="col-sm-2 control-label">Heure de fin</label>
                            <div class="col-sm-10">
                                <input type="time" class="form-control" id="heure_fin" name="heure_fin" value="${resa.heure_fin}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="id_user_valid" class="col-sm-2 control-label">Utilisateur pour la validation</label>
            
                            <div class="col-sm-10">
                                <select class="form-control" id="id_user_valid" name="id_user_valid">
                                    <c:forEach items = "${listUser}" var="user">
										<c:if test="${user.id_utilisateur==resa.id_utilisateur_validation}">
											<option value="${user.id_utilisateur}">
                                        		${user.nom_utilisateur}
                                        	</option>
										</c:if>
									</c:forEach>
									<c:forEach items = "${listUser}" var="user">
										<c:if test="${user.id_utilisateur!=resa.id_utilisateur_validation}">
											<option value="${user.id_utilisateur}">
                                        		${user.nom_utilisateur}
                                        	</option>
										</c:if>
									</c:forEach>
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
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script>
    $(function () {
        $('[data-mask]').inputmask()
    });
</script>
</html>