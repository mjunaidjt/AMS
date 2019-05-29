package com.ams.reports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "TBLJOURNAL")
public class Journal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long JOURNAL_ID;
	
	@Column( name = "JOURNAL_STARTDATE")
	private String JOURNAL_STARTDATE;
	
	@Column( name = "JOURNAL_ENDDATE")
	private String JOURNAL_ENDDATE;
	
	@Column( name = "ISACTIVE")
	private String ISACTIVE;
	
	@Column( name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;
	
	@Column( name = "MODIFIED_BY")
	private long MODIFIED_BY;
	
	@Column( name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	
	
	public long getJOURNAL_ID() {
		return JOURNAL_ID;
	}

	public void setJOURNAL_ID(long jOURNAL_ID) {
		JOURNAL_ID = jOURNAL_ID;
	}

	public String getJOURNAL_STARTDATE() {
		return JOURNAL_STARTDATE;
	}

	public void setJOURNAL_STARTDATE(String jOURNAL_STARTDATE) {
		JOURNAL_STARTDATE = jOURNAL_STARTDATE;
	}

	public String getJOURNAL_ENDDATE() {
		return JOURNAL_ENDDATE;
	}

	public void setJOURNAL_ENDDATE(String jOURNAL_ENDDATE) {
		JOURNAL_ENDDATE = jOURNAL_ENDDATE;
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
