/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.okulfrekvenssi.util;

/**
 *
 * @author Oskari
 */
public class OmaTuple {
    private final int luku;
    private final char merkki;
    public OmaTuple(int a, char c) {
        this.luku=a;
        this.merkki=c;
    }
    public int getInt() {
        return this.luku;
    }
    public char getMerkki() {
        return this.merkki;
    }
    @Override
    public String toString() {
        return String.valueOf(merkki)+": "+luku;
    }
}
