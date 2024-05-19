package com.example.wagecalctandug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView txtName,txtType,txtHours,txtWage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        txtName = findViewById(R.id.txtEmployeeName);
        txtType = findViewById(R.id.txtEmployeeType);
        txtHours = findViewById(R.id.txtHours);
        txtWage = findViewById(R.id.txtTotalWage);



        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " +EmployeeName);
        txtType.setText("Employee Type: " + String.valueOf(EmployeeType));
        txtHours.setText("Hours Rendered: "+ String.valueOf(EmployeeHours));

        calcWage(EmployeeType,EmployeeHours,txtWage);



    }
    //Method to calculate wage
    public void calcWage(String employeeType, Double employeeHours, TextView txtWage){
        Double totalWage = 0.0;




        if(employeeHours > 8.0){
            //overtime hours code
        }
        else{
            if(employeeType.equals("Full-time")){
                totalWage = employeeHours * 100;
                txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
            }
            else if(employeeType.equals("Part-time")){
                totalWage = employeeHours * 75;
                txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
            }
            else{
                totalWage = employeeHours * 90;
                txtWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
            }
        }
    }





}
