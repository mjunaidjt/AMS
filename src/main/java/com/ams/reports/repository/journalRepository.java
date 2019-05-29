package com.ams.reports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.reports.model.Journal;

public interface journalRepository extends JpaRepository<Journal, Long>{

	@Query(value = "Select * from TBLJOURNAL where ISACTIVE='Y' " , nativeQuery=true )
	public List<Journal> findActive();
	
	
}
