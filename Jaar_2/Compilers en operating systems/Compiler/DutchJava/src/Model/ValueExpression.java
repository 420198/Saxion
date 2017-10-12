package Model;

/**
 * Created by thama on 21-6-2017.
 */
public class ValueExpression {
    /**
     * Type of the expresiion
     */
    private Type expressionType;

    /**
     * Constructor for the value expression
     *
     * @param expressionType Type of the expression
     */
    public ValueExpression(Type expressionType) {
        this.expressionType = expressionType;
    }

    /**
     * Getter
     *
     * @return the expression type
     */
    public Type getExpressionType() {
        return expressionType;
    }

    @Override
    public String toString() {
        return "ValueExpression{" +
                "expressionType=" + expressionType +
                '}';
    }
}
