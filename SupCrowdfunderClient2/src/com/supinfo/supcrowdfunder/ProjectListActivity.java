package com.supinfo.supcrowdfunder;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.supinfo.supcrowdfunder.R;
import com.supinfo.supcrowdfunder.adapter.ProjectListAdapter;
import com.supinfo.supcrowdfunder.model.Project;
import com.supinfo.supcrowdfunder.webservice.ProjectWebService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectListActivity extends Activity {

    public static final String PROJECT_INTENT_PARAMETER = "project";
    public static final String PROJECT_INDEX_INDENT_PARAMETER = "project_index";
    private static final int PROJECT_ACTIVITY = 1;
    private List<Project> projects = new ArrayList<Project>();
    private ProjectListAdapter projectAdapter;
    private ProjectWebService projectWebService;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);
        projectWebService = new ProjectWebService();
        projects = projectWebService.getAllProjects();
        initAdapter();
    }

    private void initAdapter() {
        projectAdapter = new ProjectListAdapter(this, android.R.layout.simple_list_item_1, projects);
        ListView projectList = (ListView) findViewById(R.id.projectList);
        projectList.setAdapter(projectAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PROJECT_ACTIVITY:
                computeProjectActivityResult(resultCode, data);
                break;
            default:
                throw new RuntimeException("Bad request code");
        }
    }

    private void computeProjectActivityResult(int resultCode, Intent data) {
        switch (resultCode) {
            case ProjectActivity.RESULT_OK:
                Bundle bundle = data.getExtras();
                Project project = (Project) bundle.getSerializable(PROJECT_INTENT_PARAMETER);
                int projectIndex = bundle.getInt(PROJECT_INDEX_INDENT_PARAMETER);
                projects.set(projectIndex, project);
                projectAdapter.notifyDataSetChanged();
                break;
            case ProjectActivity.RESULT_CANCELED:
                Toast.makeText(this, R.string.cancel_message, 1000).show();
                break;
            default:
                throw new RuntimeException("Bad result code");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        projects = (List<Project>) savedInstanceState.getSerializable(PROJECT_INTENT_PARAMETER);
        initAdapter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PROJECT_INTENT_PARAMETER, (Serializable) projects);
        super.onSaveInstanceState(outState);
    }
}