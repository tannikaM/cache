package Cache.storage;

import java.util.HashMap;
import Exception.*;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{
    private Integer capacity;
    private HashMap<Key, Value> storage;

    public HashMapStorage(Integer capacity){
        HashMap<Key, Value> storage = new HashMap<Key, Value>();
        this.storage = storage;
        this.capacity = capacity;
    }

    public void put(Key key, Value value) throws StorageFullException{
        try {
            this.storage.put(key, value);
            this.capacity = this.capacity + 1;
        }catch (Exception ex){
            throw new StorageFullException("Capacity of storage is full");
        }
    }

    public Value get(Key key) throws KeyNotFound {
        try {
            Value value = this.storage.get(key);
            return value;
        }catch (Exception ex) {
            throw new KeyNotFound("The key is not present");
        }
    }

    public boolean isFull() {
        return this.storage.size() == this.capacity;
    }

    public void removeKey(Key key) throws KeyNotFound {
        try {
            this.storage.remove(key);
        }catch (Exception ex) {
            throw new KeyNotFound("The key is not present");
        }

    }
}
