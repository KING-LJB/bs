package com.hncj.bs.vo;

import java.util.List;

import com.hncj.bs.domain.Contract;
import com.hncj.bs.domain.ExtCproduct;
import com.hncj.bs.domain.Factory;

public class ContractProductVO {
    private String id;
	
	private Contract contract;		             //将复杂的关联关系变成单表操作
	private Factory factory;                     //和生产厂家多对一
	private List<ExtCproductVO> extCproducts;      //和附件一对多
//	private String contractId;		            //关联关系的表（外键），都成为普通字段
//	private String factoryId;
	
//	private String factoryName;         
	private String productNo;
	private String productImage;
	private String productDesc;
	private Integer cnumber;            //数量
	private Integer outNumber;          //出货数量
	private String loadingRate;			//装率
	private Integer boxNum;				//箱数
	private String packingUnit;			//包装单位
	private Double price;               //单价
	private Double amount;              //总金额
	private Integer finished;           //是否出货完毕   0未完成 1完成
	private String exts;                //附件
	private Integer orderNo;            //排序号
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getContractId() {
//		return contractId;
//	}
//	public void setContractId(String contractId) {
//		this.contractId = contractId;
//	}
//	public String getFactoryId() {
//		return factoryId;
//	}
//	public void setFactoryId(String factoryId) {
//		this.factoryId = factoryId;
//	}
//	public String getFactoryName() {
//		return factoryName;
//	}
//	public void setFactoryName(String factoryName) {
//		this.factoryName = factoryName;
//	}
	
	public String getProductNo() {
		return productNo;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	
	public List<ExtCproductVO> getExtCproducts() {
		return extCproducts;
	}
	public void setExtCproducts(List<ExtCproductVO> extCproducts) {
		this.extCproducts = extCproducts;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public Integer getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(Integer outNumber) {
		this.outNumber = outNumber;
	}
	public String getLoadingRate() {
		return loadingRate;
	}
	public void setLoadingRate(String loadingRate) {
		this.loadingRate = loadingRate;
	}
	public Integer getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getFinished() {
		return finished;
	}
	public void setFinished(Integer finished) {
		this.finished = finished;
	}
	public String getExts() {
		return exts;
	}
	public void setExts(String exts) {
		this.exts = exts;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
