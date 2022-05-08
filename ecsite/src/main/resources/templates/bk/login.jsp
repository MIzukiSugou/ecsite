<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:���O�C����ʂł��B
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>���O�C�����</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" />
<script type="text/javascript">
	function check() {

		// ���O�C��ID�ƃp�X���[�h���擾
		var loginId = document.forms[0].loginId.value;
		var password = document.forms[0].password.value;

		if (loginId === "") {
			// ���b�Z�[�W���|�b�v�A�b�v�\��
			window.alert("���O�C��ID�����͂���Ă��܂���B");
			// �����𒆒f
			return false;
		} else if (loginId === "" || password === "") {
			// ���b�Z�[�W���|�b�v�A�b�v�\��
			window.alert("�p�X���[�h�����͂���Ă��܂���B");
			// �����𒆒f
			return false;
		}
		// ���������s
		return true;
	}
</script>
</head>

<body class="body_color">
	<form:form action="${pageContext.request.contextPath}/login" modelAttribute="loginForm" onsubmit="return check()">

		<br /><br /><br />
		<div align="center">���[�U�F�؉��</div>
		<br /><br />

		<table class="table_size">
			<tr><td class="sub_message">���O�C��ID�ƃp�X���[�h����͂��āu���O�C���{�^���v�������ĉ������B</td></tr>
			<tr><td class="sub_message">�啶���A�������̋�ʂ����ē��͂��Ă��������B</td></tr>
		</table>
		<br /><br />

		<table class="main_table">
			<tr>
				<td>
					<table class="table_size">
						<tr>
							<td class="table_header">���O�C��ID</td>
							<td><form:input path="loginId" class="text_box" maxlength="4" /></td>
						</tr>
						<tr>
							<td id="tableHeader">�p�X���[�h</td>
							<td><form:password path="password" class="text_box" maxlength="100" /></td>
						</tr>
						<tr>
							<td align="center" colspan="10">
							<br />
							<br />
							<form:button>���O�C��</form:button>
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
