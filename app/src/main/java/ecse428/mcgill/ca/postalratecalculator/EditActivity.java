package ecse428.mcgill.ca.postalratecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HenryChiang on 2016-02-20.
 */
public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mail);

        TextView title = (TextView)findViewById(R.id.edit_destination);
        title.setText("Sending to " + getIntent().getStringExtra("destination"));
    }
}
