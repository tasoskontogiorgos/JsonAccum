package org.tasos.main;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.tasos.core.CNV;
import org.tasos.core.GenMap;
import org.tasos.core.PathAccessor;

import java.io.File;
import java.util.Map;
import java.util.Objects;

public class Play
{


    public static void main(String... args) throws Exception
    {
        File f = new File( "src/resources/a.json");
        ObjectMapper om = new ObjectMapper();
        Map m = om.readValue( f, Map.class );
        GenMap gm = CNV.Convert( m );
       // System.out.println( gm );
        PathAccessor pa = new PathAccessor( "$value", 0 );
        Object o = pa.get( gm );
        System.out.printf(Objects.toString( o ) );
    }
}
