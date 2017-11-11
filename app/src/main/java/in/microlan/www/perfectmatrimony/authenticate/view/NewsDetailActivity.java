package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.constant.StringConstant;

import static in.microlan.www.perfectmatrimony.common.constant.StringConstant.IBundle.BUNDLE_FEATURE;

/**
 * Created by Shefali on 03/11/17.
 */

public class NewsDetailActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView back_Img, ivShare;
    private TextView toolbarTitle;
    private Intent intent;
    Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    public void InitView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back_Img = toolbar.findViewById(R.id.menu_back);
        ivShare = toolbar.findViewById(R.id.ivShare);
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);


        back_Img.setOnClickListener(this);
        ivShare.setOnClickListener(this);
        bundle = new Bundle();
        bundle = getIntent().getExtras();
        if (bundle == null) {
            toolbarTitle.setText("News Detail");
        } else {
            int commDetail = (int) bundle.get(BUNDLE_FEATURE);
            if (commDetail == 1) {
                toolbarTitle.setText("Help Detail");
            } else {
                toolbarTitle.setText("News Detail");
            }
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_feed_detail;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(NewsDetailActivity.this, NewsFeedActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                NewsDetailActivity.this.finish();
                break;

        }
    }
}
