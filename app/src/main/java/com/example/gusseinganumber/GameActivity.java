package com.example.gusseinganumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView TRight,Tlast , THINT;
    Button button;
    EditText GUESS;
    Boolean twodigit,threedigit,fourdigit;
    Random random=new Random();
    int r;
    int RmainGuess=10;
    ArrayList<Integer> list = new ArrayList<>();
    int Attempt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        THINT = findViewById(R.id.t3);
        TRight = findViewById(R.id.t1);
        Tlast = findViewById(R.id.t2);
        button = findViewById(R.id.cheakbtn);
        GUESS = findViewById(R.id.textGuess);

        twodigit = getIntent().getBooleanExtra("two", false);
        threedigit = getIntent().getBooleanExtra("three",false);
        fourdigit = getIntent().getBooleanExtra("four",false);

        if(twodigit){
            r = random.nextInt(90)+10;

        }
        if(threedigit){
            r = random.nextInt(900)+100;

        }
        if(fourdigit){
            r = random.nextInt(9000)+1000;

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = GUESS.getText().toString();

                if(guess.equals("")) {
                    Toast.makeText(GameActivity.this, "Pleas Guess Your Number First", Toast.LENGTH_SHORT).show();
                }
             else {
                   Tlast.setVisibility(view.VISIBLE);
                    TRight.setVisibility(View.VISIBLE);
                    THINT.setVisibility(View.VISIBLE);
//
                   Attempt++;
                    RmainGuess--;
                    Tlast.setText("Your Last Guess is : "+ guess);
                    int crtguess = Integer.parseInt(guess);
                    list.add(crtguess);
                    TRight.setText("Remain rights " + RmainGuess);

                    if(r == crtguess){


                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("LET'S GUESS JD!");
                        builder.setCancelable(false);
                        builder.setMessage("Congratulation. My guess Was " + r + "\n\n You Know My Number In " + Attempt + "Attempt.\n\n Your Guesses :" +list + "\n\n Would You Like To Play Again ?"  );
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                startActivity( new Intent(GameActivity.this , MainActivity.class));
                                finish();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(GameActivity.this , MainActivity.class));
                                finish();

                            }
                        });
                        builder.create().show();
                    }
                    if(r > crtguess){
                        THINT.setText("Increase Number");
                    }
                    if(r< crtguess){
                        THINT.setText("Decrease Number");
                    }

                    if(RmainGuess ==0){

                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("LET'S GUESS JD!");
                        builder.setCancelable(false);
                 builder.setMessage("Sorry your right to guess is over " + "" +
                         "\n\n My guess was " + r +
                         "\n\n Your guesses " + list +
                         "\n\n Would you like to play again ?" ) ;
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                startActivity( new Intent(GameActivity.this , MainActivity.class));
                                finish();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(GameActivity.this , MainActivity.class));
                                finish();

                            }
                        });
                        builder.create().show();

                    }

                    GUESS.setText("");

               }

            }
        });



    }
}