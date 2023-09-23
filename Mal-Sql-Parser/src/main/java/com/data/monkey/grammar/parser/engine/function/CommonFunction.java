package com.data.monkey.grammar.parser.engine.function;


import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.outlier.AnomListConfig;
import com.data.monkey.grammar.parser.engine.params.MoMDuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class CommonFunction implements Function {
    private Constructor<? extends Operand> constructor;
    private String name;
    private Class<? extends Operand> operandClazz;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public CommonFunction(Class<? extends Operand> operandClazz, String name) {
        this.operandClazz = operandClazz;
        this.name = name;
    }

    @Override
    public Object call(Object... args) {
        try {
            if (args.length == 1) {
                if (args[0] instanceof Operand) {
                    constructor = operandClazz.getConstructor(Operand.class);
                    return constructor.newInstance(args[0]);

                } else if (args[0] instanceof IBooleanExpression) {
                    constructor = operandClazz.getConstructor(IBooleanExpression.class);
                    return constructor.newInstance(args[0]);
                } else if (args[0] instanceof MoMDuration) {
                    constructor = operandClazz.getConstructor(MoMDuration.class);
                    return constructor.newInstance(args[0]);
                } else if (args[0] instanceof AnomListConfig) {
                    constructor = operandClazz.getConstructor(AnomListConfig.class);
                    return constructor.newInstance(args[0]);
                }

            } else if (args.length == 2) {
                if (args[0] instanceof Operand
                        && args[1] instanceof IBooleanExpression) {
                    constructor = operandClazz.getConstructor(Operand.class, IBooleanExpression.class);
                    return constructor.newInstance(args[0], args[1]);
                }


            }
        } catch (Exception e) {
            logger.error("call internal function {} error", name, e);
        }

        throw new RuntimeException("parser sql aggregators error");
    }
}
