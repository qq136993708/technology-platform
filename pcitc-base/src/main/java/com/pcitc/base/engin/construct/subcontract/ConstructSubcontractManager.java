package com.pcitc.base.engin.construct.subcontract;

public class ConstructSubcontractManager {
	/**
	 * 业务id
	 */
	private String dataId;

	/**
	 * 分包结果编号
	 */
	private String resultId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 岗位
	 */
	private String post;

	/**
	 * 身份证号码
	 */
	private String idNumber;

	/**
	 * 职业资格
	 */
	private String qualification;

	/**
	 * 职称证
	 */
	private String certificate;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId == null ? null : dataId.trim();
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId == null ? null : resultId.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post == null ? null : post.trim();
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber == null ? null : idNumber.trim();
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification == null ? null : qualification.trim();
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate == null ? null : certificate.trim();
	}
}