package Simulation;

import java.io.IOException;
import java.util.ArrayList;

public class Simulation {

	public String simuName;
	
	public int nbAgents;
	public ArrayList<Agent> agents;
	public ArrayList<Agent> cimetiere;
	
	public Marche marche;
	public Etat etat;
	
	public double richesseTotale;
	public int time;
	
	
	
	public void initSimu(){
		
		this.simuName = "Modèle1.essai0";

		this.time = 0;
		this.marche = new Marche();
		this.nbAgents = 500;
		this.richesseTotale = 50000.0;
		
		this.cimetiere = new ArrayList<Agent>();
		this.agents = new ArrayList<Agent>();
		double richesseInitiale = this.richesseTotale/this.nbAgents;
		for (int i = 0; i < this.nbAgents ; i++) {
			agents.add(new Agent(this.marche, richesseInitiale, Math.random(), 0.2) );
		}
		
		
		this.etat = new Etat();
	}

	
	public void nextStep(){
		
		System.out.println("DEBUT PAS");
		System.out.println(Display.displayResultatsGlobaux(this));
		// ---- CONSO & INVEST
		for (Agent agent : this.agents) {
			agent.consommation();
			agent.epargneinvest();
		}
		
		//System.out.println("APRES CONSO&INVEST");
		//System.out.println(Display.displayResultatsGlobaux(this));
		// ---- REMUNERATION
		marche.remunerer(this.agents);
		
		//System.out.println("APRES REMUNERATION");
		//System.out.println(Display.displayResultatsGlobaux(this));
		// ---- TAXATION
		etat.taxer(this.agents);
		
		//System.out.println("APRES TAXATION");
		//System.out.println(Display.displayResultatsGlobaux(this));
		// ---- MORTS
		int tailleListe = this.agents.size();
		int compteur = 0;
		while (compteur < tailleListe) {
			
			if(this.agents.get(compteur).getAge() >= 50 ){
				this.marche.production += this.agents.get(compteur).getRichesse();
				cimetiere.add(this.agents.get(compteur));
				agents.remove(this.agents.get(compteur));
				tailleListe -=1;
			}			
			else{
				compteur +=1;
			}
		}
		
		//System.out.println("APRES MORTS");
		//System.out.println(Display.displayResultatsGlobaux(this));
		// ---- VIEILLISSEMENT
		for (Agent agent : agents) {
			agent.setAge(agent.getAge()+1);
		}	
		
		
		//System.out.println("APRES VIEILLISSEMENT");
		//System.out.println(Display.displayResultatsGlobaux(this));
		// ---- NAISSANCES
		this.nbAgents = this.agents.size();
		for (int i = 0; i < this.nbAgents; i++) {
			boolean nique = false;
			if ( Math.random() < 0.02 ){
				nique = true;
			}
			if (nique){
				double richesseNouveauNe = this.agents.get(i).getRichesse()*0.1;
				this.agents.get(i).setRichesse(this.agents.get(i).getRichesse()*0.9);
				
				double muNouveauNe = this.agents.get(i).getMu();
				
				this.agents.add(new Agent(this.marche, richesseNouveauNe, muNouveauNe, 0.2) );
			}	
		}
		
	
		
	}
	
	
	public void runSimu(){
		
		while (this.time < 200) {
			this.nextStep();
			this.time += 1;
		}
		
	}

	

	public static void main(String[] args) throws IOException {
		
		Simulation simu = new Simulation();
		simu.initSimu();
		Writer writer = new Writer(simu);
		
		simu.runSimu();
		
		writer.writeInfo(Display.displayResultatsGlobaux(simu));
		
		writer.closeWriting();
		
		
	}
}
