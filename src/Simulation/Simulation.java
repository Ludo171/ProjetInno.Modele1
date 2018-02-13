package Simulation;

import java.util.ArrayList;

public class Simulation {

	public int nbAgents;
	public ArrayList<Agent> agents;
	
	public Marche marche;
	public Etat etat;
	
	public double richesseTotale;
	public int time;
	
	
	
	public void initSimu(){
		
		this.time = 0;
		
		this.marche = new Marche();
		
		this.agents = new ArrayList<Agent>();
		double richesseInitiale = this.richesseTotale/this.nbAgents;
		for (int i = 0; i < this.nbAgents ; i++) {
			agents.add(new Agent(this.marche, richesseInitiale, Math.random(), 0.2) );
		}
		
		
		this.etat = new Etat();
	}

	
	public void nextStep(){
		
		// ---- CONSO & INVEST
		for (Agent agent : agents) {
			agent.consommation();
			agent.epargneinvest();
		}
		
		// ---- REMUNERATION
		marche.remunerer(agents);
		
		// ---- TAXATION
		etat.taxer(agents);
		
		
		// ---- MORTS
		for (Agent agent : agents) {
			
			if(agent.getAge() >= 50 ){
				
				this.marche.production += agent.getRichesse();
				agents.remove(agent);
			}			
		}
		
		// ---- NAISSANCES
		for (Agent agent : agents) {
			
			boolean nique = false;
			
			if ( Math.random() < 0.02 ){
				nique = true;
			}
			
			if (nique){
				double richesseNouveauNe = agent.getRichesse()*0.1;
				agent.setRichesse(agent.getRichesse()*0.9);
				
				double muNouveauNe = agent.getMu();
				
				agents.add(new Agent(this.marche, richesseNouveauNe, muNouveauNe, 0.2) );
			}	
		}
		
		// ---- VIEILLISSEMENT
		for (Agent agent : agents) {
			agent.setAge(agent.getAge()+1);
		}		
		
	}
	
	
	public void runSimu(){
		
		while (this.time < 50) {
			this.nextStep();
			this.time += 1;
		}
		
	}

	
	public void diplay(){
		
	}
	
	
	public void writeData(){
		
	}
	

	public static void main(String[] args) {
		
		Simulation simu = new Simulation();
		simu.initSimu();
		simu.runSimu();
		
	}
}
