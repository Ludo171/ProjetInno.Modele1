package Simulation;

import java.util.ArrayList;
import java.util.Iterator;

public class Marche {

	public double production;
	public double tauxInteret;
	
	
	public Marche(){
		this.production = 0;
		this.tauxInteret = 0.1;
	}
	
	
	public void remunerer(ArrayList<Agent> agents){
		
		double normalisation = 0;
		for (Agent agent : agents) {
			normalisation += agent.getMu();
		}
		
		for (Agent agent : agents) {
			agent.setRevenuTravail(agent.getRichesse() + (agent.getMu()/normalisation)*this.production);
			agent.setRevenuCapital(agent.getInvest()*this.tauxInteret);
		}

		this.production=0;
		
	}


	
	
	
}
