<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
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
		新增系统用户
    </div> 
    </div>
    </div>
</div>  

<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">用户名：</td>
	            <td class="tableContent"><input type="text" name="username"></input></td>
	            <td class="columnTitle_mustbe">用户密码：</td>
	            <td class="tableContent"><input type="text" name="password"></input></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">薪水：</td>
	            <td class="tableContent"><input type="text" name="salary"></input></td>
	            <td class="columnTitle_mustbe">出生日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="birthday"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});"></input>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">性别：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="gender" value="男" class="input" checked></input>男
	            	<input type="radio" name="gender" value="女" class="input"></input>女
	            </td>
	         </tr>
	         <tr>
	            <td class="columnTitle_mustbe">职位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="station" value="管理员" class="input" checked></input>管理员
	            	<input type="radio" name="station" value="总经理" class="input"></input>总经理
	            	<input type="radio" name="station" value="销售主管" class="input"></input>销售主管
	            	<input type="radio" name="station" value="运输主管" class="input"></input>运输主管
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" name="telephone"></input></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">个人说明：</td>
	            <td class="tableContent"><textarea name="remark" style="height:120px;"></textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

