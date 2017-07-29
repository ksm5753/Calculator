package com.example.pita.calculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;
import java.util.StringTokenizer;

import static com.example.pita.calculator.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;

    private Button AC;
    private Button Plus;
    private Button Minus;
    private Button Multiple;
    private Button Divide;
    private Button equal;

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        AC = (Button) findViewById(R.id.AC);
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().length() != 0) {
                    result.setText(result.getText().subSequence(0, result.getText().length() - 1));
                }
            }
        });
        AC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (result.getText().length() != 0) {
                    result.setText("0");
                }
                return true;
            }
        });
        Multiple = (Button) findViewById(R.id.Multiple);
        Multiple.setOnClickListener(this);
        Divide = (Button) findViewById(R.id.Divide);
        Divide.setOnClickListener(this);
        Plus = (Button) findViewById(R.id.Plus);
        Plus.setOnClickListener(this);
        Minus = (Button) findViewById(R.id.Minus);
        Minus.setOnClickListener(this);
        equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(this);
        result = (TextView) findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn1)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("1");
            } else {
                result.setText(result.getText() + "1");
            }
        } else if (v.equals(btn2)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("2");
            } else {
                result.setText(result.getText() + "2");
            }
        } else if (v.equals(btn3)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("3");
            } else {
                result.setText(result.getText() + "3");
            }
        } else if (v.equals(btn4)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("4");
            } else {
                result.setText(result.getText() + "4");
            }
        } else if (v.equals(btn5)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("5");
            } else {
                result.setText(result.getText() + "5");
            }
        } else if (v.equals(btn6)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("6");
            } else {
                result.setText(result.getText() + "6");
            }
        } else if (v.equals(btn7)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("7");
            } else {
                result.setText(result.getText() + "7");
            }
        } else if (v.equals(btn8)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("8");
            } else {
                result.setText(result.getText() + "8");
            }
        } else if (v.equals(btn9)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("9");
            } else {
                result.setText(result.getText() + "9");
            }
        } else if (v.equals(btn0)) {
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("0");
            } else {
                result.setText(result.getText() + "0");
            }
        } else if (v.equals(Divide)) {
            result.setText(result.getText() + "/");
        } else if (v.equals(Plus)) {
            result.setText(result.getText() + "+");

        } else if (v.equals(Minus)) {
            result.setText(result.getText() + "-");
        } else if (v.equals(Multiple)) {
            result.setText(result.getText() + "*");
        } else if (v.equals(equal)) {
            result.setText(Calc(result.getText().toString()));
        }
    }

    private String Calc(String str) {
        if (str.indexOf('(') != -1) {
            int fs = str.indexOf('(');
            int ls = str.lastIndexOf(')');
            String s = Calc(str.substring(fs + 1, ls));
            str = str.substring(0, fs) + s + str.substring(ls + 1, str.length());
        }

        int cnt = 0;
        Stack<Integer> Stk_Num = new Stack<Integer>();
        StringTokenizer ST_Num = new StringTokenizer(str, "+-/* ");
        StringTokenizer ST_Oper = new StringTokenizer(str, "1234567890 ");

        Stk_Num.push(Integer.parseInt(ST_Num.nextToken()));
        while (ST_Num.hasMoreTokens()) {
            char oper = ST_Oper.nextToken().charAt(0);
            String num = ST_Num.nextToken();
            int a;

            if (oper == '*') {
                a = Stk_Num.pop();
                a *= Integer.parseInt(num);
                Stk_Num.push(a);
            } else if (oper == '/') {
                a = Stk_Num.pop();
                a /= Integer.parseInt(num);
                Stk_Num.push(a);
            } else if (oper == '+') {
                Stk_Num.push(Integer.parseInt(num));
            } else if (oper == '-') {
                Stk_Num.push(-1 * (Integer.parseInt(num)));
            }
        }

        while (!Stk_Num.isEmpty()) {
            cnt += Stk_Num.pop();
        }

        return Integer.toString(cnt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setIcon(R.drawable.ic_settings_black_24dp);
                alertBuilder.setTitle("TEXT 크기 설정");

                // List Adapter 생성
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        this,
                        android.R.layout.select_dialog_singlechoice);
                adapter.add("크게");
                adapter.add("중간");
                adapter.add("작게");

                // 버튼 생성
                alertBuilder.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        });
                alertBuilder.setAdapter(adapter,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                switch (id) {
                                    case 0:
                                        result.setTextSize(70);
                                        break;
                                    case 1:
                                        result.setTextSize(50);
                                        break;
                                    case 2:
                                        result.setTextSize(30);
                                        break;
                                }
                            }
                        });
                alertBuilder.show();
                break;

            case R.id.maker:
                Toast.makeText(MainActivity.this, "Copyright ⓒ 2017.강석문. All rights reserved.", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}