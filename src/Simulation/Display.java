package Simulation;

public class Display {

	
	
	public static String displayParam(Simulation simu){
		
		String display = "";
		
		display += "PARAMETRES : \n"
				+  "Nombre de personnes initial : " + simu.nbAgents + "\n";
		
		return display;
	}
	
	public static String displayResultatsGlobaux(Simulation simu){
		
		String display = "";
		
		display += "RESULTATS GLOBAUX : \n"
				+  "Id, age, richesse, mu, probaMort, probaEnfant, alpha, revenuTravail, revenuCapital" + "\n";
		
		for (Agent agent : simu.agents) {
			display += agent.toString();
			display += "\n";
		}
		
		
		
		
		return display;
	}
	
	
	
	
}
