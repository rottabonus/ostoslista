package ostoslista.model;

public class Ostos {

	private int id;
	private String nimi;
	private int maara;
	private String kuvaus;
	private double hinta;
	
	//parametrillinen konstruktori
	public Ostos(int id, String nimi, int maara, String kuvaus, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.maara = maara;
		this.kuvaus = kuvaus;
		this.hinta = hinta;
	}

	//parametriton konstruktori
	public Ostos() {
		super();
		this.id = 0;
		this.nimi = null;
		this.maara = 0;
		this.kuvaus = null;
		this.hinta = 0;
	}

	
	//setterit
	public void setId(int id) {
		this.id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	//getterit
	public int getId() {
		return id;
	}

	public String getNimi() {
		return nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public double getHinta() {
		return hinta;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}
	
	
	
	
}
