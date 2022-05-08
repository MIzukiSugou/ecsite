<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:ポイント詳細画面です。
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>ポイント詳細画面</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/pointDetail.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/top.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/js/top.js" />" type="text/javascript"></script>
</head>

<body class="body_image">

	<jsp:include page="top.jsp" flush="true" />

	<form:form action="${pageContext.request.contextPath}/pointDetail/search" modelAttribute="pointDetailForm">

		<div align="center">
			<table>
				<tr class="tr_valign">
					<td>
						<div class="frame_outside">
							<table class="table_width">
								<tr>
									<td>
										<%-- メルマガ登録 --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/mailmaga_btn01.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- ネットショッピング --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu01.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- オークション --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu02.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 本やCDのお買い物 --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu03.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 宿泊予約・切符購入 --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu04.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- アンケート --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu05.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 歩いて --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu06.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 音楽を聴いて --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu08.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 映画やドラマを見て --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu09.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 無料登録 --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu10.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<%-- 食料品のお買い物 --%>
										<a href="<c:url value="/resources/jsp/unmounting.jsp" />">
											<img src="<c:url value="/resources/image/sideButton/point_mu11.gif" />" class="img_border" />
										</a>
									</td>
								</tr>
							</table>
						</div>
					</td>
					<td>
						<div class="frame_outside">
							<table>
								<tr>
									<td colspan="2">
										<table class="get_point_table">
											<tr>
												<td><font class="get_point_size">現在の所持ポイント</font></td>
											</tr>
										</table>
										<table class="point_state_table" border="0">
											<tr>
												<td class="td_center">前月ポイント残高</td>
												<td class="td_center">今月の獲得ポイント</td>
												<td class="td_center">今月の消費ポイント</td>
												<td class="td_center">今月のポイント残高</td>
												<td class="td_center">今月の交換回数</td>
											</tr>
											<tr>
												<td class="td_right"><fmt:formatNumber value="${pointDetailForm.prevBalancePoint}" pattern="###,###,###" />&nbsp;ポイント</td>
												<td class="td_right"><fmt:formatNumber value="${pointDetailForm.acquisitionPoint}" pattern="###,###,###" />&nbsp;ポイント</td>
												<td class="td_right"><fmt:formatNumber value="${pointDetailForm.expenditurePoint}" pattern="###,###,###" />&nbsp;ポイント</td>
												<td class="td_right"><fmt:formatNumber value="${pointDetailForm.balancePoint}" pattern="###,###,###" />&nbsp;ポイント</td>
												<td class="td_right"><fmt:formatNumber value="${pointDetailForm.exchangeCount}" pattern="###,###,###" />&nbsp;回</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr class="tr_top">
									<td class="item_list_td">
										<table>
											<c:forEach var="recommendationInfo" items="${pointDetailForm.recommendationList}">
												<tr>
													<td>
														<div class="frame">
															あと&nbsp;
															<font class="font_red">
																<fmt:formatNumber value="${recommendationInfo.remainderPoint}" pattern="###,###,###" />
															</font>
															&nbsp;ポイント
															<table width="300px">
																<tr>
																	<td align="left">
																		<div class="farame_image">
																			<a href="${pageContext.request.contextPath}/pointDetail/viewGoodsDetail?goodsId=<c:out value="${recommendationInfo.goodsId}" />">
																				<c:set var="imagePath" value="${recommendationInfo.imagePath}" />
																				<img src="<c:url value="/resources/image/item/${imagePath}" />" class="item_img" />
																			</a>
																		</div>
																	</td>
																	<td>
																		<img src="<c:url value="/resources/image/icon/ico_point.gif" />" class="point_img" />
																		<fmt:formatNumber value="${recommendationInfo.goodsPoint}" pattern="###,###,###" />&nbsp;ポイント
																		<br /><br />
																		<img src="<c:url value="/resources/image/icon/ico_osusume.gif" />" class="osusume_img" />
																		<br />
																		<a href="${pageContext.request.contextPath}/pointDetail/viewGoodsDetail?goodsId=<c:out value="${recommendationInfo.goodsId}" />">
																			<font size="2"><c:out value="${recommendationInfo.goodsName}" /></font>
																		</a>
																	</td>
																</tr>
															</table>
														</div>
													</td>
												</tr>
											</c:forEach>
										</table>
									</td>
									<td>
										<table>
											<tr>
												<td>
													<div class="frame_search" align="left">
														<img src="<c:url value="/resources/image/backGround/search_point.png" />" />
														<table align="center" class="inner_table">
															<tr>
																<td>
																	<form:select path="searchPoint" class="box_length">
																		<form:option value="all">すべてのポイント</form:option>
																		<form:options items="${pointDetailForm.pointCategoryList}" itemLabel="pointAmount" itemValue="pointCategoryCode" />
																	</form:select>
																</td>
																<td><form:button name="searchPointButton">検索</form:button></td>
															</tr>
															<tr>
																<td align="right">
																	<img src="<c:url value="/resources/image/icon/ico_arrow.gif" />" />
																</td>
																<td align="left">
																	<font size="2pt">
																		<a href="${pageContext.request.contextPath}/pointDetail/search?searchType=point&searchCondition=all">全アイテム一覧</a>
																	</font>
																</td>
															</tr>
														</table>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="frame_search" align="left">
														<img src="<c:url value="/resources/image/backGround/search_item_no.png" />" />
														<table align="center" class="inner_table">
															<tr>
																<td>
																	<form:input path="searchId" class="box_length" maxlength="8" />
																</td>
																<td><form:button name="searchIdButton">検索</form:button></td>
															</tr>
															<tr>
																<td align="right">
																	<img src="<c:url value="/resources/image/icon/ico_arrow.gif" />" />
																</td>
																<td align="left">
																	<font size="2pt">
																		<a href="${pageContext.request.contextPath}/pointDetail/search?searchType=id&searchCondition=all">全アイテム一覧</a>
																	</font>
																</td>
															</tr>
														</table>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="frame_search_long" align="left">
														<img src="<c:url value="/resources/image/backGround/search_genre.png" />" />
														<table align="left" class="inner_table">
															<c:forEach var="genreInfo" items="${pointDetailForm.genreList}">
																<tr>
																	<td class="td_left">
																		<img src="<c:url value="/resources/image/icon/ico_arrow.gif" />" />
																		<font size="2pt">
																			<a href="${pageContext.request.contextPath}/pointDetail/search?searchType=genre&searchCondition=<c:out value="${genreInfo.genreCode}" />">
																				<c:out value="${genreInfo.genreName}" />
																			</a>
																		</font>
																	</td>
																</tr>
															</c:forEach>
															<tr>
																<td align="right">
																	<img src="<c:url value="/resources/image/icon/ico_arrow.gif" />" />
																</td>
																<td align="left">
																	<font size="2pt">
																		<a href="${pageContext.request.contextPath}/pointDetail/search?searchType=genre&searchCondition=all">全アイテム一覧</a>
																	</font>
																</td>
															</tr>
														</table>
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</div>

	</form:form>

</body>
</html>
