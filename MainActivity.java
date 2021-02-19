package chen.pa.com.butterknifeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.tv_hello_butter)
    TextView tvHelloButter;

    @BindString(R.string.str_hi_butterknife)
    String butter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_hello_butter)
    public void onViewClicked() {
    }
}
