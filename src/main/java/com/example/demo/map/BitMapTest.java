package com.example.demo.map;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

/**
 * java bitset
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/3/26 21:04
 */
public class BitMapTest {


    public static void main(String[] args) {

        BitSet bitSet = new BitSet();
        bitSet.set(32322);
        boolean b = bitSet.get(32322);

        System.out.println(b);

        HashMap<Integer, BitSet> integerBitSetHashMap = new HashMap<>();
        BitSet bitSet1 = integerBitSetHashMap.computeIfAbsent(187, k -> new BitSet());
        bitSet1.set(2332);
    }

}
