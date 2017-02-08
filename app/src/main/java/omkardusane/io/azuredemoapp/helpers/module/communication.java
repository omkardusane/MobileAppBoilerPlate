package omkardusane.io.azuredemoapp.helpers.module;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Omkar Dusane on 08-Feb-17.
 */

public class communication {


    public static void sendFetchRequest(boolean isPost , RequestParams params, final jsonCallBack jsonCallback ,String url) {
        AsyncHttpResponseHandler asyncHttpResponseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (jsonCallback != null) {
                    JSONObject responseJson = null;
                    try {
                        responseJson = new JSONObject(new String(responseBody));
                        jsonCallback.callBack(responseJson, true);

                    } catch (JSONException e) {
                        jsonCallback.callBack(null, false);
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (jsonCallback != null && responseBody != null) {
                    JSONObject responseJson = null;
                    try {
                        responseJson = new JSONObject(new String(responseBody));
                        jsonCallback.callBack(responseJson, false);

                    } catch (JSONException e) {
                        jsonCallback.callBack(null, false);
                        e.printStackTrace();
                    }
                }
            }

        };
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", "appdemo");
        client.setMaxRetriesAndTimeout(8, 4500);
        if(isPost)
        {
            client.post(url, params, asyncHttpResponseHandler);
        }else{
            client.get(url, params, asyncHttpResponseHandler);
        }
    }

}
