<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

    <head>
        <title>Home Page</title>
    </head>

    <body>
        <h2>Home Page</h2>
        <hr>

        <p>
            Welcome to the home page!
        </p>

        <hr>

        <security:authorize access="isAuthenticated()">
            <p>
                User: <security:authentication property="principal.username" />
                <br><br>
                Role(s): <security:authentication property="principal.authorities" />
            </p>
        </security:authorize>

            
            
            
            
            
        <security:authorize access="hasRole('MANAGER')">

            <p>
                <a href="/teams">Teams Management</a>
            </p>

        </security:authorize>	


        <security:authorize access="hasRole('ADMIN')">  

            <p>
                <a href="/systems">IT Systems</a>
            </p>

        </security:authorize>

        <hr>

        <security:authorize access="isAuthenticated()">

            <form:form action="/logout" method="POST">

                <input type="submit" value="Logout" />

            </form:form>
        </security:authorize>

    </body>

</html>