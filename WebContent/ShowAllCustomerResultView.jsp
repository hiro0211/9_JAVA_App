<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>得意先一覧</title>

</head>
<body>
	<form action="/SearchItemSample/jsys" method="POST">
	<!-- ボタンID用フィールド -->
	<input type="hidden" name="BUTTON_ID" value="UC000_03_01">
	<div align="center">
		<h2>得意先一覧</h2>
	</div>
    <div align="center">
        <table border="1">
    <tr>
        <th>顧客コード</th>
        <th>顧客名</th>
        <th>電話番号</th>
        <th>郵便番号</th>
        <th>住所</th>
        <th>割引率</th>
        <th>フラグ</th>
    </tr>
    <c:forEach var="cust" items="${customer}">
        <tr>
            <td><c:out value="${cust.customerCode}" /></td>
            <td><c:out value="${cust.customerName}" /></td>
            <td><c:out value="${cust.customerTelno}" /></td>
            <td><c:out value="${cust.customerPostalcode}" /></td>
            <td><c:out value="${cust.customerAddress}" /></td>
            <td><c:out value="${cust.discountRate}" /></td>
            <td><c:out value="${cust.deleteFlag}" /></td>
        </tr>
    </c:forEach>
        </table>
    </div>
		<br><br>
		<div align="center">
			<input type="submit" value="前画面に戻る">
		</div>
	</form>
</body>
</html>