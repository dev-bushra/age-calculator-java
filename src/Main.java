/*          Deveolp By : Bushra Aboubida Ahmed          */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main extends JFrame {
//================================== Menu Bar ==================================
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("About");

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        pack();
    }
    
    //--------------------------------------------------------------------------
        private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {                                               
        new About().setVisible(true);
        this.setVisible(false);
    } 
        //----------------------------------------------------------------------
         // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    // End of variables declaration
//=============================== End Of Menu Bar ==============================
    
    
    JLabel birthDate, deathDate, result;
    JCheckBox deathDateState;
    JComboBox dayOfBirth, monthOfBirth, yearOfBirth, dayOfDeath, monthOfDeath, yearOfDeath;
    JButton calculateAge;

    int d1, d2, m1, m2, y1, y2;

    LocalDate startDate, endDate;

    long daysCounter, monthsCounter, yearsCounter;

    Font font = new Font("Arial", Font.BOLD, 18);

    public Main() {
        createAndShowGUI();
        initComponents();
    }

    private void createAndShowGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

        int currentYear = LocalDate.now().getYear();

        Integer[] years = new Integer[currentYear];

        for (int i = 0; i < years.length; i++) {
            years[i] = i + 1;
        }

        birthDate = new JLabel("Birth Date");
        deathDate = new JLabel("Death Date");
        deathDateState = new JCheckBox();
        dayOfBirth = new JComboBox(days);
        monthOfBirth = new JComboBox(months);
        yearOfBirth = new JComboBox(years);
        dayOfDeath = new JComboBox(days);
        monthOfDeath = new JComboBox(months);
        yearOfDeath = new JComboBox(years);
        calculateAge = new JButton("Calculate Age");
        result = new JLabel("", JLabel.CENTER);

        birthDate.setBounds(175, 40, 200, 30);
        dayOfBirth.setBounds(120, 80, 50, 30);
        monthOfBirth.setBounds(173, 80, 70, 30);
        yearOfBirth.setBounds(246, 80, 70, 30);
        deathDateState.setBounds(158, 140, 20, 30);
        deathDate.setBounds(183, 140, 200, 30);
        dayOfDeath.setBounds(120, 180, 50, 30);
        monthOfDeath.setBounds(173, 180, 70, 30);
        yearOfDeath.setBounds(246, 180, 70, 30);
        calculateAge.setBounds(118, 250, 200, 60);
        result.setBounds(0, 345, 440, 30);

        birthDate.setFont(font);
        deathDate.setFont(font);
        calculateAge.setFont(font);
        result.setFont(new Font("Arial", Font.BOLD, 17));

        yearOfBirth.setSelectedItem(2000);
        yearOfDeath.setSelectedItem(2000);

        deathDate.setEnabled(false);
        dayOfDeath.setEnabled(false);
        monthOfDeath.setEnabled(false);
        yearOfDeath.setEnabled(false);

        add(birthDate);
        add(deathDate);
        add(dayOfBirth);
        add(monthOfBirth);
        add(yearOfBirth);
        add(deathDateState);
        add(dayOfDeath);
        add(monthOfDeath);
        add(yearOfDeath);
        add(calculateAge);
        add(result);

        deathDateState.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (deathDateState.isSelected()) {
                    deathDate.setEnabled(true);
                    dayOfDeath.setEnabled(true);
                    monthOfDeath.setEnabled(true);
                    yearOfDeath.setEnabled(true);
                } else {
                    deathDate.setEnabled(false);
                    dayOfDeath.setEnabled(false);
                    monthOfDeath.setEnabled(false);
                    yearOfDeath.setEnabled(false);
                }
            }
        });

        monthOfBirth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                String month = monthOfBirth.getSelectedItem().toString();

                if (month.equals("Jan") || month.equals("Mar") || month.equals("May")
                        || month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")) {
                    for (int i = 1; i <= 31; i++) {
                        dayOfBirth.addItem(i);
                    }
                } else if (month.equals("Feb")) {
                    for (int i = 1; i <= 28; i++) {
                        dayOfBirth.addItem(i);
                    }
                } else {
                    for (int i = 1; i <= 30; i++) {
                        dayOfBirth.addItem(i);
                    }
                }

            }
        });

        monthOfDeath.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                String month = monthOfDeath.getSelectedItem().toString();

                if (month.equals("Jan") || month.equals("Mar") || month.equals("May")
                        || month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")) {
                    for (int i = 1; i <= 31; i++) {
                        dayOfDeath.addItem(i);
                    }
                } else if (month.equals("Feb")) {
                    for (int i = 1; i <= 28; i++) {
                        dayOfDeath.addItem(i);
                    }
                } else {
                    for (int i = 1; i <= 30; i++) {
                        dayOfDeath.addItem(i);
                    }
                }

            }
        });

        calculateAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                y1 = yearOfBirth.getSelectedIndex() + 1;
                m1 = monthOfBirth.getSelectedIndex() + 1;
                d1 = dayOfBirth.getSelectedIndex() + 1;

                if (deathDateState.isSelected()) {
                    y2 = yearOfDeath.getSelectedIndex() + 1;
                    m2 = monthOfDeath.getSelectedIndex() + 1;
                    d2 = dayOfDeath.getSelectedIndex() + 1;
                } else {
                    y2 = LocalDate.now().getYear();
                    m2 = LocalDate.now().getMonthValue();
                    d2 = LocalDate.now().getDayOfMonth();
                }

                startDate = LocalDate.of(y1, m1, d1);
                endDate = LocalDate.of(y2, m2, d2);

                yearsCounter = Period.between(startDate, endDate).getYears();
                monthsCounter = Period.between(startDate, endDate).getMonths();
                daysCounter = Period.between(startDate, endDate).getDays();

                if (yearsCounter == 0 && monthsCounter == 0 && daysCounter == 0) {
                    result.setForeground(Color.red);
                    result.setText("Cannot compare same date!");
                } else if (!Period.between(startDate, endDate).isNegative()) {

                    if (yearsCounter == 1) {
                        text += yearsCounter + " year ";
                    } else if (yearsCounter > 1) {
                        text += yearsCounter + " years ";
                    }

                    if (monthsCounter == 1) {
                        if (yearsCounter > 0 && daysCounter > 0) {
                            text += ", " + monthsCounter + " month ";
                        } else if (yearsCounter > 0 && daysCounter == 0) {
                            text += "and " + monthsCounter + " month ";
                        } else {
                            text += monthsCounter + " month ";
                        }
                    }

                    if (monthsCounter > 1) {
                        if (yearsCounter > 0 && daysCounter > 0) {
                            text += ", " + monthsCounter + " months ";
                        } else if (yearsCounter > 0 && daysCounter == 0) {
                            text += "and " + monthsCounter + " months ";
                        } else {
                            text += monthsCounter + " months ";
                        }
                    }

                    if (daysCounter == 1) {
                        if (yearsCounter == 0 && monthsCounter == 0) {
                            text += daysCounter + " day";
                        } else {
                            text += "and " + daysCounter + " day";
                        }
                    }

                    if (daysCounter > 1) {
                        if (yearsCounter == 0 && monthsCounter == 0) {
                            text += daysCounter + " days";
                        } else {
                            text += "and " + daysCounter + " days";
                        }
                    }

                    result.setForeground(Color.black);
                    result.setText(text);
                } else {
                    result.setForeground(Color.red);
                    result.setText("Logic order of Dates is wrong!");
                }

            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(436, 446);
        setTitle("Age Calculator");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

}
