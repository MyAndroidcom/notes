##[HashMap原理](http://mp.weixin.qq.com/s?src=3&timestamp=1476015614&ver=1&signature=6QFjq9sccuvl*WhO1AgXD0agxTtbkcVK0MAZ1rsB1ujGtWSjNwKS9poPdPLyxhl8BH7L9i8s*TQmLAU7LG-cu*56ES3j3*Uh2mYEUU12SR*RYB0sKnKVg6NmZhhfjlY8WZQmh-TIGOqECHB-sXFY6plnkbAexb6sSvtfZcf8UXU=)
- HashMap有一个特性key是唯一值，在HashMap（jdk1.7）的put方法实现中首先利用了hash()生成key的hashCode，然后比较key的hashCode是否已经存在集合，如果不存在，就插入到集合，如果已存在，则返回null。
#### hashCode方法和equals方法比较
HashCode是jdk根据对象的地址或字符串或者数字利用hash算法计算出的int类型的数值。Java采用了哈希表的原理，将数据依照特定算法直接指定到一个地址上，这样可以简单的理解为hashCode方法返回的就是对象存储位置的映像。因此HashCode能够快速的定位对象所在的地址，并且根据Hash常规协定，如果两个对象相等，则他们一定有相同的HashCode。而equals方法对比两个对象实例是否相等时，对比的就是对象示例的ID（内存地址）是否是同一个对象实例；该方法是利用的等号（==）的判断结果。所以HashCode的效率远远大于equals,但是HashCode并不保证唯一性，因此当对象的HashCode相同时，再利用equals方法来判断两个对象是否相同，就大大加快了对比的速度。equals()比较的是key相等，hashCode()则是计算出插入槽的位置。
     
     ####   java对象比较方法总结
“ == ”：对比对象实例的内存地址来判断是否是同一个对象；
 equals()：当对象没有重写Object的equals方法时，equals方法判断的是对象实例的ID，也就是内存地址，是否是同一对象实例；该方法就是使用等号（==）的判断结果。Object类的源码如下：public boolean equals(Object obj) {
        return (this == obj);
    }
 hashCode()：根据对象的地址或字符串或者数字等计算出对象实例的哈希码。可以简单的说，hashCode比较的是对象的内存地址。
 **hash算法**的意义在于提供了一种快速存取数据的方法,它用一种算法建立键值与真实值之间的对应关系,(每一个真实值只能有一个键值,但是一个键值可以对应多个真实值),这样可以快速在数组等里面存取数据。HashMap就是采用了Hash算法来实现快速存取数据。
 **注意**：jdk1.8版本对HashMap改动很大，jdk1.7之前的版本，HashMap采用的是链表+位桶的方式，也就是我们经常说的散列表的方式，但是在jdk1.8版本中，HashMap采用的是位桶+链表/红黑树的方式，也是非线程安全的。当某个位桶的链表的长度到达某个阈值的时候，这个链表就转化为红黑树。
 
 ### HashMap是什么
 HashMap线程非安全，Hahtable线程安全的
 HashMap基于哈希表的 Map 接口的实现。此实现提供所有可选的Map操作，并允许使用 null 值和 null 键。（除了非同步和允许使用 null 之外，HashMap 类与 Hashtable 大致相同。）此类不保证映射的顺序，特别是它不保证该顺序恒久不变。        
 HashMap的实例有两个参数影响其性能：**初始容量**和**加载因子**。容量是哈希表中桶的数量，初始容量只是哈希表在创建时的容量。加载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度。当哈希表中的条目数超出了加载因子与当前容量的乘积时，则要对该哈希表进行rehash操作（重建内部数据结构），从而哈希表将具有大约两倍的桶数。
 通常默认加载因子(.75)在时间和空间成本上寻求一种折衷。加载因子过高虽然减小了空间开销，但是同时也增加了查询成本。在设置初始容量时应该考虑到映射中所需的条目数及其加载因子，以便最大限度地减少rehash操作次数。如果初始容量大于最大条目数除以加载因子，则不会发生rehash操作。

### HashTable是什么

#### HashMap和HashTable的区别
- HashMap是非线程同步的，HashTable是线程同步的。
- HashMap允许null作为键或者值，HashTable不允许
- HashTable中有个一个contains方法，HashMap去掉了此方法
-  效率上来讲，HashMap因为是非线程安全的，因此效率比HashTable高
- 从定义上看，hashTable继承Dictionary，而HashMap继承Abstract
- 从实现上看，hashTable的put方法实现了同步，而hashMap没有hashMap的put、get方法源码：

				 public V put(K key, V value) {
				        if (key == null)
				            return putForNullKey(value);
				        int hash = hash(key.hashCode());
				        int i = indexFor(hash, table.length);
				        //indexFor(hash,table.length)计算槽的索引 return  hash & table.length-1
				        for (Entry<K,V> e = table[i]; e != null; e = e.next) { 
				         //如果table(默认16)中table[i]处有值，
				        //hash冲突,解决hash冲突问题[hash值相同，key值相同],覆盖以前的value并返回oldvalue
				            Object k;
				            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				                V oldValue = e.value;
				                e.value = value;  
				                e.recordAccess(this);
				                return oldValue;
				            }
				        }
			
			        modCount++;
			        addEntry(hash, key, value, i);
			        //如果此处有值hash并没有冲突则扩容
		void addEntry(int hash, K key, V value, int bucketIndex) {
		        if ((size >= threshold) && (null != table[bucketIndex])) {
		            resize(2 * table.length);  //threshold=加载因子*table.length扩容
		            hash = (null != key) ? hash(key) : 0;
		            bucketIndex = indexFor(hash, table.length);//再次计算索引
		        }
		//把值存放
        createEntry(hash, key, value, bucketIndex);
		
		void createEntry(int hash, K key, V value, int bucketIndex) {
		        Entry<K,V> e = table[bucketIndex];
		        table[bucketIndex] = new Entry<>(hash, key, value, e);
		        size++;
		    }
	    }


			        return null;
			    }


			public V get(Object key) {
			        if (key == null)
			            return getForNullKey();
			        int hash = hash(key.hashCode());
			        for (Entry<K,V> e = table[indexFor(hash, table.length)];
			             e != null;
			             e = e.next) {
			            Object k;
			            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
			                return e.value;
			        }
			        return null;
			    }

			//HashTable中的put()
				public synchronized V put(K key, V value) {
				        // Make sure the value is not null
				        if (value == null) {
				            throw new NullPointerException();
				        }

        // Makes sure the key is not already in the hashtable.
        Entry tab[] = table;
        int hash = hash(key);
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        modCount++;
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            hash = hash(key);
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        Entry<K,V> e = tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
        return null;
    }


从源码中可以看到HashMap解决hash冲突时必须要保证e.hash==hash && (k = e.key || key.equal(k))即hash值一样，equals()比较结果一样.

### HashMap的存储结构
HashMap的数据结构是基于数组和链表的.

- 数组的存取区间是连续的，占用内存严重，因此空间复杂度很大。但是数组的二分查找事件复杂度小为O(1);数组的特点是：寻址容易，插入和删除困难
- 链表的存储区间离散，占用内存比较松散，因此空间复杂度很小，单事件复杂度很大，达O（N）。链表的特点是：寻址困难，插入和删除容易
- Java的HashMap是通过“拉链法”实现的哈希表。包括table、size、threshold、loadFactor和modCount。其中table是一个Entry[]数组类型，而Entry实际上是一个单向链表。哈希表的“key-value键值对”都是存放在Entry数组中。size是HashMap的大小，它是HashMap保存的键值对的数量。threshold是HashMap的阈值，用于判断是否需要调整HashMap的容量。threshold = “容量 * 加载因子”，当HashMap中存储数据的数量达到threshold值时，就需要rehash，将HashMap容量扩展到原来的2倍。loadFactor就是加载因子。modCount用来实现fail-fast机制。

