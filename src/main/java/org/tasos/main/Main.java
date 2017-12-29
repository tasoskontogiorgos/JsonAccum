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
            Object value = Val();
            a.putGen( key, value );
        }

        return a;
    }


    static int s_depth = 0;
    private static Object Val()
    {
        try {
            s_depth++;
            if (s_depth >= 3) {
                return s_rand.nextDouble() * 100;
            }
            int k = s_rand.nextInt(2);
            if (k == 0) {
                return ObjMap();
            } else
            {
                return StrMap();
            }

        } finally {
            s_depth--;
        }
    }

    private static GenMap StrMap()
    {
        GenMap  a = new StringMap();

        int sz = s_rand.nextInt( 10 ) + 1;
        for( int i = 0; i < sz; i++ )
        {
            String k = s_names[ s_rand.nextInt( s_names.length)];
            String s = k + "_" +  s_rand.nextInt(10);
            a.putGen( s, Val() );
        }

        return a;
    }


    public static void main(String[] args)
    {
        System.out.println( ObjMap() );


    }
}
