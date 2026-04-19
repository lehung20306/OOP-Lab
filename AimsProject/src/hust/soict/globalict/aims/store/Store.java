package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ITEM = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ITEM];
    private int qtyInStore = 0;
    public void addDVD (DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_ITEM) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc has been added"); // Thông báo khi thêm thành công 
        } 
        else {
            System.out.println("The store is almost full"); // Thông báo cửa hàng hết chỗ 
        }
    }
    public void addDVD(DigitalVideoDisc[] dvdList) {
    for (DigitalVideoDisc dvd : dvdList) {
            this.addDVD(dvd);
        }
    }
    public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDVD(dvd1);
        this.addDVD(dvd2);
    }
    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the store");
    }
}
