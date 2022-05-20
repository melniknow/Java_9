import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LambdaDemoTest {
    private static final Human h0 = new Human("Sanya", "Golovanov", "pshh", 22, Gender.MALE); // for test age
    private static final Human h1 = new Human("Sanya", "Golovanov", "pshh", 23, Gender.MALE);
    private static final Human h2 = new Human("Slava", "Ustugov", "hhhh", 20, Gender.MALE);
    private static final Human h3 = new Human("Iliya", "Tupoy", "llll", 18, Gender.MALE);

    private static final Student s1 = new Student("Max", "Maxutov", "kkkk", 19, Gender.MALE,
            "OmGU", "Physical faculty ", "applied physics");
    private static final Student s2 = new Student("Tanya", "Golovanov", "bbbb", 21, Gender.FEMALE,
            "OmGU", "IMIT", "pogromist");



    @Test
    public void FunctionTest() {
        assertEquals(Integer.valueOf(5), LambdaRunner.run(LambdaDemo.getLength, "SLAVA"));
        assertEquals(Character.valueOf('T'), LambdaRunner.run(LambdaDemo.getFirstSymbol, "Tupoy"));
        assertEquals(Integer.valueOf(5), LambdaRunner.run(LambdaDemo.replaceCount, "qwert, 123, 123, 2,7"));
        assertEquals(Integer.valueOf(7), LambdaRunner.run(LambdaDemo.replaceCount, "каждый, охотник, желает, знать, где, сидит, фазан"));

        assertEquals(Integer.valueOf(19), LambdaRunner.run(LambdaDemo.getAge, s1));
        assertEquals(Integer.valueOf(21), LambdaRunner.run(LambdaDemo.getAge, s2));
        assertEquals(Integer.valueOf(20), LambdaRunner.run(LambdaDemo.getAge, h2));

        assertEquals("Max Maxutov kkkk", LambdaRunner.run(LambdaDemo.getFullName, s1));
        assertEquals("Iliya Tupoy llll", LambdaRunner.run(LambdaDemo.getFullName, h3));

        assertEquals(h1, LambdaRunner.run(LambdaDemo.makeOldest, h0));


        assertTrue(LambdaRunner.run(LambdaDemo.containsSpace, "IMIT"));
        assertFalse(LambdaRunner.run(LambdaDemo.containsSpace, "Mathe ma tic"));
    }

    @Test
    public void BiPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.equalsLastName, h1, s2));
        assertFalse(LambdaRunner.run(LambdaDemo.equalsLastName, h1, h3));

        var list1 = new ArrayList<Human>(3);
        var list2 = new ArrayList<Human>(3);
        list1.add(h1); list1.add(s1); list1.add(h3);
        list2.add(s1); list2.add(s2); list2.add(h2);
        assertTrue(LambdaRunner.run(LambdaDemo.isYoungerMaxAge, list1, 24));
        assertFalse(LambdaRunner.run(LambdaDemo.isYoungerMaxAge, list2,  20));
    }
}