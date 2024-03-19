import javax.swing.*;

public class Demo extends JFrame {

    private JPanel panelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JTextField textField3;
    private JButton previousButton;
    private JButton nextButton;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Soubor");
    private JMenuItem menuItem = new JMenuItem("Načti...");
    EvidenceZamestnancu evidenceZamestnancu = new EvidenceZamestnancu();
    private int index = 0;

    public Demo(){
        initComponents();
    }
    public void initComponents(){
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Seznam zaměstnanců");
        menuBar.add(menu);
        menu.add(menuItem);
        setJMenuBar(menuBar);
        pack();

        menuItem.addActionListener(e -> openFile());
        nextButton.addActionListener(e -> next());
        previousButton.addActionListener(e -> previous());
    }

    public void openFile(){
        JFileChooser jFileChooser = new JFileChooser(".");
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            evidenceZamestnancu.readFromFile(jFileChooser.getSelectedFile());
            textField1.setText(evidenceZamestnancu.getZamestnanec(index).getJmeno());
            textField2.setText(evidenceZamestnancu.getZamestnanec(index).getPrijmeni());
            checkBox1.setSelected(evidenceZamestnancu.getZamestnanec(index).isPojisteni());
            textField3.setText(evidenceZamestnancu.getZamestnanec(index).getNarozeni().toString());
        }
        else {
            JOptionPane.showMessageDialog(this, "Soubor nebyl načten");
        }
    }
    public void next(){
        if (index < evidenceZamestnancu.zamestnanci.size() - 1){
            index++;
            textField1.setText(evidenceZamestnancu.getZamestnanec(index).getJmeno());
            textField2.setText(evidenceZamestnancu.getZamestnanec(index).getPrijmeni());
            checkBox1.setSelected(evidenceZamestnancu.getZamestnanec(index).isPojisteni());
            textField3.setText(evidenceZamestnancu.getZamestnanec(index).getNarozeni().toString());
        }
        if(index == evidenceZamestnancu.zamestnanci.size()- 1){
            JOptionPane.showMessageDialog(this, "Jste na konci seznamu");
        }
    }
    public void previous(){
        if (index > 0){
            index--;
            textField1.setText(evidenceZamestnancu.getZamestnanec(index).getJmeno());
            textField2.setText(evidenceZamestnancu.getZamestnanec(index).getPrijmeni());
            checkBox1.setSelected(evidenceZamestnancu.getZamestnanec(index).isPojisteni());
            textField3.setText(evidenceZamestnancu.getZamestnanec(index).getNarozeni().toString());
        }
        if (index == 0){
            JOptionPane.showMessageDialog(this, "Jste na začátku seznamu");
        }

    }

}
