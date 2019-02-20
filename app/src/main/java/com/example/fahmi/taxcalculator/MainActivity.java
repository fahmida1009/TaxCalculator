package com.example.fahmi.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String Result = null;
    // protected static final boolean = false;
    private EditText editTextMoneyAmount;
    private RadioGroup RadioButtonGender, RadioButtonLocation;
    private RadioButton checkedRadioButtonGender, checkedRadioButtonLocation;
    private Button Calculate;
    String checkedTextGender, checkedTextLocation;
    double tempMoney;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // hide titlebar of application
        // must be before setting the layout
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide statusbar of Android
        // could also be done later
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        editTextMoneyAmount = (EditText) findViewById(R.id.editTextMoneyAmount);
        Calculate = (Button) findViewById(R.id.Calculate);

        RadioButtonGender = (RadioGroup) findViewById(R.id.RadioButtonGender);
        RadioButtonLocation = (RadioGroup) findViewById(R.id.RadioButtonLocation);

        RadioButtonGender
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        checkedRadioButtonGender = (RadioButton) findViewById(checkedId);
                        checkedTextGender = checkedRadioButtonGender.getText()
                                .toString();
                        Toast.makeText(getApplicationContext(),
                                checkedTextGender, Toast.LENGTH_SHORT).show();
                    }
                });

        RadioButtonLocation
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        checkedRadioButtonLocation = (RadioButton) findViewById(checkedId);
                        checkedTextLocation = checkedRadioButtonLocation
                                .getText().toString();
                        Toast.makeText(getApplicationContext(),
                                checkedTextLocation, Toast.LENGTH_SHORT).show();
                    }
                });

        Calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // if(editTextMoneyAmount.getText().toString() != null)
                // {
                // Toast.makeText(getApplicationContext(), "not null",
                // Toast.LENGTH_LONG).show();
                // }
                // else
                // {
                // Toast.makeText(getApplicationContext(), "null",
                // Toast.LENGTH_LONG).show();
                // }

                if (editTextMoneyAmount.getText().toString() != null) {

                    String money = editTextMoneyAmount.getText().toString();

                    // Dialog Box
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialogbox);
                    dialog.setTitle("Your Income Tax");

                    TextView text = (TextView) dialog.findViewById(R.id.text);
                    ImageView image = (ImageView) dialog
                            .findViewById(R.id.image);

                    Button dialogButton = (Button) dialog
                            .findViewById(R.id.dialogButtonOK);

                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                    if (checkedTextGender != null) {

                        if (checkedTextGender.contains("Male")) {

                            if (checkedTextLocation != null) {

                                if (checkedTextLocation
                                        .contains("City Corporation")) {

                                    if (money != null) {

                                        try {

                                            tempMoney = Double
                                                    .parseDouble(money);
                                        } catch (Exception e) {
                                            Toast.makeText(
                                                    getApplicationContext(),
                                                    "Give correct amount!",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                        double tempValue;
                                        if (tempMoney >= 1
                                                && tempMoney <= 220000) {

                                            text.setText("No Tax");

                                        }

                                        else if (tempMoney >= 220001
                                                && tempMoney <= 250000) {

                                            text.setText("3,000 Tk");

                                        } else if (tempMoney >= 250001
                                                && tempMoney <= 300000) {

                                            tempValue = ((tempMoney - 220000) * 10) / 100;

                                            text.setText("Result:" + tempValue);

                                        } else if (tempMoney >= 300001
                                                && tempMoney <= 400000) {

                                            tempValue = ((tempMoney - 220000) * 15) / 100;

                                            text.setText("Result:" + tempValue);

                                        } else if (tempMoney >= 400001
                                                && tempMoney <= 500000) {

                                            tempValue = ((tempMoney - 220000) * 20) / 100;

                                            text.setText("Result:" + tempValue);

                                        } else if (tempMoney >= 500001
                                                && tempMoney <= 3000000) {

                                            tempValue = ((tempMoney - 220000) * 25) / 100;

                                            text.setText("Result:" + tempValue);

                                        } else if (tempMoney >= 3000001
                                                && tempMoney <= 10000000) {

                                            tempValue = ((tempMoney - 220000) * 25) / 100;

                                            text.setText("Result:" + tempValue);

                                        } else {
                                            text.setText("Enter a Valid Input.");

                                        }
                                    }
                                } else if (checkedTextLocation
                                        .contains("District Town Areas")) {

                                    double tempMoney = Double
                                            .parseDouble(money);
                                    double tempValue;
                                    if (tempMoney >= 1 && tempMoney <= 220000) {

                                        text.setText("No Tax");

                                    }

                                    else if (tempMoney >= 220001
                                            && tempMoney <= 250000) {

                                        text.setText("2,000 Tk");

                                    } else if (tempMoney >= 250001
                                            && tempMoney <= 300000) {

                                        tempValue = ((tempMoney - 220000) * 10) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 300001
                                            && tempMoney <= 400000) {

                                        tempValue = ((tempMoney - 220000) * 15) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 400001
                                            && tempMoney <= 500000) {

                                        tempValue = ((tempMoney - 220000) * 20) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 500001
                                            && tempMoney <= 3000000) {

                                        tempValue = ((tempMoney - 220000) * 25) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 3000001
                                            && tempMoney <= 10000000) {

                                        tempValue = ((tempMoney - 220000) * 25) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else {
                                        text.setText("Enter a Valid Input.");

                                    }
                                } else if (checkedTextLocation
                                        .contains("Others Areas")) {

                                    double tempMoney = Double
                                            .parseDouble(money);
                                    double tempValue;
                                    if (tempMoney >= 1 && tempMoney <= 220000) {

                                        text.setText("No Tax");

                                    }

                                    else if (tempMoney >= 220001
                                            && tempMoney <= 250000) {

                                        text.setText("1,000 Tk");

                                    } else if (tempMoney >= 250001
                                            && tempMoney <= 300000) {

                                        tempValue = ((tempMoney - 220000) * 10) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 300001
                                            && tempMoney <= 400000) {

                                        tempValue = ((tempMoney - 220000) * 15) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 400001
                                            && tempMoney <= 500000) {

                                        tempValue = ((tempMoney - 220000) * 20) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 500001
                                            && tempMoney <= 3000000) {

                                        tempValue = ((tempMoney - 220000) * 25) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else if (tempMoney >= 3000001
                                            && tempMoney <= 10000000) {

                                        tempValue = ((tempMoney - 220000) * 25) / 100;

                                        text.setText("Result:" + tempValue);

                                    } else {
                                        text.setText("Enter a Valid Input.");

                                    }

                                }
                            }
                        }
                    }

                    // else female
                    else {
                        if (checkedTextLocation.contains("City Corporation")) {

                            double tempMoney = Double.parseDouble(money);
                            double tempValue;
                            if (tempMoney >= 1 && tempMoney <= 270000) {

                                text.setText("No Tax");

                            }

                            else if (tempMoney >= 220001 && tempMoney <= 250000) {

                                text.setText("3,000 Tk");

                            } else if (tempMoney >= 250001
                                    && tempMoney <= 300000) {

                                tempValue = ((tempMoney - 270000) * 10) / 100;

                                text.setText("Result" + tempValue);

                            } else if (tempMoney >= 300001
                                    && tempMoney <= 400000) {

                                tempValue = ((tempMoney - 270000) * 15) / 100;

                                text.setText("Result" + tempValue);

                            } else if (tempMoney >= 400001
                                    && tempMoney <= 500000) {

                                tempValue = ((tempMoney - 270000) * 20) / 100;

                                text.setText("Result" + tempValue);

                            } else if (tempMoney >= 500001
                                    && tempMoney <= 3000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 3000001
                                    && tempMoney < 10000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else {
                                text.setText("Enter a Valid Input.");

                            }

                        } else if (checkedTextLocation
                                .contains("District Town Areas")) {
                            double tempMoney = Double.parseDouble(money);
                            double tempValue;
                            if (tempMoney >= 1 && tempMoney <= 270000) {

                                text.setText("No Tax");

                            }

                            else if (tempMoney >= 220001 && tempMoney <= 250000) {

                                text.setText("2,000 Tk");

                            } else if (tempMoney >= 250001
                                    && tempMoney <= 300000) {

                                tempValue = ((tempMoney - 270000) * 10) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 300001
                                    && tempMoney <= 400000) {

                                tempValue = ((tempMoney - 270000) * 15) / 100;

                                text.setText("Result" + tempValue);

                            } else if (tempMoney >= 400001
                                    && tempMoney <= 500000) {

                                tempValue = ((tempMoney - 270000) * 20) / 100;

                                text.setText("Result" + tempValue);

                            } else if (tempMoney >= 500001
                                    && tempMoney <= 3000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 3000001
                                    && tempMoney < 10000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else {
                                text.setText("Enter a Valid Input.");

                            }
                        } else if (checkedTextLocation.contains("Others Areas")) {

                            double tempMoney = Double.parseDouble(money);
                            double tempValue;
                            if (tempMoney >= 1 && tempMoney <= 270000) {

                                text.setText("No Tax");

                            }

                            else if (tempMoney >= 220001 && tempMoney <= 250000) {

                                text.setText("1,000 Tk");

                            } else if (tempMoney >= 250001
                                    && tempMoney <= 300000) {

                                tempValue = ((tempMoney - 270000) * 10) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 300001
                                    && tempMoney <= 400000) {

                                tempValue = ((tempMoney - 270000) * 15) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 400001
                                    && tempMoney <= 500000) {

                                tempValue = ((tempMoney - 270000) * 20) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 500001
                                    && tempMoney <= 3000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else if (tempMoney >= 3000001
                                    && tempMoney < 10000000) {

                                tempValue = ((tempMoney - 270000) * 25) / 100;

                                text.setText("Result:" + tempValue);

                            } else {
                                text.setText("Enter a Valid Input.");

                            }

                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter an amount",
                            Toast.LENGTH_LONG).show();
                }
            }

        });
    }

}

