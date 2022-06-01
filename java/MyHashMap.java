//package java;
//
//import java.io.Serializable;
//import java.util.AbstractMap;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * <Description> <br>
// *
// * @author sunyue <br>
// * @version 9.0 <br>
// * @taskId <br>
// * @CreateDate 2021/12/28 <br>
// * @since V9.0 <br>
// */
//public class MyHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {
//
//    /**默认容量16**/
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//
//    /**最大桶数**/
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    final float loadFactor;
//
//    int threshold;
//
//    /**默认负载因子**/
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    /**转换成树的阀值**/
//    static final int TREEIFY_THRESHOLD = 8;
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    transient Node<K,V>[] table;
//
//
//    /**
//     * 定义内部类描述节点
//     * **/
//    static class Node<K,V> implements Map.Entry<K,V> {
//        final int hash;
//        final K key;
//        V value;
//        Node<K,V> next;
//
//        Node(int hash, K key, V value, Node<K,V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey()        { return key; }
//        public final V getValue()      { return value; }
//        public final String toString() { return key + "=" + value; }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        @Override
//        public final boolean equals(Object o) {
//            if (o == this) {
//                return true;
//            }
//            if (o instanceof Map.Entry) {
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    public static int tableSizeFor(int initialCapacity) {
//        return 1;
//    }
//
//    public MyHashMap(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0) {
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                    initialCapacity);
//        }
//        if (initialCapacity > MAXIMUM_CAPACITY) {
//            initialCapacity = MAXIMUM_CAPACITY;
//        }
//        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
//            throw new IllegalArgumentException("Illegal load factor: " +
//                    loadFactor);
//        }
//
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//
//    public MyHashMap(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//
//    public MyHashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//    }
//
//    @Override
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    @Override
//    public Set<Entry<K, V>> entrySet() {
//        return null;
//    }
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        Node<K,V>[] tab;
//        Node<K,V> p;
//        int n;
//        // 第一次如果为空，初始化桶
//        if ((tab = table) == null || (n = tab.length) == 0) {
//            n = (tab = resize()).length;
//        }
//        // 计算值放在桶的位置  int i = (n-1) & hash -> tab[i]
//        // 从桶中拿到hash值对应索引位置的头节点/根节点 p = tab[i]
//        int i  = (n - 1) & hash;
//        p = tab[i];
//        if (p == null) {
//            tab[i] = newNode(hash, key, value, null);
//        } else {
//            Node<K,V> e;
//            K k;
//
//            // key如果已经存在直接覆盖
//            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
//                e = p;
//            }
//
//            // 如果p是树节点
//            else if (p instanceof TreeNode) {
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            }
//            else {
//                // p是链表节点
//                for (int binCount = 0; ; ++binCount) {
//                    // 节点第一次插入
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        // 超过阀值将链表转成红黑树
//                        if (binCount >= TREEIFY_THRESHOLD - 1) {
//                            treeifyBin(tab, hash);
//                        }
//                        break;
//                    }
//                    // 节点已经存在
//                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
//                        break;
//                    }
//                    p = e;
//                }
//            }
//
//            // existing mapping for key
//            if (e != null) {
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null) {
//                    e.value = value;
//                }
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
//        return new Node<>(hash, key, value, next);
//    }
//
//    final Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        if (oldCap > 0) {
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
//                newThr = oldThr << 1; // double threshold
//            }
//        }
//        // initial capacity was placed in threshold
//        else if (oldThr > 0) {
//            newCap = oldThr;
//        }
//        else {               // zero initial threshold signifies using defaults
//            newCap = DEFAULT_INITIAL_CAPACITY;
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                    (int)ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;
//        @SuppressWarnings({"rawtypes","unchecked"})
//        HashMap.Node<K,V>[] newTab = (HashMap.Node<K,V>[])new HashMap.Node[newCap];
//        table = newTab;
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) {
//                HashMap.Node<K,V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof HashMap.TreeNode)
//                        ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        HashMap.Node<K,V> loHead = null, loTail = null;
//                        HashMap.Node<K,V> hiHead = null, hiTail = null;
//                        HashMap.Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//
//    static final class TreeNode<K,V> extends MyLinkedHashMap.Entry<K,V>{
//        TreeNode<K,V> parent;  // red-black tree links
//        TreeNode<K,V> left;
//        TreeNode<K,V> right;
//        TreeNode<K,V> prev;
//        boolean red;
//
//        TreeNode(int hash, K key, V value, Node<K, V> next) {
//            super(hash, key, value, next);
//        }
//    }
//
//}
