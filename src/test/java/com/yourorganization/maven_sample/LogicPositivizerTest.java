package com.yourorganization.maven_sample;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicPositivizerTest {

    @Test
    void testParseSimpleClass() {
        // Given a sample Java snippet string
        String code = "public class TestClass { public boolean check() { return !false; } }";

        // When parsed using JavaParser (similar to how LogicPositivizer operates)
        CompilationUnit cu = StaticJavaParser.parse(code);

        // Then verify the compilation unit is successfully created and contains the class
        assertNotNull(cu);
        assertEquals(1, cu.getTypes().size());
        assertEquals("TestClass", cu.getType(0).getNameAsString());
    }

    @Test
    void testBinaryExpressionInversionLogic() {
        // Given an expression with negation or logical checks typical of LogicPositivizer
        String code = "class Foo { boolean val = !(a == b); }";
        CompilationUnit cu = StaticJavaParser.parse(code);

        // Verify that we can find and inspect binary expressions inside the AST
        boolean foundBinaryExpr = cu.findAll(BinaryExpr.class).size() > 0;
        assertTrue(foundBinaryExpr, "Expected to find binary expressions in the parsed AST");
    }
}
// testing
