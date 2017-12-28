package org.tasos.main;

import org.tasos.core.GenMap;
import org.tasos.core.ObjectMap;
import org.tasos.core.StringMap;

import java.util.Random;

public class Main
{

    private static String[] s_names = {
            "Red",
            "Green",
            "Blue",
            "Left",
            "Right",
            "Up",
            "Down"
    };
    private static Random s_rand  = new Random();

    private static GenMap ObjMap()
    {
        GenMap  a = new ObjectMap();

        int sz = s_rand.nextInt( 3 ) + 1;
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

        int sz = s_rand.nextInt( 10 ) + 1;
        for( int i = 0; i < sz; i++ )
        {
            String k = s_names[ s_rand.nextInt( s_names.length)];
            String s = k + "_" +  s_rand.nextInt(10);
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
