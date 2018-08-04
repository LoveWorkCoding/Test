package users;

public class User {
	private TipUser tipUser;
	private String numeUtilizator;
	private String parola;
	
	public User(TipUser tipUser, String numeUtilizator, String parola) {
		this.tipUser = tipUser;
		this.numeUtilizator = numeUtilizator;
		this.parola = parola;
	}

	public TipUser getTipUser() {
		return tipUser;
	}

	public void setTipUser(TipUser tipUser) {
		this.tipUser = tipUser;
	}

	public String getNumeUtilizator() {
		return numeUtilizator;
	}

	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	@Override
	public String toString() {
		return "tip user=" + tipUser + ", nume utilizator=" + numeUtilizator + ", parola=" + parola;
	}
	
	

}
