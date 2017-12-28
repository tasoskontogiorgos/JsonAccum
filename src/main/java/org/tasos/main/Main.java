package org.tasos.main;

import org.tasos.core.GenMap;
import org.tasos.core.ObjectMap;
import org.tasos.core.StringMap;

import java.util.Random;

public class Main
{

    private static Random s_rand  = new Random();

    private static GenMap ObjMap()
    {
        GenMap  a = new ObjectMap();

        int sz = s_rand.nextInt( 100 ) + 1;
        for( int i = 0; i < sz; i++ )
        {
            Object key = StrMap();
            Object value = StrMap();
            a.putGen( key, value );
        }

        return a;
    }

    private static GenMap StrMap()
    {
        GenMap  a = new StringMap();

        int sz = s_rand.nextInt( 100 ) + 1;
        for( int i = 0; i < sz; i++ )
        {
            String s = "key_" +  s_rand.nextInt();
            Double v = s_rand.nextDouble() * 1000;
            a.putGen( s, v );
        }

        return a;
    }


    public static void main(String[] args)
    {
        System.out.println( ObjMap() );


    }
}
