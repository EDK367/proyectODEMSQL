package view.analisisLexico;

import java.io.*;

import lexico.Lexer;
import tokenEnum.Tokens;

public class analisisLex {

    public String analisis(String texto){
        File archivo = new File("lectura");
        PrintWriter escritura = null;

        try {
            escritura = new PrintWriter(archivo);
            escritura.println(texto);
            escritura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error en la lectura del archivo " + e);
        }


        try {
            Reader lectura = new BufferedReader(new FileReader(archivo));
            Lexer lexer = new Lexer(lectura);
            String resultado = "";
            while(true){
                Tokens tokens = lexer.yylex();
                System.out.println("Es el token: " + tokens + " Y la palabra: " + lexer.yytext());
                if(tokens == null){
                    System.out.println("Si llega aca al if");
                    resultado += "Fin del analisis Lexico";
                    return resultado;
                }
                switch (tokens){
                    case RESERVADA -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case PRIMARYKEY -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case SECONDKEY -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  TIPO -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  NULO -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  NONULO -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  LOGICO -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  LPAREN -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  RPAREN -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  CONCAT -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  PCOMA -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  CHAR -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  STRING -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  DIGIT -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  IDENTIFICADOR -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  COMENTARIO -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    case  ERROR -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                    default -> resultado += lexer.lexeme + " Es: " + tokens + " Se encuentra en (" + lexer.yyLine+ "," + lexer.yyColumn +")\n";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
