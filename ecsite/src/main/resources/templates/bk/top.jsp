<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:共通ヘッダ画面です。
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="${pageContext.request.contextPath}/logout">

	<div align="center">

		<table class="button_table">
			<tr>
				<td width="60%"></td>
				<td><img src="<c:url value="/resources/image/backGround/hb_nav_line.gif" />" /></td>
				<td>
					<%-- サイトマップ --%>
					<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
						<img src="<c:url value="/resources/image/button/hb_nav01.gif" />" class="img_border" />
					</a>
				</td>
				<td><img src="<c:url value="/resources/image/backGround/hb_nav_line.gif" />" /></td>
				<td>
					<%-- Q&A --%>
					<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
						<img src="<c:url value="/resources/image/button/hb_nav02.gif" />" class="img_border" />
					</a>
				</td>
				<td><img src="<c:url value="/resources/image/backGround/hb_nav_line.gif" />" /></td>
				<td>
					<%-- お問い合わせ --%>
					<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
						<img src="<c:url value="/resources/image/button/hb_nav03.gif" />" class="img_border" />
					</a>
				</td>
				<td><img src="<c:url value="/resources/image/backGround/hb_nav_line.gif" />" /></td>
				<td>
					<%-- ログアウト --%>
					<a href="javascript:void(0)" onclick="logout();return false;">
						<img src="<c:url value="/resources/image/button/hb_btn01.gif" />" class="img_border" />
					</a>
				</td>
			</tr>
		</table>

		<table class="user_table">
			<tr>
				<td class="td_left">
					<font class="font_mono">ログインユーザ：</font>
					<b>
						<font class="font_black">
						<c:out value="${login_user_info.familyNm}" />&nbsp;<c:out value="${login_user_info.firstNm}" />
						</font>
					</b>
					<font class="font_mono">様</font>
				</td>
			</tr>
		</table>

	</div>

</form:form>
