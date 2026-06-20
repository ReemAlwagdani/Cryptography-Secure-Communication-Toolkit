
// Student Name: Reem Rakan Alwagadani
// ID: 2323653
// Section: IAR
//GradedLab1


public class GradedLab1_ReemAlwagdani_2323653_IAR extends javax.swing.JFrame {
    
    String plaintext = "";
    String ciphertext = "";
    String key; 

    public GradedLab1_ReemAlwagdani_2323653_IAR() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Plaintext = new javax.swing.JTextField();
        Ciphertext = new javax.swing.JTextField();
        Key = new javax.swing.JTextField();
        OriginalText = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Plaintext");

        jLabel2.setText("Ciphertext");

        jLabel3.setText("Original Text");

        jLabel4.setText("Key");

        Encrypt.setText("Encrypt");
        Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptActionPerformed(evt);
            }
        });

        Decrypt.setText("Decrypt");
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Plaintext, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Ciphertext, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Key, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(OriginalText)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Encrypt)
                            .addComponent(Decrypt))))
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Plaintext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(Encrypt)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Ciphertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(Decrypt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OriginalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // -------------------- Encrypt --------------------
    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed

        plaintext = Plaintext.getText().toLowerCase();
        key = Key.getText().toLowerCase();
        ciphertext = "";

        if (key == null || key.length() == 0) {
          javax.swing.JOptionPane.showMessageDialog(this, "Key cannot be empty!");
          return;
            }

        int keyIndex = 0; // to repeat the key

        for (int i = 0; i < plaintext.length(); i++) {
         char pChar = plaintext.charAt(i);

          if (pChar >= 'a' && pChar <= 'z') {
            int p = pChar - 'a'; // 0..25

            char kChar = key.charAt(keyIndex % key.length());
            int k = kChar - 'a'; // 0..25

                  
            int c = (p + k) % 26;

            ciphertext += (char) (c + 'a');
            keyIndex++;
        } else {
            ciphertext += pChar; // keep spaces/symbols
             }
           }

            Ciphertext.setText(ciphertext);
        }


    // -------------------- Decrypt --------------------
    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed

        ciphertext = Ciphertext.getText().toLowerCase();
        key = Key.getText().toLowerCase();
        plaintext = "";

        if (key == null || key.length() == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Key cannot be empty!");
         return;
        }   

        int keyIndex = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
         char cChar = ciphertext.charAt(i);

             if (cChar >= 'a' && cChar <= 'z') {
                 int c = cChar - 'a'; 

                 char kChar = key.charAt(keyIndex % key.length());
                 int k = kChar - 'a'; 

             
                 int p = (c - k + 26) % 26;

                 plaintext += (char) (p + 'a');
                 keyIndex++;
                 } else {
                 plaintext += cChar;
              }
             }

            OriginalText.setText(plaintext);

                }
    
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GradedLab1_ReemAlwagdani_2323653_IAR().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ciphertext;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JTextField Key;
    private javax.swing.JTextField OriginalText;
    private javax.swing.JTextField Plaintext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    }//GEN-LAST:event_EncryptActionPerformed

   
