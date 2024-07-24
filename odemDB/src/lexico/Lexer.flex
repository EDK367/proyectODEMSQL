|package lexico;

import tokenEnum.Tokens;
import static tokenEnum.Tokens.*;

%%
%class Lexer
%type Tokens

L = [a-zA-Z_]+
D = [0-9]+
space = [ ,\t,\r,\n]+

%{
    public String lexeme;
    public int yyLine = 1;
    public int yyColumn = 1;
%}
%{
   public void position(String text){
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                yyLine++;
                yyColumn = 1;
            }else{
                if(text.charAt(i) == ' '){
                    yyColumn++;
                }
            }
        }
   }
%}

%%
"," {lexeme=yytext(); position(yytext()); return CONCAT;}
crafter | CRAFTER |
select | SELECT |
chest  | CHEST |
block | BLOCK |
RENEW | renew |
delete | DELETE |
inventory | INVENTORY |
mine | MINE |
group | GROUP |
board | BOARD |
not | NOT |
order | ORDER |
True | False |
true | false |
references | REFERENCES
|OPEN {lexeme=yytext(); position(yytext()); return RESERVADA;}
{space} {position(yytext());}
diamond | DIAMOND   {lexeme=yytext(); position(yytext()); return PRIMARYKEY;}
netherite | NETHERITE   {lexeme=yytext(); position(yytext()); return SECONDKEY;}
int | string | char {lexeme=yytext(); position(yytext()); return TIPO;}
null | NULL {lexeme=yytext(); position(yytext()); return NULO;}
nonull | NONULL {lexeme=yytext(); position(yytext()); return NONULO;}
"&&" | "||" | "!=" | "=" {lexeme=yytext(); position(yytext()); return LOGICO;}
"(" {lexeme=yytext(); position(yytext()); return LPAREN;}
")" {lexeme=yytext(); position(yytext()); return RPAREN;}
";" {lexeme=yytext(); position(yytext()); return PCOMA;}
"'"([a-zA-Z0-9])"'" { lexeme = yytext(); position(yytext()); return CHAR; }
\"([^\"]*)\" { lexeme = yytext(); position(yytext()); return STRING;}
{D}+ {lexeme=yytext(); position(yytext()); return DIGIT;}
{L}+({L} | {D})* {lexeme=yytext(); position(yytext()); return IDENTIFICADOR;}
"//".* {lexeme=yytext(); position(yytext()); return COMENTARIO;}
 . {lexeme=yytext(); position(yytext()); return ERROR;}



