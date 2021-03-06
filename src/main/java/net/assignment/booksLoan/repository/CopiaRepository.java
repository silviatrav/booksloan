package net.assignment.booksLoan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.assignment.booksLoan.model.Copia;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, Long> {

	@Query(value = "SELECT * FROM Copia c JOIN Libro l on c.id = l.id where c.id = ?1", nativeQuery = true)
	public List<Copia> findCopieById(int id);

	@Modifying
	@Query(value = "UPDATE Copia SET disponibilita = 0 WHERE isbn = ?1", nativeQuery = true)
	public void setCopiaPrenotata(Long isbn);

	@Modifying
	@Query(value = "INSERT INTO Prestito (data_consegna, n_tessera, isbn) VALUES (timestampadd(month,1,current_timestamp), ?1, ?2)", nativeQuery = true)
	public void setUtentePrestito(int n_tessera, Long isbn);
	
	@Modifying
	@Query(value = "INSERT INTO Copia (isbn, id, disponibilita) VALUES (?1, ?2, ?3)", nativeQuery = true)
	public void setCopia(Long isbn, int id, boolean disponibilita);

	@Query(value = "SELECT u.n_tessera FROM Utente u WHERE u.username = ?1", nativeQuery = true)
	public int getN_tessera(String username);

	@Modifying
	@Query(value = "UPDATE Copia SET disponibilita = 1 WHERE isbn = ?1", nativeQuery = true)
	public void restituisciISBN(Long isbn);

}