import java.util.*;

public class SynchronizedListSample {
    public static void main(String[] args) throws InterruptedException {
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        synchronized (synchronizedList) {
            synchronizedList.add("One");
            synchronizedList.add("Two");
            synchronizedList.add("Three");

        }
		System.out.println("Synchronized List: " + synchronizedList);
		
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
		Runnable listOperations = () -> {
			syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		};
		
		Thread thread1 = new Thread(listOperations);
		Thread thread2 = new Thread(listOperations);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
		System.out.println("syncCollection: " + syncCollection);
		
		List<String> syncCollection2 = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
		List<String> uppercasedCollection = new ArrayList<>();
			
		Runnable listOperations2 = () -> {
			synchronized (syncCollection2) {
				syncCollection2.forEach((e) -> {
					uppercasedCollection.add(e.toUpperCase());
				});
			}
		};
		Thread thread3 = new Thread(listOperations2);
		thread3.start();
		thread3.join();
		System.out.println("syncCollection2: " + syncCollection2);
		System.out.println("uppercasedCollection: " + uppercasedCollection);
		
		//Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
		//Map<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
		//Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
		//SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());

    }
}

/*
https://www.baeldung.com/java-synchronized-collections#the-synchronizedCollection-method
8.1. Synchronized Collections 
Synchronized collections achieve thread-safety through intrinsic locking, and the entire collections are locked. Intrinsic locking is implemented via synchronized blocks within the wrapped collection’s methods.

As we might expect, synchronized collections assure data consistency/integrity in multi-threaded environments. However, they might come with a penalty in performance, as only one single thread can access the collection at a time (a.k.a. synchronized access).

For a detailed guide on how to use synchronized methods and blocks, please check our article on the topic.

8.2. Concurrent Collections
Concurrent collections (e.g. ConcurrentHashMap), achieve thread-safety by dividing their data into segments. In a ConcurrentHashMap, for example, different threads can acquire locks on each segment, so multiple threads can access the Map at the same time (a.k.a. concurrent access).

Concurrent collections are much more performant than synchronized collections, due to the inherent advantages of concurrent thread access.

So, the choice of what type of thread-safe collection to use depends on the requirements of each use case, and it should be evaluated accordingly.
/