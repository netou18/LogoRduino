package projectJFlex;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Iniciando analizador léxico...");

		System.out.println("1 - Generar");
		System.out.println("2 - Ejecutar");
		System.out.println("3 - salir");
		
		Scanner scan = new Scanner(System.in);
		int opcion = scan.nextInt();

		switch (opcion) {

			case 1:
				System.out.println("/nGenerando...");

				String fileLexer = "";
				if (args.length > 0) {
					System.out.println("\n*** Procesando archivo custom ***\n");
					fileLexer = args[0];
				} else {
					System.out.println("\n*** Procesando archivo default ***\n");
					fileLexer = "lexer.flex";
				}
				String[] entrada = { fileLexer };
				jflex.Main.main(entrada);
				// Movemos el archivo generado al directorio src
				File arch = new File("Analyzer.java");
				if (arch.exists()) {
					System.out.println("" + arch);
					Path currentRelativePath = Paths.get("");
					String nuevoDir = currentRelativePath.toAbsolutePath().toString()
							+ File.separator + "src" + File.separator
							+ "analizadorlex" + File.separator + arch.getName();
					File archViejo = new File(".src/projectJFlex/Analyzer.java");
					archViejo.delete();
					if (arch.renameTo(new File("./src/projectJFlex/Analyzer.java"))) {
						System.out.println("\n*** Generado ***\n");
						System.out.println("\n*** Saliendo automaticamente ***\n");
						System.exit(0);
					} else {
						System.out.println("\n*** No generado ***\n");
					}
				} else {
					System.out.println("\n*** Codigo no existente ***\n");
				}
				break;

			case 2:

				break;
			case 3:
				break;
		}
	}

}
