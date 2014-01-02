package de.prokaion.args;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.prokaion.args.exception.FalseFlagException;
import de.prokaion.args.exception.UnKnownTypeException;

public class TestKataArgs {
    
    private String[] argsArray;
    // private String schema = "l?,p*,d#";
    private String schema = "l?";
    
    @Before
    public void setup() {
        argsArray = new String[5];
        argsArray[0] = "-l";
    }
    
    @Test
    public void testBoolean() {
        try {
            argsArray = new String[] { "-l" };
            Args args = new Args(schema, argsArray);
            
            // do test
            Assert.assertTrue(args.getBoolean('l'));
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testBooleanSetWithValue() {
        try {
            // prepare
            argsArray = new String[] { "-l", "true" };
            
            // do test
            Args args = new Args(schema, argsArray);
            Assert.assertTrue(args.getBoolean('l'));
            
            // prepare 2
            argsArray[1] = "TRUE";
            
            args = new Args(schema, argsArray);
            
            // do test
            Assert.assertTrue(args.getBoolean('l'));
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testBooleanSetWithWrongStringValue() {
        try {
            argsArray = new String[] { "-l", "bla" };
            Args args = new Args(schema, argsArray);
            
            // do test
            Assert.assertFalse(args.getBoolean('l'));
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testForArgNotSet() {
        try {
            argsArray = new String[] {};
            Args args = new Args(schema, argsArray);
            // do test
            
            Assert.assertFalse(args.getBoolean('l'));
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Not yet implemented");
        }
    }
    
    @Test(expected = UnKnownTypeException.class)
    public void falseTypeTest() {
        // prepare
        schema = "b'";
        // test
        Args args = new Args(schema, argsArray);
        
    }
    
    @Test(expected = FalseFlagException.class)
    public void falseFlagTest() {
        // prepare
        argsArray = new String[] { "-b" };
        Args args = new Args(schema, argsArray);
        
    }
    
}
