<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
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
		浏览报运信息
    </div> 
    </div>
    </div>
</div>  
  
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">合同或确认书号：</td>
	            <td class="tableContent">${obj.customerContract}</td>
	            <td class="columnTitle">信用证号：</td>
	            <td class="tableContent">${obj.lcno}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">货物数/附件数：</td>
	            <td class="tableContent">${obj.epnum}/${obj.extnum}</td>
	            <td class="columnTitle">收货人及地址：</td>
	            <td class="tableContentAuto">
	            	${obj.consignee}
	            </td>
	        </tr>
	         <tr>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent">${obj.shipmentPort}</td>
	            <td class="columnTitle">目的港：</td>
	            <td class="tableContent">${obj.destinationPort}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">运输方式：</td>
	            <td class="tableContent">${obj.transportMode}</td>
	            <td class="columnTitle">价格条件：</td>
	            <td class="tableContent">${obj.priceCondition}</td>
	        </tr>
	        
	        <tr>
	            <td class="columnTitle">制单日期：</td>
	            <td class="tableContent"><fmt:formatDate value="${obj.inputDate}" pattern="yyyy-MM-dd"/></td>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	<c:if test="${obj.state==1}">已上报</c:if>
	            	<c:if test="${obj.state==0}">草稿</c:if>
	            </td>
	        </tr>
	</div>
</div>
 
 
 <%-- <div class="textbox" id="centerTextbox">
	  <div class="textbox-header">
	  <div class="textbox-inner-header">
	  <div class="textbox-title">
	    货物列表
	  </div> 
	  </div>
	  </div>
  </div>
  
<div>
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家名称</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">装率</td>
		<td class="tableHeader">箱数</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
<c:forEach items="${obj.contractProducts}" var="cp" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td>${status.index+1}</td>
		<td>${cp.factory.factoryName}</td>
		<td>${cp.productNo}</td>
		<td>${cp.cnumber}</td>
		<td>${cp.packingUnit}</td>
		<td>${cp.loadingRate}</td>
		<td>${cp.boxNum}</td>
		<td>${cp.price}</td>
		<td>${cp.amount}</td>
	</tr>
	
	<c:forEach items="${cp.extCproducts}" var="ext" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><font color="blue">附件：${status.index+1}</font></td>
		<td>${ext.factory.factoryName}</td>
		<td>${ext.productNo}</td>
		<td>${ext.cnumber}</td>
		<td>${ext.packingUnit}</td>
		<td></td>
		<td></td>
		<td>${ext.price}</td>
		<td>${ext.amount}</td>
	</tr>
	</c:forEach>
	
</c:forEach>
	
	</tbody>
</table>
</div>
</div> --%>
 
</form>
</body>
</html>

