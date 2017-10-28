package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;


public class AdsActivity extends BaseActivity implements View.OnClickListener {
    //Defining Variables
    private Context context;
    private ImageView back_image;
    private Toolbar toolbar;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }


    @Override
    protected int getLayoutResourceId() {

        return R.layout.activity_ads;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_history, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_home_history) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void InitView() {
        context = this;

        toolbar = (Toolbar) findViewById(R.id.ads_toolbar);
        // View view = navigationView.getHeaderView(0);
        setSupportActionBar(toolbar);

         back_image = (ImageView) findViewById(R.id.ads_menu_back);

        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdsActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                AdsActivity.this.finish();
            }
        });


    }


    @Override
    public void onClick(View v) {

    }
}
