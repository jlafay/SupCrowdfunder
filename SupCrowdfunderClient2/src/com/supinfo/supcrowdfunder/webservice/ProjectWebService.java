package com.supinfo.supcrowdfunder.webservice;

import android.util.Log;
import com.supinfo.supcrowdfunder.R;
import com.supinfo.supcrowdfunder.application.ProjectApplication;
import com.supinfo.supcrowdfunder.model.Project;

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

public class ProjectWebService {

	private final String url = "http://10.0.2.2:8080/SupCrowdfunderSrv/resources/project";
    private static final String LOG_TAG = "SupCrowdfunder";


    public ProjectWebService() {
    }

    public List<Project> getAllProjects() {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            get.setHeader("Accept", "application/json");
            HttpResponse response = client.execute(get);
            String responseStr = EntityUtils.toString(response.getEntity());

            List<Project> projects = new ArrayList<Project>();
            if (responseStr != null && !responseStr.equals("null")) {
                JSONObject projectsObject = new JSONObject(responseStr);
                if (projectsObject.get("project") instanceof JSONArray) {
                    computeJsonArray(projects, projectsObject);
                } else if (projectsObject.get("project") instanceof JSONObject) {
                    computeJsonObject(projects, projectsObject.getJSONObject("project"));
                } else {
                    Log.e(LOG_TAG, "Unable to parse Json");
                }
            }
            return projects;
        } catch (IOException e) {
            Log.e(LOG_TAG, "Unable to execute request", e);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Unable to parse Json", e);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Unable to parse Date", e);
        }
        return new ArrayList<Project>();
    }

    private void computeJsonObject(List<Project> projects, JSONObject projectsObject) throws JSONException, ParseException {
        Project project = convertJsonIntoString(projectsObject);
        projects.add(project);
    }

    private void computeJsonArray(List<Project> projects, JSONObject projectsObject) throws JSONException, ParseException {
        JSONArray projectsArray = projectsObject.getJSONArray("project");
        for (int i = 0; i < projectsArray.length(); i++) {
            computeJsonObject(projects, projectsArray.getJSONObject(i));
        }
    }

    private Project convertJsonIntoString(JSONObject singleProjectJson) throws JSONException, ParseException {
    	Project project = new Project();
    	project.setId(singleProjectJson.getLong("id"));
    	project.setName(singleProjectJson.getString("name"));
    	project.setShortContent(singleProjectJson.getString("shortContent"));
    	project.setPrice(singleProjectJson.getLong("price"));
    	project.setContribution(singleProjectJson.getLong("contribution"));
    	project.setPercent(singleProjectJson.getLong("percent"));
    	
        return project;
    }
}
