<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先を削除</title>
<script>
function PushDeleteButton() {
    var customerCode = document.inform.CUSTOMER_CODE.value;
    if (customerCode == "") {
        alert("得意先コードが未入力です。");
        return false;
    }
    if (confirm('得意先を削除します。よろしいですか？')){
        document.inform.BUTTON_ID.value='UC000_05_02';
        document.inform.submit();
        return true;
    } else {
        alert("削除をキャンセルしました。");
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
            </table>
        </div><br>
        <div align="center">
            <input type="button" value="削除" onclick="return PushDeleteButton()">
            <input type="button" value="メニュー画面に戻る" onclick="document.inform.BUTTON_ID.value='UC999_01'; document.inform.submit();">
        </div>
    </form>
</body>
</html>