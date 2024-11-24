package electricitybillsystem;

import javax.swing.*;

class InvalidNumberLengthException extends Exception {
    InvalidNumberLengthException(String s) {
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }
}

class InvalidEmailException extends Exception {
    InvalidEmailException(String s) {
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }
}

public class validation {
    validation(String phone,String email){
        
        if(phoneCheck(phone)==1 && emailCheck(email)==1)
        {
            
        }
    }
    int phoneCheck(String s) {
        try {
            if (s.length() != 10) {
                throw new InvalidNumberLengthException("Check Your Phone Number");
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
        
    }

    int emailCheck(String s) {
        int count = 0;
        for (char e : s.toCharArray()) {
            if (e == '@') {
                count++;
            }
        }
        try {
            if (count == 0) {
                throw new InvalidEmailException("Check Your Email.\n'i.e \"xyz@gmail.com\"");
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
        
    }
    public static void main(String[] args) {
        new validation("","");
    }
}
