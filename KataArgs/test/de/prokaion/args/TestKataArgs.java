package de.prokaion.args;

import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKataArgs {
    
    private String[] args;
    private ArgsParser argsParser;
    
    @Before
    public void setup() {
        args = new String[5];
        args[0] = "-l";
        argsParser = new ArgsParser();
    }
    
    @Test
    public void test() {
        try {
            
            argsParser.parse(args);
            
            // do test
            Set<String> keys = argsParser.getKeys();
            Assert.assertNotNull(keys);
            Assert.assertNotNull(argsParser.get("-l"));
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Not yet implemented");
        }
    }
    
}
