package com.emep.dubbo.demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 
* @ClassName: Area 
* @Description: TODO(流域表) 
* @author com_emep_ppc
* @date 2016年9月21日 上午11:59:00 
*
 */
public class Area  implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@NotNull
	private String id;
	
	/**
	 * 流域名字
	 */
	private String name;
	
	/**
	 * 流域编码code
	 */
	private String code;
	
	/**
	 * 纬度
	 */
	private String latitude;
	
	/**
	 * 经度
	 */
	private String longitude;
	
	/**
	 * 流域国家编码code
	 */
	private String nationalCode; 
	
	/**
	 * 流域父级ID
	 */
	private String parentId;
	
	/**
	 * 流域父级层级Code集合
	 */
	private String parentPath;
	
	/**
	 * 父流域编码code
	 */
	private String pCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}
	
	

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	
}
