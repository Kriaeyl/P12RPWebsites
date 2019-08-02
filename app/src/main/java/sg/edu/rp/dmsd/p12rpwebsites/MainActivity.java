package sg.edu.rp.dmsd.p12rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    Spinner sp1;
    Spinner sp2;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        b1 = findViewById(R.id.button);
        al = new ArrayList<>();
        aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, al);
        al.addAll(Arrays.asList(getResources().getStringArray(R.array.second)));
        sp2.setAdapter(aa);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] ono = null;
                switch (position) {
                    case 0:
                        ono = getResources().getStringArray(R.array.second);
                        break;
                    case 1:
                        ono = getResources().getStringArray(R.array.third);
                }
                al.clear();
                al.addAll(Arrays.asList(ono));
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String [][] sites = {
                        {"https://www.rp.edu.sg/", "https://www.rp.edu.sg/student-life"},
                        {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}
                };
                intent.putExtra("website", sites[sp1.getSelectedItemPosition()][sp2.getSelectedItemPosition()]);
                startActivity(intent);
            }
        });
    }
}
