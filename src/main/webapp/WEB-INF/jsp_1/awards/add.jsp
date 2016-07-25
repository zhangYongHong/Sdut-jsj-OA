<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<!DOCTYPE>

<head>
<meta charset="UTF-8">
<title>信息添加</title>
<link href="css/table_add.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<h3>大学生研究与创新活动获奖情况信息</h3>
		<div style="margin-left: 200px;">
			<form action="">
				<table cellpadding="4" cellspacing="3">
					<tr>
						<td>序&nbsp;&nbsp;号:&nbsp;</td>
						<td><select class="input" required="required"
							style="width: 66px;">
								<option value="1-1">1-1</option>
								<option value="1-2">1-2</option>
								<option value="1-3">1-3</option>
								<option value="2-1">2-1</option>
								<option value="2-2">2-2</option>
						</select></td>
					</tr>

					<tr>
						<td>竞赛项目:&nbsp;</td>
						<td><select class="input" name="" style="width: 360px;">
								<option value="1-1">“博创杯”全国大学生嵌入式物联网设计大赛山东赛区</option>
								<option value="1-2">“博创杯”全国大学生嵌入式物联网设计大赛山东赛区</option>
								<option value="1-3">“博创杯”全国大学生嵌入式物联网设计大赛山东赛区</option>
								<option value="2-1">“博创杯”全国大学生嵌入式物联网设计大赛山东赛区</option>
								<option value="2-2">“博创杯”全国大学生嵌入式物联网设计大赛山东赛区</option>
						</select></td>
					</tr>

					<tr>
						<td>成果名称:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>
					<tr>
						<td>获奖级别:&nbsp;</td>
						<td><input type="radio" name="prize">国家级 <input
							type="radio" name="prize">省级 <input type="radio"
							name="prize">校级</td>
					</tr>

					<tr>
						<td>获奖等级:&nbsp;</td>
						<td><select class="input" name="" style="width: 87px;">
								<option value="1-1">特等奖</option>
								<option value="1-2">一等奖</option>
								<option value="1-3">二等奖</option>
								<option value="2-1">三等奖</option>
								<option value="2-2">优秀奖</option>
						</select></td>
					</tr>
					<tr>
						<td>参赛学生:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>专&nbsp;&nbsp;业:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>班&nbsp;&nbsp;级:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>指导老师:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>获奖时间:&nbsp;</td>
						<td><input type="date" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>获奖单位:&nbsp;</td>
						<td><input type="text" name="" class="inputcss"></td>
					</tr>

					<tr>
						<td>备&nbsp;注:</td>
					</tr>
				</table>
				<table>
					<br>
					<textarea name="" id="" cols="40" rows="10"
						style="margin-left: 100px;"></textarea>
					<tr>
					<tr height="26px"></tr>
					<td width="44px;"></td>
					<%
						if(popedomCode.contains("ab")) {
					%>
					<td><input type="submit" name="" style="margin-left: 48px;"
						value="提交审核" class="button"></td>
					<%}%>
					<%
						if(popedomCode.contains("abc")) {
					%>
					<td><input type="submit" name="" style="margin-left: 48px;"
							   value="通过审核" class="button"></td>
					<%}%>
					<td width="60px;"></td>
					<td></td>
					<td><input type="reset" name="" class="button"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

</body>
</html>