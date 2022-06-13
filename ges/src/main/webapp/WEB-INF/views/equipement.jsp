<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/common/head.jsp" %>

        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>


    </head>

    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">

            <h1>Equipements</h1>
            <form style="float:right" class="form-horizontal" method="post" action="/rentmanager/vehicles/search">
                <input   type="text"  id="search" name="search" placeholder=" Rechercher un vehicule" >
                <button type="submit" class="btn btn-primary">Chercher</button>
            </form>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box">
                            <div class="box-body no-padding">
                                <table class="table table-striped table-hover" id="dataTable">
                                    <tr class="backwhite backgrey" style="color: white" >
                                        <th style="width: 10px">#</th>
                                        <th style="width :15%">Nom</th>
                                        <th style="width :15%">Zone</th>
                                        <th style="width :15%">Etat</th>
                                        <th style="width :15%">Disponibilite</th>
                                        <th style="width :15%">Date</th>
                                        <th style="text-align: center">Action</th>
                                    </tr>


                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td style="width :10%;">

                                            <a class="btn btn-primary"  href="details_materiel.php?id=" title="view"
                                               style="background-color: transparent; border-color: transparent; margin-right: -10px">
                                                <i  style="color: green;" class="fa fa-eye"></i>
                                            </a>
                                            <a class="btn btn-primary"  href="details_materiel.php?id=" title="view"
                                               style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                                <i  style="color: orange" class="fa fa-edit"></i>
                                            </a>
                                            <a class="btn btn-primary"  href="details_materiel.php?id=" title="view"
                                               style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                                <i  style="color: red" class="fa fa-trash"></i>
                                            </a>


                                        </td>


                                    </tr>
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
