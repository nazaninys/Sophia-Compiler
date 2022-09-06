grammar Sophia;

@header{
    import main.ast.types.*;
    import main.ast.types.functionPointer.*;
    import main.ast.types.list.*;
    import main.ast.types.single.*;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.declaration.classDec.*;
    import main.ast.nodes.declaration.classDec.classMembersDec.*;
    import main.ast.nodes.declaration.variableDec.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.statement.loop.*;
    import java.util.ArrayList;
}

sophia returns[Program sophiaProgram]:
    p = program
    { $sophiaProgram = $p.programRet; }
    EOF;

program returns[Program programRet]:
    { $programRet = new Program();
      $programRet.setLine(1);
    }
    (c = sophiaClass
        {$programRet.addClass($c.sophiaClassRet); }
    )*;

sophiaClass returns [ClassDeclaration sophiaClassRet]:

    c = CLASS id = identifier {$sophiaClassRet = new ClassDeclaration($id.my_id); $sophiaClassRet.setLine($c.getLine());}
    (EXTENDS parid = identifier {$sophiaClassRet.setParentClassName($parid.my_id);})?
    LBRACE (((var1 = varDeclaration {$sophiaClassRet.addField($var1.fieldRet);}
    | met1 = method {$sophiaClassRet.addMethod($met1.methodRet);}
    )* constr = constructor {$sophiaClassRet.setConstructor($constr.constructorRet);}
     (var2 = varDeclaration {$sophiaClassRet.addField($var2.fieldRet);}
     | met2 = method {$sophiaClassRet.addMethod($met2.methodRet);}
     )*) | ((var3 = varDeclaration {$sophiaClassRet.addField($var3.fieldRet);}
     | met3 = method {$sophiaClassRet.addMethod($met3.methodRet);}
     )*)) RBRACE;

varDeclaration returns [VarDeclaration varRet, FieldDeclaration fieldRet]:
    id = identifier COLON t = type SEMICOLLON {$varRet = new VarDeclaration($id.my_id, $t.my_type);
                                               $varRet.setLine($id.my_id.getLine());}
                                               {$fieldRet = new FieldDeclaration ($varRet);
                                               $fieldRet.setLine($id.my_id.getLine());}             ;

method returns [MethodDeclaration methodRet]:
    d = DEF (t = type | v = VOID ) id = identifier {if ($v.text != null) $methodRet = new MethodDeclaration($id.my_id, new NullType());

                                               else {$methodRet = new MethodDeclaration($id.my_id, $t.my_type);}
                                               $methodRet.setLine($d.getLine());}


    LPAR met = methodArguments {$methodRet.setArgs($met.methodargRet);}
    RPAR LBRACE m = methodBody {$methodRet.setLocalVars($m.bodyvarRet);
                                $methodRet.setBody($m.bodystmtRet);}
    RBRACE;

constructor returns [ConstructorDeclaration constructorRet]:
    d = DEF id = identifier {$constructorRet = new ConstructorDeclaration($id.my_id);
                              $constructorRet.setLine($d.getLine());}
    LPAR met = methodArguments {$constructorRet.setArgs($met.methodargRet);}
    RPAR LBRACE m = methodBody {$constructorRet.setLocalVars($m.bodyvarRet);
                                $constructorRet.setBody($m.bodystmtRet);}
    RBRACE;

methodArguments returns [ArrayList<VarDeclaration> methodargRet]:
    {$methodargRet = new ArrayList<>();}
    (var1 = variableWithType {$methodargRet.add($var1.varwithtype);}
    (COMMA var2 = variableWithType {$methodargRet.add($var2.varwithtype);})*)?;

variableWithType returns [VarDeclaration varwithtype]:
    id = identifier COLON t = type {$varwithtype = new VarDeclaration ($id.my_id, $t.my_type);
                                    $varwithtype.setLine($id.my_id.getLine());};

type returns [Type my_type]:
   prim =  primitiveDataType  {$my_type = $prim.primRet;}
   | a = listType {$my_type = $a.listTypeRet;}
   | b = functionPointerType {$my_type = $b.funcptrTypeRet;}
   | c = classType {$my_type = $c.classTypeRet;};

classType returns [ClassType classTypeRet]:
    id = identifier {$classTypeRet = new ClassType($id.my_id);};

listType returns [ListType listTypeRet]:
    LIST LPAR ((size = INT_VALUE SHARP t = type) {$listTypeRet = new ListType(Integer.parseInt($size.text), new ListNameType($t.my_type));}
    | (a = listItemsTypes {$listTypeRet = new ListType($a.listitemstype.getElementsTypes());})) RPAR;

listItemsTypes returns [ListType listitemstype]:
    {$listitemstype = new ListType();}
    l = listItemType {$listitemstype.addElementType($l.listitemtype);}
    (COMMA l2 = listItemType {$listitemstype.addElementType($l2.listitemtype);})*;

listItemType returns [ListNameType listitemtype]:
    a = variableWithType {$listitemtype = new ListNameType($a.varwithtype);}|
    t = type {$listitemtype = new ListNameType($t.my_type);};

functionPointerType returns [FptrType funcptrTypeRet]:
    {$funcptrTypeRet = new FptrType();}
    FUNC LESS_THAN (VOID | a = typesWithComma {$funcptrTypeRet.setArgumentsTypes($a.typecomma);})
    ARROW (VOID {$funcptrTypeRet.setReturnType(new NullType());}| t = type {$funcptrTypeRet.setReturnType($t.my_type);})
    GREATER_THAN;

typesWithComma returns [ArrayList<Type> typecomma]:
    {$typecomma = new ArrayList<>();}
    t1 = type {$typecomma.add($t1.my_type);} (COMMA t2 = type {$typecomma.add($t2.my_type);})*;

primitiveDataType returns [Type primRet]:
    INT {$primRet = new IntType();}
    | STRING {$primRet = new StringType();}
    | BOOLEAN {$primRet = new BoolType();};

methodBody returns [ArrayList<VarDeclaration> bodyvarRet, ArrayList <Statement> bodystmtRet]:
    {$bodyvarRet = new ArrayList<>();
    $bodystmtRet = new ArrayList<>();}
    (v = varDeclaration {$bodyvarRet.add($v.varRet);})*
    (s = statement {$bodystmtRet.add($s.stmt);})*;


statement returns[Statement stmt]: s1 = forStatement {$stmt = $s1.forRet;}
         | s2 = foreachStatement {$stmt = $s2.foreachRet;}
         | s3 = ifStatement {$stmt = $s3.ifRet;}
         | s4 = assignmentStatement {$stmt = $s4.stmt;}
         | s5 = printStatement{$stmt = $s5.stmt;}
         | s6 = continueBreakStatement{$stmt = $s6.stmt;}
         | s7 = methodCallStatement {$stmt = $s7.metstmt;}
         | s8 = returnStatement{$stmt = $s8.stmt;}
         | s9 = block{$stmt = $s9.stmt;};

block returns[BlockStmt stmt] :
  {$stmt = new BlockStmt();}
  lb=LBRACE (st=statement { $stmt.addStatement($st.stmt); })* RBRACE
  { $stmt.setLine($lb.getLine()); };

assignmentStatement returns[AssignmentStmt stmt]: s = assignment SEMICOLLON{$stmt = $s.stmt;};

assignment returns[AssignmentStmt stmt]: l = orExpression as = ASSIGN r = expression
 {$stmt = new AssignmentStmt($l.expr,$r.expr);
  $stmt.setLine($as.getLine());};

printStatement returns[Statement stmt]: p=PRINT LPAR expr=expression RPAR SEMICOLLON
  { $stmt = new PrintStmt($expr.expr);
    $stmt.setLine($p.getLine());
  };

returnStatement returns[Statement stmt]:
     r=RETURN {$stmt = new ReturnStmt(); $stmt.setLine($r.getLine());
               NullValue nul = new NullValue(); nul.setLine($stmt.getLine()); ((ReturnStmt)$stmt).setReturnedExpr(nul);}
     (rexpr = expression {((ReturnStmt)$stmt).setReturnedExpr($rexpr.expr);})? SEMICOLLON
     ;


methodCallStatement returns [MethodCallStmt metstmt]:
 m = methodCall SEMICOLLON {$metstmt = new MethodCallStmt($m.methodcallRet);
                            $metstmt.setLine($m.methodcallRet.getLine());
                            };





methodCall returns[MethodCall methodcallRet]:
   {Expression expr;}
   other = otherExpression {expr = $other.expr; }
  ((par = LPAR m = methodCallArguments RPAR {MethodCall newmet = new MethodCall(expr, $m.metargRet);
                                      newmet.setLine($par.getLine()); expr = newmet;} )
 | (DOT id = identifier {ObjectOrListMemberAccess obj = new ObjectOrListMemberAccess(expr, $id.my_id);
                            obj.setLine($id.my_id.getLine()); expr = obj;})
 | (lb = LBRACK e = expression RBRACK) {ListAccessByIndex ac = new ListAccessByIndex(expr,$e.expr);
                                    ac.setLine($lb.getLine()); expr = ac;})*
  (l = LPAR met = methodCallArguments RPAR {$methodcallRet = new MethodCall(expr, $met.metargRet);})
  {$methodcallRet.setLine($l.getLine());};


methodCallArguments returns [ArrayList<Expression> metargRet]:
    {$metargRet = new ArrayList<>();}
    (ex1 = expression {$metargRet.add($ex1.expr);}
     (COMMA ex2 = expression {$metargRet.add($ex2.expr);}  )*)?;

continueBreakStatement returns[Statement stmt]:
 (b = BREAK {$stmt = new BreakStmt();
             $stmt.setLine($b.getLine());
            }
 |c = CONTINUE {$stmt = new ContinueStmt();
               $stmt.setLine($c.getLine());
               }) SEMICOLLON;

forStatement returns [ForStmt forRet]:
    {$forRet = new ForStmt();}
    f = FOR LPAR (a = assignment {$forRet.setInitialize($a.stmt);})?
    SEMICOLLON (b = expression {$forRet.setCondition($b.expr);})?
    SEMICOLLON (c = assignment {$forRet.setUpdate($c.stmt);})?
    RPAR d = statement {$forRet.setBody($d.stmt);}
    {$forRet.setLine($f.getLine());};


foreachStatement returns [ForeachStmt foreachRet]:
    f = FOREACH LPAR id = identifier IN ex = expression RPAR st = statement
    {$foreachRet = new ForeachStmt($id.my_id, $ex.expr);
     $foreachRet.setBody($st.stmt);}
     {$foreachRet.setLine($f.getLine());};


ifStatement returns [ConditionalStmt ifRet]:
    cond = IF LPAR ex = expression RPAR st = statement {$ifRet = new ConditionalStmt($ex.expr, $st.stmt);}
    (ELSE st2 = statement {$ifRet.setElseBody($st2.stmt);})?
    {$ifRet.setLine($cond.getLine());};

expression returns[Expression expr]: l = orExpression {$expr = $l.expr ;}
(as = ASSIGN r = expression { $expr = new BinaryExpression($l.expr,$r.expr,BinaryOperator.assign);
                               $expr.setLine($as.getLine());})?;

orExpression returns[Expression expr]: l = andExpression {$expr = $l.expr ;}
 ( op = OR r = andExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.or); $expr.setLine($op.getLine());} )*
 ;

andExpression returns[Expression expr]: l = equalityExpression {$expr = $l.expr ;}
( op = AND r = equalityExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.and); {$expr.setLine($op.getLine());} } )*
;

equalityExpression returns[Expression expr]: l = relationalExpression {$expr = $l.expr ;}
(op1 = EQUAL r = relationalExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.eq); }
                                 {$expr.setLine($op1.getLine());}
| op2 = NOT_EQUAL r = relationalExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.neq); }
                                              {{$expr.setLine($op2.getLine());}})*;

relationalExpression returns[Expression expr]: l = additiveExpression {$expr = $l.expr ;}
(op1 = GREATER_THAN r = additiveExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.gt);
                                                {$expr.setLine($op1.getLine());}}
| op2 = LESS_THAN r = additiveExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.lt);
                                        {$expr.setLine($op2.getLine());}} )*;

additiveExpression returns[Expression expr]: l = multiplicativeExpression {$expr = $l.expr;}
( op1 = PLUS  r = multiplicativeExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.add);
                                        {$expr.setLine($op1.getLine());}}
| op2 = MINUS r = multiplicativeExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.sub);
                                        {$expr.setLine($op2.getLine());}} )*;

multiplicativeExpression returns[Expression expr]: l = preUnaryExpression {$expr = $l.expr;}
(op1 = MULT r = preUnaryExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.mult);
                                {$expr.setLine($op1.getLine());}}
| op2 = DIVIDE r = preUnaryExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.div);
                                    {$expr.setLine($op2.getLine());}}
| op3 = MOD r = preUnaryExpression { $expr = new BinaryExpression($expr,$r.expr,BinaryOperator.mod);
                                {$expr.setLine($op3.getLine());}})*;

preUnaryExpression returns[Expression expr]: {UnaryOperator u;} {int line;}
((op1 = NOT {u = UnaryOperator.not; line = $op1.getLine();}
| op2 = MINUS {u = UnaryOperator.minus; line = $op2.getLine();}
| op3 = INCREMENT {u = UnaryOperator.preinc; line = $op3.getLine();}
| op4 = DECREMENT {u = UnaryOperator.predec; line = $op4.getLine();})
 op = preUnaryExpression {$expr = new UnaryExpression($op.expr,u);
                           $expr.setLine(line);})
 | o = postUnaryExpression {$expr = $o.expr;};

postUnaryExpression returns[Expression expr]: a = accessExpression {$expr = $a.expr;}
(op1 = INCREMENT {$expr = new UnaryExpression($expr,UnaryOperator.postinc);
                   $expr.setLine($op1.getLine());}
| op2 = DECREMENT {$expr = new UnaryExpression($expr,UnaryOperator.postdec);
               $expr.setLine($op2.getLine());})?;

accessExpression returns[Expression expr]: other = otherExpression {$expr = $other.expr;}
((op1 = LPAR met = methodCallArguments RPAR)  {MethodCall method = new MethodCall($expr, $met.metargRet);
                                               method.setLine($op1.getLine());
                                               $expr = method;}|
(DOT id = identifier {ObjectOrListMemberAccess obj = new ObjectOrListMemberAccess($expr,$id.my_id);
                       obj.setLine($id.my_id.getLine());
                       $expr = obj;} )
| (op2 = LBRACK e = expression RBRACK {ListAccessByIndex ac = new ListAccessByIndex($expr,$e.expr);
                                        ac.setLine($op2.getLine());
                                        $expr = ac;}) )*;

otherExpression returns[Expression expr]: t = THIS {ThisClass tclas = new ThisClass();
                                                    tclas.setLine($t.getLine());
                                                    $expr = tclas;}
               | n = newExpression {$expr = $n.expr;}
               | v = values {$expr = $v.val;}
               | id = identifier {$expr = $id.my_id;}
               | LPAR (e = expression) RPAR {$expr = $e.expr;};

newExpression returns[Expression expr]: n = NEW c = classType LPAR met = methodCallArguments RPAR
{$expr = new NewClassInstance($c.classTypeRet, $met.metargRet);
 $expr.setLine($n.getLine());};


values returns[Value val]:
       b = boolValue {$val = $b.val;}
       | str = STRING_VALUE {$val = new StringValue($str.text.replaceAll("^\"|\"$", ""));
                             $val.setLine($str.getLine());}
       | my_int = INT_VALUE {$val = new IntValue($my_int.int);
                             $val.setLine($my_int.getLine());}
       | n = NULL {NullValue temp = new NullValue();
                  temp.setLine($n.getLine());
                  $val = temp;}
       | l = listValue {$val = $l.listval;};

boolValue returns[Value val]: t = TRUE {$val = new BoolValue(true);
                                              $val.setLine($t.getLine());}
                            | f = FALSE {$val = new BoolValue(false);
                                               $val.setLine($f.getLine());};

listValue returns [ListValue listval]:
    op = LBRACK met = methodCallArguments RBRACK {$listval = new ListValue($met.metargRet);}
    {$listval.setLine($op.getLine());};

identifier returns [Identifier my_id]:
    id = IDENTIFIER {$my_id = new Identifier($id.text);
                     $my_id.setLine($id.getLine());};


DEF: 'def';
EXTENDS: 'extends';
CLASS: 'class';

PRINT: 'print';
FUNC: 'func';

NEW: 'new';

CONTINUE: 'continue';
BREAK: 'break';
RETURN: 'return';

FOREACH: 'foreach';
IN: 'in';
FOR: 'for';
IF: 'if';
ELSE: 'else';

BOOLEAN: 'bool';
STRING: 'string';
INT: 'int';
VOID: 'void';
NULL: 'null';
LIST: 'list';

TRUE: 'true';
FALSE: 'false';

THIS: 'this';

ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';
NOT_EQUAL: '!=';
EQUAL: '==';

MULT: '*';
DIVIDE: '/';
MOD: '%';
PLUS: '+';
MINUS: '-';
AND: '&&';
OR: '||';
NOT: '!';
QUESTION_MARK: '?';

ASSIGN: '=';

INCREMENT: '++';
DECREMENT: '--';

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

SHARP: '#';
COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;
STRING_VALUE: '"'~["]*'"';
COMMENT: ('//' ~( '\r' | '\n')*) -> skip;
WS: ([ \t\n\r]) -> skip;