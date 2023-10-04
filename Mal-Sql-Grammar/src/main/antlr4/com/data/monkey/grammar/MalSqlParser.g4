grammar MalSqlParser;
@Header {package com.data.monkey.grammar;}

options { tokenVocab=MalSqlLexer; }

root
:
	SELECT fields FROM tableName
	(whereStatement)?
	(timeRangeStatement)?
	(exportStatement)?
	EOF
;

fields
:
	field
	(
		COMMA field
	)*
	|allFields
;

allFields
:
    STAR
;

field
:
	(
		actualTableName = LetterOrDigit DOT
	)? name
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
	| LetterOrDigit LPAREN  name RPAREN # AggregationName
	| LetterOrDigit LPAREN  name COMMA predicate = conditionStatement RPAREN # AggregationName
	| LetterOrDigit LPAREN predicate = conditionStatement RPAREN # AggregationName
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

exportStatement
:
    EXPORT fileName = LetterOrDigit
;

whereStatement
:
	WHERE
	conditionStatement
	(filterStatement)?
	(timeRangeStatement)?
;

conditionStatement
:
	LPAREN conditionStatement RPAREN # insideExpression
	| left = conditionStatement AND right = conditionStatement # andOperation
	| left = conditionStatement OR right = conditionStatement # orOperation
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
	| likeStatement # likeExpr
;

collection
:
    LPAREN identity (COMMA identity)* RPAREN
;

timeRangeStatement
:
	 FOR LAST number = name unit = (MINUTE | EVENTS)
;

timeRange
:
    number = INT unit = (MINUTE | HOUR | DAY)
;

filterStatement
:
    FILTER BY LetterOrDigit (COMMA LetterOrDigit)*
;

likeStatement
:
   LetterOrDigit (COMMA LetterOrDigit)*  LIKE PERCENT  LetterOrDigit  # leftMatch |
   LetterOrDigit (COMMA LetterOrDigit)*  LIKE LetterOrDigit PERCENT  # rightMatch |
   LetterOrDigit (COMMA LetterOrDigit)*  LIKE PERCENT LetterOrDigit PERCENT  # containMatch
;



