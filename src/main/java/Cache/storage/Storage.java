package Cache.storage;

import Exception.*;

public interface Storage<Key, Value> {

    public void put(Key key, Value value) throws StorageFullException;
    public Value get(Key key) throws KeyNotFound;
    public boolean isFull();
    public void removeKey(Key key);

}
