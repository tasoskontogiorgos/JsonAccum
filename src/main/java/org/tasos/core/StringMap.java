package org.tasos.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class StringMap extends LinkedHashMap< String, Object > implements GenMap
{

    public StringMap()
    {
        putStr( "$type", "StringMap" );
    }

    private Object  putStr( String key, Object value )
    {
        return put( key, value );
    }

    private Object  getStr( String key  )
    {
        return  get( key );
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

    @Override
    public Object getGen(Object key)
    {
        return getStr( key.toString() );
    }

    @Override
    public Object putGen(Object key, Object value)
    {
        return putStr( key.toString(), value );
    }
}
