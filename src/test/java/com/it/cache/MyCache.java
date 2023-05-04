package com.it.cache;

import org.apache.ibatis.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;

public class MyCache implements Cache {

    private final Map<Object, Object> cacheMap = new HashMap<>();

    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void putObject(Object key, Object value) {
        cacheMap.put(key, value);
    }

    @Override
    public Object getObject(Object key) {
        return cacheMap.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        return cacheMap.remove(key);
    }

    @Override
    public void clear() {
        cacheMap.clear();
    }

    @Override
    public int getSize() {
        return cacheMap.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

}
