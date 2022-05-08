<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:ログイン画面です。
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>ログイン画面</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" />
<script type="text/javascript">
	function check() {

		// ログインIDとパスワードを取得
		var loginId = document.forms[0].loginId.value;
		var password = document.forms[0].password.value;

		if (loginId === "") {
			// メッセージをポップアップ表示
			window.alert("ログインIDが入力されていません。");
			// 処理を中断
			return false;
		} else if (loginId === "" || password === "") {
			// メッセージをポップアップ表示
			window.alert("パスワードが入力されていません。");
			// 処理を中断
			return false;
		}
		// 処理を実行
		return true;
	}
</script>
</head>

<body class="body_color">
	<form:form action="${pageContext.request.contextPath}/login" modelAttribute="loginForm" onsubmit="return check()">

		<br /><br /><br />
		<div align="center">ユーザ認証画面</div>
		<br /><br />

		<table class="table_size">
			<tr><td class="sub_message">ログインIDとパスワードを入力して「ログインボタン」を押して下さい。</td></tr>
			<tr><td class="sub_message">大文字、小文字の区別をして入力してください。</td></tr>
		</table>
		<br /><br />

		<table class="main_table">
			<tr>
				<td>
					<table class="table_size">
						<tr>
							<td class="table_header">ログインID</td>
							<td><form:input path="loginId" class="text_box" maxlength="4" /></td>
						</tr>
						<tr>
							<td id="tableHeader">パスワード</td>
							<td><form:password path="password" class="text_box" maxlength="100" /></td>
						</tr>
						<tr>
							<td align="center" colspan="10">
							<br />
							<br />
							<form:button>ログイン</form:button>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<br /><br />

		<c:if test="${!empty loginForm.errorMessage}">
			<table align="center" class="error_msg">
				<tr>
					<td><c:out value="${loginForm.errorMessage}" /></td>
				</tr>
			</table>
		</c:if>

	</form:form>
</body>
</html>
