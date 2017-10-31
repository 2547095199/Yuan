package fragment.bwie.com.rikao111;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText shoujihao;
    private EditText mima;
    private Button denglu;
    private Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoujihao = (EditText) findViewById(R.id.shoujihao);
        mima = (EditText) findViewById(R.id.mima);
        denglu = (Button) findViewById(R.id.denglu);
        zhuce = (Button) findViewById(R.id.zhuce);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = shoujihao.getText().toString();
                String pwd = mima.getText().toString();
                boolean judge = isMobile(number);
                if (TextUtils.isEmpty(number)) {
                    Toast.makeText(MainActivity.this, "手机号为空，请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "密码不能为空，请输入密码", Toast.LENGTH_SHORT).show();
                }else if (judge == true) {
                    Intent intent = new Intent(MainActivity.this, TiaoZhuan.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "手机号不和发", Toast.LENGTH_SHORT).show();
                }

            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);

            }
        });
    }

    private boolean isMobile(String number) {
        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }

    }

}
