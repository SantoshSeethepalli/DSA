package StacksAndQueues;

import java.util.ArrayList;
import java.util.HashSet;

class Q6_LRU_Cache {
    class KeyValuePair {
        int key;
        int value;

        public KeyValuePair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LruDataStructure {

        int capacity;
        HashSet<Integer> keySet;
        ArrayList<KeyValuePair> dataStore;

        public LruDataStructure(int capacity) {
            this.capacity = capacity;
            dataStore = new ArrayList<>();
            keySet = new HashSet<>();
        }


        void put(int key, int value) {

            if(keySet.contains(key)) {

                for(int i = 0; i < dataStore.size(); i++) {

                    if(dataStore.get(i).key == key) {

                        keySet.remove(key);
                        dataStore.remove(i);

                        break;
                    }

                }
            }

            dataStore.add(new KeyValuePair(key, value));
            keySet.add(key);

            if (dataStore.size() > capacity) {
                KeyValuePair cacheKVPair = dataStore.get(0);

                keySet.remove(cacheKVPair.key);
                dataStore.remove(0);
            }
        }


        int get(int key) {

            if(!keySet.contains(key)) return -1;

            KeyValuePair cacheKVPair = new KeyValuePair(0, 0);

            for(int i = 0; i < dataStore.size(); i++) {

                if(dataStore.get(i).key == key) {

                    cacheKVPair = dataStore.get(i);
                    dataStore.remove(i);

                    dataStore.add(cacheKVPair);

                    break;
                }
            }

            return cacheKVPair.value;
        }

    }


    static LruDataStructure dataStore;
    static int capacity;

    Q6_LRU_Cache(final int cap) {
        capacity = cap;
        dataStore = new LruDataStructure(capacity);
    }

    public int get(int key) {
        return dataStore.get(key);
    }


    public void put(int key, int value) {
        dataStore.put(key, value);
    }

    public static void main(String[] args) {
        Q6_LRU_Cache cache = new Q6_LRU_Cache(2);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(1, 5);
        cache.put(4, 5);
        cache.put(6, 7);
        System.out.println(cache.get(4));
        cache.put(1, 2);
        System.out.println(cache.get(3));
    }
}