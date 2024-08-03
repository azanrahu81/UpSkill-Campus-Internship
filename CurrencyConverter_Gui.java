import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import java.awt.Font;
// import java.awt.Color;

public class CurrencyConverter_GUI {

    public static void main(String[] args) {
        // Create JFrame instance
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



        Font font=new Font("Serif", Font.BOLD,30);
       // Create a Color object
        Color c = new Color(0,255,255);

        // Set the background color of the frame
        frame.getContentPane().setBackground(c);

      


        JLabel l1=new JLabel(" Currency Converter ");
        l1.setFont(font);
        l1.setBounds(100,5,300,40);
        frame.add(l1);

        // Create components
        JLabel labelAmount = new JLabel("Amount:");
        labelAmount.setFont(new Font("Serif", Font.BOLD,15));

        labelAmount.setBounds(50, 50, 100, 30);

        JTextField textAmount = new JTextField();
        textAmount.setBounds(200, 50, 200, 30);

        JLabel labelResult = new JLabel("Converted Amount:");
        labelResult.setFont(new Font("Serif", Font.BOLD,15));
        labelResult.setBounds(50, 100, 150, 30);

        JTextField textResult = new JTextField();
        textResult.setBounds(200, 100, 200, 30);
        textResult.setEditable(false);

        JButton buttonConvert = new JButton("Convert");
        buttonConvert.setFont(new Font("Serif", Font.BOLD,15));
        buttonConvert.setBounds(250, 200, 100, 30);

       

        // Country selection
        JLabel labelCountry = new JLabel("Select Country:");
        labelCountry.setBounds(50, 150, 100, 30);

        String[] countries = {"USA", "Canada", "UK", "Euro", "Japan", "Australia", "China", "India", "Brazil", "South Africa"};
        JComboBox<String> comboCountry = new JComboBox<>(countries);
        comboCountry.setBounds(200, 150, 200, 30);

        // Add components to frame
        frame.add(labelAmount);
        frame.add(textAmount);
        frame.add(labelResult);
        frame.add(textResult);
        frame.add(buttonConvert);
      
        frame.add(labelCountry);
        frame.add(comboCountry);

        // ActionListener for Convert button
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(textAmount.getText());
                    String selectedCountry = (String) comboCountry.getSelectedItem();
                    double conversionRate = getConversionRate(selectedCountry);
                    double convertedAmount = amount * conversionRate;
                    textResult.setText(String.format("%.2f", convertedAmount));
                } catch (NumberFormatException ex) {
                    textResult.setText("Invalid input");
                }
            }
        });

        // MouseListener for Change Color button
      
        // Set the frame visibility
        frame.setVisible(true);
    }

    private static double getConversionRate(String country) {
        switch (country) {
            case "USA":
                return 1.0; // USD
            case "Canada":
                return 0.74; // CAD
            case "UK":
                return 0.82; // GBP
            case "Euro":
                return 0.93; // EUR
            case "Japan":
                return 135.6; // JPY
            case "Australia":
                return 1.5; // AUD
            case "China":
                return 6.9; // CNY
            case "India":
                return 83.4; // INR
            case "Brazil":
                return 5.1; // BRL
            case "South Africa":
                return 18.1; // ZAR
            default:
                return 1.0;
        }
    }
}
