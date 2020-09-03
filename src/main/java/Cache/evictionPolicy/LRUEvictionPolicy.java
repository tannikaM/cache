package Cache.evictionPolicy;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    
    public LRUEvictionPolicy(){

    }
    public void AccessedKey(Key key) {

    }

    public Key keyToBeRemoved() {
        return null;
    }
}
