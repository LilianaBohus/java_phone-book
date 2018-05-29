
public class Nevjegy {
	
	private String nev;
	private String foglalkozas;
	private String lakcim;
	private String email;
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getFoglalkozas() {
		return foglalkozas;
	}
	public void setFoglalkozas(String foglalkozas) {
		this.foglalkozas = foglalkozas;
	}
	public String getLakcim() {
		return lakcim;
	}
	public void setLakcim(String lakcim) {
		this.lakcim = lakcim;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Nevjegy(String nev, String foglalkozas, String lakcim, String email) {
		super();
		this.nev = nev;
		this.foglalkozas = foglalkozas;
		this.lakcim = lakcim;
		this.email = email;
	}

}
