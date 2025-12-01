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

public class project_activity extends AppCompatActivity {

    Button project, resume, contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        project = findViewById(R.id.button1);
        resume = findViewById(R.id.button2);
        contact = findViewById(R.id.button3);

        contact.setOnClickListener(v->{
            Intent intent = new Intent(project_activity.this, contact_page.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // no need to add the flags here because we use the activity context and it becomes the activity
             startActivity(intent);
        });

        resume.setOnClickListener(v->{
            openResume();
        });

        project.setOnClickListener(v -> {
            openProject();
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
    public void openResume(){
        Uri resume = Uri.parse("https://drive.google.com/file/d/1J-KTIr7yjYo3HE-Zq19SRNgTcByqkaZV/view?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW, resume);
        // when ever we open the some resources of external links then we use this
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
    public void openProject(){
        Uri project = Uri.parse("https://github.com/zunaidali-728/Food---Donation-APP");
        Intent intent = new Intent(Intent.ACTION_VIEW,project);
        //always use before start the activity
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
}