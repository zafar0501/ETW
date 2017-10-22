package in.microlan.www.perfectmatrimony.authenticate.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationAdapter;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationManager;


public class VerifyUsersActivity extends BaseActivity implements IResultView, View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    public EditText edtCompany, edtUsername, edtPassword;
    private int mCurrentState;
    private String strCompanyId, strUsername, strPassword;
    private View viewProgressBar;
    private Button btnSignIn;
    //For the Validation we use Recycleview & ScrollView for UI Display
    private RecyclerView rcvValidationMessage;
    private ScrollView scvloginScroll;
    private TextView textView_signwithfingerID, textView_forgot_login;
    private CheckBox checkBox;
    private Context context = VerifyUsersActivity.this;
    private TextView txt_resend_otp;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitView();
    }

    @SuppressLint("ServiceCast")
    @Override
    public void InitView() {
        context = this;
        txt_resend_otp = (TextView) findViewById(R.id.txt_resend_otp);
        txt_resend_otp.setOnClickListener(this);

        //Initialization of Validation instance
        ValidationManager.getValidationMessageInstance();

        scvloginScroll = (ScrollView) findViewById(R.id.scv_verify_scroll);

        rcvValidationMessage = ValidationManager.setValidationRecyclerView(this);

        //On basis of server message, get will pass the custom code in the method
        // new ValidationManager().setValidationError(ErrorMessageUtility.getCustomErrorCode(AppsValidationMessage.ICommonError.NO_INTERNET), this);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_verify_users;
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
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.txt_resend_otp:
                startActivity(new Intent(context, ForgotPasswordActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
