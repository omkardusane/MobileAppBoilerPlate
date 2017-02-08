package omkardusane.io.azuredemoapp.utils;

/**
 * Created by Omkar Dusane on 08-Feb-17.
 */

public interface urls {

    public static final String WEB_SERVER_URL = "azure_url";
    public static final String LOCAL_NETWORK_SERVER = "http://192.168.1.5:3000";

    public static final String APP = LOCAL_NETWORK_SERVER ;


    public static final String LOGIN = APP + "/signIn" ;
    public static final String SIGNUP = APP + "/signUp" ;
    public static final String DO_SOMETHING = APP + "/things/do" ;

}
