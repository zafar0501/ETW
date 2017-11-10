package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.constant.StringConstant;
import in.microlan.www.perfectmatrimony.utility.HelperUtility;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    private TextView mTextMessage;
    private Toolbar toolbar;
    private ImageView menu_home,menu_chat,menu_bell;
    private BottomNavigationView navigation;



    private void basicdetails_fragment() {
        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new MemberDetailsFragment(), StringConstant.FragmentTag.MATCHES_TAG);
    }
    private void newmatchesFragment() {

        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new MemberDetailsFragment(), StringConstant.FragmentTag.NEW_MATCHES_TAG);
    }
    private void shortlistedFragment() {

        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new MemberDetailsFragment(), StringConstant.FragmentTag.SHORTLISTED_TAG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        basicdetails_fragment();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.menu_home:
            {
                Intent intent = new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                DashboardActivity.this.finish();
            }
            break;

        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_matches:
                mTextMessage.setText(R.string.title_basic_details);
                basicdetails_fragment();
                return true;
            case R.id.navigation_new_matches:
                mTextMessage.setText(R.string.title_religion);
                newmatchesFragment();
                return true;
            case R.id.navigation_shortlisted:
                mTextMessage.setText(R.string.title_carrier_details);
                shortlistedFragment();
                return true;

        }
        return  true;
    }

}
