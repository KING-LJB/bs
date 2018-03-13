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
		修改主页介绍信息
    </div> 
    </div>
    </div>
</div>
    
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	    
	        <tr>
	            <td class="columnTitle_mustbe">新增信息日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="logtime" value="<fmt:formatDate value="${obj.logtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});"></input>
				</td>
	        </tr>
	        
	        <tr>
	            <td class="columnTitle_mustbe">信息内容：</td>
	            <td class="tableContent"><textarea name="logtext" style="height:120px;">${obj.logtext}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

