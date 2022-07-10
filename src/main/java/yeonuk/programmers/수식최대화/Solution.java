package yeonuk.programmers.수식최대화;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public long solution(String expression) {
        List<ExpressionPiece> pieceList = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (char piece : expression.toCharArray()) {
            if (piece == '+' || piece == '-' || piece == '*') {
                ExpressionPiece numberPiece = new ExpressionPiece(stringBuilder.toString());
                pieceList.add(numberPiece);

                ExpressionPiece expressionPiece = new ExpressionPiece(String.valueOf(piece));
                pieceList.add(expressionPiece);

                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(piece);
            }
        }
        ExpressionPiece numberPiece = new ExpressionPiece(stringBuilder.toString());
        pieceList.add(numberPiece);

        long maxValue = 0;
        maxValue = Math.max(maxValue, calculate(pieceList, "+", "-", "*"));
        maxValue = Math.max(maxValue, calculate(pieceList, "+", "*", "-"));
        maxValue = Math.max(maxValue, calculate(pieceList, "-", "+", "*"));
        maxValue = Math.max(maxValue, calculate(pieceList, "-", "*", "+"));
        maxValue = Math.max(maxValue, calculate(pieceList, "*", "+", "-"));
        maxValue = Math.max(maxValue, calculate(pieceList, "*", "-", "+"));

        return maxValue;
    }

    private long calculate(List<ExpressionPiece> pieceList, String firstExpression, String secondExpression, String thirdExpression) {
        List<ExpressionPiece> firstList = Calculator.calculate(pieceList, firstExpression);
        List<ExpressionPiece> secondList = Calculator.calculate(firstList,secondExpression);
        List<ExpressionPiece> thirdList = Calculator.calculate(secondList, thirdExpression);
        ExpressionPiece expressionPiece = thirdList.get(0);
        return Math.abs(expressionPiece.getNumberPiece());
    }
}

class ExpressionPiece {

    private final PieceType type;
    private final String piece;

    public ExpressionPiece(String piece) {
        if (Character.isDigit(piece.charAt(0))) {
            this.type = PieceType.NUMBER;
        } else {
            this.type = PieceType.EXPRESSION;
        }

        this.piece = piece;
    }

    public String getExpressionPiece() {
        return piece;
    }

    public long getNumberPiece() {
        return Long.parseLong(piece);
    }

    public boolean isExpressionType() {
        return this.type == PieceType.EXPRESSION;
    }
}

enum PieceType {

    NUMBER,
    EXPRESSION,
    ;
}

abstract class Calculator {
    public static List<ExpressionPiece> calculate(List<ExpressionPiece> pieceList, String expressionType) {
        List<ExpressionPiece> temp = new LinkedList<>(pieceList);
        List<ExpressionPiece> result = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            ExpressionPiece expressionPiece = temp.get(i);
            if (expressionPiece.isExpressionType() && expressionPiece.getExpressionPiece().equals(expressionType)) {
                long first = result.get(result.size() - 1).getNumberPiece();
                long second = temp.get(i + 1).getNumberPiece();
                result.remove(result.size() - 1);


                result.add(calculateExpression(first, second, expressionType));
                i += 1;
            } else {
                result.add(expressionPiece);
            }

        }

        return result;
    }

    private static ExpressionPiece calculateExpression(long first, long second, String expressionType) {
        if (expressionType.equals("+")) {
            return new ExpressionPiece(String.valueOf(first + second));
        } else if (expressionType.equals("-")) {
            return new ExpressionPiece(String.valueOf(first - second));
        } else {
            return new ExpressionPiece(String.valueOf(first * second));
        }
    }
}
