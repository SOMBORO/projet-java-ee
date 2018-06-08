<%-- 
    Document   : decri
    Created on : 9 avr. 2018, 00:41:12
    Author     : SOMBORO
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
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img src="images/${requestScope.produit.getImg()}" width="200px" style="margin-left: 300px"/>
                    </div>
                    <div class="col-md-6"><br><br><br>
                        <p>Prix: ${requestScope.produit.getPrix()} TND TTC</p>
                        <c:if test="${!empty sessionScope.client}">
                            <button type="button" data-toggle="modal" data-target="#pa" class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart"></span>Ajouter Au Panier</button>
                            <div class="modal fade" id="pa">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">x</button>
                                        </div>
                                        <div class="modal-body">
                                            <legend>Votre panier</legend>
                                            <ul>
                                                <li>sdfg</li>
                                                <li>sdfgh</li>
                                                <li>zerty</li>
                                            </ul>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="Controleur?panier=${requestScope.produit.getId()}&cat=${requestScope.produit.getCategorie()}" type="button" class="btn btn-block btn-primary">Ajouter dans le panier</a>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="row">

                    <h4 style="text-align: center">Fiche Technique</h4>
                    <table class="table">
                <tr>
                    <td>Ecran</td><td>${requestScope.fiche.getEcran()}</td>
                </tr>
                <tr>
                    <td>Processeur</td><td>${requestScope.fiche.getProcesseur()}</td>
                </tr><tr>
                    <td>Reference Processeur</td><td>${requestScope.fiche.getRefProcesseur()}</td>
                </tr>
                <tr>
                    <td>Memoire</td><td>${requestScope.fiche.getMemoire()}</td>
                </tr>
                <tr>
                    <td>Stockage</td><td>${requestScope.fiche.getStockage()}</td>
                </tr>
                <tr>
                    <td>Specificites</td><td>${requestScope.fiche.getSpecificites()}</td>
                </tr>
                <tr>
                    <td>camera</td><td>${requestScope.fiche.getCamera()}</td>
                </tr>
                <tr>
                    <td>Systeme d'exploitation</td><td>${requestScope.fiche.getOs()}</td>
                </tr>
                <tr>
                    <td>Carte Graphique</td><td>${requestScope.fiche.getCarteGraphique()}</td>
                </tr>
                <tr>
                    <td>Ref Graphique</td><td>${requestScope.fiche.getRefCarteGraphique()}</td>
                </tr>
                <tr>
                    <td>Garantie</td><td>${requestScope.fiche.getGarantie()}</td>
                </tr>
            </table>
                </div>
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