<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>販売支援システム</title>
</head>

<body>
	<!-- 見出し -->
	<div align="center">
		<h2>得意先検索結果</h2>
	</div>

	<!-- フォーム -->
	<form action="/SearchItemSample/jsys" method="POST">
		<!-- ボタンID用フィールド -->
		<input type="hidden" name="BUTTON_ID" value="UC000_02_01">
		<div align="center">
			<table>
				<tr>
					<td nowrap align="left" width="100">
						得意先コード
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.customerCode}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						得意先名
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.customerName}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						電話番号
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.customerTelno}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						郵便番号
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.customerPostalcode}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						住所
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.customerAddress}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						割引率
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.customer.discountRate}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
											解除フラグ
					</td>
					<td nowrap align="left" width="300">
					<c:out value="${requestScope.customer.deleteFlag}" />
					</td>
				</tr>
			</table>
		</div><br><br>
		<div align="center">
			<input type="submit" value="前画面に戻る">
		</div>
	</form>
</body>
</html>