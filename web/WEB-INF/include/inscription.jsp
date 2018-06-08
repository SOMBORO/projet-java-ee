<%-- 
    Document   : inscription
    Created on : 10 avr. 2018, 08:40:57
    Author     : SOMBORO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <!--<link href="resources/css/bootstrap.min.css" rel="stylesheet">-->
        <style>
            body, p, legend, label, input {
                font: normal 8pt verdana, helvetica, sans-serif;
            }
            fieldset {
                padding: 10px;
                border: 1px #0568CD solid;
                width: 500px;
                margin-left: 400px;
            }
            legend {
                font-weight: bold;
                color: #0568CD;
            }
            form label {
                float: left;
                width: 200px;
                margin: 3px 0px 0px 0px;
            }
            form input {
                margin: 3px 3px 0px 0px;
                border: 1px #999 solid;
            }
            form input.sansLabel {
                margin-left: 200px;
            }
            form .requis {
                color: #c00;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron">
            <form method="post" action="Controleur">
                <fieldset>
                    <legend>Inscription</legend>
                    <p>Vous pouvez vous inscrire via ce formulaire.</p>

                    <label for="nom">Nom d'utilisateur <span class="requis">*</span></label>
                    <input type="text" id="nom" name="nom" value="${requestScope.formulaire.getClient().getNom()}" size="20"  />
                    <br />

                    <label for="prenom">Prenom</label>
                    <input type="text" id="prenom" name="prenom" value="${requestScope.formulaire.getClient().getPrenom()}" size="20" maxlength="20" />
                    <br />

                    <label for="email">Adresse email <span class="requis">*</span></label>
                    <input type="text" id="email" name="email" value="${requestScope.formulaire.getClient().getEmail()}" size="20" /><span>${requestScope.formulaire.getErreurs().get("email")}</span>
                    <br />

                    <label for="password">Mot de passe <span class="requis">*</span></label>
                    <input type="password" id="password" name="password" value="" size="20" /><span>${requestScope.formulaire.getErreurs().get("password")}</span>
                    <br />

                    <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                    <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" /><span>${requestScope.formulaire.getErreurs().get("confirmation")}</span>
                    <br />

                    <input type="submit" name="logon" value="Inscription" class="sansLabel" />
                    <br />
                </fieldset>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>