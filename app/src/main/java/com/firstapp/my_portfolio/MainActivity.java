package com.firstapp.my_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button knowMore;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        knowMore = findViewById(R.id.button);
        profile = findViewById(R.id.image2);

        knowMore.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, education_section.class);
            // here we don't need to add the flag Flaf activity new tack because here we use the activity and it becomes the activity
            startActivity(intent);
        });

        profile.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Hey, it's Me, Zunaid..", Toast.LENGTH_SHORT).show());

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
}