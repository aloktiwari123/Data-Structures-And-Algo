package DLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class LFUCache {
    int capacity;
    PriorityQueue<Data> pq;
    HashMap<Integer,Integer>cache;
    public LFUCache(int capacity) {
       this.capacity=capacity;
       this.cache=new HashMap<>();
       this.pq=new PriorityQueue<>((a,b)->(a.key-b.key));
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            getValue(key);
            return cache.get(key);
        }else{
            return -1;
        }
    }

    public void getValue(int key){
        List<Data> Datas=new ArrayList<>();
        while(!pq.isEmpty()){
            Data peek=pq.poll();
            if(peek.key==key){
                peek.freq+=1;
                pq.add(peek);
                break;
            }else{
                Datas.add(peek);
            }
        }

        for (int i = 0; i < Datas.size(); i++) {
            pq.add(Datas.get(i));
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            get(key);
        }else{
            if(capacity<=cache.size()){
                evict();
            }
            Data Data=new Data(key,value);
            cache.put(key,value);
            pq.add(Data);  
        }
    }

    public void evict(){
        Data peek=pq.poll();
        cache.remove(peek.key);
    }
}

class Data{
    int key;
    int value;
    int freq;
    Data(int key,int value){
        this.key=key;
        this.value=value;
        this.freq=1;
    }
}
