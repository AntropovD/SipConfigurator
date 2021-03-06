package com.example.sipconfigurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {
    private final static String BROADCAST_ACTION = "sipBroadcastAction";
    private final static String PARAM_USERNAME = "username";
    private final static String PARAM_PASSWORD = "password";
    private final static String PARAM_DOMAIN = "domain";
    private final static String PARAM_TRANSPORT = "transport";
    private final static String PARAM_IS_VIDEO_CALL = "isVideoCall";
    private final static String TAG = "SipConfigurator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSipConfigs();
    }

    private void sendSipConfigs() {
        String username = getApplicationContext().getString(R.string.account_login);
        String password = getApplicationContext().getString(R.string.account_password);
        String domain = getApplicationContext().getString(R.string.server_domain);
        String transport = getApplicationContext().getString(R.string.server_transport);
        boolean isVideoCall = Boolean.parseBoolean(
                getApplicationContext().getString(R.string.initialize_video_call));

        Intent intent = new Intent(BROADCAST_ACTION);
        intent.putExtra(PARAM_USERNAME, username);
        intent.putExtra(PARAM_PASSWORD, password);
        intent.putExtra(PARAM_DOMAIN, domain);
        intent.putExtra(PARAM_TRANSPORT, transport);
        intent.putExtra(PARAM_IS_VIDEO_CALL, isVideoCall);

        sendBroadcast(intent);
    }
}
