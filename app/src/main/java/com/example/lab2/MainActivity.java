package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private boolean originalCheckboxState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        // Find views by IDs
        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.TextView);
        CheckBox checkBox = findViewById(R.id.checkBox);

        // Setting OnClickListener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting and setting the current text from the EditText
                String newText = editText.getText().toString();
                textView.setText(newText);

                // Display a Toast message
                String toastMessage = getString(R.string.toast_message);
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        //Adding a CheckChangedListener to the CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String statusMessage = isChecked ? "on" : "off";
                String snackbarMessage = "The checkbox is now " + statusMessage;

                //Showing the snackbar message
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), snackbarMessage, Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Reverting the Checkbox back to its original state
                        checkBox.setChecked(originalCheckboxState);
                    }
                });
                snackbar.show();
            }
        });
    }
}