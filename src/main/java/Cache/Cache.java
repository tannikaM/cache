package Cache;

import Cache.evictionPolicy.EvictionPolicy;
import Cache.storage.Storage;
import Exception.StorageFullException;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> policy;

    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> policy, Storage<Key, Value>storage){
        this.policy = policy;
        this.storage = storage;
    }

    public Value get(Key key){
        this.policy.AccessedKey(key);
        Value value = this.storage.get(key);
        return value;
    }

    public void put(Key key, Value value) throws Exception{
        try{
            this.policy.AccessedKey(key);
            this.storage.put(key, value);
        }catch (Exception ex){
            System.out.println("Storage is full");
            Key removedKey = this.policy.keyToBeRemoved();
            if(removedKey == null)
                throw new Exception("storage is full but no key to be removed");
            this.storage.removeKey(removedKey);
        }

    }
}
