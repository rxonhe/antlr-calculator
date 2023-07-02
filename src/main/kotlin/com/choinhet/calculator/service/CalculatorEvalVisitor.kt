import com.choinhet.calculator.CalculatorBaseVisitor
import com.choinhet.calculator.CalculatorParser

class CalculatorEvalVisitor : CalculatorBaseVisitor<Float>() {
    private val operationVocabulary: Map<String, List<String>>
        get() = mapOf(
            "*" to listOf("*", "x", "X", "multiplied by", "times", "multiplied"),
            "/" to listOf("/", "÷", "divided by", "over"),
            "+" to listOf("+", "plus", "added to", "add", "sum"),
            "-" to listOf("-", "minus", "subtracted from", "subtract", "sub")
        )

    private val operatorMap = mapOf(
        "*" to { left: Float, right: Float -> left.times(right) },
        "/" to { left: Float, right: Float -> left.div(right) },
        "+" to { left: Float, right: Float -> left.plus(right) },
        "-" to { left: Float, right: Float -> left.minus(right) }
    )

    override fun visitQuestion(ctx: CalculatorParser.QuestionContext): Float {
        return visit(ctx.expression())
    }

    override fun visitExpression(ctx: CalculatorParser.ExpressionContext): Float {
        return when {
            ctx.NUMBER() != null -> ctx.NUMBER().text.toFloat()
            ctx.mult() != null -> evaluateBinaryExpression(ctx, ctx.mult().text)
            ctx.div() != null -> evaluateBinaryExpression(ctx, ctx.div().text)
            ctx.sum() != null -> evaluateBinaryExpression(ctx, ctx.sum().text)
            ctx.sub() != null -> evaluateBinaryExpression(ctx, ctx.sub().text)
            ctx.parenthesisExpression() != null -> visit(ctx.parenthesisExpression().expression())
            else -> throw IllegalArgumentException("Invalid expression")
        }
    }

    private fun evaluateBinaryExpression(ctx: CalculatorParser.ExpressionContext, operator: String): Float {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        val operation = operationVocabulary.entries.find { it.value.contains(operator) }?.key.let { operatorMap[it] }
            ?: throw IllegalArgumentException("Invalid operator: $operator")
        return operation(left, right)
    }
}
