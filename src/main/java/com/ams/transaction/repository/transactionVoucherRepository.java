package com.ams.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.transaction.model.TransactionVoucher;

public interface transactionVoucherRepository extends JpaRepository<TransactionVoucher, Long>  {
	
	@Query(value = "select * from TBLTRANSACTIONVOUCHER where ISACTIVE ='Y' " , nativeQuery=true)
	public List<TransactionVoucher> findActive();
	
	
	@Query(value = "select * from TBLTRANSACTIONVOUCHER "
			+ "where( TRANSACTION_DATE like '%'+?1+'%'"
			+ " or TRANSACTION_DESCRIPTION like '%'+?1+'%' ) and ISACTIVE ='Y' ", nativeQuery = true )
	public List<TransactionVoucher> findBySearch( String search );
	
	
	
	@Query(value = "select * from TBLTRANSACTIONVOUCHER"
			+ " where TRANSACTION_DATE like '%'+?1+'%' "
			+ " or TRANSACTION_DESCRIPTION like '%'+?1+'%' ", nativeQuery=true)
	public List<TransactionVoucher> findAllBySearch( String search );
	
	
	@Query(value = "select * from TBLTRANSACTIONVOUCHER"
			+ " where TRANSACTION_ID like CASE WHEN ?1=0 THEN TRANSACTION_ID ELSE ?1 END"
			+ " and ISACTIVE ='Y' ", nativeQuery=true)
	public List<TransactionVoucher> findByAdvancedSearch(long TRANSACTION_ID);
	
	
	
	@Query(value = "select * from TBLTRANSACTIONVOUCHER"
			+ " where TRANSACTION_ID like CASE WHEN ?1=0 THEN TRANSACTION_ID ELSE ?1 END" , nativeQuery=true)
	public List<TransactionVoucher> findAllByAdvancedSearch(long TRANSACTION_ID);

	
}
