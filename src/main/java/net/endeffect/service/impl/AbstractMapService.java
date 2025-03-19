package net.endeffect.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        // Store the object in the map with the given id as the key
        // The map.put(id, object) method associates the specified value with the specified key in this map
        map.put(id, object);
        // Return the object that was saved
        return object;
    }

    List<T> findAll() {
        // Create a new ArrayList to hold all the values from the map
        // The map.values() method returns a Collection view of the values contained in the map
        // The ArrayList constructor is used to create a new list containing the elements returned by map.values()
        return new ArrayList<>(map.values());
    }

    T findById(ID id) {
        // Retrieve the object associated with the given id from the map
        // The map.get(id) method returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
        return map.get(id);
    }

    void deleteById(ID id) {
        // Remove the object associated with the given id from the map
        // The map.remove(id) method removes the mapping for the specified key from this map if present
        map.remove(id);
    }
}
