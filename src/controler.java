import model.loggBokModell;
import view.loggBokView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controler {
    private loggBokModell modell;
    private loggBokView view;

    public static void main(String[] args) {
        controler controler = new controler();
    }

    public controler() {
        view = new loggBokView();
        modell = new loggBokModell();

        JFrame frame = new JFrame();
        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(setMenu());

        view.getButton().addActionListener(addloggAL());

        frame.pack();
        frame.setVisible(true);
    }

    private ActionListener addloggAL() {
        return null;
    }

    private JMenuBar setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;

        menu = new JMenu("save");
        menu.addActionListener(new saveAL());
        menuBar.add(menu);

        menu = new JMenu("load");
        //menu.addActionListener(new loadAL());
        menuBar.add(menu);

        return menuBar;
    }

    private class saveAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.save();
        }
    }

    private class loadAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
