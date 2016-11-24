package factorial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
    
    JLabel lNumber;
    JTextField tfNumber;
    JButton bCalculate, bStop;
    
     Window() {                      
        setTitle("Obliczanie silni");
        setSize(350, 250);
        setLocation(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        lNumber = new JLabel("Liczba: ");
        lNumber.setLocation(50,10);
        lNumber.setSize(50,25);
        add(lNumber);
        
        tfNumber = new JTextField();
        tfNumber.setLocation(110, 10);
        tfNumber.setSize(70, 25);
        add(tfNumber);
        
        bCalculate = new JButton("Oblicz");
        bCalculate.setLocation(200,10);
        bCalculate.setSize(100, 25);
        add(bCalculate);
        
        bStop = new JButton("Nie chce dłużej czekać");
        bStop.setLocation(80, 50);
        bStop.setSize(200, 25);
        add(bStop);
     }
     
}
