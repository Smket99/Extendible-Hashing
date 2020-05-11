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
    public Integer mod=(int)Math.pow(2,gd);
    public void codeUtil()
    {
        hm.clear();
        gd = 1;
        int flag_display=0;
        Arrays.fill(ld, 1);//Local Depth = 1
        for (int i = 0; i < (int) Math.pow(2, gd); i++) {   //All possible HashValues
            String key_hash=binary(i,gd);
            String hashval = binary(i, gd);
            List<Integer> ll = new ArrayList<>();
            hm.put(key_hash, ll);
            ListIterator<Integer> it = keys.listIterator();
//            if(ld[i]>bfr+1){
//                JOptionPane.showMessageDialog(null, "CANNOT ADD "+xin);
//                keys.remove(xin);
//                flag_display=1;
//                break;
//            }
            while (it.hasNext()) {  //traversing List
                int k = it.next();
                mod=(int)Math.pow(2,gd);
                String h = hash(binary(k%mod, ld[i]), ld[i]);
                if (hashval.equals(h) || h.equals(hashval.substring(gd - ld[i], gd))) {
                    ll.add(k);
                    if (ll.size() > bfr) {
                        if (gd <= ld[i]) 
                            gd++;
                        ld[i]++;
                        i = -1;
                        hm.clear();
                        break;
                    }
                }
            }
            hm.put(hashval, ll);
        }
        if(flag_display==0)
        {
        Map<String, List<Integer>> map = new TreeMap<>(hm);
        global.setText(Integer.toString(gd));
        modtext.setText(Integer.toString(mod));
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
        int d = Integer.parseInt(strNum);
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
            String dir="\t";
            int flag=0;
            for (Map.Entry<String, List<Integer>> ml : hm.entrySet()) {
            String str = ml.getKey();
            List<Integer>lsearch=ml.getValue();
            if(lsearch.contains(sear))
            { 
                if(flag>0)
                    dir=dir+"\n\t";
                dir=dir+ml.getKey();
                flag++;
            }
            
        }
            textArea.setText(sear+" IS PRESENT IN DIRECTORY:-\n"+dir);
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
          global.setText(Integer.toString(gd));
        buksize.setText(Integer.toString(bfr));
        modtext.setText(Integer.toString(mod));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        buksize = new javax.swing.JTextField();
        modtext = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jLabel3.setText("jLabel3");

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
        global.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                globalActionPerformed(evt);
            }
        });
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
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
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

        jLabel4.setBackground(new java.awt.Color(26, 24, 2));
        jLabel4.setFont(new java.awt.Font("DialogInput", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BFR->");

        buksize.setEditable(false);
        buksize.setBackground(new java.awt.Color(0, 0, 0));
        buksize.setFont(new java.awt.Font("Ebrima", 1, 56)); // NOI18N
        buksize.setForeground(new java.awt.Color(255, 255, 255));
        buksize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buksize.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        buksize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buksizeKeyPressed(evt);
            }
        });

        modtext.setEditable(false);
        modtext.setBackground(new java.awt.Color(0, 0, 0));
        modtext.setFont(new java.awt.Font("Ebrima", 1, 56)); // NOI18N
        modtext.setForeground(new java.awt.Color(255, 255, 255));
        modtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modtext.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        modtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modtextKeyPressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(26, 24, 2));
        jLabel5.setFont(new java.awt.Font("DialogInput", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MOD->");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyval, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buksize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(global, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modtext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Clearbut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deletebut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchbut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(display, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(getkeys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(global, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyval, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buksize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modtext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Clearbut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(getkeys, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(deletebut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(searchbut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(hash, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buksizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buksizeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buksizeKeyPressed

    private void getkeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getkeysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getkeysActionPerformed

    private void getkeysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getkeysMouseClicked
        textArea.setText(keys.toString());
    }//GEN-LAST:event_getkeysMouseClicked

    private void ClearbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbutActionPerformed

    private void ClearbutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbutMouseClicked
        Clear();
    }//GEN-LAST:event_ClearbutMouseClicked

    private void deletebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletebutActionPerformed

    private void deletebutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutMouseClicked
        Delete();
    }//GEN-LAST:event_deletebutMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayActionPerformed

    private void displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseClicked
        codeUtil();
    }//GEN-LAST:event_displayMouseClicked

    private void searchbutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbutMouseClicked
        search();
    }//GEN-LAST:event_searchbutMouseClicked

    private void globalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_globalKeyPressed

    }//GEN-LAST:event_globalKeyPressed

    private void hashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hashMouseClicked
        code();
    }//GEN-LAST:event_hashMouseClicked

    private void keyvalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyvalKeyPressed
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
    }//GEN-LAST:event_keyvalKeyPressed

    private void keyvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyvalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyvalActionPerformed

    private void modtextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modtextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_modtextKeyPressed

    private void globalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_globalActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
            gui.setLocationRelativeTo(null);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clearbut;
    private javax.swing.JTextField buksize;
    private javax.swing.JButton deletebut;
    private javax.swing.JButton display;
    private javax.swing.JButton getkeys;
    private javax.swing.JTextField global;
    private javax.swing.JButton hash;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyval;
    private javax.swing.JTextField modtext;
    private javax.swing.JButton searchbut;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
