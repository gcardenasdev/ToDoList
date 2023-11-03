<%--
  Created by IntelliJ IDEA.
  User: Alari
  Date: 10/27/2023
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="ToDoFiles.ToDoApp" %>
<%@page import="entity.TodolistitemsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="ToDoFiles.ToDoApp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>To Do App</title>
</head>
<body class="">
<div class="container d-flex flex-column align-items-center">
    <section class="main">
        <h1 class="my-5 text-info">Welcome to my To Do App!</h1>

    </section>
    <%  ToDoApp toDoList = new ToDoApp();
        List<TodolistitemsEntity> items = ToDoApp.viewList(); %>
    <section class="list">
        <div class="card border-info-subtle border-4" style="width: 31rem;">
            <div class="card-header bg-info-subtle">
                <form method="post" action="/ToDoFiles.addItemServlet" class="input-group">
                    <label class="form-label" for="toDoItem">Enter To Do Item: </label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="toDoItem" name="toDoItem" required>
                    </div>
                    <button class="btn btn-outline-info" type="submit">Submit</button>
                </form>
            </div>
            <ul class="list-group list-group-flush">
                <form method="post" action="/ToDoFiles.deleteItemServlet" class="">
                    <% for (TodolistitemsEntity item: items) {%>
                   <li class="list-group-item d-flex flex-row justify-content-between">
                       <div class="form-check">
                        <input class="form-check-input" type="radio" name="listItem"  id="listItem" value="<%=item.getListitemId()%>">
                        <label class="form-check-label" for="listItem"><%=item.getListitem()%></label>
                       </div>
                       <div class="">
                            <button class="btn btn-outline-danger btn-sm" type="submit">Delete</button>
                       </div>
                        <%}%>

                   </li>
                </form>
            </ul>
        </div>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
