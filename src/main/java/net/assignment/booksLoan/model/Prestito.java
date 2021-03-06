package net.assignment.booksLoan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Prestito{

	@Column(name = "data_inizio")
    private String data_inizio;
	@Column(name = "data_consegna")
    private String data_consegna;
	@Id
	@Column(name = "isbn")
    private Long isbn;

	@Column(name = "n_tessera")
    private int n_tessera;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="isbn")
    private Copia copia;
    
    public Prestito() {

    }

    public String getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(String data_inizio) {
        this.data_inizio = data_inizio;
    }

    // https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/composite-primary-key.html
    public String getData_consegna() {
        return data_consegna;
    }

    public void setData_consegna(String data_consegna) {
        this.data_consegna = data_consegna;
    }

    public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public int getN_tessera() {
        return n_tessera;
    }

    public void setN_tessera(int n_tessera) {
        this.n_tessera = n_tessera;
    }

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	@Override
	public String toString() {
		return "Prestito [data_inizio=" + data_inizio + ", data_consegna=" + data_consegna + ", isbn=" + isbn
				+ ", n_tessera=" + n_tessera + ", copia=" + copia + "]";
	}  
	
}
