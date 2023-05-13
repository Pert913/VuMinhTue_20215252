package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.*;

public class Store {
    private DigitalVideoDisc []itemInStore = new DigitalVideoDisc[100];
    public int cnt = 0;

    public void addDVD(DigitalVideoDisc dvd){
        itemInStore[cnt] = dvd;
        System.out.println("The disc has been added.");
        cnt++;
    }

    public void removeDVD(DigitalVideoDisc dvd){
        for (int i = 0; i < cnt; i++) {
			if (itemInStore[i] == dvd) {
				for (int j = i; j < cnt; j++) {
                    //Shift up the following DVDs
					itemInStore[j] = itemInStore[j + 1];
				}
				System.out.println("The disc has been removed.");
				return;
			}
		}
		System.out.println("Cannot find said disc.");
    }
}
