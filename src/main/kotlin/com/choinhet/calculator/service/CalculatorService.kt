package com.choinhet.calculator.service

import CalculatorEvalVisitor
import com.choinhet.calculator.CalculatorLexer
import com.choinhet.calculator.CalculatorParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.springframework.stereotype.Service

@Service
class CalculatorService {
    fun calculate(expression: String): Float {
        val inputCharStream = CharStreams.fromString(expression)
        val lexer = CalculatorLexer(inputCharStream)
        val tokens = CommonTokenStream(lexer)
        val parser = CalculatorParser(tokens)

        val tree = parser.question()
        val visitor = CalculatorEvalVisitor()

        return visitor.visit(tree)
    }
}
