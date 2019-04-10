package com.ams.transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "TBLTRANSACTIONVOUCHER" )
public class TransactionVoucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long TRANSACTION_ID;

	@Column( name = "TRANSACTION_DATE")
	private String TRANSACTION_DATE;
	
	@Column( name = "TRANSACTION_DESCRIPTION")
	private String TRANSACTION_DESCRIPTION;
	
	@Column( name = "ISACTIVE")
	private String ISACTIVE;
	
	@Column( name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;
	
	@Column( name = "MODIFIED_BY")
	private long MODIFIED_BY;
	
	@Column( name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;
	
	
	// getter setter methods...................

	public long getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}

	public void setTRANSACTION_ID(long tRANSACTION_ID) {
		TRANSACTION_ID = tRANSACTION_ID;
	}

	public String getTRANSACTION_DATE() {
		return TRANSACTION_DATE;
	}

	public void setTRANSACTION_DATE(String tRANSACTION_DATE) {
		TRANSACTION_DATE = tRANSACTION_DATE;
	}

	public String getTRANSACTION_DESCRIPTION() {
		return TRANSACTION_DESCRIPTION;
	}

	public void setTRANSACTION_DESCRIPTION(String tRANSACTION_DESCRIPTION) {
		TRANSACTION_DESCRIPTION = tRANSACTION_DESCRIPTION;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
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
