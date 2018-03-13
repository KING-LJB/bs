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
<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('tocreate.action','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('submit.action','_self');this.blur();">上报</a></li>
<li id="new"><a href="#" onclick="formSubmit('cancel.action','_self');this.blur();">取消</a></li>
<!-- <li id="print"><a href="#" onclick="formSubmit('print.action','_self');this.blur();">打印</a></li>
<li id="print" style="white-space:nowrap;"><a href="#" onclick="formSubmit('printTemplate.action','_self');this.blur();">模板打印</a></li>
 -->

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
      装箱单列表
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
			<td class="tableHeader">卖家</td>
			<td class="tableHeader">买家</td>
			<td class="tableHeader">发票号</td>
			<td class="tableHeader">发票日期</td>
			<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
	    	<td><input type="checkbox" name="id" value="${o.id}"></input></td>
			<td>${status.index+1}</td>
			<td>${o.seller}</td>
			<td>${o.buyer}</td>
			<td>${o.invoiceNo}</td>
			<td><fmt:formatDate value="${o.invoiceDate}" pattern="yyyy-MM-dd"/></td>
			<td>
				<c:if test="${o.state==1}"><font color="green">已上报</font></c:if>
				<c:if test="${o.state==0}">草稿</c:if>
			</td>
    </tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

