package users;

public class Admin extends User{
	
	private String nume;
	private long nrTelefon;
	
	public Admin(TipUser tipUser, String numeUtilizator, String parola, String nume, long nrTelefon) {
		super(tipUser, numeUtilizator, parola);
		this.nume = nume;
		this.nrTelefon = nrTelefon;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public long getNrTelefon() {
		return nrTelefon;
	}

	public void setNrTelefon(long nrTelefon) {
		this.nrTelefon = nrTelefon;
	}

	@Override
	public String toString() {
		return " Admin nume=" + nume + ", nrTelefon=" + nrTelefon;
	}

	
}
