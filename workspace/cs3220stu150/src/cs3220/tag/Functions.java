package cs3220.tag;

public class Functions {

    public static String leetTalk( String s )
    {
        return s.replaceAll( "f", "ph" )
            .replace( 'a', '4' )
            .replace( 'e', '3' )
            .replace( 'l', '1' )
            .replace( 'o', '0' )
            .replace( 's', 'z' );
    }

}