package com.chenxuan.common.utils.ktx

import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * @author cx
 * 中缀函数
 */
infix fun <E> ArrayList<E>.ktxAdd(e: E) = this.add(e)

infix fun <E> ArrayList<E>.ktxRemove(e: E) = this.remove(e)

infix fun <E> ArrayList<E>.ktxRemove(index: Int) = this.removeAt(index)

infix fun <E> ArrayList<E>.ktxContains(e: E) = this.contains(e)

infix fun <E, T : E> ArrayList<E>.ktxAddAll(t: Collection<T>) = this.addAll(t)


infix fun <E> LinkedList<E>.ktxAdd(e: E) = this.add(e)

infix fun <E> LinkedList<E>.ktxRemove(e: E) = this.remove(e)

infix fun <E> LinkedList<E>.ktxRemove(index: Int) = this.removeAt(index)

infix fun <E> LinkedList<E>.ktxContains(e: E): Boolean = this.contains(e)

infix fun <E, T : E> LinkedList<E>.ktxAddAll(t: Collection<T>) = this.addAll(t)


infix fun <K, V> HashMap<K, V>.ktxGet(k: K) = this[k]

infix fun <K, V> HashMap<K, V>.ktxContainsKey(k: K) = this.containsKey(k)

infix fun <K, V> HashMap<K, V>.ktxContainsValue(v: V) = this.containsValue(v)

infix fun <K, V> HashMap<K, V>.ktxRemove(k: K) = this.remove(k)

infix fun <K, V, M : K, N : V> HashMap<K, V>.ktxPutAll(map: Map<M, N>) = this.putAll(map)


infix fun <K, V> LinkedHashMap<K, V>.ktxGet(k: K) = this[k]

infix fun <K, V> LinkedHashMap<K, V>.ktxContainsKey(k: K) = this.containsKey(k)

infix fun <K, V> LinkedHashMap<K, V>.ktxContainsValue(v: V) = this.containsValue(v)

infix fun <K, V> LinkedHashMap<K, V>.ktxRemove(k: K) = this.remove(k)

infix fun <K, V, M : K, N : V> LinkedHashMap<K, V>.ktxPutAll(map: Map<M, N>) = this.putAll(map)


infix fun <K, V> ConcurrentHashMap<K, V>.ktxGet(k: K) = this[k]

infix fun <K, V> ConcurrentHashMap<K, V>.ktxContainsKey(k: K) = this.containsKey(k)

infix fun <K, V> ConcurrentHashMap<K, V>.ktxContainsValue(v: V) = this.containsValue(v)

infix fun <K, V> ConcurrentHashMap<K, V>.ktxRemove(k: K) = this.remove(k)

infix fun <K, V, M : K, N : V> ConcurrentHashMap<K, V>.ktxPutAll(map: Map<M, N>) = this.putAll(map)


infix fun <K, V> TreeMap<K, V>.ktxGet(k: K) = this[k]

infix fun <K, V> TreeMap<K, V>.ktxContainsKey(k: K) = this.containsKey(k)

infix fun <K, V> TreeMap<K, V>.ktxContainsValue(v: V) = this.containsValue(v)

infix fun <K, V> TreeMap<K, V>.ktxRemove(k: K) = this.remove(k)

infix fun <K, V, M : K, N : V> TreeMap<K, V>.ktxPutAll(map: Map<M, N>) = this.putAll(map)


infix fun <E> HashSet<E>.ktxAdd(e: E) = this.add(e)

infix fun <E> HashSet<E>.ktxRemove(e: E) = this.remove(e)

infix fun <E> HashSet<E>.ktxContains(e: E) = this.contains(e)

infix fun <E, T : E> HashSet<E>.ktxAddAll(t: Collection<T>) = this.addAll(t)


infix fun <E> LinkedHashSet<E>.ktxAdd(e: E) = this.add(e)

infix fun <E> LinkedHashSet<E>.ktxRemove(e: E) = this.remove(e)

infix fun <E> LinkedHashSet<E>.ktxContains(e: E) = this.contains(e)

infix fun <E, T : E> LinkedHashSet<E>.ktxAddAll(t: Collection<T>) = this.addAll(t)


infix fun <E> TreeSet<E>.ktxAdd(e: E) = this.add(e)

infix fun <E> TreeSet<E>.ktxRemove(e: E) = this.remove(e)

infix fun <E> TreeSet<E>.ktxContains(e: E) = this.contains(e)

infix fun <E, T : E> TreeSet<E>.ktxAddAll(t: Collection<T>) = this.addAll(t)
