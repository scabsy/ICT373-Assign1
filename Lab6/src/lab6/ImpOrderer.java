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
public class ImpOrderer implements Orderer
{  
    public Object minOf(ArrayList a, Orderer b)
    {
        Object c;
        c = a.get(0);
        for(int i=1;i<a.size();i++)
        {
            if(isLOE(a.get(i),c))
            {
                c=a.get(i);
            }
        }
        
        return c;
    }
    
    public boolean isLOE(Object a, Object b) 
    {       
        return true;
    }
}
