package Cache.storage;

public interface Storage<Key, Value> {

    public void put(Key key, Value value);
    public Value get(Key key);
    public boolean isFull();

}
