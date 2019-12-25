<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"
            type="text/javascript"></script>
    <script src="<c:url value="/js/as3.js" />"></script>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    <title>View</title>
</head>
<body>
<c:url value="/viewSet" var="viewSet"/>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">File data to a table</h1>
            <a href="index.html">Home</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9">

            <c:if test="${not empty resultObjectList}">
                <b>Result Set:</b>
                <table>
                    <c:forEach var="entry" items="#{resultObjectList}">
                        <tr>
                            <td><c:out value="${entry}"/></td>
                            <td>
                                <button type="button" onClick="window.location.href='/deleteEntry?entryDelete=${entry}'">&#10008;</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
    <hr>
    <div align="center">
        <br/>
        <button id="save" type="button" class="btn btn-info"> Save</button>
    </div>
</div>
</body>
</html>