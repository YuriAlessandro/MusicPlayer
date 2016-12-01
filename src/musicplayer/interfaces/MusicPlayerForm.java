/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.interfaces;

import banco.BancoMusic;
import java.awt.Component;
import java.io.File;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import musicplayer.Music;
import musicplayer.Playlist;
import musicplayer.User;
import musicplayer.UserCommom;
import musicplayer.UserVIP;

/**
 *
 * @author yurialessandro
 */
public class MusicPlayerForm extends javax.swing.JFrame {
    
    private String path;
    private AdvancedPlayer play;
    private final DefaultListModel l1 = new DefaultListModel();
    private User user;
    private PlayMusic playMusic;
    private Thread theadFromMusic;
    private boolean playFromPause;
//    private Player play;
    /**
     * Creates new form MusicPlayerForm
     * @param u
     */
    public MusicPlayerForm(User u){
        initComponents();
        this.setResizable(false);
//        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.listOfMusics.clearSelection();
        
        this.user = u;
        
        if(u instanceof UserCommom){
            this.listOfPlaylist.setEnabled(false);
            this.btnVipPanel.setEnabled(false);
            this.btnNewPlaylist.setEnabled(false);
        }
        
        this.txtUserName.setText(u.getUserName());
        this.playFromPause = false;
        
        this.btnPause.setEnabled(false);
        this.btnStop.setEnabled(false);
        this.playlistMusics.setEnabled(false);
        this.btnAddMusic.setEnabled(false);
    }

    private MusicPlayerForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChooseFile = new javax.swing.JButton();
        lblNameMusic = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnVipPanel = new javax.swing.JButton();
        btnAddDir = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        timeMusic = new javax.swing.JProgressBar();
        jSeparator3 = new javax.swing.JSeparator();
        btnStop = new javax.swing.JButton();
        txtUserName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfMusics = new javax.swing.JList<>();
        txtPName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlistMusics = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfPlaylist = new javax.swing.JList<>();
        btnNewPlaylist = new javax.swing.JButton();
        btnAddMusic = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        txtNewPName = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnChooseFile.setText("Add File");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        btnPlay.setText("PLAY");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jLabel2.setText("JYATH Music Player");

        btnVipPanel.setText("VIP Panel");
        btnVipPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVipPanelActionPerformed(evt);
            }
        });

        btnAddDir.setText("Add Directory");
        btnAddDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDirActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtUserName.setText("name");

        jLabel4.setText("User:");

        jLabel3.setText("Songs:");

        jScrollPane1.setViewportView(listOfMusics);

        jScrollPane2.setViewportView(playlistMusics);

        jLabel5.setText("Playlists:");

        jScrollPane3.setViewportView(listOfPlaylist);

        btnNewPlaylist.setText("New Playlist");
        btnNewPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPlaylistActionPerformed(evt);
            }
        });

        btnAddMusic.setText("Add new song");
        btnAddMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMusicActionPerformed(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txtPName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(btnNewPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtNewPName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelect)
                            .addComponent(txtNewPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddMusic)
                            .addComponent(btnNewPlaylist)))
                    .addComponent(jScrollPane1)))
        );

        jTextField1.setText("Search music...");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(timeMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVipPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUserName)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVipPanel)
                    .addComponent(txtUserName)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAddDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseFile))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPause)
                    .addComponent(btnStop))
                .addGap(5, 5, 5)
                .addComponent(timeMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Songs", "mp3");
        jf.addChoosableFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);
        int choose = jf.showOpenDialog(this);
        Music temp = new Music();
        
        if(choose == JFileChooser.APPROVE_OPTION){    
            temp.setName(jf.getSelectedFile().getName());
            temp.setPath(jf.getSelectedFile().getPath());
        }
        
        this.l1.addElement(temp.getName());
        listOfMusics.setModel(l1);
    }//GEN-LAST:event_btnChooseFileActionPerformed

    private Music selectAMusic(){
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Songs", "mp3");
        jf.addChoosableFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);
        int choose = jf.showOpenDialog(this);
        Music temp = new Music();
        
        if(choose == JFileChooser.APPROVE_OPTION){    
            temp.setName(jf.getSelectedFile().getName());
            temp.setPath(jf.getSelectedFile().getPath());
        }
        
        return temp;
    }
    
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if(!this.playFromPause){
            int i;
            if(listOfMusics.isEnabled()){
                i = listOfMusics.getSelectedIndex();
            }else{
                i = playlistMusics.getSelectedIndex();
            }
            System.err.println(i);
            Music m = BancoMusic.getMusics().get(i);
            this.path = m.getPath();
            this.lblNameMusic.setText(m.getName());

            this.playMusic = new PlayMusic(this.play, this.path);
            this.theadFromMusic = new Thread(this.playMusic);
            this.theadFromMusic.start();            
        }else{
            this.theadFromMusic.resume();
        }
        
        btnPlay.setEnabled(false);
        this.btnPause.setEnabled(true);
        this.btnStop.setEnabled(true);
        this.listOfMusics.setEnabled(false);
        
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnVipPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVipPanelActionPerformed
        new VipPanel().setVisible(true);
    }//GEN-LAST:event_btnVipPanelActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        this.theadFromMusic.stop();
        this.btnPlay.setEnabled(true);
        this.btnPause.setEnabled(true);
        this.playFromPause = false;
        this.listOfMusics.setEnabled(true);

    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        this.theadFromMusic.suspend();
        this.btnPlay.setEnabled(true);
        this.btnPause.setEnabled(false);
        this.playFromPause = true;
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnAddDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDirActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);
        
        int w = jf.showOpenDialog(this);
        File f = jf.getSelectedFile();
        String dirPath = f.getName();
        
        File[] listOfFiles = f.listFiles();
        Music m;
             
        for(int i = 0; i < listOfFiles.length; i++){
            File e = listOfFiles[i];
            if(e.isFile() && e.getName().contains(".mp3")){
                m = new Music(e.getName(), e.getAbsolutePath());
                this.l1.addElement(listOfFiles[i].getName());
            }
        }
        
        this.listOfMusics.setModel(l1);
    }//GEN-LAST:event_btnAddDirActionPerformed

    private void btnNewPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPlaylistActionPerformed
        if(this.txtNewPName.getText().isEmpty()){
            this.txtNewPName.setText("Put a name...");
        }else{
            UserVIP vip = (UserVIP) this.user;
            vip.newPlaylist(this.txtNewPName.getText());
            this.txtNewPName.setText(" ");
            this.updateListOfPlaylist();
        }
    }//GEN-LAST:event_btnNewPlaylistActionPerformed
    
    private void updateListOfPlaylist(){
        UserVIP temp = (UserVIP) this.user;
        DefaultListModel p1 = new DefaultListModel();

        for(Playlist p : temp.getPlaylists()){
            p1.addElement(p.getName());
        }
        
        this.listOfPlaylist.setModel(p1);
    }
    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        this.btnAddMusic.setEnabled(true);
        this.listOfMusics.setEnabled(false);
        this.playlistMusics.setEnabled(true);
        this.playlistMusics.clearSelection();
//        this.listOfMusics.setEnabled(true);
        UserVIP vip = (UserVIP) this.user;
//        Playlist ts;
        String selected = this.listOfPlaylist.getSelectedValue();
        DefaultListModel m1 = new DefaultListModel();
        
        for(Playlist p : vip.getPlaylists()){
            if(p.getName().equals(selected)){
                this.txtPName.setText(p.getName());
                for(Music m : p.getMusics()){
                    m1.addElement(m.getName());
                }
            }
        }
        this.listOfMusics.setModel(m1);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnAddMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMusicActionPerformed
        UserVIP vip = (UserVIP) this.user;
//        Playlist ts;
        String selected = this.listOfPlaylist.getSelectedValue();
        DefaultListModel m1 = new DefaultListModel();
        
        for(Playlist p : vip.getPlaylists()){
            if(p.getName().equals(selected)){
               Music temp = this.selectAMusic();
               p.addMusic(temp);
               m1.addElement(temp.getName());
            }
        }
        
        this.playlistMusics.setModel(m1);
    }//GEN-LAST:event_btnAddMusicActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicPlayerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDir;
    private javax.swing.JButton btnAddMusic;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnNewPlaylist;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnVipPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNameMusic;
    private javax.swing.JList<String> listOfMusics;
    private javax.swing.JList<String> listOfPlaylist;
    private javax.swing.JList<String> playlistMusics;
    private javax.swing.JProgressBar timeMusic;
    private javax.swing.JTextField txtNewPName;
    private javax.swing.JLabel txtPName;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables
    
    public class PlayMusic implements Runnable{
        
        private AdvancedPlayer play;
        String path;
        
        public PlayMusic(AdvancedPlayer play, String path) {
            this.path = path;
            this.play = play;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(path);
                play = new AdvancedPlayer(fis);
                play.play();
                
            } catch (JavaLayerException | FileNotFoundException ex) {
                Logger.getLogger(MusicPlayerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
}
