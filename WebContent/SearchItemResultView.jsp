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
		<h2>商品検索結果画面</h2>
	</div>

	<!-- フォーム -->
	<form action="/SearchItemSample/jsys" method="POST">
		<!-- ボタンID用フィールド -->
		<input type="hidden" name="BUTTON_ID" value="UC000_01_01">
		<div align="center">
			<table>
				<tr>
					<td nowrap align="left" width="100">
						商品コード
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.item.itemCode}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						商品名
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.item.itemName}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						単価（円）
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.item.price}" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" width="100">
						在庫数（個）
					</td>
					<td nowrap align="left" width="300">
						<c:out value="${requestScope.item.stock}" />
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