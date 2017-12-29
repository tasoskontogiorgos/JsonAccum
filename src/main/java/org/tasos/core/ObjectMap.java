package org.tasos.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class ObjectMap extends LinkedHashMap implements GenMap
{


    @SuppressWarnings("unchecked")
    public ObjectMap()
    {
        put( "$type", "ObjectMap" );
        put( "$value", m_dataList );
    }

    @Override
    public Object getGen(Object key)
    {
        return getObj( key );
    }

    @Override
    public Object putGen(Object key, Object value)
    {
        return putObj( key, value );
    }

    static private class Pair extends LinkedHashMap< Object, Object >
    {

        Pair( Object key, Object value )
        {
            put( "$key", key );
            put( "$value", value );
        }

        Object getKey()
        {
            return get( "$key" );
        }

        void setValue( Object value )
        {
            put( "$value", value );
        }
        Object getValue()
        {
            return get( "$value" );
        }
    }

    private List< Pair >    m_dataList = new ArrayList<>();






    private Object  putObj( Object key, Object value )
    {
        for( Pair p : m_dataList)
        {
            if( key.equals( p.getKey()))
            {
                p.setValue( value );
                return value;
            }
        }
        m_dataList.add( new Pair( key, value ));
        return value;
    }

    private Object  getObj( Object key  )
    {
        for( Pair p : m_dataList)
        {
            if( key.equals( p.getKey()))
            {
                return p.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        ObjectMapper om = new ObjectMapper();
        try
        {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString( this );
        } catch( Exception x )
        {
            return "Error: " + x.toString();
        }
    }

}
