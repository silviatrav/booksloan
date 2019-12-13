package net.assignment.booksLoan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.assignment.booksLoan.model.Copia;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, Integer> {


    //https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/
      @Query(value = "SELECT * FROM Copia c JOIN Libro l on c.id = l.id where c.id = ?1", nativeQuery = true)
      public List<Copia> findCopieById(int id);

}
