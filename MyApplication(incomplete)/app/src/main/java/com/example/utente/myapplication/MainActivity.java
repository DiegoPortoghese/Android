package com.example.utente.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import static java.lang.Thread.sleep;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {


  //  public abstract void loopgame();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean[] pressuto = {false};

        final int[] result = new int[1];
        result[0]=0;
        final int[] inizio = new int[1];
        inizio[0]=1;
        final int[] stoped = new int[1];
        final float[] n = new float[1];
        n[0]=15;
        final float[] XDSTART= new float[1];


        final TextView testo = (TextView) findViewById(R.id.textView);
        //final TextView mtesto = (TextView) findViewById(R.id.textView2);
        final TextView stesto = (TextView) findViewById(R.id.textView5);
        //final TextView mtesto = (TextView) findViewById(R.id.textView2);
        final Button bottone = (Button) findViewById(R.id.button);
        final Button binizio = (Button) findViewById(R.id.button2);
        final ImageView mtesto = (ImageView) findViewById(R.id.imageView3);
        final ImageView p20 = (ImageView) findViewById(R.id.imageView4);
        p20.setVisibility(View.GONE);
        final ImageView coglione = (ImageView) findViewById(R.id.imageView5);
        coglione.setVisibility(View.GONE);
        final ImageView p50 = (ImageView) findViewById(R.id.imageView6);
        p50.setVisibility(View.GONE);
        final ImageView p100 = (ImageView) findViewById(R.id.imageView7);
        p100.setVisibility(View.GONE);
        final ImageView p10 = (ImageView) findViewById(R.id.imageView8);
        p10.setVisibility(View.GONE);



        //testo.setText("X : "+ XDSTART);

        //START
        binizio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result[0]=0;
                final int[] score = new int[1];
                score[0] = 0;
                final float xxx2=mtesto.getX();
                mtesto.setX(xxx2 + 1);
                XDSTART[0]=mtesto.getX();

                binizio.setVisibility(View.GONE);

        new CountDownTimer(10000, 10) {

            public void onTick(long millisUntilFinished) {
                final float xxx=mtesto.getX();

                testo.setText("SECONDS: " + millisUntilFinished / 1000 + " ---DEBUG x:" + xxx +" r:"+ result[0] +" Score:"+ score[0]);
                bottone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (result[0] > -10 && result[0] < 10) {
                            if (result[0] > -8 && result[0] < 8) {
                                if (result[0] > -4 && result[0] < 4) {
                                    if (result[0] > -1 && result[0] < 1) {
                                        new CountDownTimer(1000, 1) { // + 100
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                p100.setVisibility(View.VISIBLE);
                                            }
                                            @Override
                                            public void onFinish() {
                                                p100.setVisibility(View.GONE);
                                            }
                                        }.start();
                                        score[0] += 100;
                                    } else { // PIU 50
                                        new CountDownTimer(1000, 1) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                p50.setVisibility(View.VISIBLE);
                                            }
                                            @Override
                                            public void onFinish() {
                                                p50.setVisibility(View.GONE);
                                            }
                                        }.start();
                                        score[0] += 50;
                                    }
                                } else { // PIU 20
                                    new CountDownTimer(1000, 1) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            p20.setVisibility(View.VISIBLE);
                                        }
                                        @Override
                                        public void onFinish() {
                                            p20.setVisibility(View.GONE);
                                        }
                                    }.start();
                                    score[0] += 20;
                                }
                            }else{ //+ 10
                                new CountDownTimer(1000, 1) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        p10.setVisibility(View.VISIBLE);
                                    }
                                    @Override
                                    public void onFinish() {
                                        p10.setVisibility(View.GONE);
                                    }
                                }.start();
                                score[0] += 10;
                            }
                        } else{ // COGLIONE
                            new CountDownTimer(1000, 1) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    coglione.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onFinish() {
                                    coglione.setVisibility(View.GONE);
                                }
                            }.start();
                        }

                        stesto.setText("" + " " + result[0]+" s:"+ score[0]);
                        pressuto[0]=true;
                    }
                });

                    if (result[0] > 22) {
                        inizio[0] = 0;
                    }
                    if (result[0] < -22) {
                        inizio[0] = 1;
                    }

                    if (inizio[0] == 1) {

                        mtesto.setX(xxx + n[0]);
                        result[0]++;
                    } else {

                        mtesto.setX(xxx - n[0]);
                        result[0]--;
                    }

            }


            public void onFinish() {
                mtesto.setX(XDSTART[0]);
                binizio.setVisibility(View.VISIBLE);
            }
        }.start();

            }
        });

        //loopgame();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

