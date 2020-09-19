import java.util.Map;
import java.util.HashMap;

public class LRU_Cache{
	//Approach : HashMap with DoublyLinkedList
	//The problem can be solved with hashmap that keeps
	//track of keys and its values in the double linked
	//list. The is O(1) time for put and get operations
	//and allows to remove the first added node in O(1)
	//time as well.
	//Doubly LinkedList Node
    class DLinkedNode{
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
    }
    private void addNode(DLinkedNode node){
            //Always add the new node right after head.
            node.prev = head;
            node.next = head.next;
            
            head.next.prev = node;
            head.next = node;
    }
    private void removeNode(DLinkedNode node){
            //Remove an existing node from the linked list.
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            
            prev.next = next;
            next.prev = prev;
    }
    private void moveToHead(DLinkedNode node){
            //Move certain node in between to the head
            removeNode(node);
            addNode(node);
    }
    private DLinkedNode popTail(){
            //Pop the current tail.
            DLinkedNode result = tail.prev;
            removeNode(result);
            return result;
    }
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        //head.prev = null;
        
        tail = new DLinkedNode();
        //tail.next = null;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        
        //move the accessed node to the head;
        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            
            if(size > capacity){
                //pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            //Update the value
            node.value = value;
            moveToHead(node);
        }
    }
}
/**
 * _146_LRU_Cache object will be instantiated and called as such:
 * _146_LRU_Cache obj = new _146_LRU_Cache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */