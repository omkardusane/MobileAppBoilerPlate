package omkardusane.io.azuredemoapp.helpers;

import com.loopj.android.http.RequestParams;

import omkardusane.io.azuredemoapp.helpers.module.communication;
import omkardusane.io.azuredemoapp.helpers.module.jsonCallBack;
import omkardusane.io.azuredemoapp.utils.keys;
import omkardusane.io.azuredemoapp.utils.urls;

/**
 * Created by Omkar Dusane on 08-Feb-17.
 */

public class HttpApiHelper {

    public static void login(String username, String password, jsonCallBack callback){
        RequestParams requestParams = new RequestParams();
        requestParams.put(keys.USERNAME, username );
        requestParams.put(keys.PASSWORD, password );
        communication.sendFetchRequest(true,requestParams,callback, urls.LOGIN);
    }

    public static void signup(String username, String password, jsonCallBack callback){
        RequestParams requestParams = new RequestParams();
        requestParams.put(keys.USERNAME, username );
        requestParams.put(keys.PASSWORD, password );
        communication.sendFetchRequest(true,requestParams,callback, urls.SIGNUP);
    }


}
