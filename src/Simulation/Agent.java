package Simulation;

public class Agent {
	
	private int id;
	public static int compteurAgentsId;
	private int age;
	
	private Marche marche;
	private double richesse;
	private double mu;
	private double probaMort;
	private double probaEnfant;
	
	private double conso;
	private double invest;
	private double alpha;
	
	private double revenuTravail;
	private double revenuCapital;	
	

	public Agent(Marche marche, double richesseInitiale, double mu, double alpha){
		
		this.id = this.compteurAgentsId;
		this.compteurAgentsId+=1;
		
		this.age = 0;
		this.marche = marche;
		this.richesse = richesseInitiale;
		this.mu=mu;
		this.alpha = alpha;

	}
	
	
	public void consommation(){
		
		this.conso = alpha*richesse;
		this.richesse -= this.conso;
		this.marche.production += this.conso;
		
	}
	
	public void epargneinvest(){
		this.invest = this.richesse;
		this.richesse-= this.invest;
		this.marche.production += this.invest;	
				
	}
	
	public void mourir(){
		
		
	}
 
	public void donnerNaissance(){
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public static int getCompteurAgentsId() {
		return compteurAgentsId;
	}


	public static void setCompteurAgentsId(int compteurAgentsId) {
		Agent.compteurAgentsId = compteurAgentsId;
	}


	public Marche getMarche() {
		return marche;
	}


	public void setMarche(Marche marche) {
		this.marche = marche;
	}


	public double getRichesse() {
		return richesse;
	}


	public void setRichesse(double richesse) {
		this.richesse = richesse;
	}


	public double getMu() {
		return mu;
	}


	public void setMu(double mu) {
		this.mu = mu;
	}


	public double getConso() {
		return conso;
	}


	public void setConso(double conso) {
		this.conso = conso;
	}


	public double getInvest() {
		return invest;
	}


	public void setInvest(double invest) {
		this.invest = invest;
	}


	public double getAlpha() {
		return alpha;
	}


	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	
	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getProbaMort() {
		return probaMort;
	}


	public void setProbaMort(double probaMort) {
		this.probaMort = probaMort;
	}


	public double getProbaEnfant() {
		return probaEnfant;
	}


	public void setProbaEnfant(double probaEnfant) {
		this.probaEnfant = probaEnfant;
	}


	public double getRevenuTravail() {
		return revenuTravail;
	}


	public void setRevenuTravail(double revenuTravail) {
		this.revenuTravail = revenuTravail;
	}


	public double getRevenuCapital() {
		return revenuCapital;
	}


	public void setRevenuCapital(double revenuCapital) {
		this.revenuCapital = revenuCapital;
	}
	

	
}
