package com.firstapp.my_portfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class contact_page extends AppCompatActivity {

    EditText name,email,number,message;
    ImageView instagram,linkedin,github,whatsapp,emails;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // link all the attributes with the java code
        name = findViewById(R.id.edit1);
        email = findViewById(R.id.edit2);
        number = findViewById(R.id.edit3);
        message = findViewById(R.id.edit4);
        instagram = findViewById(R.id.image2);
        github = findViewById(R.id.image3);
        linkedin = findViewById(R.id.image4);
        whatsapp = findViewById(R.id.image5);
        emails = findViewById(R.id.image6);
        submit = findViewById(R.id.button);

        String[] info = new String[4];

        instagram.setOnClickListener(v ->{
            openInstagram();
        });

        github.setOnClickListener(v_->{
            openGithub();
        });

        linkedin.setOnClickListener(v_->{
            openLinkedin();
        });

        whatsapp.setOnClickListener(v_->{
            openWhatsapp();
        });
        emails.setOnClickListener(v->{
            openEmail();
        });

        // additionally, when the user click on the submit button then the info sent it to my mail
        submit.setOnClickListener(v ->{
            info[0] = name.getText().toString();
            info[1] = email.getText().toString();
            info[2] = number.getText().toString();
            info[3] = message.getText().toString();
            // click on the submit button then data is saved in the string array and the space of name, email, number, message is cleared
            name.setText("");
            email.setText("");
            number.setText("");
            message.setText("");
            Toast.makeText(this, "Message Sent, Connect With You Soon😊", Toast.LENGTH_SHORT).show();
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
    public void openInstagram(){
        Uri instagram = Uri.parse("https://www.instagram.com/zunaid_728");
        Intent intent = new Intent(Intent.ACTION_VIEW,instagram);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
    public void openGithub(){
        Uri github = Uri.parse("https://github.com/zunaidali-728");
        Intent intent = new Intent(Intent.ACTION_VIEW,github);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
    public void openLinkedin(){
        Uri linkedin = Uri.parse("https://www.linkedin.com/in/md-zunaid-ali-315bb8229");
        Intent intent = new Intent(Intent.ACTION_VIEW,linkedin);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
    public void openWhatsapp(){
        Uri whatsapp = Uri.parse("https://wa.me/qr/XDOBYOIDSBSUI1");
        Intent intent = new Intent(Intent.ACTION_VIEW,whatsapp);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this tell android to open in new separate task instead of mix with the ongoing task...
        startActivity(intent);
    }
    public void openEmail(){
        //Intent.ACTION_SENDTO is used when you want to send data to another app to perform an action. It's specifically designed for sending data to another component.
        // it will open the email and the add my email at the to:  space
//        EXTRA_CC - For CC recipients
//        EXTRA_BCC - For BCC recipients
//        EXTRA_SUBJECT - For the email subject
//        EXTRA_TEXT - For the email body
        Intent mail = new Intent(Intent.ACTION_SENDTO); // sendTo is used send it specific application
//        step 1 set the data
        mail.setData(Uri.parse("mailto:")); // Only email apps can handle this, setData() is used to set the action to send email

//        step 2 -> add the extra with intent to get prefilled space like to,subject,body
        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"zunaid12stat@gmail.com"}); // place with your email "to" filed at email
        mail.putExtra(Intent.EXTRA_SUBJECT, "Contact from Portfolio App"); // Pre-fills the email subject
        mail.putExtra(Intent.EXTRA_TEXT, "Hello!!,\n"); // Pre-fills the email body


//        step 3 --> open email. set the target app
        mail.setPackage("com.google.android.gm"); // open the particular application


        // before open this, check the app is install in your device is not
        if(getIntent().resolveActivity(getPackageManager()) != null){
            mail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(mail,"Send Email")); // it shows the user email applications to choose
        }
        else{
            Toast.makeText(this, "App is not installed", Toast.LENGTH_SHORT).show();
        }

    }
}