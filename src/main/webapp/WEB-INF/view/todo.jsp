<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div>
    <div>
        <div>
            <div>
                <div>Add TODO</div>
                <div>
                    <form:form method="post" modelAttribute="todo">
                        <form:hidden path="id" />
                        <fieldset>
                            <form:label path="description">Description</form:label>
                            <form:input path="description" type="text" class="form-control"
                                        required="required" />
                            <form:errors path="description" cssClass="text-warning" />
                        </fieldset>

                        <fieldset>
                            <form:label path="targetDate">Target Date</form:label>
                            <form:input path="targetDate" type="date" class="form-control"
                                        required="required" />
                            <form:errors path="targetDate" cssClass="text-warning" />
                        </fieldset>

                        <button type="submit">Save</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>