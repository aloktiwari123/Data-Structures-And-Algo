package DLinkedList;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer,Node> cache;
    DoubleLinkedList doubleLinkedList;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        doubleLinkedList=new DoubleLinkedList();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            doubleLinkedList.remove(node);
            doubleLinkedList.add(node);
            return node.val;
        }else{
            return -1;
        }
        

    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).val=value;
            get(key);
        }else{
            if(capacity<=cache.size()){
                evict();
            }
            Node node=new Node(key,value);
            cache.put(key,node);
            doubleLinkedList.add(node);  
        }
    }

    public void evict(){
        int key=doubleLinkedList.removeTail();
        cache.remove(key);
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;

    DoubleLinkedList(){
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void add(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public int removeTail(){
        int key=tail.prev.key;
        remove(tail.prev);
        return key;
    }

}

class Node {
    Node prev=null;
    Node next=null;
    int key;
    int val;

    public Node(int key,int val){
        this.val=val;
        this.key=key;
    }

}

