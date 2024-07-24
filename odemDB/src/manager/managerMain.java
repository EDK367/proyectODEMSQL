package manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class managerMain {

    public static void main(String[] args) {
        String rutaLexico = "C:/Users/denil/OneDrive/Escritorio/odemDB/src/lexico/Lexer.flex";
        String rutaLexCup = "C:/Users/denil/OneDrive/Escritorio/odemDB/src/sintactico/LexerCup.flex";
        String[] rutaCup = {"-parser", "Sintax", "C:/Users/denil/OneDrive/Escritorio/odemDB/src/sintactico/Sintax.cup"};
        try {
            creator(rutaLexico,rutaLexCup, rutaCup);
        } catch (Exception ex) {
            System.out.println("ERROR EN CREAR " + ex);
        }
    }

    public static void creator(String ruta1, String ruta2, String[] ruta3) throws IOException, Exception {
        File archivo;
        //archivo = new File(ruta1);
        //JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(ruta3);

        moveFile("C:/Users/denil/OneDrive/Escritorio/odemDB/sym.java", 
                 "C:/Users/denil/OneDrive/Escritorio/odemDB/src/sintactico/sym.java");
        
        moveFile("C:/Users/denil/OneDrive/Escritorio/odemDB/Sintax.java", 
                 "C:/Users/denil/OneDrive/Escritorio/odemDB/src/sintactico/Sintax.java");
    }

    //no se porque me genero error y chat gpt hizo esto
    private static void moveFile(String sourcePathStr, String targetPathStr) throws IOException {
        Path sourcePath = Paths.get(sourcePathStr);
        Path targetPath = Paths.get(targetPathStr);
        if (Files.exists(targetPath)) {
            Files.delete(targetPath);
        }
        Files.move(sourcePath, targetPath);
    }
}
