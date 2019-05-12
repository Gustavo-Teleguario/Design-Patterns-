import HA_01.*;
import org.junit.Test;

/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 01
 * University of Kassel
 */
// HA01: 07/ 10
    // -2 Kein Test es fehlen Assertions
    // -1 Tests mussen auch im Package sein
public class TestDeliveryService {
    @Test
    public void testDeliveryService() {
        DeliveryService mySub = new DeliveryService();
        mySub.withCateres(new PizzaShop());
        mySub.withCateres(new BurgerBude());
        mySub.withCateres(new DoenerLaden());
        mySub.withCateres(new AsiaLaden());


        mySub.deliver("M4", "WilliAlle73");
        mySub.deliver("M4", "WilliAlle73");
        mySub.deliver("M4", "WilliAlle73");

        /**
         * Test für Neue Laden
         */
        mySub.deliver("M4", "WilliAlle73");
        System.out.println("TEST_ END");
    }
}
