package net.assignment.booksLoan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.assignment.booksLoan.model.Copia;
import net.assignment.booksLoan.repository.CopiaRepository;

@Service
@Transactional
public class CopieService {

    @Autowired
    private CopiaRepository repo;

    public List<Copia> CopieId(int id){
        return repo.findCopieById(id);
    }

    public String TitoloId(int id){
        return repo.findTitoloById(id);
    }

    public void prenota(Long isbn) {
        repo.setCopiaPrenotata(isbn);
    }
    
    public int getN_tessera(String username) {
    	return repo.getN_tessera(username);
    }
    
    public void setUtentePrestito(int n_tessera, Long isbn) {
    	repo.setUtentePrestito(n_tessera, isbn);
    }
    public Copia get(int id) {
        return repo.findById(id).get();
    }

	
}
