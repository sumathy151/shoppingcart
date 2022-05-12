package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mindtree.shoppingcart.model.BookDetails;


@Repository
public interface BookRepository extends JpaRepository<BookDetails,Integer>
{
   
}
