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
            background-color: rgb(181, 57, 103);
            color: white;
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
        .controltd{
            width: 10%;
        }
        .stylecontrol{
            background-color: transparent;
            border-color: transparent;
            margin-right: -10px
        }
        .but_middle{
            margin: auto;
            width: 7%;
            padding: 10px;
        }
        .titre{
            font-size: 35px;
        }
    </style>
    <body>
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <div class="content-wrapper backwhite">
            <p class="titre">Listes des salles</p>
            <p>Nombre de salles : ${nombre}</p>
            <div class="but_middle">
                <a class="btn btn-primary btn-lg" style="font-size:25px;text-align:center;border-color:rgb(181, 57, 103);background-color:rgb(181, 57, 103);" href="${pageContext.request.contextPath}/salle_create">Ajouter</a> 
            </div>
            <table class="tablemanager">
                <thead>
                    <tr>
                        <th class="disableSort"></th>
                        <th>Numero</th>
                        <th>Etage</th>
                        <th>Capacite</th>
                        <th>Utilite</th>
                        <th>Disponible</th>
                        <th>Date de creation</th>
                        <th class="disableFilterBy">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listeSalle}" var="salle">
                        <tr>
                            <td></td>
                            <td class="prova">${salle.numero}</td>
                            <td class="prova">${salle.etage}</td>
                            <td class="prova">${salle.capacite}</td>
                            <td class="prova">${salle.utilite}</td>
                            <c:if test="${salle.disponibilite_salle==1}">
                                <td class="prova">Oui</td>
                            </c:if>
                            <c:if test="${salle.disponibilite_salle==0}">
                                <td class="prova">Non</td>
                            </c:if>
                            <td class="prova">${salle.date_acquisition_salle}</td>
                            <td class="prova controltd">
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
                </tbody>
            </table>
     
        </div>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>

    <!-- /script table -->
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

    </script
            <!-- /script table fin -->
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</html>
