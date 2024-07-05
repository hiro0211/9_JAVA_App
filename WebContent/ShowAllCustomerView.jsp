<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 見出し -->
	<div align="center">
		<h2>得意先検索</h2>
	</div>
	<!-- フォーム -->
	<form action="/SearchItemSample/jsys" method="POST" name="inform">
		<!-- ボタンID用フィールド -->
		<input type="hidden" name="BUTTON_ID" value="">
		<div align="center">
			<table>
				<tr>
					<td nowrap align="left">
						得意先一覧
					</td>
				</tr>
			</table>
		</div><br>
		<div align="center">
		    <input type="button" value="メニュー画面に戻る" onclick="document.inform.BUTTON_ID.value='UC999_01'; document.inform.submit();">
		</div>
	</form>
</body>
</html>