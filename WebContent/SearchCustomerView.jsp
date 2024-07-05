<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>得意先管理システム</title>
		<script type="text/javascript">
			// 検索ボタンが押された場合、未入力チェックを行う。
			function PushSearchButton() {
				var customerCode = document.inform.CUSTOMER_CODE.value;
				if (customerCode == "") {
					alert("得意先コードが未入力です。");
					return false;
				}

				document.inform.BUTTON_ID.value='UC000_02_02';
				document.inform.submit();
			}
		</script>
</head>

<body>
	<!-- 見出し -->
	<div align="center">
		<h2>得意先検索</h2>
	</div>
	<div align="center" style="color: red;">
		<c:out value="${requestScope.message}" />
	</div>
	<!-- フォーム -->
	<form action="/SearchItemSample/jsys" method="POST" name="inform">
		<!-- ボタンID用フィールド -->
		<input type="hidden" name="BUTTON_ID" value="">
		<div align="center">
			<table>
				<tr>
					<td nowrap align="left">
						得意先コード
					</td>
					<td nowrap align="left">
						<input type="text" name="CUSTOMER_CODE" value="${param.CUSTOMER_CODE}" maxLength="6" size="10">
					</td>
				</tr>
			</table>
		</div><br>
		<div align="center">
			<input type="button" value="検索" onclick="return PushSearchButton()" >
		</div><br>
		<div align="center">
		    <input type="button" value="メニュー画面に戻る" onclick="document.inform.BUTTON_ID.value='UC999_01'; document.inform.submit();">
		</div>
	</form>
</body>
</html>
