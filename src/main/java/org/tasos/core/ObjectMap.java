package org.tasos.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectMap implements GenMap
{

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

    static private class Pair extends HashMap< Object, Object >
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

    private List< Pair > m_data = new ArrayList<>();

    public ObjectMap()
    {

    }

    private Object  putObj( Object key, Object value )
    {
        for( Pair p : m_data )
        {
            if( key.equals( p.getKey()))
            {
                p.setValue( value );
                return value;
            }
        }
        m_data.add( new Pair( key, value ));
        return value;
    }

    private Object  getObj( Object key  )
    {
        for( Pair p : m_data )
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
            return om.writerWithDefaultPrettyPrinter().writeValueAsString( m_data );
        } catch( Exception x )
        {
            return "Error: " + x.toString();
        }
    }

}
