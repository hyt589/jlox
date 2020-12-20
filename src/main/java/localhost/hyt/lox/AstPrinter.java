package localhost.hyt.lox;

import localhost.hyt.lox.Expr.Assign;
import localhost.hyt.lox.Expr.Binary;
import localhost.hyt.lox.Expr.Grouping;
import localhost.hyt.lox.Expr.Literal;
import localhost.hyt.lox.Expr.Unary;
import localhost.hyt.lox.Expr.Variable;
import localhost.hyt.lox.Stmt.Block;
import localhost.hyt.lox.Stmt.Expression;
import localhost.hyt.lox.Stmt.Print;
import localhost.hyt.lox.Stmt.Var;

public class AstPrinter implements Expr.Visitor<String>, Stmt.Visitor<String> {

    String print(Expr exp) {
        return exp.accept(this);
    }

    String print(Stmt stmt) {
        return stmt.accept(this);
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
        if (expr.value == null) {
            return "nil";
        }
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();
        builder.append("(").append(name);
        for (Expr exp : exprs) {
            builder.append(" ");
            builder.append(exp.accept(this));
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitExpressionStmt(Expression stmt) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitPrintStmt(Print stmt) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitVarStmt(Var stmt) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitBlockStmt(Block stmt) {
        // TODO Auto-generated method stub
        return null;
    }
}
