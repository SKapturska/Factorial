package factorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

    JLabel lNumber, lResult, lTimeIteration, lTimeRecursion;
    JTextField tfNumber;
    JButton bCalculate, bStop;
    Thread iterationThread, recursionThread;
    FactorialIteration iteration;
    FactorialRecursion recursion;

    Window() {
        setTitle("Obliczanie silni");
        setSize(350, 200);
        setLocation(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        lNumber = new JLabel("Liczba: ");
        lNumber.setLocation(50, 10);
        lNumber.setSize(50, 25);
        add(lNumber);

        tfNumber = new JTextField();
        tfNumber.setLocation(110, 10);
        tfNumber.setSize(70, 25);
        add(tfNumber);

        bCalculate = new JButton("Oblicz");
        bCalculate.setLocation(200, 10);
        bCalculate.setSize(100, 25);
        bCalculate.addActionListener(this);
        add(bCalculate);

        bStop = new JButton("Nie chce dłużej czekać");
        bStop.setLocation(70, 50);
        bStop.setSize(200, 25);
        add(bStop);

        lResult = new JLabel("Wynik: ");
        lResult.setLocation(20, 90);
        lResult.setSize(100, 25);
        add(lResult);

        lTimeIteration = new JLabel("Czas obliczania iteracyjnie: ");
        lTimeIteration.setLocation(20, 110);
        lTimeIteration.setSize(300, 25);
        add(lTimeIteration);

        lTimeRecursion = new JLabel("Czas obliczania rekurencyjnie: ");
        lTimeRecursion.setLocation(20, 130);
        lTimeRecursion.setSize(300, 25);
        add(lTimeRecursion);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == bCalculate) {
            iteration = new FactorialIteration(Integer.parseInt(tfNumber.getText()));
            iterationThread = new Thread(iteration);
            recursion = new FactorialRecursion(Integer.parseInt(tfNumber.getText()));
            recursionThread = new Thread(recursion);

            iterationThread.start();
            recursionThread.start();

            while (iterationThread.isAlive() && recursionThread.isAlive()) {
                
            }
            
            if((!iterationThread.isAlive() && !iterationThread.isInterrupted()) && (!recursionThread.isAlive() && !recursionThread.isInterrupted())){
                lTimeIteration.setText("Czas obliczania iteracyjnie: " + iteration.getTime() + " nanosekund");
                lTimeRecursion.setText("Czas obliczania rekurencyjnie: " + recursion.getTime() + " nanosekund");
                lResult.setText("Wynik: " + iteration.getResult());
                
            }else if(!recursionThread.isAlive() && !recursionThread.isInterrupted()) {
                lTimeRecursion.setText("Czas obliczania rekurencyjnie: " + recursion.getTime() + " nanosekund");
                lResult.setText("Wynik: " + recursion.getResult());

            }else if (!iterationThread.isAlive() && !iterationThread.isInterrupted()) {
                lTimeIteration.setText("Czas obliczania iteracyjnie: " + iteration.getTime() + " nanosekund");
                lResult.setText("Wynik: " + iteration.getResult());
            }
            
            
            while(iterationThread.isAlive() || recursionThread.isAlive()){
                
            }
            
            if(!recursionThread.isAlive() && !recursionThread.isInterrupted()) {
                lTimeRecursion.setText("Czas obliczania rekurencyjnie: " + recursion.getTime() + " nanosekund");

            }if (!iterationThread.isAlive() && !iterationThread.isInterrupted()) {
                lTimeIteration.setText("Czas obliczania iteracyjnie: " + iteration.getTime() + " nanosekund");
            }
            

        } else if (source == bStop) {
            iterationThread.interrupt();
            recursionThread.interrupt();
            lResult.setText("Wynik: Brak");
        }
    }

}
