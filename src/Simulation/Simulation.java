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
		
		double richesseInitiale = this.richesseTotale/this.nbAgents;
		for (int i = 0; i < this.nbAgents ; i++) {
			agents.add(new Agent(this.marche, richesseInitiale, Math.random(), 0.2) );
		}
		
		
		this.etat = new Etat();
	}
	
	
	
	public void nextStep(){
		
		for (Agent agent : agents) {
			agent.consommation();
			agent.epargneinvest();
		}
		
		marche.remunerer(agents);
		
		etat.taxer(agents);
		
		for (Agent agent : agents) {
			
			
			agent.mourir();
			
			
			agent.donnerNaissance();
			
			
			
		}
		
	}
	
	
	public void runSimu(){
		
	}
	
	public void writeData(){
		
	}
	
	
	
	
	
	
	
}
