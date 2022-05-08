<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:商品一覧画面です。
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>商品一覧画面</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/goodsInquiry.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/top.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/js/top.js" />" type="text/javascript"></script>
</head>

<body class="body_image">

	<jsp:include page="top.jsp" flush="true" />

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
						<form:form action="${pageContext.request.contextPath}/goodsInquiry/search" modelAttribute="goodsInquiryForm">
							<table>
								<tr>
									<td>
										<table class="get_point_table">
											<tr>
												<td><font class="get_point_size">アイテム検索結果</font></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<table>
											<tr>
												<td width="150px"><font size="2pt"> 現在の所持ポイント </font></td>
												<td>
													<font color="red" size="2pt">
														<fmt:formatNumber value="${goodsInquiryForm.myPoint}" pattern="###,###,###" />&nbsp; ポイント
													</font>
												</td>
											</tr>
										</table>
										<hr />
									</td>
								</tr>
								<tr>
									<td>
										<table width="720px" height="72px" background="<c:url value="/resources/image/backGround/table_bg.png" />">
											<tr>
												<td>
													<table>
														<tr>
															<td width="120px" height="30px">
																<font size="2pt">ポイント数で探す </font>
															</td>
															<td>
																<form:select path="searchPointAmount" class="box_length">
																	<form:option value="">すべてのポイント</form:option>
																	<form:options items="${goodsInquiryForm.pointCategoryList}" itemLabel="pointAmount" itemValue="pointCategoryCode" />
																</form:select>
															</td>
															<td rowspan="2" width="70px" align="center">
																<form:button name="searchPointAndGenreButton">検索</form:button>
															</td>
														</tr>
														<tr>
															<td><font size="2pt"> ジャンルから探す </font></td>
															<td>
																<form:select path="searchGenre" class="box_length">
																	<form:option value="">すべてのジャンル</form:option>
																	<form:options items="${goodsInquiryForm.genreList}" itemLabel="genreName" itemValue="genreCode" />
																</form:select>
															</td>
														</tr>
													</table>
												</td>
												<td>
													<table width="300px">
														<tr>
															<td><font size="2pt"> アイテム番号から探す </font></td>
														</tr>
														<tr>
															<td>
																<form:input path="searchGoodsId" size="20px" maxlength="8" />
																<form:button name="searchGoodsIdButton">検索</form:button>
															</td>
														</tr>
														<tr>
															<td><font size="1pt"> ※半角数字8桁で入力してください </font></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<br />
							<table width="720px">
								<tr>
									<td width="33%">
										<font size="2pt">
											&nbsp;&nbsp;<fmt:formatNumber value="${goodsInquiryForm.totalGoodsCount}" pattern="###,###,###" />&nbsp;件の該当データがあります。
										</font>
									</td>
									<td width="33%" align="center">
										<font size="2pt">
											<fmt:formatNumber value="${goodsInquiryForm.pageCount}" pattern="###,###,###" />
											/
											<fmt:formatNumber value="${goodsInquiryForm.totalPageCount}" pattern="###,###,###" />
											ページ
										</font>
									</td>
									<td width="33%" align="right">
										<font size="2pt">
											&nbsp;&nbsp;
											<fmt:formatNumber value="${goodsInquiryForm.firstGoodsCount}" pattern="###,###,###" />
											 -
											<fmt:formatNumber value="${goodsInquiryForm.lastGoodsCount}" pattern="###,###,###" />
											件を表示
										</font>
									</td>
								</tr>
								<tr>
									<td><br /></td>
								</tr>
								<tr>
									<td align="center" colspan="3">
										<font size="2pt">
											<c:if test="${goodsInquiryForm.showForwardLink == true}">
												<a href="${pageContext.request.contextPath}/goodsInquiry/pageMove?page_control=forward">前のページ</a>
											</c:if>
											<c:if test="${goodsInquiryForm.showForwardLink == false}">
												&lt;&lt;前のページ
											</c:if>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<c:if test="${goodsInquiryForm.showNextLink == true}">
												<a href="${pageContext.request.contextPath}/goodsInquiry/pageMove?page_control=next">次のページ</a>
											</c:if>
											<c:if test="${goodsInquiryForm.showNextLink == false}">
												次のページ&gt;&gt;
											</c:if>
										</font>
									</td>
								</tr>
							</table>
							<br />
							<c:if test="${!(empty goodsInquiryForm.goodsList)}">
								<table align="center">
									<c:forEach var="goodsInfo" items="${goodsInquiryForm.goodsList}" varStatus="status">
										<c:if test="${status.index == 0}">
											<tr>
										</c:if>
										<c:if test="${status.index == 3}">
											<tr>
										</c:if>
										<c:if test="${status.index == 6}">
											<tr>
										</c:if>
										<td>
											<c:if test="${!(empty goodsInfo.goodsId)}">
												<div class="item_frame_image" align="center">
													<table width="150px" height="200px">
														<tr>
															<td height="20px" valign="middle">
																<img src="<c:url value="/resources/image/icon/ico_point.gif" />" class="point_img" />
																<font size="2">
																	<fmt:formatNumber value="${goodsInfo.goodsPoint}" pattern="###,###,###" />
																	&nbsp;ポイント
																</font>
															</td>
														</tr>
														<tr>
															<td align="center" height="91px">
																<div>
																	<a href="${pageContext.request.contextPath}/goodsInquiry/viewGoodsDetail?goodsId=<c:out value="${goodsInfo.goodsId}" />">
																		<c:set var="imagePath" value="${goodsInfo.imagePath}" />
																		<img src="<c:url value="/resources/image/item/${imagePath}" />" class="item_img" />
																	</a>
																</div>
															</td>
														</tr>
														<tr>
															<td>
																<a href="${pageContext.request.contextPath}/goodsInquiry/viewGoodsDetail?goodsId=<c:out value="${goodsInfo.goodsId}" />">
																	<font size="2" style="line-height: 18px;">
																		<c:out value="${goodsInfo.goodsName}" />
																	</font>
																</a>
															</td>
														</tr>
													</table>
												</div>
											</c:if>
											<c:if test="${(empty goodsInfo.goodsId)}">
												<table width="210px" height="249px">
													<tr>
														<td>&nbsp;</td>
													</tr>
												</table>
											</c:if>
										</td>
										<c:if test="${status.index == 2}">
											</tr>
										</c:if>
										<c:if test="${status.index == 5}">
											</tr>
										</c:if>
										<c:if test="${status.index == 8}">
											</tr>
										</c:if>
									</c:forEach>
								</table>
							</c:if>
						</form:form>
					</div>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
