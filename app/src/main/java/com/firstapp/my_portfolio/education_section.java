package com.firstapp.my_portfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class education_section extends AppCompatActivity {

    Button graduate, intermediate, matric, project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education_section);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        graduate = findViewById(R.id.button1);
        intermediate = findViewById(R.id.button2);
        matric = findViewById(R.id.button3);
        project = findViewById(R.id.button4);

        graduate.setOnClickListener(v -> {
            openDegree();
        });

        intermediate.setOnClickListener(v -> {
            openIntermediate();
        });

        matric.setOnClickListener(v -> {
            openMatric();
        });


        project.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),project_activity.class);
            // here we use the getApplicationContext() it not a task or activity then we have to add flag so when we click on that a new activity started and come on the top of the stack
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // this is used to show the xml resources to in actual in the application
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // basically we select the item of the menu and match with the item id
        int itemId = item.getItemId();

        // it check which item is select by id and perform action
        if(itemId == R.id.home){
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(itemId == R.id.project){
            Intent intent = new Intent(this, project_activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(itemId == R.id.education){
            Intent intent = new Intent(this, education_section.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(itemId == R.id.connect_me){
            Intent intent = new Intent(this, contact_page.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void openDegree(){
        Uri degree = Uri.parse("https://drive.google.com/file/d/1GKT9pCTCj26cq_dm3eM2g8sWIkVUVI2P/view?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW,degree);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void openIntermediate(){
        Uri intermediate = Uri.parse("https://drive.google.com/file/d/1HI-waO3WSKMkQE9XBOOC1ZFsTne-5G5R/view?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW,intermediate);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void openMatric(){
        Uri matric = Uri.parse("https://drive.google.com/file/d/1GD4b10-P-WB4KDC6CPKkD6h_0fWVrCfz/view?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW,matric);
        // add the new task separately from the current task
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}