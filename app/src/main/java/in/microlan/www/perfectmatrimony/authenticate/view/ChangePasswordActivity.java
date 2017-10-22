package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationAdapter;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationManager;


public class ChangePasswordActivity extends BaseActivity implements IResultView, View.OnClickListener {
    private Context context = ChangePasswordActivity.this;
    private Button btn_login, btn_signup;
    //For the Validation we use Recycleview & ScrollView for UI Display
    private RecyclerView rcvValidationMessage;
    private ScrollView scvloginScroll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    public void InitView() {

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_signup = (Button) findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(this);
        btn_signup.setOnClickListener(this);

        //Initialization of Validation instance
        ValidationManager.getValidationMessageInstance();

        scvloginScroll = (ScrollView) findViewById(R.id.scv_cpassword_scroll);


        rcvValidationMessage = ValidationManager.setValidationRecyclerView(this);

        //On basis of server message, get will pass the custom code in the method
        //new ValidationManager().setValidationError(ErrorMessageUtility.getCustomErrorCode(AppsValidationMessage.ICommonError.NO_INTERNET), this);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_change_password;
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login: {
                startActivity(new Intent(context, LoginActivity.class));
                finish();

            }
            break;
            case R.id.btn_signup: {
                startActivity(new Intent(context, SignUpActivity.class));
                finish();
            }
            break;
        }
    }

    @Override
    public void showResult(Object listDO) {

    }

    @Override
    public void onDisplayMessage(String message) {

    }

    @Override
    public void showResultList(List resultDOList) {

    }

    @Override
    public void displayErrorList(List errorList) {
        ValidationAdapter validationAdapter = new ValidationAdapter(errorList, this);
        rcvValidationMessage.setAdapter(validationAdapter);
        scvloginScroll.scrollTo(0, 0);
        validationAdapter.notifyDataSetChanged();
    }
}
