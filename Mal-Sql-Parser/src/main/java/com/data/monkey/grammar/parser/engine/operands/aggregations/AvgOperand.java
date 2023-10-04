package com.data.monkey.grammar.parser.engine.operands.aggregations;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @deprecated average is not a solid operand
 */
@Deprecated
public class AvgOperand extends AbstractSingleOperand {

    public AvgOperand(Operand innerOperand) {
        super(innerOperand);
    }

    public AvgOperand(IBooleanExpression predicate) {
        super(predicate);
    }

    public AvgOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {

        Double value = filterForCalculus(filter(events, parameters), parameters).mapToDouble(e ->
                        Double.parseDouble(
                                getNameOperand().getValue(Arrays.asList(e), parameters).toString()))
                .average().orElse(0);

        return value;

    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toReadableString()
    {
        return String.format("AVG(%s)", this.getInnerOperand().toReadableString());
    }

    @Override
    public String toString() {
        return String.format(
                "%s(innerOperand=%s, predicate=%s)",
                this.getClass().getSimpleName(),
                Objects.toString(this.getInnerOperand()),
                Objects.toString(this.getPredicate())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            final AvgOperand operand = (AvgOperand) obj;
            return Objects.equals(this.getInnerOperand(), operand.getInnerOperand()) &&
                   Objects.equals(this.getPredicate(), operand.getPredicate());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.getInnerOperand(), this.getPredicate());
    }
}
