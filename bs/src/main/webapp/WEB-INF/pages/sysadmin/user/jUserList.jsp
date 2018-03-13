<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<!-- 按钮区域  -->
<!-- <li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li> -->
<li id="new"><a href="#" onclick="formSubmit('${ctx}/sysadmin/user/tocreate.action','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>

</ul>
  </div>
</div>
</div>
</div>
   
<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
<!-- 标题 -->
    	用户列表
  </div> 
  </div>
  </div>
</div>
  
<div>
	<!-- 列表区域 -->
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></input></td>
		    <td class="tableHeader">序号</td>
			<td class="tableHeader">用户名</td>
			<td class="tableHeader">用户密码</td>
			<td class="tableHeader">薪水</td>
			<td class="tableHeader">出生日期</td>
			<td class="tableHeader">性别</td>
			<td class="tableHeader">职位</td>
			<td class="tableHeader">电话</td>
			<td class="tableHeader">个人评价</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
	    	<td><input type="checkbox" name="id" value="${o.id}"></input></td>
			<td>${status.index+1}</td>
			<td>${o.username}</td>
			<%-- <td><a href="toview.action?id=${o.id}">${o.contractNo}</a></td>
			<td align="center">${o.cpnum}/${o.extnum}</td> --%>
			<td>${o.password}</td>
			<td>${o.salary}</td>
			<td><fmt:formatDate value="${o.birthday}" pattern="yyyy-MM-dd"/></td>
			<td>${o.gender}</td>
			<td>${o.station}</td>
			<td>${o.telephone}</td>
			<td>${o.remark}</td>
    </tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

