package com.thanh.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IssuedBook {
	private String callNo;
	private String studentId;
	private String studentName;
	private String studentMobile;
	private Date issuedDate;
	private String returnStatus;

	public IssuedBook(String callNo, String studentId, String studentName, String studentMobile, Date issuedDate,
			String returnStatus) {
		super();
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMobile = studentMobile;
		this.issuedDate = issuedDate;
		this.returnStatus = returnStatus;
	}

	public IssuedBook(ResultSet resultSet) throws SQLException {
		this.callNo = resultSet.getString("callNo");
		this.studentId = resultSet.getString("studentId");
		this.studentName = resultSet.getString("studentName");
		this.studentMobile = resultSet.getString("studentMobile");
		this.issuedDate = new Date(resultSet.getTimestamp("issuedDate").getTime());
		this.returnStatus = resultSet.getString("returnStatus");
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

}
