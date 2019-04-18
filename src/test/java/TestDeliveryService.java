import HA_01.BurgerBude;
import HA_01.DeliveryService;
import HA_01.DoenerLaden;
import HA_01.PizzaShop;
import org.junit.Test;

public class TestDeliveryService {
    @Test
    public void testDeliveryService() {
        DeliveryService mySub = new DeliveryService();
        mySub.withCateres(new PizzaShop());
        mySub.withCateres(new BurgerBude());
        mySub.withCateres(new DoenerLaden());


        mySub.deliver("M4", "WilliAlle73");
        mySub.deliver("M8", "WilliAlle73");
        mySub.deliver("M2", "WilliAlle73");
        System.out.println("TEST END");
    }
}
