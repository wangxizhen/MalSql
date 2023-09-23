grammar MalSqlParser;
@Header {package com.data.monkey.grammar;}

options { tokenVocab=MalSqlLexer; }

root
:
	SELECT columList FROM tableName
	(whereCluaster)?
	(durationExpr)?
	(exportExpr)?
	EOF
;

columList
:
	nameOprand
	(
		COMMA nameOprand
	)*
	|allColumn
;

allColumn
:
    STAR
;

nameOprand
:
	(
		actualTableName = LetterOrDigit DOT
	)? columnName = name
	(
		AS alias = LetterOrDigit
	)?
;

name
:
	LPAREN name RPAREN # LRName
	| left = name op =
	(
		STAR
		| SLASH
		| MOD
	) right = name # MulName
	| left = name op =
	(
		PLUS
		| SUB
	) right = name # AddName
	| left = name op =
    (
    	AMP
        | BAR
        | CARET
        | LTLT
        | GTGT
    ) right = name # BitwiseName
	| LetterOrDigit LPAREN columnName = name RPAREN # AggregationName
	| LetterOrDigit LPAREN columnName = name COMMA predicate = boolExpr RPAREN # AggregationName
	| LetterOrDigit LPAREN predicate = boolExpr RPAREN # AggregationName
	| identity # columnName
	| parenthesis # parenthesisName
;

parenthesis
:   PARENTHESIS
;

identity
:
	LetterOrDigit # letterOrDigitElement
	| INT # intElement
	| FLOAT # floatElement
	| NEG_INT # negativeIntElement
	| NEG_FLOAT # negativeFloatElement
	| STRING # stringElement
;

tableName
:
	actualTableName = LetterOrDigit
	(
		AS alias = LetterOrDigit
	)?
;

exportExpr
:
    EXPORT fileName = LetterOrDigit
;

whereCluaster
:
	WHERE
	boolExpr
	(filterByExpr)?
	(durationExpr)?
;

boolExpr
:
	LPAREN boolExpr RPAREN # insideExpression
	| left = boolExpr AND right = boolExpr # andOperation
	| left = boolExpr OR right = boolExpr # orOperation
	| basicBoolExpr # basicExpr
;

basicBoolExpr
:
left = name option =
	(
		EQ
		| GT
		| LT
		| GTEQ
		| LTEQ
		| NEQ
	) right = name # compareExpr
	| left = name option = IN right = collection # inExpression
;

collection
:
    LPAREN identity (COMMA identity)* RPAREN
;

durationExpr
:
	 FOR LAST number = name unit = (MINUTE | EVENTS)
;

duration
:
    number = INT unit = (MINUTE | HOUR | DAY)
;

filterByExpr
:
    FILTER BY LetterOrDigit (COMMA LetterOrDigit)*
;


