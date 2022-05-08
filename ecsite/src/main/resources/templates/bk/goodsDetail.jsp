<%--
  - Author:Itec
  - Date:2019/04/01
  - Copyright Notice:IT Engineer Center Co.,Ltd.
  - Description:商品詳細画面です。
 --%>
<%@ page contentType="text/html; charset = Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>商品詳細画面</title>
<meta http-equiv="content-type" content="text/html; charset=Shift_JIS" />
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/top.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/js/top.js" />" type="text/javascript"></script>
</head>

<body background="<c:url value="/resources/image/backGround/bd_bg02.gif" />">

	<jsp:include page="top.jsp" flush="true" />

	<div align="center">
		<table>
			<tr valign="top">
				<td>
					<div class="frame_outside">
						<table width="190px">
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
					<form:form action="${pageContext.request.contextPath}/goodsDetail/exchange" modelAttribute="goodsDetailForm">
						<div class="frame_outside">
							<table>
								<tr>
									<td colspan="2">
										<table background="<c:url value="/resources/image/backGround/h1_lower.gif" />" width="720px" height="85px">
											<tr>
												<td><font size="5">&nbsp;アイテム詳細</font></td>
											</tr>
										</table>

										<table cellspacing="1" width="720px" height="400px" bgcolor="#FFFFFF">
											<tr>
												<td height="40px" align="left" colspan="3" class="point_and_item_name">
													<font color="red">
														&nbsp;
														<fmt:formatNumber value="${goodsDetailForm.goodsPoint}" pattern="###,###,###" />
														&nbsp;Point&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</font>
													<font size="3pt">
														<c:out value="${goodsDetailForm.goodsName}" />
													</font>
												</td>
											</tr>
											<tr>
												<td align="left" valign="top" height="182px">
													<c:set var="imagePath" value="${goodsDetailForm.imagePath}" />
													<img src="<c:url value="/resources/image/item/${imagePath}" />" width="220px" height="182px" />
												</td>
												<td width="60px"></td>
												<td align="left" valign="top">
													<font size="2pt">
														<c:out value="${goodsDetailForm.goodsInfo1}" /><br /><br />
														<c:out value="${goodsDetailForm.goodsInfo2}" /><br /><br />
														アイテム番号：[<c:out value="${goodsDetailForm.goodsId}" />]<br />
														カテゴリ：[<c:out value="${goodsDetailForm.categoryName}" />]
													</font>
												</td>
											</tr>
											<tr>
												<td align="center" colspan="3">
													<div class="frame">
														<c:if test="${goodsDetailForm.inputExchage == true}">
															<table width="400px">
																<tr>
																	<td align="left" height="50px">
																		<form:input path="exchangeAmount" maxlength="2" styleClass="text_box" />
																		&nbsp;&nbsp;&nbsp;
																		<form:button name="exchangeButton">交換</form:button>
																	</td>
																</tr>
																<tr>
																	<td align="left">
																		<font size="2pt">
																			※半角数字で入力してください <br /> ポイント交換手続きの上限は1回につき99個までとなります
																		</font>
																	</td>
																</tr>
															</table>
														</c:if>
														<c:if test="${goodsDetailForm.inputExchage == false}">
															<table width="500px">
																<tr>
																	<td align="left" height="50px">
																		<table>
																			<tr>
																				<td>[</td>
																				<td>交換個数</td>
																				<td>:</td>
																				<td align="right">
																					<c:out value="${goodsDetailForm.exchangeAmount}" /> 個
																				</td>
																				<td>]</td>
																			</tr>
																			<tr>
																				<td>[</td>
																				<td>合計交換ポイント</td>
																				<td>:</td>
																				<td align="right">
																					<fmt:formatNumber value="${goodsDetailForm.totalExchagePoint}" pattern="###,###,###" /> ポイント
																				</td>
																				<td>]</td>
																			</tr>
																			<tr>
																				<td>[</td>
																				<td>交換前所持ポイント</td>
																				<td>:</td>
																				<td align="right">
																					<fmt:formatNumber value="${goodsDetailForm.beforeMyPoint}" pattern="###,###,###" /> ポイント
																				</td>
																				<td>]</td>
																			</tr>
																			<tr>
																				<td>[</td>
																				<td>交換後所持ポイント</td>
																				<td>:</td>
																				<td align="right">
																					<fmt:formatNumber value="${goodsDetailForm.afterMyPoint}" pattern="###,###,###" /> ポイント
																				</td>
																				<td>]</td>
																			</tr>
																		</table>
																	</td>
																	<td></td>
																</tr>
																<tr>
																	<td>
																		<font size="2pt"><b>上記の内容で交換してよろしいですか？ </b></font>
																	</td>
																	<td align="left">
																		<form:button name="confirmationButton">&nbsp;確&nbsp;認&nbsp;</form:button>
																		<form:button name="cancelButton">キャンセル</form:button>
																	</td>
																</tr>
															</table>
															<form:hidden path="hidExchangeAmount" />
														</c:if>
													</div>
												</td>
											</tr>
											<c:if test="${!(empty goodsDetailForm.errorMessage)}">
												<tr>
													<td colspan="3">
														<font color="red"><c:out value="${goodsDetailForm.errorMessage}" /></font>
													</td>
												</tr>
											</c:if>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<form:hidden path="hidGoodsPoint" />
						<form:hidden path="hidGoodsName" />
						<form:hidden path="hidImagePath" />
						<form:hidden path="hidGoodsInfo1" />
						<form:hidden path="hidGoodsInfo2" />
						<form:hidden path="hidGoodsId" />
						<form:hidden path="hidCategoryName" />
						<form:hidden path="hidTotalExchagePoint" />
						<form:hidden path="hidAfterMyPoint" />
						<form:hidden path="hidMaxExchangeCount" />
					</form:form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
