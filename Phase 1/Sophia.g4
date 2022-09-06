grammar Sophia;

sophia : prog EOF ;
prog :  my_class+ ;

type_kw
    : BOOL | KW_INT | KW_STRING | list_kw | IDENTIFIER | funcPtr | my_new;


list_kw
    : lk2| lk3;

lk1
    : LIST LPAR ((type_kw COMMA)* type_kw)? RPAR ;
lk2
    : LIST LPAR  ((IDENTIFIER COLON type_kw | type_kw )COMMA)* (IDENTIFIER COLON type_kw | type_kw) RPAR ;
lk3
    : LIST LPAR INT SHARP type_kw RPAR ;

list_mem
    : LBRACK (((expr | list_mem) COMMA)* (expr | list_mem))? RBRACK;


var_dec
    : (THIS DOT)? r = IDENTIFIER
     {System.out.println("VarDec:" + $r.text);} COLON type_kw DELIM
     ;

primitive
    : string | INT | bool;

funcPtr
    : FUNC REL1 ((type_kw (COMMA type_kw)*) | KW_VOID ) ARROW (type_kw | KW_VOID) REL2 ;


string
    :  STRING ;
bool
    : TRUE | FALSE ;

identifier
    : IDENTIFIER ;

func_call:
    IDENTIFIER LPAR ((expr COMMA)* expr)? RPAR;


expr : assign | fasl;
assign : fasl AS  expr {System.out.println("Operator:=");};
fasl : atf OR  fasl {System.out.println("Operator:||");} | atf;
atf : comp AND  atf {System.out.println("Operator:&&");} | comp;

comp : relation a*;
a : REL3 relation {System.out.println("Operator:==");} | REL4  relation {System.out.println("Operator:!=");};
relation : mp b*;
b : REL1 mp {System.out.println("Operator:<");} |  REL2  mp {System.out.println("Operator:>");};

mp : dm c*;
c:  PLUS dm {System.out.println("Operator:+");}|  MINUS dm {System.out.println("Operator:-");};



dm : pre1op d*;
d : MULT pre1op {System.out.println("Operator:*");} |
      DIV pre1op {System.out.println("Operator:/");}|
     REM pre1op  {System.out.println("Operator:%");};


pre1op : PP post1op {System.out.println("Operator:++");} | MM post1op{System.out.println("Operator:--");}
            | NOT post1op {System.out.println("Operator:!");}
                | MINUS  post1op {System.out.println("Operator:-");}  | post1op;
post1op : access_list (PP {System.out.println("Operator:++");} | MM{System.out.println("Operator:--");}) | access_list;
access_list : temp LBRACK expr RBRACK (LBRACK expr RBRACK)* (term)? | temp;
temp : access_mem | IDENTIFIER | bool | string | INT | LPAR expr RPAR| list_mem | my_new;
access_mem : (IDENTIFIER | THIS | func_call (LPAR ((expr COMMA)* expr)? RPAR)* |primitive |LPAR expr RPAR | my_new | list_kw) term |  func_call (LPAR ((expr COMMA)* expr)? RPAR)*;
term : DOT rightdot;
rightdot :(IDENTIFIER | THIS | access_list | func_call (LPAR ((expr COMMA)* expr)? RPAR)*) DOT rightdot | IDENTIFIER | func_call (LPAR ((expr COMMA)* expr)? RPAR)*;




my_class
    :  CLASS  r1= identifier (EXTENDS r2 =identifier)?
    {if ($r2.text == null)
            System.out.println("ClassDec:" + $r1.text);
            else
            System.out.println("ClassDec:" + $r1.text + "," + "$r2.text");} classScope
         ;

classScope :  LBRACE  (method | var_dec )*  constructor? (method | var_dec)* RBRACE ;


my_new : NEW func_call ;

my_for : FOR {System.out.println("Loop:for");} LPAR (assign)? DELIM (expr)? DELIM (assign)?  RPAR (scope | line );

foreach
    : FOREACH {System.out.println("Loop:foreach");} LPAR identifier IN  expr RPAR (scope | line );

print : PRINT  {System.out.println("Built-in:print");} LPAR expr RPAR ;

ifst : IF {System.out.println("Conditional:if");}
        LPAR expr RPAR;

del : print |  BREAK  {System.out.println("Control:break");} | CONTINUE {System.out.println("Control:continue");}|
        assign | returnVal | func_call {System.out.println("MethodCall");}
        |access_mem LPAR ((expr COMMA)* expr)? RPAR {System.out.println("MethodCall");}
        | temp LBRACK expr RBRACK (LBRACK expr RBRACK)* (term)? LPAR ((expr COMMA)* expr)? RPAR {System.out.println("MethodCall");};



conditionalStmt : ifStmt | ifst mline ELSE {System.out.println("Conditional:else");} mline |
            ifst LBRACE mst RBRACE ELSE {System.out.println("Conditional:else");} mline
            | ifst mline ELSE {System.out.println("Conditional:else");} LBRACE mst RBRACE
            |  ifst LBRACE mst RBRACE ELSE {System.out.println("Conditional:else");} LBRACE mst RBRACE;

ifStmt :  ifst scope | ifst line ;

unmatchedIf :
            ifst mline ELSE {System.out.println("Conditional:else");} uline |
            ifst mline ELSE {System.out.println("Conditional:else");} LBRACE ust RBRACE
            | ifst LBRACE mst RBRACE ELSE {System.out.println("Conditional:else");} uline
            | ifst LBRACE mst RBRACE ELSE {System.out.println("Conditional:else");} LBRACE ust RBRACE;



mline : del DELIM | my_for | foreach | conditionalStmt;
uline : unmatchedIf;
line : mline | uline ;
mst : mline*;
ust : (uline | mline)* uline (uline | mline)*;
stmt : mst | ust ;
scope : LBRACE stmt RBRACE;

method
    : KW_DEF (type_kw | KW_VOID)  r =IDENTIFIER {System.out.println("MethodDec:" + $r.text);} LPAR ((values COMMA)* values)? RPAR method_scope
     ;

values:
    IDENTIFIER ':' type_kw;

method_scope:
    LBRACE (var_dec)* stmt  returnVal? RBRACE;

returnVal
    : (RET expr? DELIM)
    {System.out.println("Return");} ;

constructor:
       KW_DEF r = IDENTIFIER ((LPAR (values COMMA)* values RPAR) | (LPAR RPAR)) {System.out.println("ConstructorDec:" + $r.text);}
       method_scope
        ;



COMMENT : '//' .*? '\n' -> skip;
KW_VOID : 'void';
KW_DEF : 'def';
RET : 'return' ;

FUNC : 'func';

IF : 'if' ;
ELSE : 'else' ;

FOR : 'for' ;
BREAK : 'break' ;
CONTINUE  : 'continue' ;
FOREACH : 'foreach' ;
IN : 'in' ;

LIST : 'list' ;

FALSE : 'false' ;
TRUE : 'true' ;
BOOL : 'bool' ;
NULL :'null';
PRINT :'print';

KW_INT : 'int' ;
KW_STRING : 'string';

CLASS : 'class';
EXTENDS : 'extends';
THIS : 'this' ;
NEW : 'new' ;
STRING  : '"' ~('"')+ '"' ;


INT  :   ZERO | INTPOS ;
INTPOS : [1-9][0-9]*;
ZERO : '0';

LBRACE : '{';
RBRACE : '}' ;
LBRACK : '[';
RBRACK : ']' ;
LPAR : '(';
RPAR : ')' ;
DELIM : ';' ;
SHARP : '#' ;
DOT : '.';
COLON : ':';
PLUS : '+';
MULT : '*';
DIV : '/';
REM : '%';
NOT : '!' ;
MINUS : '-' ;
PP :'++' ;
MM : '--' ;
COMMA : ',';
ARROW : '->' ;
OR : '||';
AND : '&&';
AS : '=' ;

REL1 : '<';
REL2 : '>';
REL3 : '==';
REL4 : '!=';


IDENTIFIER :   [a-zA-Z_][a-zA-Z0-9_]* ;

WS :   [ \t\r\n]+ -> skip ;