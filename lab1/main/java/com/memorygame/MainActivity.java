package com.Martsinkevich.memorygame;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView player1;

    ImageView image1, image2, image3, image4,
            image5, image6, image7, image8,
            image9, image10, image11, image12,
            image13, image14, image15, image16,
            image17, image18, image19, image20,
            image21, image22, image23, image24;

    List<ImageView> tilesList;

    List<Integer> imagesList;

    int clickNumber = 1;

    int click1Value = 0;
    int click2Value = 0;

    int currentPlayer = 1;

    //points
    int player1Points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = findViewById(R.id.player1);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);

        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);

        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);

        image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18);
        image19 = findViewById(R.id.image19);
        image20 = findViewById(R.id.image20);

        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image24 = findViewById(R.id.image24);

        tilesList = new ArrayList<>();

        tilesList.add(image1);
        tilesList.add(image2);
        tilesList.add(image3);
        tilesList.add(image4);

        tilesList.add(image5);
        tilesList.add(image6);
        tilesList.add(image7);
        tilesList.add(image8);

        tilesList.add(image9);
        tilesList.add(image10);
        tilesList.add(image11);
        tilesList.add(image12);

        tilesList.add(image13);
        tilesList.add(image14);
        tilesList.add(image15);
        tilesList.add(image16);

        tilesList.add(image17);
        tilesList.add(image18);
        tilesList.add(image19);
        tilesList.add(image20);

        tilesList.add(image21);
        tilesList.add(image22);
        tilesList.add(image23);
        tilesList.add(image24);

        //images
        imagesList = new ArrayList<>();

        imagesList.add(R.drawable.image1);
        imagesList.add(R.drawable.image2);
        imagesList.add(R.drawable.image3);
        imagesList.add(R.drawable.image4);

        imagesList.add(R.drawable.image5);
        imagesList.add(R.drawable.image6);
        imagesList.add(R.drawable.image7);
        imagesList.add(R.drawable.image8);

        imagesList.add(R.drawable.image9);
        imagesList.add(R.drawable.image10);
        imagesList.add(R.drawable.image11);
        imagesList.add(R.drawable.image12);

        imagesList.add(R.drawable.image1);
        imagesList.add(R.drawable.image2);
        imagesList.add(R.drawable.image3);
        imagesList.add(R.drawable.image4);

        imagesList.add(R.drawable.image5);
        imagesList.add(R.drawable.image6);
        imagesList.add(R.drawable.image7);
        imagesList.add(R.drawable.image8);

        imagesList.add(R.drawable.image9);
        imagesList.add(R.drawable.image10);
        imagesList.add(R.drawable.image11);
        imagesList.add(R.drawable.image12);

        //start the game - shuffle the images
        Collections.shuffle(imagesList);

        //enable all the tiles
        for (ImageView imageView : tilesList) {
            imageView.setEnabled(true);
        }

        //clicks

        //row 1
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image1, 0);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image2, 1);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image3, 2);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image4, 3);
            }
        });

        //row 2
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image5, 4);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image6, 5);
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image7, 6);
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image8, 7);
            }
        });

        //row 3
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image9, 8);
            }
        });

        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image10, 9);
            }
        });

        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image11, 10);
            }
        });

        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image12, 11);
            }
        });

        //row 4
        image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image13, 12);
            }
        });

        image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image14, 13);
            }
        });

        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image15, 14);
            }
        });

        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image16, 15);
            }
        });

        //row 5
        image17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image17, 16);
            }
        });

        image18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image18, 17);
            }
        });

        image19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image19, 18);
            }
        });

        image20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image20, 19);
            }
        });

        //row 6
        image21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image21, 20);
            }
        });

        image22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image22, 21);
            }
        });

        image23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image23, 22);
            }
        });

        image24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(image24, 23);
            }
        });
    }

    private void buttonClick(ImageView image, int number) {
        if (clickNumber == 1) {
            image.setImageResource(imagesList.get(number));
            clickNumber = 2;
            click1Value = number + 1;
        } else if (clickNumber == 2) {
            //image.setImageResource(imagesList.get(number));
            clickNumber = 1;
            click2Value = number + 1;

            compareTiles();
        }
    }


    private void compareTiles() {
        //disable all the tiles
        for (ImageView imageView : tilesList) {
            imageView.setEnabled(false);
        }

        if (imagesList.get(click1Value - 1).equals(imagesList.get(click2Value - 1))&&click1Value != click2Value) {
            //same images
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //remove tiles
                    tilesList.get(click1Value - 1).setVisibility(View.INVISIBLE);
                    tilesList.get(click2Value - 1).setVisibility(View.INVISIBLE);

                    //points
                    if (currentPlayer == 1) {
                        player1Points = player1Points + 1;
                        player1.setText("Player 1: " + player1Points);
                    }

                    //enable all the tiles
                    for (ImageView imageView : tilesList) {
                        imageView.setEnabled(true);
                    }
                }
            }, 1000);
        } else {
            //different images
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //flip tiles
                    tilesList.get(click1Value - 1).setImageResource(R.drawable.tile);
                    tilesList.get(click2Value - 1).setImageResource(R.drawable.tile);

                    //enable all the tiles
                    for (ImageView imageView : tilesList) {
                        imageView.setEnabled(true);
                    }
                }
            }, 200);
        }
    }
}