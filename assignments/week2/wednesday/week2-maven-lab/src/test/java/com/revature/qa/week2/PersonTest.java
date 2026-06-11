package com.revature.qa.week2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    public void shouldAnswerWithTrue() {
        Person p1 = new Person("Benson", 22);
        assertEquals(p1.getMessage(),"Benson:22");
    }
}
