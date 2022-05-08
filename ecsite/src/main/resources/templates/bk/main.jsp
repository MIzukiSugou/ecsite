<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:���C����ʂł��B
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>���C�����</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/top.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/js/top.js" />" type="text/javascript"></script>
</head>

<body class="body_image">

	<jsp:include page="top.jsp" flush="true" />

	<form:form action="${pageContext.request.contextPath}/main/viewPointDetail" modelAttribute="mainForm">

		<div align="center">
			<table class="dummy_table">
				<tr>
					<td class="td_center">
						<%-- �l�b�g�V���b�s���O --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu01.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- �I�[�N�V���� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu02.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- �{��CD�̂������� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu03.gif" />" class="img_border" />
						</a>
					</td>
				</tr>
				<tr>
					<td class="td_center">
						<%-- �h���\��E�ؕ��w�� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu04.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- �A���P�[�g --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu05.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- ������ --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu06.gif" />" class="img_border" />
						</a>
					</td>
				</tr>
				<tr>
					<td class="td_center">
						<%-- ���y�𒮂��� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu08.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- �f���h���}������ --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu09.gif" />" class="img_border" />
						</a>
					</td>
					<td class="td_center">
						<%-- �����o�^ --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu10.gif" />" class="img_border" />
						</a>
					</td>
				</tr>
				<tr>
					<td class="td_center">
						<%-- �H���i�̂������� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_mu11.gif" />" class="img_border" />
						</a>
					</td>
				</tr>
			</table>

			<br /><br />

			<table>
				<tr>
					<td>
						<%-- �|�C���g�m�F�E���� --%>
						<a href="javascript:mainForm.submit()">
							<img src="<c:url value="/resources/image/button/point_nav01.gif" />" class="img_border" />
						</a>
					</td>
					<td>
						<%-- �|�C���g���ߕ��u�� --%>
						<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
							<img src="<c:url value="/resources/image/button/point_nav02.gif" />" class="img_border" />
						</a>
					</td>
				</tr>
			</table>
		</div>

	</form:form>
</body>
</html>
