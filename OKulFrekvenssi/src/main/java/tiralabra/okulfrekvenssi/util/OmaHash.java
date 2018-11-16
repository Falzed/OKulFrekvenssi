/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

/**
 *
 * @author Oskari
 * @param <K> avainten luokka
 * @param <V> arvojen luokka
 */
public class OmaHash<K, V> {
    private K key;
    private V value;
    private V[] table;

    /**
     * luo 256-paikkaisen taulun, riittää [a-z]
     */
    public OmaHash() {
        //nykytarkoituksiin riittävä, muistivaatimus ei optimi mutta
        //silti minimaalinen
        this.table = (V[]) new Object[256];
    }
    
    /**
     *
     * @param size määrää taulun koon
     */
    public OmaHash(int size) {
        this.table = (V[]) new Object[size];
    }
    
    //sama algoritmi kuin normi hashmapin hash-funktio

    /**
     *
     * @param key avain
     * @return hash
     */
    
    public static final int hash(Object key) {
        if(key == null) {
            return 0;
        } else {
            int h = key.hashCode();
            return h ^ (h >>> 16);
        }
    }

    /**
     *
     * @param k avain
     * @param v arvo
     */
    public void put(K k, V v) {
        this.table[OmaHash.hash(k)] = v;
    }

    /**
     *
     * @param k avain
     * @return arvo taulussa
     */
    public V get(K k) {
        return this.table[OmaHash.hash(k)];
    }
    
//    /**
//     *
//     * @return koko taulu
//     */
//    public V[] getTable() {
//        return this.table;
//    }
}
