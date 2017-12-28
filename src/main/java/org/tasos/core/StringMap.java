package org.tasos.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class StringMap
{
    private Map< String, Object >       m_data = new HashMap<>();

    public StringMap()
    {

    }

    public Object  put( String key, Object value )
    {
        return m_data.put( key, value );
    }

    public Object  get( String key  )
    {
        return m_data.get( key );
    }

    @Override
    public String toString()
    {
        ObjectMapper om = new ObjectMapper();
        try
        {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(m_data);
        } catch( Exception x )
        {
            return "Error: " + x.toString();
        }
    }

}
