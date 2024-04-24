package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private Greeting target = new Greeting();
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getMessage_GoodMorning(){
        String message = this.target.getMessage(5);
        assertThat(message,is("GoodMorning"));
    }

    @Test
    public void getMessage_Hello(){
        String message = this.target.getMessage(11);
        assertThat(message,is("Hello"));
    }

    @Test
    public void getMessage_GoodEvening(){
        String message = this.target.getMessage(18);
        assertThat(message,is("GoodEvening"));
    }

}

