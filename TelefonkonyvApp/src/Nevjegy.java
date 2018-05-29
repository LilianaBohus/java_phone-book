
public class Nevjegy {
	
	private String nev;
	private String foglalkozas;
	private String lakcim;
	private String email;

	// TIPP: Getter es Setter fuggvenyeket legeneralni a Source --> Generate Getters and Setters paranccsal tudunk.
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
	
	// TIPP: Konstruktort generalni a Source --> Generate Constructor using fields... paranccsal tudunk.
	public Nevjegy(String nev, String foglalkozas, String lakcim, String email) {
		super();
		this.nev = nev;
		this.foglalkozas = foglalkozas;
		this.lakcim = lakcim;
		this.email = email;
	}
	
	// Osszehasonlitja a nevjegyet, amire meghivjak, a parameterben levovel, hogy egyeznek-e az attributumaik.
	public boolean equals(Nevjegy n) {
		if (n.getNev().equals(this.getNev()) && 
			n.getFoglalkozas().equals(this.getFoglalkozas()) && 
			n.getLakcim().equals(this.getLakcim()) &&
			n.getEmail().equals(this.getEmail())){
			return true;
		}
		return false;
	}

}
