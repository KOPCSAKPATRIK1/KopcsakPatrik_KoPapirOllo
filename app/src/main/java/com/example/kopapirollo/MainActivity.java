package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView emberKep;
    private ImageView gepKep;
    private Button koBtn;
    private Button papirBtn;
    private Button olloBtn;
    private TextView gepPont;
    private TextView emberPont;
    private int gepEredmeny, emberEredmeny, emberValasztott, gepValasztott;
    private Random rnd; //1 ko, 2 papir, 3 ollo
    private AlertDialog.Builder jatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gepValasztott = rnd.nextInt(3);
                emberValasztott = 1;
                emberKep.setImageResource(R.drawable.rock);

                if (emberValasztott == gepValasztott)
                {
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if (gepValasztott == 2)
                {
                    gepKep.setImageResource(R.drawable.paper);
                    gepEredmeny++;
                    gepPont.setText("Computer: " + String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "Gép Nyert", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    gepKep.setImageResource(R.drawable.scissors);
                    emberEredmeny++;
                    emberPont.setText("Ember: " + String.valueOf(emberEredmeny) +" ");
                    Toast.makeText(MainActivity.this, "Te Nyertél", Toast.LENGTH_SHORT).show();
                }

                if (emberEredmeny == 3)
                {
                    jatekVege.setTitle("Győzelem").create();
                    jatekVege.show();
                }
                else  if (gepEredmeny == 3)
                {
                    jatekVege.setTitle("Vereség").create();
                    jatekVege.show();
                }
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gepValasztott = rnd.nextInt(3);
                emberValasztott = 2;
                emberKep.setImageResource(R.drawable.paper);

                if (emberValasztott == gepValasztott)
                {
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if (gepValasztott == 1)
                {
                    gepKep.setImageResource(R.drawable.rock);
                    emberEredmeny++;
                    emberPont.setText("Ember: " + String.valueOf(emberEredmeny) +" ");
                    Toast.makeText(MainActivity.this, "Te Nyertél", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    gepKep.setImageResource(R.drawable.scissors);
                    gepEredmeny++;
                    gepPont.setText("Computer: " + String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "Gép Nyert", Toast.LENGTH_SHORT).show();
                }

                if (emberEredmeny == 3)
                {
                    jatekVege.setTitle("Győzelem").create();
                    jatekVege.show();
                }
                else  if (gepEredmeny == 3)
                {
                    jatekVege.setTitle("Vereség").create();
                    jatekVege.show();
                }
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gepValasztott = rnd.nextInt(3);
                emberValasztott = 3;
                emberKep.setImageResource(R.drawable.scissors);

                if (emberValasztott == gepValasztott)
                {
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if (gepValasztott == 2)
                {
                    gepKep.setImageResource(R.drawable.paper);
                    emberEredmeny++;
                    emberPont.setText("Ember: " + String.valueOf(emberEredmeny) +" ");
                    Toast.makeText(MainActivity.this, "Te Nyertél", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    gepKep.setImageResource(R.drawable.rock);
                    gepEredmeny++;
                    gepPont.setText("Computer: " + String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "Gép Nyert", Toast.LENGTH_SHORT).show();
                }

                if (emberEredmeny == 3)
                {
                    jatekVege.setTitle("Győzelem").create();
                    jatekVege.show();
                }
                else  if (gepEredmeny == 3)
                {
                    jatekVege.setTitle("Vereség").create();
                    jatekVege.show();
                }
            }
        });

    }

    private void init()
    {
        emberKep = findViewById(R.id.teValasztasod);
        gepKep = findViewById(R.id.gepValasztasa);
        koBtn = findViewById(R.id.ko_btn);
        papirBtn = findViewById(R.id.papir_btn);
        olloBtn = findViewById(R.id.ollo_btn);
        gepPont = findViewById(R.id.gepPont);
        emberPont = findViewById(R.id.emberPont);
        gepEredmeny = 0;
        emberEredmeny = 0;
        emberValasztott = 0;
        gepValasztott = 0;
        rnd = new Random();
        jatekVege = new AlertDialog.Builder(MainActivity.this);
        jatekVege.setCancelable(false)
                .setTitle("Jatek Vege")
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }

                    private void ujJatek() {
                        gepEredmeny = 0;
                        emberEredmeny = 0;
                        gepPont.setText("Computer: " + String.valueOf(gepEredmeny));
                        emberPont.setText("Ember: " + String.valueOf(emberEredmeny) +" ");
                    }
                }).create();
    }
}