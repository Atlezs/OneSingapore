package sg.edu.rp.c346.id2006248.onesingapore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText etSong, etName, etYear, etHotel;
    Button btnInsert, btnList;
    RatingBar rb;
    RadioButton rbutton, rbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSong = findViewById(R.id.etSong);
        etName = findViewById(R.id.etName);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rb = findViewById(R.id.ratingBar);
        etHotel = findViewById(R.id.etHotel);
        rbutton = findViewById(R.id.radioButton);
        rbutton2 = findViewById(R.id.radioButton2);
        tv = findViewById(R.id.textView7);

        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.GONE);
                etHotel.setVisibility(View.GONE);
            }
        });

        rbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.VISIBLE);
                etHotel.setVisibility(View.VISIBLE);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etSong.getText().toString();
                String data2 = etName.getText().toString();
                String data3 = etYear.getText().toString();
                int intData3 = Integer.parseInt(data3);
                int local;
                if(rbutton.isChecked()){
                    local = 0;
                } else {
                    local = 1;
                }
                String hotel = "";
                if(local == 1){
                    hotel = etHotel.getText().toString();
                }

                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertSong(data, data2, intData3, local, hotel, (int) rb.getRating());
                Toast.makeText(MainActivity.this,"Insert Successful",Toast.LENGTH_LONG).show();
            }
        });

    }
}