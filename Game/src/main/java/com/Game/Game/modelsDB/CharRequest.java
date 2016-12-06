package com.Game.Game;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CharRequest extends StringRequest
{
    private static final String CHAROPTION_REQUEST_URL = "http://teiser2016.000webhostapp.com/charoption.php";
    private Map<String, String> params;

    public CharRequest(String char_name, Response.Listener<String> listener)
    {
        super(Method.POST, CHAROPTION_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("char_name", char_name);

    }

    @Override
    public Map<String, String> getParams()
    {

        return params;
    }
}
