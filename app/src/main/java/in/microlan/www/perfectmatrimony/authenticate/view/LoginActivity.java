package in.microlan.www.perfectmatrimony.authenticate.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xwray.passwordview.PasswordView;

import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.AuthenticateDO;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;
import in.microlan.www.perfectmatrimony.common.validationMessage.AppsValidationMessage;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationAdapter;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationManager;
import in.microlan.www.perfectmatrimony.network.NetworkConstants;
import in.microlan.www.perfectmatrimony.utility.ErrorMessageUtility;
import in.microlan.www.perfectmatrimony.utility.HelperUtility;
import retrofit2.Call;


public class LoginActivity extends BaseActivity implements IResultView, View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextView txt_register, txt_forgot_password;
    private EditText edt_username;
    private Button btn_login;

    //For the Validation we use Recycleview & ScrollView for UI Display
    private RecyclerView rcvValidationMessage;
    private ScrollView scvloginScroll;
    private CheckBox checkBox;
    private Context context = LoginActivity.this;
    private PasswordView password;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @SuppressLint("ServiceCast")
    @Override
    public void InitView() {
        context = this;
        txt_register = (TextView) findViewById(R.id.txt_register);
        txt_forgot_password = (TextView) findViewById(R.id.txt_forgot_password);
        password = (PasswordView) findViewById(R.id.pv_login_password);
        edt_username = (EditText) findViewById(R.id.edt_username);
        btn_login=(Button)findViewById(R.id.btn_login_signin);
        //Initialization of Validation instance
        ValidationManager.getValidationMessageInstance();

        SpannableString content = new SpannableString("Registered");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txt_register.setText(content);

        txt_register.setOnClickListener(this);
        txt_forgot_password.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        scvloginScroll = (ScrollView) findViewById(R.id.scv_login_scroll);


        rcvValidationMessage = ValidationManager.setValidationRecyclerView(this);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
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

            case R.id.txt_register:
                startActivity(new Intent(context, SignUpActivity.class));
                break;

            case R.id.txt_forgot_password:
                startActivity(new Intent(context, ForgotPasswordActivity.class));
                break;
            case R.id.btn_login_signin:
                if (HelperUtility.InternetCheck(context)) {
                    startActivity(new Intent(context, HomeActivity.class));
                } else {
                    //On basis of server message, get will pass the custom code in the method
                    new ValidationManager().setValidationError(ErrorMessageUtility.getCustomErrorCode(AppsValidationMessage.ICommonError.NO_INTERNET), this);
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
