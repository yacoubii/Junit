package monprojet;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SommeArgentTest {

    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private static int beforeCounter=0;
    private static int afterCounter=0;

    @BeforeEach
    public void init() {
       m12CHF= new SommeArgent(12, "CHF");
       m14CHF= new SommeArgent(14, "CHF");
       beforeCounter++;
       System.out.println(beforeCounter+"ime passage avant exécution d'une méthode de test");
    }

    @AfterEach
    public void finish() {
        afterCounter++;
        System.out.println(afterCounter+"ime passage APRES exécution d'une méthode de test");
    }

    @Test
    void add() throws UniteDistincteException {
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF);
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    void testEquals() {
        SommeArgent m14USD= new SommeArgent(14, "USD");
        Assert.assertTrue(!m12CHF.equals(null));
        Assert.assertEquals(m12CHF, m12CHF);
        Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF")); // (1)
        Assert.assertTrue(!m12CHF.equals(m14CHF));
        Assert.assertTrue(!m14USD.equals(m14CHF));
    }

    @Test
    void testException(){
        SommeArgent m14CHF= new SommeArgent(14, "CHF");
        SommeArgent m14USD= new SommeArgent(14, "USD");
        Assertions.assertThrows(UniteDistincteException.class, () -> m14USD.add(m14CHF));
    }



}