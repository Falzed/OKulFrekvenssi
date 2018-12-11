/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

/**
 *
 * @author Oskari
 * @param <V>
 */
public class OmaJono<V> {

    private V[] arr;
    private int head;
    private int max;
    private int length;

    public OmaJono() {
        arr = (V[]) new Object[256];
        head = 0;
        max = 256;
        length = 0;
    }
    
    public OmaJono (int maxSize) {
        arr = (V[]) new Object[maxSize];
        head = 0;
        max = maxSize;
        length = 0;
    }

    public V dequeue() {
        if (length == 0) {
            System.out.println("attempting to dequeue length 0 queue");
            return null;
        } else {
            V ret = arr[head];
            head = head + 1 >= max ? head + 1 : 0;
            length--;
            return ret;
        }
    }

    public void queue(V val) {
        if (length>=max) {
            System.out.println("queue already at capacity");
        } else {
            arr[(head + length) % max] = val;
            length++;
        }
    }
}
