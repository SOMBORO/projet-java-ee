
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
        <main>
            <div class="container">
            <c:if test="${requestScope.admin}">
                <div class="row" style="margin-top: 50px">
                    <legend>Produit à gerer</legend>
                    <a href="admin?q=ordinateur" class="btn btn-default">Ordinateur</a>
                    <a href="admin?q=telephone" class="btn btn-default">Telephone</a>
                    <a href="admin?q=stockage" class="btn btn-default">Stockage</a>
                    <a href="admin?q=accessoires" class="btn btn-default">Accessoires</a>
                    <a href="admin?q=refresh&produit=${requestScope.type}" class="btn btn-default" style="margin-left: 400px">Refresh</a>
                    <a href="Controleur" class="btn btn-link" style="margin-left: 1000px;">Retour vers la page d'accueil</a>
                </div>
                <c:if test="${!empty requestScope.type}">
                    <div class="row" style="margin-top: 50px">
                        <a href="admin?q=ajout&cat=${requestScope.type}" class="btn btn-default">Ajouter un nouveau produit</a>
                    </div>
                    <hr>
                    <div class="row">
                        <legend style="text-align: center">Liste des produits</legend><br>
                        <table class="table">
                            <thead>
                                <th>ID</th>
                                <th>Marque</th>
                                <th>Nom</th>
                                <th>Modele</th>
                                <th>Type</th>
                                <th>Prix</th>
                                <th>Quantite</th>
                                <th>Image</th>
                                <th>Couleur</th>
                            </thead>
                            <tbody>
                            <c:set var="img" value="images/"></c:set>
                            <%! int i=1;%>
                            <c:forEach items="${requestScope.produits}" var="curseur">
                                <tr>
                                    <td>${curseur.getId()}</td>
                                    <td>
                                        <img src="logo/${curseur.getNom()}.jpg" alt="logo/${curseur.getNom()}.jpg" width="40px" />
                                    </td>
                                    <td>${curseur.getNom()}</td>
                                    <td>${curseur.getModele()}</td>
                                    <td>${curseur.getType()}</td>
                                    <td>${curseur.getPrix()}</td>
                                    <td>${curseur.getQuantite()}</td>
                                    <td>
                                        <img src="images/${curseur.getImg()}" width="40px" />
                                    </td>
                                    <td>${curseur.getCouleur()}</td>
                                    <td>
                                        <a href="admin?id=${curseur.getId()}&value=editer" class="btn btn-default">Editer</a>
                                    </td>
                                    <td>
                                        <a href="admin?id=${curseur.getId()}&value=delete" class="btn btn-default">Supprimer</a>
                                    </td>
                                </tr>
                            <% i++; %>
                            </c:forEach>
                            <% i =1;%>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </div>
                </c:if>
            </c:if>
            </div>
        </main>
        <c:if test="${!requestScope.admin}">
        <div class="jumbotron">
            <form method="post" action="admin" style=" padding: 50px; margin-left: 400px">
                <div class="form-group">
                    <label for="email">Email: </label>
                    <input type="email" id="email" name="email" required style="margin-left: 70px" /><span>${requestScope.email}</span>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe: </label>
                    <input type="password" id="password" name="password" required="true" style="margin-left: 20px" /><span>${requestScope.password}</span>
                </div>
                <input type="submit" class="btn btn-primary" name="login" value="Se connecter" />
            </form>
        </div>
        </c:if>
    </body>
</html>