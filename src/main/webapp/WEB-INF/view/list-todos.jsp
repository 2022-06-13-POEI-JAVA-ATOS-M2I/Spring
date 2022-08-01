<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div>
    <div>
        <a type="button" href="/add-todo">Add Todo</a>
    </div>
    <br>
    <div>
        <div>
            <h3>List of TODO's</h3>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
                        <th width="40%">Description</th>
                        <th width="40%">Target Date</th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td><fmt:formatDate value="${todo.targetDate}"
                                            pattern="dd/MM/yyyy" /></td>
                            <td><a type="button" class="btn btn-success"
                                   href="/update-todo?id=${todo.id}">Update</a>
                                <a type="button" class="btn btn-warning"
                                   href="/delete-todo?id=${todo.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="common/footer.jsp"%>