package com.Game.Game.requestsDB;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DialogRequest extends StringRequest
{
    private static final String DIALOG_REQUEST_URL = "http://teiser2016.000webhostapp.com/dialog.php";
    private Map<String, String> params;

    public DialogRequest(String text1,String text2, Response.Listener<String> listener)
    {
        super(Method.POST, DIALOG_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("text1", text1);
        params.put("text2", text2);

    }

    @Override
    public Map<String, String> getParams()
    {

        return params;
    }
}
