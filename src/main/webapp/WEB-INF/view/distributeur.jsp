<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Distributeur - Spring MVC</title>
    </head>
    <body>

        <h2>Crédit restant : <c:out value="${credit}" /></h2>

        <table>
            <caption>Liste des produit</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach var="product" items="${stock}">
                <tr>
                    <td><c:out value="${product.getId()}"/></td>
                    <td><c:out value="${product.getName()}"/></td>
                    <td><c:out value="${product.getQuantity()}"/></td>
                    <td><c:out value="${product.getPrice()}"/></td>
                </tr>
            </c:forEach>

        </table>

        <br />

        <form:form method="POST" action="/addBalance" modelAttribute="userForm">
            <fieldset>
                <legend>Ajouter du crédit</legend>
                <p>
                    <form:label path="balance">Montant : </form:label>
                    <form:input path="balance" type="number" />
                    <form:errors path="balance" />
                </p>
                <input type="submit" value="Ajouter" />
            </fieldset>
        </form:form>

        <br />

        <form:form method="POST" action="/buyProduct" modelAttribute="buyForm">
            <fieldset>
                <legend>Acheter un produit</legend>
                <p>
                    <form:label path="id">Numéro de produit : </form:label>
                    <form:input path="id" type="number" />
                    <form:errors path="id" />
                </p>
                <input type="submit" value="Acheter" />
            </fieldset>
        </form:form>

    </body>
</html>
