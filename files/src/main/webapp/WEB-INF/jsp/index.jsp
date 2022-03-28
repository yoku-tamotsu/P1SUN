<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>ExamEntities</title>
        <link rel="stylesheet/less" type="text/css" href="<c:url value="/css/style.less"/>" />
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/less@4" ></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/script.js"/>"></script>
        <script type="text/x-template" id="datatable">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Kolumna 1</th>
                        <th>Kolumna 2</th>
                        <th>Kolumna 3</th>
                        <th>Kolumna 4</th>
                    </tr>
                </thead>
                <tr v-for="entity in entities">
                    <td>{{entity.id}}</td>
                    <td>{{entity.col_1}}</td>
                    <td>{{entity.col_2}}</td>
                    <td>{{entity.col_3}}</td>
                    <td>{{entity.col_4}}</td>
                </tr>
            </table>
        </script>
    </head>
    <body>
        <select id="columns-combobox">
            <c:forEach items="${columnsNames}" var="columnName">
                <option>${columnName}</option>
            </c:forEach>
        </select>
        <button mode="duplicates">Find duplicates</button>
        <button mode="singels">Find singels</button>
        <div id="result-container"></div>
    </body>
</html>