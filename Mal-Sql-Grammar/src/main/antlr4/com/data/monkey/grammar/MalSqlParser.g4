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
	)? fieldName
	(
		AS alias = LetterOrDigit
	)?
;

fieldName
:
	LPAREN fieldName RPAREN # LRName
	| left = fieldName op =
	(
		STAR
		| SLASH
		| MOD
	) right = fieldName # MulName
	| left = fieldName op =
	(
		PLUS
		| SUB
	) right = fieldName # AddName
	| left = fieldName op =
    (
    	AMP
        | BAR
        | CARET
        | LTLT
        | GTGT
    ) right = fieldName # BitwiseName
	| LetterOrDigit LPAREN  fieldName RPAREN # AggregationName
	| LetterOrDigit LPAREN  fieldName COMMA predicate = conditionStatement RPAREN # AggregationName
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
	| basicConditionExpr # basicExpr


;

basicConditionExpr
:
left = fieldName option =
	(
		EQ
		| GT
		| LT
		| GTEQ
		| LTEQ
		| NEQ
	) right = fieldName # compareExpr
	| left = fieldName option = IN right = collection # inExpression
;

collection
:
    LPAREN identity (COMMA identity)* RPAREN
;

timeRangeStatement
:
	 FOR LAST number = fieldName unit = (MINUTE | EVENTS)
;

timeRange
:
    number = INT unit = (MINUTE | HOUR | DAY)
;

filterStatement
:
    FILTER BY LetterOrDigit (COMMA LetterOrDigit)* # matchByFieldValue |
    FILTER BY left = LetterOrDigit LIKE PERCENT right = LetterOrDigit  # leftMatch |
    FILTER BY left = LetterOrDigit LIKE right = LetterOrDigit PERCENT  # rightMatch |
    FILTER BY left = LetterOrDigit LIKE PERCENT right = LetterOrDigit PERCENT # containMatch
;






