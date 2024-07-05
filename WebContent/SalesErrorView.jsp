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
    <h2>販売支援システム</h2><br>
    <h3>エラー</h3><br>
  </div>
		
  <div align="center" style="color: red;">
    <p>
      <c:out value="${requestScope.message}" /><br><br><br>
    </p>
  </div>

  <!-- フォーム -->
  <form action="/SearchItemSample/jsys" method="POST" name="fm">
    <div align="center">
      <input type="button" value="ログイン画面に戻る" onclick="document.fm.BUTTON_ID.value='UC999_02'; document.fm.submit();">
    </div>
  </form>
</body>
</html>
