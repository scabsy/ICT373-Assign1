/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class Lab6
{
    static ArrayList<String> str = new ArrayList<>();
    static ArrayList<Integer> ints = new ArrayList<>();
    static ImpOrderer imp = new ImpOrderer();
    static Orderer ord;
    
    public static void main(String[] args) 
    {
        String lowestStr;
        int lowestInt;
        
        str.add("horse");
        str.add("cat");
        str.add("dog");
        str.add("zebra");
        str.add("mouse");
        
        ints.add(8);
        ints.add(6);
        ints.add(25);
        ints.add(89);
        ints.add(15);
        
        lowestStr=(String)imp.minOf(str, ord);
        System.out.println(lowestStr);
        
        lowestInt=(Integer)imp.minOf(ints, ord);
        System.out.println(lowestInt);
    }
    
}
