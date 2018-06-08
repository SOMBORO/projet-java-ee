<%-- 
    Document   : profil
    Created on : 13 avr. 2018, 01:11:46
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
        <c:if test="${empty sessionScope.client}">
            <div class="jumbotron">
                <form method="post" action="Controleur" style=" padding: 50px; margin-left: 400px">
                    <div class="form-group">
                        <label for="email">Email: </label>
                        <input type="email" id="email" name="email" value="${requestScope.email}" required style="margin-left: 70px" /><span>${requestScope.login}</span>
                    </div>
                    <div class="form-group">
                        <label for="password">Mot de passe: </label>
                        <input type="password" id="password" name="password" required="true" style="margin-left: 20px" /><span>${requestScope.password}</span>
                    </div>
                    <input type="submit" class="btn btn-primary" name="login" value="Se connecter" />
                </form>
                    <a href="Controleur?q=inscription" class="btn btn-link" style="margin-left: 500px">S'inscrire</a>
                    <a href="Controleur" class="btn btn-link" style="margin-left: 500px">Vers la page d'accueil</a>
            </div>
        </c:if>
        <c:if test="${!empty sessionScope.client}">
            <header>
                <%@include file="header.jsp" %>
            </header>
            <main>
                <div class="container">
                    <div class="row">
                        <c:if test="${empty sessionScope.commandes}">
                            <p>Aucune Commande !!!!</p>
                        </c:if>
                        <c:if test="${!sessionScope.commandes.isEmpty()}">
                        <legend>La liste de vos differentes commandes</legend>
                        <table class="table">
                            <thead>
                            <th>Produit</th>
                            <th>Quantité</th>
                            <th>Prix</th>
                            <th>Date Commande</th>
                            <th>Total</th>
                            </thead>
                            <tbody>
                                <c:set var="img" value="images/"></c:set>

                                <%! int i=1;%>
                                <c:forEach items="${sessionScope.commandes}" var="curseur">
                                            <tr>
                                        <td>
                                            <img src="images/${curseur.getImg()}" width="40px">  ${curseur.getType()} ${curseur.getModele()}
                                        </td>
                                        <td>
                                            ${curseur.getPrix()}
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <% i++; %>
                                </c:forEach>
                                    <% i =1;%>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </c:if>
                    </div>
                    <br>
                    <br>
                    <br>
                    
                    <div class="row">
                        <c:if test="${sessionScope.panier.getNbProduit() != 0}">
                        <legend>La liste des commandes en cours</legend>
                        <table class="table">
                            <thead>
                            <th>Image</th>
                            <th>Produit</th>
                            <th>Quantité</th>
                            <th>Etat</th>
                            <th>Total</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.panier.getAll()}" var="curseur">
                                        <tr>
                                        <td>
                                            <img src="images/${curseur.getImg()}" alt="images/${curseur.getImg()}" width="40px">
                                        </td>
                                        <td>
                                            ${curseur.getModele()}
                                        </td>
                                        <td>
                                            ${sessionScope.panier.getMap().get(curseur)}
                                        </td>
                                        <td>
                                            En cours....
                                        </td>
                                        <td>
                                            ${curseur.getPrix() * sessionScope.panier.getMap().get(curseur)}
                                        </td>
                                        <td>
                                            <a href="Controleur?annuler=${curseur.getId()}" class="btn btn-default">Annuler</a>
                                        </td>
                                        <td>
                                            <a href="Controleur?commander=${curseur.getId()}" class="btn btn-default">Passer Commande</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </c:if>
                    </div>
                </div>
            </main>
            <footer>
                <%@include file="footer.jsp" %>
            </footer>
        </c:if>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
