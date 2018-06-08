<%-- 
    Document   : accueil
    Created on : 8 avr. 2018, 03:41:48
    Author     : SOMBORO

<span style="color:rgba(0, 0, 0, 0.5);">Rupture</span>

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        
        <title>Java EE Project</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <main>
            <div class="container-fluid" style="">
                <div class="row">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 400px">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol> <!--padding-top: 70px;-->
                         <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img class="first-slide" src="images/pc-portable-asus-x550vx-i5-6e-gen-8-go.jpg" alt="First slide" style="height: 400px">
                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>Example headline.</h1>
                                        <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <img class="second-slide" src="images/pc-portable-dell-inspiron-7577-i7-7e-gen-16-go-rouge.jpg" alt="Second slide" style="height: 400px">
                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>Another example headline.</h1>
                                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <img class="third-slide" src="images/pc-portable-acer-nitro-5-i5-7e-gen-8-go.jpg" alt="Third slide" style="height: 400px">
                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>One more for good measure.</h1>
                                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <br/>
                <br/>
                <div class="row">
                    <div class="col-xs-6 col-md-3">
                        <a href="Controleur?q=ordinateur" class="thumbnail">
                            <img src="images/pc-portable-asus-strix-g502vm-i7-7e-gen-24-go.jpg" alt="essai" width="300px;" height="300px">
                            <hr>
                            <p>Ordinateurs</p>
                        </a>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <a href="Controleur?q=telephone" class="thumbnail">
                            <img src="images/telephone-portable-apple-iphone-8-64-go-gold.jpg" alt="image iphone 8" width="300px;" height="300px">
                            <hr>
                            <p>Telephone</p>
                        </a>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <a href="Controleur?q=stockage" class="thumbnail">
                            <img src="images/disque-dur-externe-adata-hd710-1-to-usb-30-antichoc-bleu.jpg" alt="essai" width="300px;" height="300px">
                            <hr>
                            <p>Stockage</p>
                        </a>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <a href="Controleur?q=accessoires" class="thumbnail">
                            <img src="images/ensemble-clavier-souris-sans-fil-avec-otg-ngs-epsilon-kit.jpg" alt="essai" width="300px" height="300px">
                            <hr>
                            <p>Accessoires</p>
                        </a>
                    </div>
                </div>
                <hr>
            </div>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>