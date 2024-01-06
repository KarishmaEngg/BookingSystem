import javax.swing.*;
import java.awt.*;
import  javax.swing.JTextField;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //to add name,address,city,state,pincode,phoneno,email,arrival-DnT,departure-DnT,NoOfKids,paymentMethod,total
        JFrame frame = new JFrame("Hotel Reservation System");

        JLabel namelb = new JLabel("Name:");
        JLabel addresslb = new JLabel("Address:");
        JLabel citylb = new JLabel("City:");
        JLabel statelb = new JLabel("State");
        JLabel pincodelb = new JLabel("PinCode:");
        JLabel phoneNolb = new JLabel("Phone No:");
        JLabel emaillb = new JLabel("E-Mail:");
        JLabel arrival_DnTlb = new JLabel("Arrival-Date and Time:");

        JLabel departure_DnTlb = new JLabel("Departure-Date and Time:");
        JLabel paymentlb = new JLabel("Payment Method:");
        JLabel bookingId = new JLabel("Booking Id:");


        JTextField nametf = new JTextField();
        JTextField addresstf = new JTextField();
        JTextField citytf = new JTextField();
        JTextField statetf = new JTextField();
        JTextField pincodetf = new JTextField();
        JTextField phoneNotf = new JTextField();
        JTextField emailtf = new JTextField();
        JTextField arrival_DnTtf = new JTextField();
        JTextField departure_DnTtf = new JTextField();

        JRadioButton cheque = new JRadioButton("Cheque");
        JRadioButton paypal = new JRadioButton("Paypal");

        JButton clear = new JButton("Clear");
        JButton submit = new JButton("Submit");

        JTextField msgAreata = new JTextField();

        namelb.setBounds(20, 10, 100, 30);
        addresslb.setBounds(20, 50, 100, 30);
        citylb.setBounds(20, 90, 100, 30);
        statelb.setBounds(20, 130, 100, 30);
        pincodelb.setBounds(20, 170, 100, 30);
        phoneNolb.setBounds(360, 10, 100, 30);
        emaillb.setBounds(360, 50, 100, 30);
        arrival_DnTlb.setBounds(360, 90, 150, 30);
        departure_DnTlb.setBounds(360, 130, 150, 30);
        paymentlb.setBounds(360, 170, 150, 30);
        cheque.setBounds(530, 170, 100, 30);
        paypal.setBounds(650, 170, 100, 30);
        bookingId.setBounds(250, 330, 400, 30);

        clear.setBounds(100, 220, 100, 30);
        submit.setBounds(300, 220, 100, 30);


        nametf.setBounds(130, 10, 200, 30);
        addresstf.setBounds(130, 50, 200, 30);
        citytf.setBounds(130, 90, 200, 30);
        statetf.setBounds(130, 130, 200, 30);
        pincodetf.setBounds(130, 170, 200, 30);
        phoneNotf.setBounds(530, 10, 200, 30);
        emailtf.setBounds(530, 50, 200, 30);
        arrival_DnTtf.setBounds(530, 90, 200, 30);
        departure_DnTtf.setBounds(530, 130, 200, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(cheque);
        bg.add(paypal);

        frame.add(namelb);
        frame.add(addresslb);
        frame.add(citylb);
        frame.add(statelb);
        frame.add(pincodelb);
        frame.add(phoneNolb);
        frame.add(emaillb);
        frame.add(arrival_DnTlb);
        frame.add(departure_DnTlb);
        frame.add(bookingId);

        frame.add(nametf);
        frame.add(addresstf);
        frame.add(citytf);
        frame.add(statetf);
        frame.add(pincodetf);
        frame.add(phoneNotf);
        frame.add(emailtf);
        frame.add(arrival_DnTtf);
        frame.add(departure_DnTtf);

        frame.add(paymentlb);
        frame.add(cheque);
        frame.add(paypal);
        frame.add(msgAreata);
        frame.add(clear);
        frame.add(submit);


        frame.setLayout(null);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(1000, 1000);


        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nametf.setText("");
                addresstf.setText("");
                phoneNotf.setText("");
                citytf.setText("");
                statetf.setText("");
                pincodetf.setText("");
                emailtf.setText("");
                arrival_DnTtf.setText("");
                departure_DnTtf.setText("");
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add the validation of form cant be empty
                if (nametf.getText().toString().isEmpty() ||
                        addresstf.getText().toString().isEmpty() ||
                        citytf.getText().toString().isEmpty() ||
                        statetf.getText().toString().isEmpty() ||
                        phoneNotf.getText().toString().isEmpty() ||
                        emailtf.getText().toString().isEmpty() ||
                        arrival_DnTtf.getText().toString().isEmpty() ||
                        departure_DnTtf.getText().toString().isEmpty() ||
                        cheque.getText().toString().isEmpty() ||
                        paypal.getText().toString().isEmpty()) {
                    bookingId.setText("Please fill the details");
                } else {
                    String url = "jdbc:mysql://localhost:3306/hotel";

                    //database credentials pass to String
                    String username = "root";
                    String password = "";


                    //make the connection jdbc to mysql
                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);


                        System.out.println("Database is Connected");
                        String sql = "insert into custmer(name,address,city,state,pincode,phoneNo,arrival_DnT,departure_DnT)"
                                + "values(?,?,?,?,?,?,?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString(1, nametf.getText().toString());
                        preparedStmt.setString(2, addresstf.getText().toString());
                        preparedStmt.setString(3, citytf.getText().toString());
                        preparedStmt.setString(4, statetf.getText().toString());
                        preparedStmt.setString(5, pincodetf.getText().toString());
                        preparedStmt.setString(6, phoneNotf.getText().toString());

                        preparedStmt.setString(7, arrival_DnTtf.getText().toString());
                        preparedStmt.setString(8, departure_DnTtf.getText().toString());


                        //name,address,city,state,pincode,phoneno,email,arrival-DnT,departure-DnT,NoOfKids,paymentMethod,total

                        preparedStmt.execute();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex+"Database is not connected");
                    }

                }


        Random random = new Random();
        int id = random.nextInt(999999);
        bookingId.setText("Your booking is confirmed and BookingID is " + id);
    }
});
}
}