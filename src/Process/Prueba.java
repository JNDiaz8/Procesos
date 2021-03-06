package Process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

	public static void main(String[] args) {
		List<String> comandos = new ArrayList<>();
		comandos.add("ls");
		comandos.add("-l");

		ProcessBuilder pb = new ProcessBuilder(comandos);
		pb.directory(new File("."));

		BufferedReader in = null;
		
		Writer out = null;

		try {
			Process proceso = pb.start();
			in = new BufferedReader(
					new InputStreamReader(proceso.getInputStream()));
			String linea;
			while ((linea  = in.readLine()) != null)
				System.out.println(linea);
			
			out = new BufferedWriter(
					new OutputStreamWriter(linea));
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
