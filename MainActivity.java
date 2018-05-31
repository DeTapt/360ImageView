package ttaptas.com.a360view;

import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Drawable[] layers;
    private View view;
    private int mStartX, mStartY, mEndX, mEndY, mImageIndex, three_sixty_size;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);


                switch(action) {
                    case (MotionEvent.ACTION_DOWN) :

                        mStartX = (int)event.getX();
                        mStartY = (int)event.getY();
                        return true;

                    case (MotionEvent.ACTION_MOVE) :

                        mEndX = (int)event.getX();
                        mEndY = (int)event.getY();


                        if((mEndX - mStartX) >  3) {
                            mImageIndex++;
                            if(mImageIndex > three_sixty_size - 1 )
                                mImageIndex = 0;

                            img.setBackground(layers[mImageIndex]);


                        }
                        if((mEndX - mStartX) < - 3) {
                            mImageIndex--;
                            if(mImageIndex < 0)
                                mImageIndex = three_sixty_size - 1;
                            img.setBackground(layers[mImageIndex]);


                        }
                        mStartX = (int)event.getX();
                        mStartY = (int)event.getY();
                        return true;

                    case (MotionEvent.ACTION_UP) :
                        mEndX = (int)event.getX();
                        mEndY = (int)event.getY();




                        return true;

                    case (MotionEvent.ACTION_CANCEL) :
                        return true;

                    case (MotionEvent.ACTION_OUTSIDE) :
                        return true;

                    default :
                        return true;
                }


            }
        });



    }
}
