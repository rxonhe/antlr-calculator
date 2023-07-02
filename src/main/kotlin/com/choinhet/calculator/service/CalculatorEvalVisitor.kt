import com.choinhet.calculator.CalculatorBaseVisitor
import com.choinhet.calculator.CalculatorParser

class CalculatorEvalVisitor : CalculatorBaseVisitor<Int>() {
    override fun visitQuestion(ctx: CalculatorParser.QuestionContext): Int {
        return visit(ctx.expression())
    }

    override fun visitExpression(ctx: CalculatorParser.ExpressionContext): Int {
        if (ctx.NUMBER() != null) {
            return ctx.NUMBER().text.toInt()
        } else if (ctx.mult() != null) {
            val left = visit(ctx.expression(0))
            val right = visit(ctx.expression(1))
            return left * right
        } else if (ctx.div() != null) {
            val left = visit(ctx.expression(0))
            val right = visit(ctx.expression(1))
            if (right != 0) {
                return left / right
            } else {
                throw ArithmeticException("Division by zero")
            }
        } else if (ctx.sum() != null) {
            val left = visit(ctx.expression(0))
            val right = visit(ctx.expression(1))
            return left + right
        } else if (ctx.sub() != null) {
            val left = visit(ctx.expression(0))
            val right = visit(ctx.expression(1))
            return left - right
        } else if (ctx.parenthesisExpression() != null) {
            return visit(ctx.parenthesisExpression().expression())
        } else {
            throw IllegalArgumentException("Invalid expression")
        }
    }
}
