package com.ams.reports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "TBLLEDGER")
public class Ledger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long LEDGER_ID;
	
	@Column( name = "LEDGER_CREDITBALANCE")
	private String LEDGER_CREDITBALANCE;
	
	@Column( name = "LEDGER_DEBITBALANCE")
	private double LEDGER_DEBITBALANCE;
	
	@Column( name = "ACCOUNT_ID")
	private long ACCOUNT_ID;
	
	@Column( name = "ISACTIVE")
	private double ISACTIVE;
	
	@Column( name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;
	
	@Column( name = "MODIFIED_BY")
	private long MODIFIED_BY;
	
	@Column( name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	
	
	public long getLEDGER_ID() {
		return LEDGER_ID;
	}

	public void setLEDGER_ID(long lEDGER_ID) {
		LEDGER_ID = lEDGER_ID;
	}

	public String getLEDGER_CREDITBALANCE() {
		return LEDGER_CREDITBALANCE;
	}

	public void setLEDGER_CREDITBALANCE(String lEDGER_CREDITBALANCE) {
		LEDGER_CREDITBALANCE = lEDGER_CREDITBALANCE;
	}

	public double getLEDGER_DEBITBALANCE() {
		return LEDGER_DEBITBALANCE;
	}

	public void setLEDGER_DEBITBALANCE(double lEDGER_DEBITBALANCE) {
		LEDGER_DEBITBALANCE = lEDGER_DEBITBALANCE;
	}

	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(long aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public double getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(double iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	public long getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(long mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}
	
	
}
