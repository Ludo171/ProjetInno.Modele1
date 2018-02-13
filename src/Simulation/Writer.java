package Simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	File file;
	FileWriter writer;
	
	
	public Writer(Simulation simu) throws IOException{
		this.file = new File("Projet_Inno_Simulation_" + simu.simuName + ".txt");
		// creates the file
		file.createNewFile();
		// create a file 
		this.writer = new FileWriter(file);
		this.writer.write("COMPTE RENDU DE LA SIMULATION " + simu.simuName + "\n");
		
	}
	
	public void writeInfo(String info) throws IOException{

			this.writer.write(info);
			this.writer.flush();
	}
	
	public void closeWriting() throws IOException{
		this.writer.close();
	}
	
	
}
