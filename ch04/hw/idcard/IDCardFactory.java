package ch04.hw.idcard;
import ch04.hw.framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
    private Hashtable database = new Hashtable();
    private int serial = 100;
    protected synchronized Product createProduct(String owner) {
        return new IDCard_New(owner, serial++);
    }
    protected void registerProduct(Product product) {
        IDCard_New card = (IDCard_New)product;
        database.put(card.getOwner(), new Integer(card.getSerial()));
    }
    public Hashtable getDatabase() {
        return database;
    }
}
