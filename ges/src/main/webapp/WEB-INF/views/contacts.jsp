<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

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



                    <section class="sec">


                        <div class="section-header">
                            <div class="container">
                                <h2>Contact Us</h2>
                                <p>
                                    EPF has found a new home at the Alembert building, which until 2020 housed the ENS
                                    Paris-Saclay.<br>
                                    This new site is located one RER station away from the old Sceaux campus.This change
                                    is part of <br>
                                    the school development strategy, which aims to improve study conditions for
                                    engineering students <br>
                                    and offer them new opportunities in regard to technology and student life.<br>
                                </p>
                            </div>
                        </div>

                        <div class="container">
                            <div class="row">

                                <div class="contact-info">
                                    <div class="contact-info-item">
                                        <div class="contact-info-icon">
                                            <i class="fas fa-home"></i>
                                        </div>




                                        <div class="contact-info-content">
                                            <h4>Address</h4>
                                            <span><img style="height:30px;"
                                                    src="resources/stockage/location.png"></span>
                                            <p>55 avenue du Président Wilson
                                                <br /> 94230 Cachan
                                            </p>
                                        </div>
                                    </div>

                                    <div class="contact-info-item">
                                        <div class="contact-info-icon">
                                            <i class="fas fa-phone"></i>
                                        </div>

                                        <div class="contact-info-content">
                                            <h4>Phone</h4>
                                            <span><img style="height:30px;" src="resources/stockage/call.png"> 01 41 13
                                                01 51</span>

                                        </div>
                                    </div>

                                    <div class="contact-info-item">
                                        <div class="contact-info-icon">
                                            <i class="fas fa-envelope"></i>
                                        </div>

                                        <div class="contact-info-content">
                                            <h4>Email</h4>
                                            <span><img style="height:30px;" src="resources/stockage/mail.png"></span>

                                            <a href="mailto:communication@epfedu.fr">communication@epfedu.fr</a>

                                        </div>

                                    </div>
                                </div>


                                <div class="contact-form">
                                    <form action="" id="contact-form">
                                        <h2>Send Message</h2>
                                        <div class="input-box">
                                            <input type="text" required="true" name="">
                                            <span>Full Name</span>
                                        </div>

                                        <div class="input-box">
                                            <input type="email" required="true" name="">
                                            <span>Email</span>
                                        </div>

                                        <div class="input-box">
                                            <textarea required="true" name=""></textarea>
                                            <span>Type your Message...</span>
                                        </div>

                                        <div class="input-box">
                                            <input type="submit" value="Send" name="">
                                        </div>
                                    </form>
                                </div>

                                <div class="reseaux">

                                    <ul class="res1">
                                        <li><a href="https://www.facebook.com/EPF.ingenieurs/"><img
                                                    src="resources/stockage/1.png"></a></li>
                                        <li><a href="https://www.instagram.com/epfingenieurs/"><img
                                                    src="resources/stockage/3.png"></a></li>
                                        <li><a href="https://www.linkedin.com/in/jnicolle/?originalSubdomain=fr/"><img
                                                    src="resources/stockage/5.png"></a></li>

                                        <li><a href=" https://twitter.com/epf_ingenieurs"><img
                                                    src="resources/stockage/2.png"></a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>

                    </section>

                </div>

                <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>
    <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>