
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-static-top navbar-inverse">
    <div class="container" style="height: 10px">
        <div class="row">
            <div class="navbar-header col-md-4">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Controleur"><img src="logo/logo.png" height="50px"/></a>
            </div><br>
            <form class="col-md-4 navbar-form" method="get" action="Controleur">
                <div class="form-group">
                    <select name="cri" id="cri" class="form-control">
                        <option value="nom">Nom</option>
                        <option value="modele">Modele</option>
                        <option value="type">Type</option>
                        <option value="categorie">Categorie</option>
                    </select>
                    <input type="text" class="form-control" placeholder="Search" name="search">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Controleur?q=connexion"><span class="glyphicon glyphicon-user"></span> ${!empty sessionScope.client ? sessionScope.client.getNom() : "Mon Compte"}</a></li>
                <c:if test="${empty sessionScope.client}">
                <li class="disabled"><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Panier </a></li>
                </c:if>
                <c:if test="${!empty sessionScope.client}">
                    <li><a href="Controleur?q=connexion"><span class="glyphicon glyphicon-shopping-cart"></span> Panier(${empty sessionScope.panier ? 0 : sessionScope.panier.getNbProduit()}) </a></li>
                    <li><a href="Controleur?q=deconnexion" class="btn btn-link">Log out</a></li>
                </c:if>
            </ul>
        </div>

        <div class="row">

            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav" style="margin-left: 100px ">
                    <li class="col-md-3"><a href="Controleur?q=ordinateur">Oridnateur</a></li>
                    <li class="col-md-3"><a href="Controleur?q=telephone">Telephone</a></li>
                    <li class="col-md-3"><a href="Controleur?q=stockage">Stockage</a></li>
                    <li class="col-md-3"><a href="Controleur?q=accessoires">Accessoires</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div><!-- /.container -->
</nav><!-- /.navbar -->