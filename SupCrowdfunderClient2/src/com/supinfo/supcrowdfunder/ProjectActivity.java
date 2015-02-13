package com.supinfo.supcrowdfunder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.supinfo.supcrowdfunder.R;
import com.supinfo.supcrowdfunder.model.Project;

public class ProjectActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);

        Bundle bundle = getIntent().getExtras();
        final Project project = (Project) bundle.getSerializable(ProjectListActivity.PROJECT_INTENT_PARAMETER);
    }
}