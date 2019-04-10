package com.ams.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.account.model.Account;

public interface accountRepository extends JpaRepository<Account,Long>
{
	//findActive
		@Query(value="SELECT * from TBLACCOUNT where ISACTIVE='Y'",nativeQuery=true)
		public List<Account> findActive();
		//findBySearch
		@Query(value="SELECT * from TBLACCOUNT where (ACCOUNT_TITLE like '%'+?1+'%' or ACCOUNT_DESCRIPTION like '%'+?1+'%') AND ISACTIVE='Y'",nativeQuery=true)
		public List<Account> findBySearch(String search);
		//findAllBySearch
		@Query(value="SELECT * from TBLACCOUNT where (ACCOUNT_TITLE like '%'+?1+'%' or ACCOUNT_DESCRIPTION like '%'+?1+'%')",nativeQuery=true)
		public List<Account> findAllBySearch(String search);
		//findByAdvancedSearch
		@Query(value="SELECT * from TBLACCOUNT where ACCOUNTTYPE_ID like CASE WHEN ?1=0 THEN ACCOUNTTYPE_ID ELSE ?1 END and ISACTIVE='Y'",nativeQuery=true)
		public List<Account> findByAdvancedSearch(long ACCOUNTTYPE_ID);
		//findAllByAdvancedSearch
		@Query(value="SELECT * from TBLACCOUNT where ACCOUNTTYPE_ID like CASE WHEN ?1=0 THEN ACCOUNTTYPE_ID ELSE ?1 END",nativeQuery=true)
		public List<Account> findAllByAdvancedSearch(long ACCOUNTTYPE_ID);


}
