<%-- 
    Document   : editer
    Created on : 12 avr. 2018, 04:06:20
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
        <title>Gestion des Produits</title>
    </head>
    <body><br>
        <header>
            <%--<%@include file="header.jsp" %>--%>
        </header>
        
        <main>
            <div class="jumbotron container">
                <form action="admin" method="post" enctype="multipart/form-data" style=" margin-left: 100px">
                    <fieldset>
                        <legend>Produit</legend>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="nom">Nom :</label>
                                    <input type="text" name="nom" value="${requestScope.produit.getNom()}" class="form-control" <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                                <div class="form-group">
                                    <label for="modele">Modele :</label>
                                    <input type="text" name="modele" value="${requestScope.produit.getModele()}" class="form-control" <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                                <div class="form-group">
                                    <label for="type">Type :</label>
                                    <input type="text" name="type" value="${requestScope.produit.getType()}" class="form-control" <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                                <div class="form-group">
                                    <label for="prix">Prix :</label>
                                    <input type="text" name="prix" value="${requestScope.produit.getPrix()}" class="form-control" <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="qte">Quantite :</label>
                                    <input type="number" name="qte" value="${requestScope.produit.getQuantite()}" class="form-control" <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                                <div class="form-group">
                                    <label for="img">Image :</label>
                                    <input type="file" name="img" class="form-control"  <c:if test="${empty requestScope.produit}">required</c:if> />
                                </div>
                                <div class="form-group">
                                    <label for="couleur">Couleur :</label>
                                    <input type="text" name="couleur" value="${requestScope.produit.getCouleur()}" class="form-control" />
                                </div>
                                <c:if test="${empty requestScope.produit}">
                                    <div class="form-group">
                                        <label for="fournisseur">Fournisseur :</label>
                                        <select name="fournisseur" id="fournisseur" class="form-control">
                                            <c:forEach items="${requestScope.fournisseurs}" var="curseur">
                                                <option value="${curseur.getId()}">${curseur.getNom()}</option>
                                            </c:forEach>
                                        </select>
                                        <a class="btn btn-link" href="#fo" data-toggle="modal" data-target="#fo" style="margin-left: 300px"> Ajouter un fournisseur?</a>
                                        <div class="modal fade" id="fo">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button class="close" type="button" data-dismiss="modal" aria-hidden="true">x</button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <fieldset>
                                                            <legend>Fournisseur</legend>
                                                            <div class="form-group">
                                                                <label for="nomF">NOM Fournisseur:</label>
                                                                <input type="text" class="form-control" id="nomF" name="nomF" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="catF">Categorie:</label>
                                                                <select name="catF" id="catF" class="form-control">
                                                                    <option value="Ordinateur">Ordinateur</option>
                                                                    <option value="Telephone">Telephone</option>
                                                                    <option value="Stockage">Stockage</option>
                                                                    <option value="Accessoires">Accessoires</option>
                                                                </select>
                                                            </div>
                                                        </fieldset>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button class="btn btn-block btn-primary" type="button" data-dismiss="modal">Enregister</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div class="row">
                            <input type="submit" class="btn btn-block btn-primary" name="editer" value="${!empty requestScope.produit ? "editer" : "ajouter"}" />
                            <input type="hidden" class="form-control" name="id" value="${requestScope.produit.getId()}" />
                            <input type="hidden" class="form-control" name="cat" value="${empty requestScope.produit ? requestScope.type : requestScope.produit.getCategorie()}" />
                        </div>
                    </fieldset>
                </form>
            </div>
        </main>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
