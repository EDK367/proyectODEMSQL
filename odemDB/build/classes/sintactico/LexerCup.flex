package sintactico;

import java_cup.runtime.*;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%column

// Definición de patrones
L = [a-zA-Z_]+
D = [0-9]+
space = [ \t\r\n]+

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
%%
// Ignorar espacios en blanco
{space} { /*IGNORE*/ }

// Tokens definidos por el usuario
"," { return symbol(sym.CONCAT, yytext()); }
crafter | CRAFTER { return symbol(sym.CREATE, yytext()); }
inventory | INVENTORY { return symbol(sym.TABLE, yytext()); }
chest | CHEST { return symbol(sym.DATABASE, yytext()); }
select | SELECT { return symbol(sym.SELECT, yytext()); }
block | BLOCK { return symbol(sym.INSERT, yytext()); }
RENEW | renew { return symbol(sym.UPDATE, yytext()); }
delete | DELETE { return symbol(sym.DELETE, yytext()); }
mine | MINE { return symbol(sym.WHERE, yytext()); }
group | GROUP { return symbol(sym.GROUP, yytext()); }
board | BOARD { return symbol(sym.FROM, yytext()); }
not | NOT { return symbol(sym.NOT, yytext()); }
order | ORDER { return symbol(sym.ORDER, yytext()); }
references | REFERENCES { return symbol(sym.REFERENCES, yytext()); }
open | OPEN { return symbol(sym.SHOW, yytext()); }
True | true | False | false { return symbol(sym.BOOLEANO, yytext()); }
diamond | DIAMOND { return symbol(sym.PRIMARYKEY, yytext()); }
netherite | NETHERITE { return symbol(sym.SECONDKEY, yytext()); }
int { return symbol(sym.INT, yytext()); }
string { return symbol(sym.STRING, yytext()); }
char { return symbol(sym.CHAR, yytext()); }
null | NULL { return symbol(sym.NULL, yytext()); }
nonull | NONULL { return symbol(sym.NONULL, yytext()); }
"&&" { return symbol(sym.AND, yytext()); }
"||" { return symbol(sym.OR, yytext()); }
"!=" { return symbol(sym.NOIGUAL, yytext()); }
"=" { return symbol(sym.IGUAL, yytext()); }
"(" { return symbol(sym.LPAREN, yytext()); }
")" { return symbol(sym.RPAREN, yytext()); }
";" { return symbol(sym.PCOMA, yytext()); }
"'"([a-zA-Z0-9])"'" { return symbol(sym.ISCHAR, yytext()); }
\"([^\"]*)\" { return symbol(sym.ISSTRING, yytext()); }
{D}+ { return symbol(sym.DIGIT, yytext()); }
{L}+({L}|{D})* { return symbol(sym.IDENTIFICADOR, yytext()); }

// Comentarios de una línea
"//".* { /*IGNORE*/ }

// Manejo de errores
. { return symbol(sym.ERROR, "Error léxico: '" + yytext() + "' en línea " + yyline + ", columna " + yycolumn); }


