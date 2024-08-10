package com.intern.book.repository;

import com.intern.book.entity.BookTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypesRepository extends JpaRepository<BookTypes, Long> {
   boolean existsByName(String name);
}
