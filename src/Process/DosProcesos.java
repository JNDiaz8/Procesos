package Process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DosProcesos {

	public static void main(String[] args) {
		
		List<String> comandos1 = new ArrayList<>();
		comandos1.add("ls");
		
		ProcessBuilder pb = new ProcessBuilder(comandos1);
		pb.directory(new File("/home/matinal"));
		
		Runtime runtime = Runtime.getRuntime();
		String[] comandos2 = {"wc" , "-w"};
		
		BufferedReader in1 = null;
		BufferedReader in2 = null;
		PrintWriter out = null;
		
		try {
			
			Process proceso1 = pb.start();
			
			Process proceso2 = runtime.exec(comandos2);
			
			// Lectura de comando BufferedReader
			
			in1 = new BufferedReader(
					new InputStreamReader(proceso1.getInputStream()));
			
			// Escritura de comando con PrintWriter
			
			out = new PrintWriter(proceso2.getOutputStream());
			
			// Salida del 1 Buffered
			String linea;
			while((linea = in1.readLine()) != null) {
				System.out.println(linea);
				out.write(linea + "\n");
			}
			
			// Lectura de la escritura que hemos realizado
			
			in2 = new BufferedReader(
					new InputStreamReader(proceso2.getInputStream()));
			
			// Salida del 2 Buffered
			while((linea = in2.readLine()) != null) {
				System.out.println("Numero de palabras: " + linea);

			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in1 != null)
				in1.close();
				if(out != null)
				out.close();
				if(in2 != null)
					in2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
