package localhost.hyt.lox;

import localhost.hyt.lox.Expr.Binary;
import localhost.hyt.lox.Expr.Grouping;
import localhost.hyt.lox.Expr.Literal;
import localhost.hyt.lox.Expr.Unary;

public class AstPrinter implements Expr.Visitor<String> {

    String print(Expr exp)
    {
        return exp.accept(this);
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return parenthesize("Grouping", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null)
        {
            return "nil";
        }
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }
    
    private String parenthesize(String name, Expr ... exprs)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("(").append("name");
        for (Expr exp : exprs)
        {
            builder.append(" ");
            builder.append(exp.accept(this));
        }
        builder.append(")");
        return "";
    }
}