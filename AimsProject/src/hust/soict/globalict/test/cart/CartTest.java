package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.cart.Cart;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
            "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.removeDigitalVideoDisc(dvd3);

        //anOrder.print();
        //anOrder.searchById(3);
        anOrder.searchByTitle("The Lion Kin");
    }
}
