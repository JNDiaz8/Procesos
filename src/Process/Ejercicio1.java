package Process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String [] args) {

		// Obtener el Runtime
		Runtime runtime = Runtime.getRuntime();

		// Creamos el comando como una cadena
		// String comando = "ls -l";

		// Creamos el comando como una coleccion de cadenas
		String[] comando = {"ls", "-l"};
		// Directorio de trabajo
		File directorio = new File("/home/matinal");
		// Creamos el proceso con el metedo exec de Runtime
		BufferedReader in = null;
		try {
			Process proceso = runtime.exec(comando, null, directorio);
			in  = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			// Obtengo el inputstream del proceso
			String linea;
			while ((linea  = in.readLine()) != null)
				System.out.println(linea);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cierre de flujos
			if (in != null) //Evitamos un nullPointerException{
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
