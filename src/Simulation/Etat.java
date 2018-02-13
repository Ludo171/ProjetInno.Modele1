package Simulation;

import java.util.ArrayList;

public class Etat {

	private double recettes_taxe;
	private double tauxSurRevenuTravail;
	private double tauxSurRevenuCapital;
	private double tauxSurRichesse;
	
	
	public Etat(){
		this.recettes_taxe=0;
	}
	
	public void taxer(ArrayList<Agent> agents){
		
		for (Agent agent : agents) {
			
			agent.setRichesse(agent.getRichesse() - agent.getRevenuTravail()*(1-this.tauxSurRevenuTravail));
			agent.setRichesse(agent.getRichesse() - agent.getRevenuCapital()*(1-this.tauxSurRevenuCapital));
			
		}
		
		
	}
	
	
	
	
}
