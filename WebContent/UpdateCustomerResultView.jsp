<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先情報更新結果</title>
</head>
<body>
    <div align="center">
        <h2>得意先情報更新結果</h2>
        <p>${message}</p>
        <table border="1">
            <tr>
                <th>得意先コード</th>
                <td>${customer.customerCode}</td>
            </tr>
            <tr>
                <th>得意先名</th>
                <td>${customer.customerName}</td>
            </tr>
            <tr>
                <th>電話番号</th>
                <td>${customer.customerTelno}</td>
            </tr>
            <tr>
                <th>郵便番号</th>
                <td>${customer.customerPostalcode}</td>
            </tr>
            <tr>
                <th>住所</th>
                <td>${customer.customerAddress}</td>
            </tr>
            <tr>
                <th>割引率</th>
                <td>${customer.discountRate}</td>
            </tr>
            <tr>
                <th>削除フラグ</th>
                <td>${customer.deleteFlag ? '削除' : '有効'}</td>
            </tr>
        </table>
        <br>
        <form action="/SearchItemSample/jsys" method="POST">
            <input type="hidden" name="BUTTON_ID" value="UC999_01">
            <input type="submit" value="メニューに戻る">
        </form>
    </div>
</body>
</html>