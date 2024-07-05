<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先情報を変更</title>
<script>
function PushSearchButton() {
    var customerCode = document.inform.CUSTOMER_CODE.value;
    if (customerCode == "") {
        alert("得意先コードが未入力です。");
        return false;
    }
    document.inform.BUTTON_ID.value='UC000_04_01';
    document.inform.submit();
    return true;
}
function PushUpdateButton() {
    var customerCode = document.inform.CUSTOMER_CODE.value;
    if (customerCode == "") {
        alert("得意先コードが未入力です。");
        return false;
    }
    if (confirm('得意先情報を更新します。よろしいですか？')){
        document.inform.BUTTON_ID.value='UC000_04_02';
        document.inform.submit();
        return true;
    } else {
        alert("更新をキャンセルしました。");
        return false;
    }
}
</script>
</head>
<body>
    <form action="/SearchItemSample/jsys" method="POST" name="inform">
        <input type="hidden" name="BUTTON_ID" value="">
        <div align="center">
            <h2>得意先情報変更</h2>
            <table>
                <tr>
                    <td>得意先コード：</td>
                    <td><input type="text" name="CUSTOMER_CODE" value="${customer.customerCode}" maxLength="6" size="10"></td>
                </tr>
                <tr>
                    <td>得意先名：</td>
                    <td><input type="text" name="CUSTOMER_NAME" value="${customer.customerName}"></td>
                </tr>
                <tr>
                    <td>電話番号：</td>
                    <td><input type="text" name="CUSTOMER_TELNO" value="${customer.customerTelno}"></td>
                </tr>
                <tr>
                    <td>郵便番号：</td>
                    <td><input type="text" name="CUSTOMER_POSTALCODE" value="${customer.customerPostalcode}"></td>
                </tr>
                <tr>
                    <td>住所：</td>
                    <td><input type="text" name="CUSTOMER_ADDRESS" value="${customer.customerAddress}"></td>
                </tr>
                <tr>
                    <td>割引率：</td>
                    <td><input type="text" name="DISCOUNT_RATE" value="${customer.discountRate}"></td>
                </tr>
                <tr>
                    <td>削除フラグ：</td>
                    <td>
                        <input type="checkbox" name="DELETE_FLAG" value="true" ${customer.deleteFlag ? 'checked' : ''}>
                        <input type="hidden" name="DELETE_FLAG" value="false">
                    </td>
                </tr>
            </table>
        </div><br>
        <div align="center">
            <input type="button" value="検索" onclick="return PushSearchButton()">
            <input type="button" value="更新" onclick="return PushUpdateButton()">
            <input type="button" value="メニュー画面に戻る" onclick="document.inform.BUTTON_ID.value='UC999_01'; document.inform.submit();">
        </div>
    </form>
</body>
</html>