package com.pioneer.Account.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBLACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ACCOUNT_ID;

	@Column(name = "ACCOUNT_TITLE")
	private String ACCOUNT_TITLE;
	
	@Column(name = "ACCOUNT_DESCRIPTION")
	private String ACCOUNT_DESCRIPTION;

	@Column(name = "ACCOUNT_CREDITBALANCE")
	private double ACCOUNT_CREDITBALANCE;

	@Column(name = "ACCOUNT_DEBITBALANCE")
	private double ACCOUNT_DEBITBALANCE;

	@Column(name = "ACCOUNT_ADDED")
	private String ACCOUNT_ADDED;

	@Column(name = "ISACTIVE")
	private String ISACTIVE;

	@Column(name = "MODIFIED_BY")
	private String MODIFIED_BY;

	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@Column(name = "MODIFIED_WORKSATION")
	private String MODIFIED_WORKSTATION;
	
	@Column(name = "ACCOUNTTYPE_ID")
	private long ACCOUNTTYPE_ID;

	public Long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(Long aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public String getACCOUNT_TITLE() {
		return ACCOUNT_TITLE;
	}

	public void setACCOUNT_TITLE(String aCCOUNT_TITLE) {
		ACCOUNT_TITLE = aCCOUNT_TITLE;
	}

	public String getACCOUNT_DESCRIPTION() {
		return ACCOUNT_DESCRIPTION;
	}

	public void setACCOUNT_DESCRIPTION(String aCCOUNT_DESCRIPTION) {
		ACCOUNT_DESCRIPTION = aCCOUNT_DESCRIPTION;
	}

	public double getACCOUNT_CREDITBALANCE() {
		return ACCOUNT_CREDITBALANCE;
	}

	public void setACCOUNT_CREDITBALANCE(double d) {
		ACCOUNT_CREDITBALANCE = d;
	}

	public double getACCOUNT_DEBITBALANCE() {
		return ACCOUNT_DEBITBALANCE;
	}

	public void setACCOUNT_DEBITBALANCE(double aCCOUNT_DEBITBALANCE) {
		ACCOUNT_DEBITBALANCE = aCCOUNT_DEBITBALANCE;
	}

	public String getACCOUNT_ADDED() {
		return ACCOUNT_ADDED;
	}

	public void setACCOUNT_ADDED(String aCCOUNT_ADDED) {
		ACCOUNT_ADDED = aCCOUNT_ADDED;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}

	public long getACCOUNTTYPE_ID() {
		return ACCOUNTTYPE_ID;
	}

	public void setACCOUNTTYPE_ID(long aCCOUNTTYPE_ID) {
		ACCOUNTTYPE_ID = aCCOUNTTYPE_ID;
	}

}
