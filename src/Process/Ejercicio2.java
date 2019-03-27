package Process;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Generamos los comandos
		List<String> comandos = new ArrayList<>();
		comandos.add("ping");
		comandos.add("-c3");
		comandos.add("www.google.es");
		
		// Creamos el processBuilder
		
		ProcessBuilder pb = new ProcessBuilder(comandos);
		pb.directory(new File("."));
		
		BufferedInputStream in = null;
		
		// Obtener el objeto Process
		try {
			Process process = pb.start();
			// Trabajamos en flujo de bytes (no recomendable)
			in = new BufferedInputStream(
					process.getInputStream());
			int byteLeido;
			while ((byteLeido = in.read()) != -1)
				System.out.print((char)byteLeido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in != null)
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
