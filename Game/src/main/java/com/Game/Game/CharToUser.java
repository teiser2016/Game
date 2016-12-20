package com.Game.Game;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CharToUser extends StringRequest {
    private static final String CHARTOUSER_URL = "http://teiser2016.000webhostapp.com/chartouser.php";
    private Map<String, String> params;




    public CharToUser(String Cd,String user_name,Response.Listener<String> listener)
    {
        super(Method.POST, CHARTOUSER_URL, listener, null);
        params = new HashMap<>();
        params.put("char_id",Cd);
        params.put("username",user_name);
    }



    @Override
    public Map<String, String> getParams()
    {

        return params;
    }
}