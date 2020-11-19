package pl.edu.wszib.magazyn.database;

import pl.edu.wszib.magazyn.model.Item;

import java.util.List;

public interface IDataBase {
    List<Item> getAllItems();
    boolean AddItems(String serialNumber, int count);
    boolean RemoveItems(String serialNumber, int count);
}
