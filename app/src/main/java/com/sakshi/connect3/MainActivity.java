package com.sakshi.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //public class Game
    //{
        int[] tags= {2,2,2,2,2,2,2,2,2};
        int[][] W= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        public void display(View v)
        {
            TextView t1 = findViewById(R.id.T1);
            TextView t2 = findViewById(R.id.T2);
            Button b= findViewById(R.id.PlayAgain);
            ImageView i = (ImageView) v; //findViewById(v.getId());
            int tag = Integer.parseInt(i.getTag().toString());

            if(tags[tag]==2)
            {
                int flag= 0;
                i.setTranslationY(-1000f);
                System.out.println(i.getTag().toString());

                if (t1.getVisibility() == View.VISIBLE) {
                    i.setImageResource(R.drawable.counter1);
                    tags[tag] = 0;
                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.VISIBLE);
                } else if (t2.getVisibility() == View.VISIBLE) {
                    i.setImageResource(R.drawable.counter2);
                    tags[tag] = 1;
                    t2.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.VISIBLE);
                }
                i.animate().translationYBy(1000f).rotation(1800f).setDuration(500);
                for(int[] w: W)
                {
                    if(tags[w[0]]==tags[w[1]] && tags[w[1]]==tags[w[2]] && tags[w[1]]!=2)
                    {
                        if(tags[w[1]]==0)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText("Player 1 wins!!");
                            t2.setVisibility(View.INVISIBLE);
                            b.setVisibility(View.VISIBLE);
                            tags= new int[]{3,3,3,3,3,3,3,3,3};
                            flag=1;
                        }
                        else if(tags[w[1]]==1)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText("Player 2 wins!!");
                            t1.setVisibility(View.INVISIBLE);
                            b.setVisibility(View.VISIBLE);
                            tags= new int[]{3,3,3,3,3,3,3,3,3};
                            flag=1;
                        }
                    }
                }
                for(int j=0;j<9;j++)
                {
                    if(tags[j]==2)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    t1.setText("It's a tie.");
                    t1.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.INVISIBLE);
                }
            }

        }

    public void reset(View view)
    {
        tags = new int[]{2,2,2,2,2,2,2,2,2};
        /*GridLayout gL = (GridLayout) findViewById(R.id.gridLayout);
        for(int j=0;j<gL.getChildCount();j++)
        {
            ((ImageView) gL.getChildAt(j)).setImageResource(0);
        }*/
        ImageView i1= (ImageView) findViewById(R.id.Iv1);
        ImageView i2= (ImageView) findViewById(R.id.Iv2);
        ImageView i3= (ImageView) findViewById(R.id.Iv3);
        ImageView i4= (ImageView) findViewById(R.id.Iv4);
        ImageView i5= (ImageView) findViewById(R.id.Iv5);
        ImageView i6= (ImageView) findViewById(R.id.Iv6);
        ImageView i7= (ImageView) findViewById(R.id.Iv7);
        ImageView i8= (ImageView) findViewById(R.id.Iv8);
        ImageView i9= (ImageView) findViewById(R.id.Iv9);
        i1.setImageResource(0);
        i2.setImageResource(0);
        i3.setImageResource(0);
        i4.setImageResource(0);
        i5.setImageResource(0);
        i6.setImageResource(0);
        i7.setImageResource(0);
        i8.setImageResource(0);
        i9.setImageResource(0);
        TextView t1 = findViewById(R.id.T1);
        TextView t2 = findViewById(R.id.T2);
        Button b= findViewById(R.id.PlayAgain);
        t1.setText("Player 1's turn");
        t1.setVisibility(View.VISIBLE);
        t2.setText("Player 2's turn");
        t2.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t2= findViewById(R.id.T2);
        t2.setVisibility(View.INVISIBLE);
        Button b= findViewById(R.id.PlayAgain);
        b.setVisibility(View.INVISIBLE);
    }
}