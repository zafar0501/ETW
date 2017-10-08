package in.microlan.www.perfectmatrimony;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


    @Override
    public void InitView() {


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
