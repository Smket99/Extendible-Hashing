package module_2;

import com.sun.glass.events.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Extendible Hashing-Java Implementation
 * @author Smiket Barodia 03.04.2020
 */
public class GUI extends javax.swing.JFrame {
    HashMap<String, List<Integer>> hm = new HashMap<>();// Initializing HashMap
    List<Integer> keys = new ArrayList<>(); //Initializing a global List
    int[] ld = new int[500];
    public Integer xin;
    public Integer gd=1,bfr=3;//Global Depth = 1 , Bfr=3
    public void codeUtil()
    {
        hm.clear();
        gd = 1;
        int flag_display=0;
        Arrays.fill(ld, 1);//Local Depth = 1
        for (int i = 0; i < (int) Math.pow(2, gd); i++) {   //All possible HashValues
            int flag = 0;
            String key_hash=binary(i,gd);
            String hashval = binary(i, gd);
            List<Integer> ll = new ArrayList<>();
            hm.put(key_hash, ll);
            ListIterator<Integer> it = keys.listIterator();
            if(ld[i]>bfr+1){
                JOptionPane.showMessageDialog(null, "CANNOT ADD "+xin);
                keys.remove(xin);
                flag_display=1;
                break;
            }
            while (it.hasNext()) {  //traversing List
                int k = it.next();
                String h = hash(binary(k%10, ld[i]), ld[i]);
                if (hashval.equals(h) || h.equals(hashval.substring(gd - ld[i], gd))) {
                    ll.add(k);
                    if (ll.size() > bfr) {
                        if (gd <= ld[i]) 
                            gd++;
                        ld[i]++;
                        flag = 1;
                        i = -1;
                        hm.clear();
                        break;
                    }
                }
            }
            //if (flag == 0)
                hm.put(hashval, ll);
        }
        if(flag_display==0)
        {
        Map<String, List<Integer>> map = new TreeMap<>(hm);
        global.setText(Integer.toString(gd));
        String stk = "Directory\tBuckets\tLocal Depth\n";
        for (Map.Entry<String, List<Integer>> ml : map.entrySet()) {
            String str = ml.getKey();
                System.out.println(ml.getKey() + "\t" + ml.getValue() + "\tLD:" + ld[Integer.parseInt(str, 2)]);
                stk = stk + ml.getKey() + "\t" + ml.getValue() + "\tLD:" + Integer.toString(ld[Integer.parseInt(str, 2)]) + "\n";
        }
        textArea.setText(stk);
        }
    }
    public void code(){         //Extendible Hashing Algorithm
        String val=keyval.getText();
        if(val.equals("")||isNumeric(val)==0)
            JOptionPane.showMessageDialog(null, "ENTER A VALID KEY"); 
        else if(keys.contains(Integer.parseInt(val)))
            JOptionPane.showMessageDialog(null, "KEY MUST BE UNIQUE");
        else
        {
        xin = Integer.parseInt(val);//getting text from TextField
        keys.add(xin);    //Adding key to list
        codeUtil();
        }
        keyval.setText("");
    }
    public static int isNumeric(String strNum) {    //To check valid key Input
    if (strNum == null) {
        return 0;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return 0;
    }
    return 1;
}
    public Integer sear;
    public void search()
    {
         String val=keyval.getText();
        if(val.equals("")||isNumeric(val)==0)
            JOptionPane.showMessageDialog(null, "ENTER A VALID KEY");
        else
        {
            sear=Integer.parseInt(keyval.getText());
        if(keys.contains(sear))
        {
            //int gd=Integer.parseInt(global.getText());
            String dir="";
            int flag=0;
            for (Map.Entry<String, List<Integer>> ml : hm.entrySet()) {
            String str = ml.getKey();
            List<Integer>lsearch=ml.getValue();
            if(lsearch.contains(sear))
            { 
                if(flag>0)
                    dir=dir+", ";
                dir=dir+ml.getKey();
                flag++;
            }
            
        }
            textArea.setText(sear+" IS PRESENT IN DIRECTORY "+dir);
        }
        else
            textArea.setText(sear+" IS NOT PRESENT");
        }
        keyval.setText("");
    }
    static String hash(String bin, int gdk) {   //Hash Encoder
        String hashvalue = bin.substring(bin.length() - gdk, bin.length());
        return hashvalue;
    }
    public String binary(int x, int gdk) //returns padded binary representation
    {
        String bin = Integer.toBinaryString(x);  //Hash Function
        if (bin.length() < gdk) {
            while (bin.length() != gdk) {
                bin = "0" + bin;
            }
        }
        return bin;
    }
    public void Delete(){
        String val=keyval.getText();
        if(val.equals("")||isNumeric(val)==0)
            JOptionPane.showMessageDialog(null, "ENTER A VALID KEY");
        else
        {
        int del=Integer.parseInt(val);
        if(keys.contains(del))
        { keys.remove(Integer.valueOf(del));
            textArea.setText(del+" WAS DELETED");}
        else
            JOptionPane.showMessageDialog(null,del+" IS NOT PRESENT");
        }
        keyval.setText("");
    }
    public void Clear()
    {
        this.dispose();
        main(null);
    }
    public GUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        keyval = new javax.swing.JTextField();
        hash = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        global = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchbut = new javax.swing.JButton();
        display = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        deletebut = new javax.swing.JButton();
        Clearbut = new javax.swing.JButton();
        getkeys = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1121, 711));
        jPanel1.setRequestFocusEnabled(false);

        keyval.setBackground(new java.awt.Color(0, 0, 0));
        keyval.setFont(new java.awt.Font("Ebrima", 1, 56)); // NOI18N
        keyval.setForeground(new java.awt.Color(255, 255, 255));
        keyval.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        keyval.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        keyval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyvalActionPerformed(evt);
            }
        });
        keyval.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyvalKeyPressed(evt);
            }
        });

        hash.setBackground(new java.awt.Color(0, 0, 0));
        hash.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        hash.setForeground(new java.awt.Color(255, 255, 255));
        hash.setText("HASH");
        hash.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        hash.setOpaque(false);
        hash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hashMouseClicked(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(51, 51, 51));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        textArea.setForeground(new java.awt.Color(255, 255, 255));
        textArea.setRows(5);
        textArea.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(textArea);

        jLabel1.setBackground(new java.awt.Color(26, 24, 2));
        jLabel1.setFont(new java.awt.Font("DialogInput", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KEY->");

        global.setEditable(false);
        global.setBackground(new java.awt.Color(0, 0, 0));
        global.setFont(new java.awt.Font("Ebrima", 1, 56)); // NOI18N
        global.setForeground(new java.awt.Color(255, 255, 255));
        global.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        global.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        global.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                globalKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(26, 24, 2));
        jLabel2.setFont(new java.awt.Font("DialogInput", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GD->");

        searchbut.setBackground(new java.awt.Color(0, 0, 0));
        searchbut.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        searchbut.setForeground(new java.awt.Color(29, 219, 79));
        searchbut.setText("SEARCH");
        searchbut.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        searchbut.setOpaque(false);
        searchbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbutMouseClicked(evt);
            }
        });

        display.setBackground(new java.awt.Color(0, 0, 0));
        display.setFont(new java.awt.Font("Ebrima", 1, 32)); // NOI18N
        display.setForeground(new java.awt.Color(2, 167, 237));
        display.setText("DISPLAY");
        display.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        display.setOpaque(false);
        display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayMouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("X");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray)));
        jButton3.setDefaultCapable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        deletebut.setBackground(new java.awt.Color(0, 0, 0));
        deletebut.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        deletebut.setForeground(new java.awt.Color(255, 0, 0));
        deletebut.setText("DELETE");
        deletebut.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        deletebut.setOpaque(false);
        deletebut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletebutMouseClicked(evt);
            }
        });
        deletebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebutActionPerformed(evt);
            }
        });

        Clearbut.setBackground(new java.awt.Color(0, 0, 0));
        Clearbut.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        Clearbut.setForeground(new java.awt.Color(255, 255, 0));
        Clearbut.setText("CLEAR");
        Clearbut.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        Clearbut.setOpaque(false);
        Clearbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearbutMouseClicked(evt);
            }
        });
        Clearbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbutActionPerformed(evt);
            }
        });

        getkeys.setBackground(new java.awt.Color(0, 0, 0));
        getkeys.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        getkeys.setForeground(new java.awt.Color(0, 255, 255));
        getkeys.setText("KEYS");
        getkeys.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        getkeys.setOpaque(false);
        getkeys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getkeysMouseClicked(evt);
            }
        });
        getkeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getkeysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(deletebut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(searchbut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(hash, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(keyval, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(getkeys, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Clearbut, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(global, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyval, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Clearbut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(getkeys, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(global, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hash, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchbut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletebut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void displayMouseClicked(java.awt.event.MouseEvent evt) {                                     
        codeUtil();
    }                                    

    private void searchbutMouseClicked(java.awt.event.MouseEvent evt) {                                       
        search();
    }                                      

    private void globalKeyPressed(java.awt.event.KeyEvent evt) {                                  

    }                                 

    private void hashMouseClicked(java.awt.event.MouseEvent evt) {                                  
        code();
    }                                 

    private void keyvalKeyPressed(java.awt.event.KeyEvent evt) {                                  
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            code();
        else if(evt.getKeyCode()==17)
            search();
        else if(evt.getKeyCode()==16)
            codeUtil();
        else if(evt.getKeyCode()==127)
            Delete();
        else if(evt.getKeyCode()==27)
            Clear();
    }                                 

    private void keyvalActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void deletebutMouseClicked(java.awt.event.MouseEvent evt) {                                       
        Delete();
    }                                      

    private void deletebutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void ClearbutMouseClicked(java.awt.event.MouseEvent evt) {                                      
        Clear();
    }                                     

    private void ClearbutActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void getkeysMouseClicked(java.awt.event.MouseEvent evt) {                                     
       textArea.setText(keys.toString());
    }                                    

    private void getkeysActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
            gui.setLocationRelativeTo(null);
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton Clearbut;
    private javax.swing.JButton deletebut;
    private javax.swing.JButton display;
    private javax.swing.JButton getkeys;
    private javax.swing.JTextField global;
    private javax.swing.JButton hash;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyval;
    private javax.swing.JButton searchbut;
    private javax.swing.JTextArea textArea;
    // End of variables declaration                   
}
