package org.tasos.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PathAccessor
{

    interface Acc
    {
        Object get( Object o );
    }

    private class MapAcc  implements Acc
    {
        private final Object m_key;

        MapAcc( Object key )
        {
            m_key = key;
        }


        @Override
        public Object get(Object o)
        {
            if( o instanceof Map )
            {
                Map m = ( Map ) o;
                if( m.containsKey( m_key ))
                {
                    return m.get( m_key );
                }
            }
            return ((GenMap) o ).getGen( m_key );
        }
    }

    private class ListAcc implements Acc
    {
        private final int m_index;

        ListAcc( int index )
        {
            m_index = index;
        }

        @Override
        public Object get( Object o )
        {
            return ((List) o ).get( m_index );
        }
    }

    private final List< Acc > m_elements = new ArrayList<>();

    public PathAccessor( Object ... raw )
    {
        for( Object r : raw )
        {
            if (r instanceof Integer)
            {
                int index = ( Integer )r;
                m_elements.add( new ListAcc( index ));
                continue;
            }

            if (r instanceof String)
            {
                m_elements.add( new MapAcc( r.toString() ));
                continue;
            }
            throw new RuntimeException("Illegal type");
        }
    }


    public Object get( Object o )
    {
        for( Acc acc : m_elements )
        {
            o = acc.get( o );
        }
        return o;
    }

}
