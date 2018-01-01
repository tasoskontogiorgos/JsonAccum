package org.tasos.core;

import java.util.List;
import java.util.Map;

public class CNV
{

    public static Object Convert( Object o )
    {
        if( o instanceof  Map )
        {
            return Convert( ( Map ) o );
        }
        return o;
    }


    public static GenMap Convert( Map m)
   {
        String s = m.get( "$type" ).toString();
        switch ( s )
        {
            case "ObjectMap":
            {
                ObjectMap om = new ObjectMap();
                List l = (List ) m.get( "$value" );
                for( Object el : l )
                {
                    Map elm = ( Map )el;
                    Object k = Convert( elm.get( "$key" ));
                    Object v = Convert( elm.get( "$value" ));
                    om.putGen( k, v );
                }
                return om;
            }
            case "StringMap":
            {
                StringMap sm = new StringMap();
                for( Object k : m.keySet())
                {
                    sm.putGen( k, m.get( k ));
                }
                return sm;
            }
            default:
            {
                throw new RuntimeException("");
            }
        }
   }
}
