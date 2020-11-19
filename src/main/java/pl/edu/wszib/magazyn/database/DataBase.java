package pl.edu.wszib.magazyn.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.model.Item;

import java.util.ArrayList;
import java.util.List;

@Component

public class DataBase implements IDataBase {
    private final List<Item> items = new ArrayList<>();

    public DataBase() {
        this.items.add(new Item("Żarówka", 14, "Zbr14LM"));
        this.items.add(new Item("Zderzak", 2, "ZDFord2009"));
        this.items.add(new Item("Reflaktor", 7, "RfFiat09-08"));
        this.items.add(new Item("Szyba", 1, "S12-5g"));
        this.items.add(new Item("Olej", 3, "Jhk-09-40W"));
    }

    @Override
    public List<Item> getAllItems() {
        return this.items;
    }

    @Override
    public boolean AddItems(String serialNumber, int count) {
        for(Item item:items){
            if(item.getSerialNumber().equals(serialNumber)) {
                item.setCount(item.getCount() + count);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean RemoveItems(String serialNumber, int count) {
        for(Item item:items){
            if(item.getSerialNumber().equals(serialNumber) && item.getCount() >= count) {
                item.setCount(item.getCount() - count);
                return true;
            }
        }
        return false;
    }
}
