package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

public class AdsActivity extends BaseActivity {

    private Toolbar toolbar;
    private ImageView Img_back;
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_ads;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return false;

    }


    @Override
    public void InitView() {


    }




}
