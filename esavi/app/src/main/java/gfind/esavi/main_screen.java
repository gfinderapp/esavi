package gfind.esavi;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.widget.TextView;
import android.widget.*;

public class main_screen extends AppCompatActivity {

    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //start main here


    }
    public void exit()
    {
        System.exit(0);
    }
    public void start(View view)
    {
        Button b= (Button) findViewById(R.id.button6);
        b.setVisibility(View.VISIBLE);
        b=(Button)findViewById(R.id.button5);
        b.setVisibility(View.VISIBLE);
        b=(Button) findViewById(R.id.button);
        b.setVisibility(View.GONE);
    }
}
