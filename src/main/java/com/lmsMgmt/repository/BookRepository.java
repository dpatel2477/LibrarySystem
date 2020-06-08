package com.lmsMgmt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lmsMgmt.models.Book;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long>{
	
	@Query("select o from Book o where isbin = :isbinNo")
    public Book findByIsbin(@Param("isbinNo") String isbinNo);
		
	}
		

