import javax.swing.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

    public class GUI_Cocktailbar extends JFrame
    {

        private JPanel contentPane;
        private JTextField txtName;
        private JTextField txtalc;
        private JTextField txtZubereitung;
        private JTextField txtZutaten;


        private CocktailBook book = new CocktailBook();

        public String auswahlbutton = "";

        /**
         * Launch the application.
         */
        public static void main(String[] args)
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        GUI_Cocktailbar frame = new GUI_Cocktailbar();
                        frame.setVisible(true);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public GUI_Cocktailbar()
        {
            setTitle("Cocktailbar Verwaltungstool");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 592, 558);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel label = new JLabel("");
            label.setBounds(5, 5, 566, 0);
            contentPane.add(label);

            JLabel lblCocktailbarVerwaltung = new JLabel("Cocktailbar Verwaltung");
            lblCocktailbarVerwaltung.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
            lblCocktailbarVerwaltung.setBounds(157, 11, 284, 26);
            contentPane.add(lblCocktailbarVerwaltung);

            txtName = new JTextField();
            txtName.setBounds(204, 89, 249, 26);
            contentPane.add(txtName);
            txtName.setColumns(10);

            JLabel lblCocktailname = new JLabel("Cocktailname");
            lblCocktailname.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
            lblCocktailname.setBounds(35, 90, 99, 20);
            contentPane.add(lblCocktailname);

            JLabel lblAlkoholgehalt = new JLabel("Alkohol-Gehalt");
            lblAlkoholgehalt.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
            lblAlkoholgehalt.setBounds(35, 133, 99, 20);
            contentPane.add(lblAlkoholgehalt);

            txtalc = new JTextField();
            txtalc.setColumns(10);
            txtalc.setBounds(204, 132, 249, 26);
            contentPane.add(txtalc);

            JLabel lblGlasTyp = new JLabel("Zubereitungsart");
            lblGlasTyp.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
            lblGlasTyp.setBounds(35, 175, 115, 20);
            contentPane.add(lblGlasTyp);

            txtZubereitung = new JTextField();
            txtZubereitung.setColumns(10);
            txtZubereitung.setBounds(204, 174, 249, 26);
            contentPane.add(txtZubereitung);

            JLabel lblZutaten = new JLabel("Zutaten");
            lblZutaten.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
            lblZutaten.setBounds(35, 258, 99, 20);
            contentPane.add(lblZutaten);

            txtZutaten = new JTextField();
            txtZutaten.setColumns(10);
            txtZutaten.setBounds(204, 257, 249, 26);
            contentPane.add(txtZutaten);

            JRadioButton rbCocktail = new JRadioButton(Glass.Cocktailglas.toString());
            rbCocktail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
            rbCocktail.setBounds(204, 217, 76, 23);

            contentPane.add(rbCocktail);

            JRadioButton rbLimo = new JRadioButton(Glass.Limoglas.toString());
            rbLimo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
            rbLimo.setBounds(282, 217, 76, 23);
            contentPane.add(rbLimo);

            JRadioButton rbSeckt = new JRadioButton(Glass.Sektglas.toString());
            rbSeckt.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
            rbSeckt.setBounds(377, 217, 76, 23);
            contentPane.add(rbSeckt);

            ButtonGroup g = new ButtonGroup();
            g.add(rbSeckt);
            g.add(rbLimo);
            g.add(rbCocktail);

            JButton btnEnde = new JButton("Beenden");
            btnEnde.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
            btnEnde.setFont(new Font("Calibri", Font.BOLD, 14));
            btnEnde.setBounds(434, 462, 132, 46);
            contentPane.add(btnEnde);

            /**
             * Rezept anlegen
             */
            JButton btnRezeptAnlegen = new JButton("Rezept anlegen");
            btnRezeptAnlegen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String auswahlButton2 ="";
                    auswahlbutton = auswahlButton2;
                    ButtonModel selectedModel = g.getSelection();

                    if (rbSeckt.getModel()== selectedModel){
                        auswahlButton2= Glass.Sektglas.toString();
                    }
                    else if(rbLimo.getModel()==selectedModel){
                        auswahlButton2= Glass.Limoglas.toString();
                    }else if (rbCocktail.getModel()== selectedModel){
                        auswahlButton2=Glass.Cocktailglas.toString();
                    }
String name = txtName.getText();
                    String zubereitung =txtZubereitung.getText();
                    String ingredient = txtZutaten.getText();
                    //TODO Splitten an ,
                    String [] ingredientSplit = ingredient.split(",");
                    String alk = txtalc.getText();
                    try {
                        Glass currentGlass = Glass.stringToGlas(auswahlButton2);
                    Recipe current = new Recipe(name,Util.arrayToArrayListIngredient(ingredientSplit),zubereitung,Double.parseDouble(alk),currentGlass);
                        book.addRecipe(current);
                    } catch (CocktailException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"Als Alkoholgehalt nur die nummer eingeben ");
                    }
                    txtName.setText("");
                    txtalc.setText("");
                    txtZubereitung.setText("");
                    txtZutaten.setText("");

                }
            });
            btnRezeptAnlegen.setFont(new Font("Calibri", Font.BOLD, 14));
            btnRezeptAnlegen.setBounds(35, 350, 174, 46);
            contentPane.add(btnRezeptAnlegen);

            JButton btnRezeptAnzeigen = new JButton("Rezept Anzeigen");
            btnRezeptAnzeigen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    try {

                        Recipe currentOne = book.findRecipeByName(txtName.getText());
                        JOptionPane.showMessageDialog(null,currentOne.toString());

                    }catch (CocktailException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });
            btnRezeptAnzeigen.setFont(new Font("Calibri", Font.BOLD, 14));
            btnRezeptAnzeigen.setBounds(35, 407, 174, 46);
            contentPane.add(btnRezeptAnzeigen);

            JButton btnRezeptLoeschen = new JButton("Rezept L\u00F6schen");
            btnRezeptLoeschen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        book.removeRecipe(txtName.getName());
                    }catch (CocktailException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });
            btnRezeptLoeschen.setForeground(Color.BLACK);
            btnRezeptLoeschen.setBackground(Color.RED);
            btnRezeptLoeschen.setFont(new Font("Calibri", Font.BOLD, 14));
            btnRezeptLoeschen.setBounds(219, 462, 155, 46);
            contentPane.add(btnRezeptLoeschen);

            JButton btnRezeptBearbeiten = new JButton("Rezept bearbeiten");
            btnRezeptBearbeiten.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    try {
                        book.removeRecipe(txtName.getName());
                        String zubereitung =txtZubereitung.getText();
                        String ingredient = txtZutaten.getText();
                        //TODO Splitten an ,
                        String [] ingredientSplit = ingredient.split(",");
                        String alk = txtalc.getText();
                        String name = txtName.getText();
                        try {
                            Glass currentGlass = Glass.stringToGlas(auswahlbutton);
                            Recipe current = new Recipe(name,Util.arrayToArrayListIngredient(ingredientSplit),zubereitung,Double.parseDouble(alk),currentGlass);
                            book.addRecipe(current);
                        } catch (CocktailException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        } catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null,"Der Alkohol muss als Zahl eingeben werden, Bitte versuche es noch mal");
                        }
                    }catch (CocktailException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });
            btnRezeptBearbeiten.setFont(new Font("Calibri", Font.BOLD, 14));
            btnRezeptBearbeiten.setBounds(35, 462, 174, 46);
            contentPane.add(btnRezeptBearbeiten);

            JLabel lblGlastyp = new JLabel("Glas-Typ");
            lblGlastyp.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
            lblGlastyp.setBounds(35, 217, 115, 20);
            contentPane.add(lblGlastyp);




        }

    }

