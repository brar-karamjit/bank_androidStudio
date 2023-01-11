package eecs1022.lab7.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import eecs1022.lab7.bank.model.Bank;

public class MainActivity extends AppCompatActivity {
    Bank b;
    /* Hint: How do you share the same bank object between button clicks (attached with controller methods) of the app? */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = new Bank();
        /* Hint: How do you initialize an empty bank and displays its status to the output textview
         * when the app is first launched?
         */
    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    public void computebuttonAddaNewAccount(View view){

        //gets inputted client name
        String inputName = getInputOfTextField(R.id.ClientNameInput);

        //receives inputted initial balance as String
        String initialBalanceString = getInputOfTextField(R.id.InitialBalanceInput);
        //converts the String to integer
        double initialBalance = Double.parseDouble(initialBalanceString);


        //create new Bank client
        b.addClient(inputName,initialBalance);
        setContentsOfTextView(R.id.computationResults, b.getStatus());
    }


    public void computebuttonConfirm(View view){

        //gets selected action from spinner
        String action = getItemSelected(R.id.spinner);

        String fromAccount = getInputOfTextField(R.id.fromAccountInput);
        String toAccount = getInputOfTextField(R.id.toAccountInput);

        String valueString = getInputOfTextField(R.id.valueInput);


        if(action.equals("Deposit")){
            double valueTotransfer = Double.parseDouble(valueString);
            b.deposit(toAccount, valueTotransfer);
            setContentsOfTextView(R.id.computationResults, b.getStatus());
        }

        if(action.equals("Withdraw")){
            double valueTotransfer = Double.parseDouble(valueString);
            b.withdraw(fromAccount, valueTotransfer);
            setContentsOfTextView(R.id.computationResults, b.getStatus());
        }

        if(action.equals("Transfer")){
            double valueTotransfer = Double.parseDouble(valueString);
            b.transfer(fromAccount, toAccount, valueTotransfer);
            setContentsOfTextView(R.id.computationResults, b.getStatus());
        }

        if(action.equals("Print Statement")){
            String printStatement = b.printStatement(fromAccount);
            setContentsOfTextView(R.id.computationResults, printStatement);
        }




    }
    /* Hints on controller methods:
     *
     * Declare two controller methods, each of which declared with a parameter with type View (see Week 9 Tutorials).
     *  - One method (say cm1) should be attached to the "ADD A NEW ACCOUNT" button,
     *      whereas the other method (say cm2) should be attached to the "CONFIRM" button.
     *
     *  - Controller method cm1 should:
     *    + Retrieve the name of client and the initial balance in the corresponding textfields.
     *      You may need to convert the retrieved text, e.g., "23.4" to a double value using Double.parseDouble.
     *    + Then, invoke the relevant method on the shared bank object to add a new client/account accordingly.
     *    + Finally, display the status of the bank to the output textview.
     *
     * - Controller method cm2 should:
     *    + Retrieve the chosen service type listed in the spinner (Deposit, Withdraw, Transfer, Print Statement)
     *    + Depending on the service type chosen, retrieve the from-account, to-account, and/or amount accordingly.
     *      (See the "Assumed Usage Pattern of the App" section in your Lab7 PDF instructions)
     *    + Then, invoke the relevant method(s), depending on the chosen service type, on the shared bank object.
     *    + Finally, display the status of the bank (in the case of a deposit, withdraw, or transfer)
     *          or the statement of an account (in the case of print statement) to the ouptut textview.
     */
	
}