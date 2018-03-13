<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">
	<input type="hidden" name="id" value="${obj.id}"></input>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改用户信息
    </div> 
    </div>
    </div>
</div>
    
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">用户名：</td>
	            <td class="tableContent"><input type="text" name="username" value="${obj.username}"></input></td>
	            <td class="columnTitle_mustbe">用户密码：</td>
	            <td class="tableContent"><input type="text" name="password" value="${obj.password}"></input></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">薪水：</td>
	            <td class="tableContent"><input type="text" name="salary" value="${obj.salary}"></input></td>
				<td class="columnTitle_mustbe">出生日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="birthday" value="<fmt:formatDate value="${obj.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});"></input>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">性别：</td>
            	<td class="tableContentAuto">
	            	<input type="radio" name="gender" value="男" class="input" <c:if test="${obj.gender=='男'}">checked</c:if>></input>男
	            	<input type="radio" name="gender" value="女" class="input" <c:if test="${obj.gender=='女'}">checked</c:if>></input>女
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">职位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="station" value="管理员" class="input" <c:if test="${obj.station=='管理员'}">checked</c:if>></input>管理员
	            	<input type="radio" name="station" value="总经理" class="input" <c:if test="${obj.station=='总经理'}">checked</c:if>></input>总经理
	            	<input type="radio" name="station" value="销售主管" class="input" <c:if test="${obj.station=='销售主管'}">checked</c:if>></input>销售主管
	            	<input type="radio" name="station" value="运输主管" class="input" <c:if test="${obj.station=='运输主管'}">checked</c:if>></input>运输主管
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" name="telephone" value="${obj.telephone}"></input></td>
	            <td class="columnTitle_mustbe">说明：</td>
	            <td class="tableContent"><textarea name="remark" style="height:120px;">${obj.remark}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

