package com.supinfo.supcrowdfunder.webservice;

import android.util.Log;
import com.supinfo.supcrowdfunder.R;
import com.supinfo.supcrowdfunder.application.ProjectApplication;
import com.supinfo.supcrowdfunder.model.Category;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CategoryWebService{

    private static final String LOG_TAG = "SupCrowdfunder";

    public CategoryWebService() {
    }
}
