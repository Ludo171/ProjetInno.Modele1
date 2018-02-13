package Simulation;

import java.util.ArrayList;

public class Etat {

	private double recettes_taxe;
	private double tauxSurRevenuTravail;
	private double tauxSurRevenuCapital;
	private double tauxSurRichesse;
	
	
	public Etat(){
		this.recettes_taxe=0;
		this.tauxSurRevenuTravail = 0.01;
		this.tauxSurRevenuCapital = 0.01;
		this.tauxSurRichesse = 0.01;
	}
	
	public void taxer(ArrayList<Agent> agents){
		
		this.recettes_taxe=0;
		
		for (Agent agent : agents) {
			agent.setRichesse(agent.getRichesse() - agent.getRevenuTravail()*this.tauxSurRevenuTravail);
			this.recettes_taxe += agent.getRevenuTravail()*this.tauxSurRevenuTravail;
			agent.setRichesse(agent.getRichesse() - agent.getRevenuCapital()*this.tauxSurRevenuCapital);
			this.recettes_taxe += agent.getRevenuCapital()*this.tauxSurRevenuCapital;	
		}
		
		//Attention,  si les agents ne font pas tous parti du même marché ça ne sera pas valable
		agents.get(0).getMarche().production = this.recettes_taxe;
		
	}
	
	
	
	
}
