<%-- 
    Document   : vue
    Created on : 8 avr. 2018, 06:45:24
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
                <div class="row" style="padding-left: 20px;">
                    <a href="Controleur">Accueil</a>&DDotrahd;<a href="Controleur?q=ordinateur">Ordinateur</a>
                </div>
                <div class="row" style="margin-left: 200px">
                    <h4>Tri:</h4>
                    <form class="form-inline" action="Controleur">
                        <select name="cri" id="cri">
                            <option value="az">NOM A-Z</option>
                            <option value="za">NOM Z-A</option>
                            <option value="prixC">Prix croissant</option>
                            <option value="prixD">Prix decroissant</option>
                        </select>
                        <input class="btn btn-default" type="submit" name="tri" value="trier" />
                        <input class="hidden" type="text" name="cat" value="${requestScope.cat}" />
                        <input class="hidden" type="text" name="produit" value="${requestScope.tri}" />
                    </form>
                </div>
                <div class="row" style="padding-top: 20px;">
                    <div class="col-md-4">
                        <div class="jumbotron">
                            <div>
                                <legend>Filtrer Par : <br>
                                    <a class="btn btn-danger btn-block <c:if test="${empty requestScope.tri}">disabled</c:if> " href="Controleur?q=${requestScope.cat}"><span class="glyphicon glyphicon-remove-sign"></span> Effacer tout</a>
                                </legend>
                            </div>
                            <div>
                                <h5>Marque</h5>
                                <c:forEach items="${requestScope.fournisseurs}" var="curseur">
                                    <div>
                                        <a class="btn btn-link" href="Controleur?cri=${curseur.getNom()}&search=${curseur.getNom()}&cat=${requestScope.cat}"> ${curseur.getNom()}</a> <span class="badge">${requestScope.produits.size()}</span>
                                    </div>
                                </c:forEach>
                            </div>
                                <hr>
                            <div>
                                <h5>Memoire</h5>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=4 Go"> 4 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=8 Go"> 8 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=12 Go"> 12 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=16 Go"> 16 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=20 Go"> 20 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=24 Go"> 24 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ram&search=32 Go"> 32 Go</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                            </div>
                                <hr>
                            <div>
                                <h5>Garantie</h5>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=garantie&search=1 an"> 1 an</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=garantie&search=2 ans"> 2 ans</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                            </div>
                                <hr>
                            <div>
                                <h5>Processeur</h5>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Core i7"> Intel Core i7</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Core i5"> Intel Core i5</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Core i3"> Intel Core i3</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=AMD Dual Core"> AMD Dual Core</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Celeron Quad Core"> Intel Celeron Quad Core</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Celeron Dual Core"> Intel Celeron Dual Core</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=processeur&search=Intel Atom Quad Core"> Intel Atom Quad Core</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                            </div>
                                <hr>
                            <div>
                                <h5>Ecran</h5>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ecran&search=12\" Full HD"> 12" Full HD</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=ecran&search=12\" Full HD"> 12" Full HD</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                            </div>
                            <hr>
                            <div>
                                <h5>OS</h5>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=os&search=MacOS"> MacOS</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=os&search=FreeDos"> FreeDos</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                                <div>
                                    <a class="btn btn-link" href="Controleur?cri=os&search=Windows 10"> Windows 10</a> <span class="badge">${requestScope.produits.size()}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <table class="table">
                            <thead>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Prix</th>
                            </thead>
                            <tbody>
                                <c:set var="img" value="images/"></c:set>
                                <%! int i=1;%>
                                <c:forEach items="${requestScope.produits}" var="curseur">
                                    <tr>
                                        <td><a href="Controleur?id=${curseur.getId()}"><img src="${img}${curseur.getImg()}" alt="${img}${curseur.getImg()}" width="200px" height="200px" /></a></td>
                                        <td>
                                            <a href="Controleur?id=${curseur.getId()}"><h4>${curseur.getType()} ${curseur.getModele()}</h4></a>
                                            <p>sdfghjfkmbndfkbndlfsbntrlbndlf</p>
                                        </td>
                                        <td>
                                            <img src="logo/${curseur.getNom()}.jpg" alt="logo/${curseur.getNom()}.jpg" class="img img-thumbnail manufacturer-logo" width="90" height="90"/>
                                            <p><span style="color:#14AA14;">En stock</span></p>
                                            <p><span class="price">${curseur.getPrix()}</span><span class="tax"> TND</span></p></td>
                                    </tr>
                                    <% i++; %>
                                </c:forEach>
                                    <% i =1;%>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </div>

                </div>
            </div>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>