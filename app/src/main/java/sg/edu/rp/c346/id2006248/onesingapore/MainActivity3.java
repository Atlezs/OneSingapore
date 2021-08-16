package sg.edu.rp.c346.id2006248.onesingapore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tv;
    EditText etSongID, etName, etYear, etSong, etHotel;
    Button btnUpdate, btnDelete, btnCancel;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etSongID = findViewById(R.id.etSongID);
        etName = findViewById(R.id.etName2);
        etYear = findViewById(R.id.etYear2);
        etSong = findViewById(R.id.etSong2);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        rb = findViewById(R.id.ratingBar3);
        tv = findViewById(R.id.textView8);
        etHotel = findViewById(R.id.etHotel2);

        Intent intent = getIntent();
        Location data = (Location) intent.getSerializableExtra("data");

        etSongID.setText(String.valueOf(data.getId()));
        etSong.setText(data.getTitle());
        etName.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));
        rb.setRating(data.getStars());
        int local = data.isLocal();
        etHotel.setText(data.getHotel());

        if(local == 1){
            tv.setVisibility(View.VISIBLE);
            etHotel.setVisibility(View.VISIBLE);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity3.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the Location \n" + data.getTitle());
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Cancel", null);

                myBuilder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper dbh = new DBHelper(MainActivity3.this);
                        dbh.deleteSong(data.getId());
                        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                        startActivity(intent);
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity3.this);
                data.setTitle(etSong.getText().toString());
                data.setSingers(etName.getText().toString());
                String data3 = etYear.getText().toString();
                int intData3 = Integer.parseInt(data3);
                data.setHotel(etHotel.getText().toString());

                data.setYear(intData3);
                data.setStars((int) rb.getRating());
                dbh.updateSong(data);
                dbh.close();

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity3.this);

                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to discard the changes?");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Do Not Discard", null);

                myBuilder.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                        startActivity(intent);
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

    }
}