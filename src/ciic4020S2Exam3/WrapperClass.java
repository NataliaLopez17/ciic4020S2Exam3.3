package ciic4020S2Exam3;

import java.util.LinkedList;
import java.util.List;

public class WrapperClass {

	public interface Map<K, V> {

		public int size();

		public boolean isEmpty();

		public V get(K key);

		public V put(K key, V value);

		public V remove(K key);

		public boolean contains(K key);

		public List<K> getKeys();

		public List<V> getValues();

		public List<K> bucketPals(K key);

	}

	@SuppressWarnings("unchecked")

	public static class HashTable<K, V> implements Map<K, V> {

		public static class MapEntry<K, V> {
			private K key;
			private V value;

			public K getKey() {
				return key;
			}

			public void setKey(K key) {
				this.key = key;
			}

			public V getValue() {
				return value;
			}

			public void setValue(V value) {
				this.value = value;
			}

			public MapEntry(K key, V value) {
				super();
				this.key = key;
				this.value = value;
			}

		}

		private int currentSize;
		private Object[] buckets;
		private static final int DEFAULT_BUCKETS = 11;

		private int hashFunction(K key) {
			return key.hashCode() % this.buckets.length;
		}

		public HashTable(int numBuckets) {
			this.currentSize = 0;
			this.buckets = new Object[numBuckets];
			for (int i = 0; i < numBuckets; ++i) {
				this.buckets[i] = new LinkedList<MapEntry<K, V>>();
			}
		}

		public HashTable() {
			this(DEFAULT_BUCKETS);
		}

		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public V get(K key) {
			int targetBucket = this.hashFunction(key);
			List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) this.buckets[targetBucket];

			for (MapEntry<K, V> M : L) {
				if (M.getKey().equals(key)) {
					return M.getValue();
				}
			}
			return null;

		}

		@Override
		public V put(K key, V value) {
			V oldValue = this.get(key);
			if (oldValue != null) {
				this.remove(key);
			}
			int targetBucket = this.hashFunction(key);
			List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) this.buckets[targetBucket];
			MapEntry<K, V> M = new MapEntry<K, V>(key, value);
			L.add(0, M);
			this.currentSize++;

			return oldValue;
		}

		@Override
		public V remove(K key) {
			int targetBucket = this.hashFunction(key);
			List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) this.buckets[targetBucket];
			int i = 0;

			for (MapEntry<K, V> M : L) {
				if (M.getKey().equals(key)) {
					V result = M.getValue();
					L.remove(i);
					this.currentSize--;
					return result;
				} else {
					i++;
				}
			}
			return null;
		}

		@Override
		public boolean contains(K key) {
			return this.get(key) != null;
		}

		@Override
		public List<K> getKeys() {
			List<K> result = new LinkedList<>();

			for (Object o : this.buckets) {
				List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) o;
				for (MapEntry<K, V> M : L) {
					result.add(0, M.getKey());
				}
			}
			return result;
		}

		@Override
		public List<V> getValues() {
			List<V> result = new LinkedList<>();

			for (Object o : this.buckets) {
				List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) o;
				for (MapEntry<K, V> M : L) {
					result.add(0, M.getValue());
				}
			}
			return result;
		}

		public List<K> bucketPartners(K key) {
			// get the target bucket using hash function
			int targetBucket = this.hashFunction(key);
			// get the buckets entry list
			List<MapEntry<K, V>> L = (List<MapEntry<K, V>>) this.buckets[targetBucket];
			List<K> result = new LinkedList<K>();
			if (L != null) {
				for (MapEntry<K, V> entry : L) {
					if (entry.key != key) {
						result.add(entry.key);
					}
				}
			}
			return result;
		}

		@Override
		public List<K> bucketPals(K key) {
			int targetBucket = this.hashFunction(key);
			/*
			 * Within that bucket there is a linked list, since we're using Separate
			 * Chaining
			 */
			LinkedList<MapEntry<K, V>> L = (LinkedList<MapEntry<K, V>>) buckets[targetBucket];
			List<K> result = new LinkedList<K>();
			if (L.contains(key)) {
				for (MapEntry<K, V> node : L) {
					if (node.getKey().equals(key)) {
						result.add(node.getKey());
					}
				}
			}
			return result;
		}

	}

}