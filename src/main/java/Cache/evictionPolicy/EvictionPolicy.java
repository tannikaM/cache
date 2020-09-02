package Cache.evictionPolicy;

public interface EvictionPolicy<Key> {

    public void AccessedKey(Key key);
    public Key keyToBeRemoved();

}
