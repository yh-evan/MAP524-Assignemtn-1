package yh.evanz.calculator_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<String> inputs = new ArrayList<String>();
    String history = "";
    Boolean advanced = false;
    String display = "";
    Button num1Btn;
    Button num2Btn;
    Button num3Btn;
    Button num4Btn;
    Button num5Btn;
    Button num6Btn;
    Button num7Btn;
    Button num8Btn;
    Button num9Btn;
    Button num0Btn;
    Button clearBtn;
    Button equalBtn;
    Button plusBtn;
    Button minusBtn;
    Button multiplyBtn;
    Button divideBtn;
    Button modeBtn;
    TextView displayArea;
    TextView historyDisplay;

    private Calculation calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1Btn = (Button) findViewById(R.id.num1Btn);
        num2Btn = (Button) findViewById(R.id.num2Btn);
        num3Btn = (Button) findViewById(R.id.num3Btn);
        num4Btn = (Button) findViewById(R.id.num4Btn);
        num5Btn = (Button) findViewById(R.id.num5Btn);
        num6Btn = (Button) findViewById(R.id.num6Btn);
        num7Btn = (Button) findViewById(R.id.num7Btn);
        num8Btn = (Button) findViewById(R.id.num8Btn);
        num9Btn = (Button) findViewById(R.id.num9Btn);
        num0Btn = (Button) findViewById(R.id.num0Btn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        equalBtn = (Button) findViewById(R.id.equalBtn);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        multiplyBtn = (Button) findViewById(R.id.multiplyBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);

        modeBtn = (Button) findViewById(R.id.modeBtn);

        displayArea = (TextView) findViewById(R.id.displayArea);
        historyDisplay = (TextView) findViewById((R.id.history));

        num1Btn.setOnClickListener(this);
        num2Btn.setOnClickListener(this);
        num3Btn.setOnClickListener(this);
        num4Btn.setOnClickListener(this);
        num5Btn.setOnClickListener(this);
        num6Btn.setOnClickListener(this);
        num7Btn.setOnClickListener(this);
        num8Btn.setOnClickListener(this);
        num9Btn.setOnClickListener(this);
        num0Btn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        equalBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        divideBtn.setOnClickListener(this);

        modeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advanced = !advanced;
                if (advanced) {
                    modeBtn.setText("ADVANCE - WITH HISTORY");
                    modeBtn.setBackgroundColor(Color.BLUE);
                    historyDisplay.setVisibility(View.VISIBLE);
                } else {
                    modeBtn.setText("STANDARD - NO HISTORY");
                    modeBtn.setBackgroundColor(Color.GRAY);
                    historyDisplay.setVisibility(View.GONE);
                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        String n = ((Button) view).getText().toString();
        if (n.equals("C")) {
            inputs.clear();
            display = "";
            displayArea.setText("");
        } else if (n.equals("=")) {
            int result = calculate.calc(inputs);
            inputs.add(n);
            inputs.add(String.valueOf(result));
        } else {
            if (display.contains("=")){
                inputs.clear();
                display = "";
                displayArea.setText("");
            }
            inputs.add(n);
        }
        display = "";
        for (String c : inputs) {
            display += c+" ";
        }
        displayArea.setText(display);

        if (n.equals("=")){
            history += display+"\n";
            historyDisplay.setText(history);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        calculate = new Calculation();
        if (advanced) {
            modeBtn.setText("ADVANCE - WITH HISTORY");
            modeBtn.setBackgroundColor(Color.BLUE);
            historyDisplay.setVisibility(View.VISIBLE);
        } else {
            modeBtn.setText("STANDARD - NO HISTORY");
            modeBtn.setBackgroundColor(Color.GRAY);
            historyDisplay.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}