package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.IParserEngine;
import com.data.monkey.grammar.parser.engine.ParserEngine;
import org.junit.Before;

public class BaseTestUtils {
    public IParserEngine engine;

    @Before
    public void setUp() {
        engine =new ParserEngine();
    }

}
