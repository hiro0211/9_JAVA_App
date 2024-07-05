<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先情報削除結果</title>
</head>
<body>
    <div align="center">
        <h2>得意先情報更新結果</h2>
        <p>${message}</p>

              <p>得意先コード ${customer.customerCode}を削除しました。</p>
        <br>
        <form action="/SearchItemSample/jsys" method="POST">
            <input type="hidden" name="BUTTON_ID" value="UC999_01">
            <input type="submit" value="メニューに戻る">
        </form>
    </div>
</body>
</html>