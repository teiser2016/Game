package com.Game.Game.requestsDB;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://teiser2016.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String password, String mail, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("mail", mail);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}