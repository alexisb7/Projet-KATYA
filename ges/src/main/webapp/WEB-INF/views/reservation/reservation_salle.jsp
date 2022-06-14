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

    <style type="text/css">
        body {
            font-family: "Roboto Condensed", Helvetica, sans-serif;
            background-color: #f7f7f7;
        }
        .container { margin: 150px auto; max-width: 960px; }
        a {

            text-decoration: none;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #bbb;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        th {
            background-color: #ddd;
        }
        th,td {
            padding: 5px;
        }
        button {
            cursor: pointer;
        }
        /*Initial style sort*/
        .tablemanager th.sorterHeader {
            cursor: pointer;
        }
        .tablemanager th.sorterHeader:after {
            content: " \f0dc";
            font-family: "FontAwesome";
        }
        /*Style sort desc*/
        .tablemanager th.sortingDesc:after {
            content: " \f0dd";
            font-family: "FontAwesome";
        }
        /*Style sort asc*/
        .tablemanager th.sortingAsc:after {
            content: " \f0de";
            font-family: "FontAwesome";
        }
        /*Style disabled*/
        .tablemanager th.disableSort {

        } 
        #for_numrows {
            padding: 10px;
            float: left;
        }
        #for_filter_by {
            padding: 10px;
            float: right;
        }
        #pagesControllers {
            display: block;
            text-align: center;
        }
    </style>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/reservation">
                <div style="display:inline-block;margin-bottom:50px;">
                    <button name="bouton_salle" value="salle" type="submit" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top: 30px;margin-left: 160px;" class="btn btn-primary btn-lg">Reservations de salles</button>
                    <a class="btn btn-primary btn-lg" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top: 30px;" href="${pageContext.request.contextPath}/reservation/create_salle">+</a> 
                    <button name="bouton_equip" value="equipement" type="submit" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top: 30px;margin-left: 160px;" class="btn btn-primary btn-lg">Reservations d'equipements</button>
                    <a class="btn btn-primary btn-lg" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);margin-top: 30px;" href="${pageContext.request.contextPath}/reservation/create_equipement">+</a> 
                </div>
            </form>
            <table class="tablemanager">
                <thead>
                <tr>
                    <th class="disableSort">Id</th>
                    <th>Numero</th>
                    <th>Utilisateur</th>
                    <th>Etat</th>
                    <th>Debut</th>
                    <th>Fin</th>
                    <th>Validation</th>
                    <th class="disableFilterBy">Action</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listResaSalle}" var="resa">
                        <tr>
                            <td class="prova">${resa.id_reservation_salle}</td>
                            <td class="prova">${resa.numero_salle}</td>
                            <td class="prova">${resa.id_utilisateur}</td>
                            <td class="prova">${resa.etat_validation}</td>
                            <td class="prova">${resa.date_debut}</td>
                            <td class="prova">${resa.date_fin}</td>
                            <td class="prova">${resa.id_utilisateur_validation}</td>
                            <td class="prova">
                                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/reservation?id_salle=${resa.id_reservation_salle}">
                                    <a class="btn btn-primary" title="Modifier" href="${pageContext.request.contextPath}/reservation/update_salle?id=${resa.id_reservation_salle}"
                                                style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                                    <i  style="color: orange" class="fa fa-edit"></i>
                                                </a>
                                    <button type="submit" class="btn btn-primary" title="Supprimer"
                                        style="background-color: transparent;border-color: transparent;margin-right: -10px">
                                        <i  style="color: red" class="fa fa-trash"></i>
                                        </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
    <!-- External jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="./js/jquery-1.12.3.min.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tableManager.js"></script>
    <script type="text/javascript">
        // basic usage
        $('.tablemanager').tablemanager({
            firstSort: [[3,0],[2,0],[1,'asc']],
            disable: ["last"],
            appendFilterby: true,
            dateFormat: [[4,"mm-dd-yyyy"]],
            debug: true,
            vocabulary: {
                voc_filter_by: 'Filter By',
                voc_type_here_filter: 'Filter...',
                voc_show_rows: 'Rows Per Page'
            },
            pagination: true,
            showrows: [5,10,20,50,100],
            disableFilterBy: [1]
        });
        // $('.tablemanager').tablemanager();
    </script>
    <script>
        try {
            fetch(new Request("https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js", { method: 'HEAD', mode: 'no-cors' })).then(function(response) {
                return true;
            }).catch(function(e) {
                var carbonScript = document.createElement("script");
                carbonScript.src = "//cdn.carbonads.com/carbon.js?serve=CK7DKKQU&placement=wwwjqueryscriptnet";
                carbonScript.id = "_carbonads_js";
                document.getElementById("carbon-block").appendChild(carbonScript);
            });
        } catch (error) {
            console.log(error);
        }
    </script>
    <script type="text/javascript">

        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-36251023-1']);
        _gaq.push(['_setDomainName', 'jqueryscript.net']);
        _gaq.push(['_trackPageview']);

        (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();

    </script>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
