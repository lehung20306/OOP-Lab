package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    
    public void addDigitalVideoDisc (DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added"); // Thông báo khi thêm thành công 
        } 
        else {
            System.out.println("The cart is almost full"); // Thông báo khi giỏ đầy 
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    for (DigitalVideoDisc dvd : dvdList) {
            this.addDigitalVideoDisc(dvd);
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void searchById(int id){
        if(id > qtyOrdered){
            System.out.println("No match found for: " + id);
        }
        else{
            System.out.println(itemsOrdered[id - 1].toString());
        }
    }

    public void searchByTitle(String title){
        boolean search = false;
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i].isMatch(title)){
                search = true;
                System.out.println(itemsOrdered[i].toString());
            }
        }
        if(search == false){
            System.out.println("No match found for: " + title);
        }
    }
}
