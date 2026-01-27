import java.util.ArrayList;
import java.util.HashMap;

class Trie<K, V> {
    ArrayList<NodeInfo> data;
    int index;
    ArrayList<Integer> indexStack;
    ArrayList<K> stack;

    public Trie(V rootValue) {
        this.data = new ArrayList();
        this.index = 0;
        this.indexStack = new ArrayList();
        this.stack = new ArrayList();
    }
    
    public int add(K key, V val) {
        if (this.data.get(this.index).children.containsKey(key)) {
            return (int)this.data.get(this.index).children.get(key);
        }
        int next = this.data.size();
        this.data.get(this.index).children.put(key, next);
        this.data.add(new NodeInfo(val));
        return next;
    }
    
    public void resetCursor() {
        this.index = 0;
        this.stack.clear();
    }
    
    public boolean isRoot() {
        return this.index == 0;
    }
    
    public NodeInfo transitOrAdd(K key, V val) {
        int next = this.add(key, val);
        this.indexStack.add(this.index);
        this.index = next;
        this.stack.add(key);
        return this.data.get(next);
    }
    
    public boolean transit(K key) {
        if (this.data.get(this.index).children.containsKey(key)) {
            int next = (int)this.data.get(this.index).children.get(key);
            this.indexStack.add(this.index);
            this.index = next;
            this.stack.add(key);
            return true;
        } else {
            return false;
        }
    }
    
    public void back() {
        this.index = this.indexStack.remove(this.indexStack.size() - 1);
        this.stack.remove(this.stack.size() - 1);
    }
    
    public V currentNode() {
        return (V)this.data.get(this.index).value;
    }
    
    public HashMap<K, Integer> children() {
        return this.data.get(this.index).children;
    }
}

class NodeInfo<K, V> {
    public V value;
    HashMap<K, Integer> children;
    
    public NodeInfo(V value) {
        this.value = value;
        this.children = new HashMap();
    }
}
