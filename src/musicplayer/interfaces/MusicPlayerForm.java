/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.interfaces;

import DAO.MusicDAO;
import DAO.PlaylistDAO;
import banco.BancoMusic;
import banco.BancoPlaylist;
import banco.TreeForSearch;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import musicplayer.Music;
import musicplayer.Playlist;
import musicplayer.User;
import musicplayer.UserCommom;
import musicplayer.persistence.MusicsPersistence;
import musicplayer.persistence.PlaylistPersistence;

/**
 *
 * @author Yuri Alessandro e Thiago Cesar
 */
public class MusicPlayerForm extends javax.swing.JFrame {

    private String path;
    private AdvancedPlayer play;
    private final DefaultListModel modelListMusics = new DefaultListModel();
    private final DefaultListModel modelListPlaylistMusics = new DefaultListModel();
    private final DefaultListModel modelPlaylists = new DefaultListModel();
    private User user;
    private PlayMusic playMusic;
    private Thread theadFromMusic;
    private boolean playFromPause;
    private boolean playlistMode;
    private ArrayList<String> searchList;
    private boolean wasOpened;
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private MusicDAO musicDAO = new MusicDAO();

    /**
     * Cria a nova janela principal do player.
     *
     * @param u Usuário que estará utilizando o player.
     * @throws java.io.IOException Falha na leitura de arquivos de persistência.
     */
    public MusicPlayerForm(User u) throws IOException {
        initComponents();
        this.searchList = new ArrayList<>();

        // Não permitir que a janela se redimensione.
        this.setResizable(false);

        // Usuário que está utilizando o player.
        this.user = u;

        // Verifica se é um usuário comum para desativar funções do VIP.
        if (u instanceof UserCommom) {
            this.btnVipPanel.setEnabled(false);
            this.btnNewPlaylist.setEnabled(false);
            this.txtPName.setEnabled(false);
        }

        // Define o nome do usuário na IU
        this.txtUserName.setText(u.getUserName());

        // Definindo o estado inicial de alguns componentes da IU
        this.playFromPause = false;
        this.playlistMode = false;
        this.btnPause.setEnabled(false);
        this.btnStop.setEnabled(false);
        this.playlistMusics.setEnabled(false);
        this.btnAddMusic.setEnabled(false);

        /*
        Testa se o player já estava aberto (Para o sistema de logoff)
        (Não funcionando muito bem)
         */
        if (!wasOpened) {
//            System.err.println("entrou");

            // Lendo a persistência das músicas
            MusicsPersistence.readMusics(u);

            // Populando a lista de músicas com o que foi lido do arquivo.
            for (Music m : BancoMusic.MUSICS) {
                if (!m.isFromPlaylist()) {
                    this.modelListMusics.addElement(m.getName());
                }
            }

            this.listOfMusics.setModel(this.modelListMusics);

            // Lendo a persistência das playlists
            PlaylistPersistence.readPlaylists();

            for (Playlist p : BancoPlaylist.PLAYLISTS) {
                this.modelPlaylists.addElement(p.getName());
            }

            this.listOfPlaylist.setModel(this.modelPlaylists);

            // Define o que deve acontecer quando o usuário clica no 'X' para
            // sair do programa.
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        // Salva as músicas e playlists na persistência.
                        MusicsPersistence.saveMusics(user);
                        PlaylistPersistence.savePlaylists();
                    } catch (IOException ex) {
                        Logger.getLogger(MusicPlayerForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }
            });
        }

    }

    private MusicPlayerForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        barTimeMusic = new javax.swing.JProgressBar();
        jSeparator3 = new javax.swing.JSeparator();
        btnStop = new javax.swing.JButton();
        txtUserName = new javax.swing.JLabel();
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
        txtNewPName = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        lblPlaylistOwner = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnChooseFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/plusx_12.png"))); // NOI18N
        btnChooseFile.setText("File");
        btnChooseFile.setMaximumSize(new java.awt.Dimension(97, 30));
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/play_32.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        jLabel2.setText("JYATH Music Player");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        btnVipPanel.setText("VIP Panel");
        btnVipPanel.setMaximumSize(new java.awt.Dimension(97, 30));
        btnVipPanel.setMinimumSize(new java.awt.Dimension(97, 30));
        btnVipPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVipPanelActionPerformed(evt);
            }
        });

        btnAddDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/plusx_12.png"))); // NOI18N
        btnAddDir.setText("Directory");
        btnAddDir.setMaximumSize(new java.awt.Dimension(97, 30));
        btnAddDir.setMinimumSize(new java.awt.Dimension(97, 30));
        btnAddDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDirActionPerformed(evt);
            }
        });

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/pause_22.png"))); // NOI18N
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/stop_32.png"))); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtUserName.setText("name");

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

        txtNewPName.setText("Playlist name...");
        txtNewPName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewPNameFocusGained(evt);
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
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblPlaylistOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlaylistOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddMusic))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewPlaylist)
                            .addComponent(btnSelect)))
                    .addComponent(jScrollPane1)))
        );

        searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBarFocusGained(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/search _12.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/interfaces/logout_22.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(barTimeMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddDir, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVipPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(searchBar)
                        .addGap(2, 2, 2)
                        .addComponent(txtUserName)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(10, 10, 10))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserName)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAddDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPause)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(barTimeMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        // Cria um novo seletor de arquivos
        JFileChooser jf = new JFileChooser();
        // Define um filtro para o seletor
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Songs", "mp3");
        jf.addChoosableFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);

        int choose = jf.showOpenDialog(this);
        Music temp = null;

        // Cria música selecionada no seletor
        if (choose == JFileChooser.APPROVE_OPTION) {
            temp = new Music(jf.getSelectedFile().getName(), jf.getSelectedFile().getPath(), false, false);
            musicDAO.insert(temp);
            TreeForSearch.insert(temp.getName());
        }

        // Atualiza a lista de músicas.
        this.modelListMusics.addElement(temp.getName());
        listOfMusics.setModel(this.modelListMusics);
    }//GEN-LAST:event_btnChooseFileActionPerformed

    /**
     * Determina a música selecionada a partir do seletor de arquivos.
     *
     * @return Música selecionada no seletor.
     */
    private Music selectAMusic() {
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Songs", "mp3");
        jf.addChoosableFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);
        int choose = jf.showOpenDialog(this);
        Music temp = new Music();
        musicDAO.insert(temp);

        if (choose == JFileChooser.APPROVE_OPTION) {
            temp.setName(jf.getSelectedFile().getName());
            temp.setPath(jf.getSelectedFile().getPath());
        }

        return temp;
    }

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // Verifica se existe uma música selecionada.
        if (this.listOfMusics.getSelectedIndex() != -1){
            // Verifica se não é um PLAY após um PAUSE
            if (!this.playFromPause) {
                String mName;

                /* 
                Verifica se a lista de músicas está ativada para pegar o nome da
                música a ser tocada. Se a lista de músicas está desativada, é porque
                o programa está rodando em modo de playlist. Então ele pega o nome
                a música na lista de músicas da playlist selecionada.
                 */
                if (this.listOfMusics.isEnabled()) {
                    mName = this.listOfMusics.getSelectedValue();
                } else {
                    mName = this.playlistMusics.getSelectedValue();
                }

                // Música que será tocada
                Music m = null;

                // Busca no banco o nome da música selecionada na lista.
                for (Music music : BancoMusic.MUSICS) {
                    // Se encontrar a música no banco, passa para m
                    if (mName.equals(music.getName())) {
                        m = music;
                    }
                }

                /*
                Se a música for encontrada, inicializa uma nova Thread para ela
                e dá play na música. */
                if (m != null) {
                    // Caminho para a música
                    this.path = m.getPath();
                    // Altera o nome da música sendo tocada atualmente
                    this.lblNameMusic.setText("Now playing " + m.getName());

                    // Dá play na música, iniciando a thread.
                    this.playMusic = new PlayMusic(this.play, this.path);
                    this.theadFromMusic = new Thread(this.playMusic);
                    this.theadFromMusic.start();
                }
                // Caso seja um play após um pause, apenas retoma a thread.
            } else {
                this.theadFromMusic.resume();
            }

            btnPlay.setEnabled(false);
            this.btnPause.setEnabled(true);
            this.btnStop.setEnabled(true);
            this.listOfMusics.setEnabled(false);
            this.playlistMusics.setEnabled(false);
        }

    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnVipPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVipPanelActionPerformed
        new VipPanel().setVisible(true);
    }//GEN-LAST:event_btnVipPanelActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // Para a thead. Primeiramente, muda o estado de alguns componentes.
        this.theadFromMusic.stop();
        this.btnPlay.setEnabled(true);
        this.btnPause.setEnabled(true);
        this.playFromPause = false;
        this.lblNameMusic.setText("");
        
        // Veifica qual o modo (música solo ou playlist) para reativar o componente certo.
        if (!this.playlistMode) {
            this.listOfMusics.setEnabled(true);
        } else {
            this.playlistMusics.setEnabled(true);
        }

    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // Suspende a thread, e ativa alguns componentes.
        this.theadFromMusic.suspend();
        this.btnPlay.setEnabled(true);
        this.btnPause.setEnabled(false);
        // Determina que foi um pause.
        this.playFromPause = true;
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnAddDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDirActionPerformed
        // Cria um novo seletor de arquivos (apenas diretórios).
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setAcceptAllFileFilterUsed(true);
        jf.setMultiSelectionEnabled(false);

        int w = jf.showOpenDialog(this);
        // Pega o diretório selecionado e salva em 'f'
        File f = jf.getSelectedFile();
        String dirPath = f.getName();
        
        // Todos arquivos em f no array de File.
        File[] listOfFiles = f.listFiles();
        Music m;
        
        // Para cada arquivo em 'listOfFiles', ele cria a nova música.
        for (int i = 0; i < listOfFiles.length; i++) {
            File e = listOfFiles[i];
            // Verifica se o arquivo dentro da pasta é mp3
            if (e.isFile() && e.getName().contains(".mp3")) {
                m = new Music(e.getName(), e.getAbsolutePath(), false, false);
                musicDAO.insert(m);
                TreeForSearch.insert(m.getName());
                this.modelListMusics.addElement(listOfFiles[i].getName());
            }
        }
        
        // Atualiza a lista de músicas na IU
        this.listOfMusics.setModel(this.modelListMusics);
    }//GEN-LAST:event_btnAddDirActionPerformed

    private void btnNewPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPlaylistActionPerformed
        // Adiciona uma nova playlist.
        
        // Verifica se o nome na caixa de texto é vazio
        if (this.txtNewPName.getText().isEmpty()) {
            this.txtNewPName.setText("Put a name...");
        } else {
//            UserVIP vip = (UserVIP) this.user;
            Playlist temp = new Playlist(this.txtNewPName.getText(), this.user, false);
            musicDAO.insert(temp);
            this.txtNewPName.setText("");
            this.updateListOfPlaylist();
        }
    }//GEN-LAST:event_btnNewPlaylistActionPerformed

    private void updateListOfPlaylist() {
        // Atualiza a lista de playlist.
//        UserVIP temp = (UserVIP) this.user;
        DefaultListModel p1 = new DefaultListModel();

        for (Playlist p : BancoPlaylist.PLAYLISTS) {
            p1.addElement(p.getName());
        }

        this.listOfPlaylist.setModel(p1);
    }
    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // Seleciona uma playlist da lista.
//        if(this.playlistMusics.getModel().getSize() != 0){
        
        // Se não estiver em modo de playlist
        if (!this.playlistMode) {
            // Passa a ficar em modo de playlist
            this.playlistMode = true;
            this.listOfPlaylist.setEnabled(false);
            this.listOfMusics.setEnabled(false);
            this.playlistMusics.clearSelection();
            this.playlistMusics.setEnabled(true);

            String selected = this.listOfPlaylist.getSelectedValue();
            DefaultListModel model = new DefaultListModel();
            
            // Exibe todas as músicas da playlist na lista.
            for (Playlist p : BancoPlaylist.PLAYLISTS) {
                if (p.getName().equals(selected)) {
                    this.txtPName.setText(p.getName());
                    for (Music m : p.getMusics()) {
                        model.addElement(m.getName());
                    }
                    this.lblPlaylistOwner.setText(p.getOwner().getUserName() + "'s playlist");
                    if (this.user.getUserName().equals(p.getOwner().getUserName())) {
                        this.btnAddMusic.setEnabled(true);
                    }
                }
            }
            // Atualiza a lista de músicas da playlista na IU
            this.playlistMusics.setModel(model);
            
            // Atualiza o botão para "Deselect"
            this.btnSelect.setText("Deselect");
        } else {
            /*
            Se não for, apenas volta o modo e reativa os componentes 
            para o estado inicial.
            */
            this.playlistMode = false;
            this.modelListPlaylistMusics.clear();
            this.playlistMusics.setEnabled(false);
            this.listOfMusics.setEnabled(true);
            this.listOfPlaylist.setEnabled(true);
            this.btnAddMusic.setEnabled(false);
            this.btnSelect.setText("Select");
//            }
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnAddMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMusicActionPerformed
        String selected = this.listOfPlaylist.getSelectedValue();

        for (Playlist p : BancoPlaylist.PLAYLISTS) {
            if (p.getName().equals(selected)) {
                Music temp = this.selectAMusic();
                p.addMusic(temp);
                this.modelListPlaylistMusics.addElement(temp.getName());
            }
        }

        this.playlistMusics.setModel(this.modelListPlaylistMusics);
    }//GEN-LAST:event_btnAddMusicActionPerformed

    private void searchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusGained
//        String actualSearch = "";
//        this.searchBar.setText("");
        customKeyListener k1 = new customKeyListener();
        this.searchBar.addKeyListener(k1);
    }//GEN-LAST:event_searchBarFocusGained

    private void txtNewPNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPNameFocusGained
        this.txtNewPName.setText("");
    }//GEN-LAST:event_txtNewPNameFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.wasOpened = true;
        try {
            new LoginForm().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JProgressBar barTimeMusic;
    private javax.swing.JButton btnAddDir;
    private javax.swing.JButton btnAddMusic;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnNewPlaylist;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnVipPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel lblNameMusic;
    private javax.swing.JLabel lblPlaylistOwner;
    private javax.swing.JList<String> listOfMusics;
    private javax.swing.JList<String> listOfPlaylist;
    private javax.swing.JList<String> playlistMusics;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTextField txtNewPName;
    private javax.swing.JLabel txtPName;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    /**
     * Classe auxiliar da thread para tocar a música.
     */
    public class PlayMusic implements Runnable {

        private AdvancedPlayer play;
        String path;
        
        /**
         * Construtor da classe
         * @param play Player que irá rodar a música
         * @param path Caminho para a música
         */
        public PlayMusic(AdvancedPlayer play, String path) {
            this.path = path;
            this.play = play;
        }

        @Override
        /**
         * Roda a thread que irá tocar a música.
         */
        public void run() {
            // Tenta abrir o arquivo mp3 da música.
            try {
                /*
                Cria um novo arquivo (que a JLayer aceita para rodar) a partir
                do diretório da música
                */
                FileInputStream fis = new FileInputStream(path);
                // Inicializa o player
                play = new AdvancedPlayer(fis);
//                moveProgressBar();
                /*
                Toca a música 
                    Nota: a thread fica parada até ela acabar)
                */
                play.play();

            } catch (JavaLayerException | FileNotFoundException ex) {
                Logger.getLogger(MusicPlayerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

//    private void makePersistenceOnClose() throws IOException {
//        MusicsPersistence.saveMusics(this.user);
//    }
    
    /**
     * Evento para tratar a busca auto-completável.
     */
    private class customKeyListener implements KeyListener {

        private String search = "";

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            // Verifica a tecla pressionada
            int a = ke.getKeyCode();
            // Verifica as teclas que devem ser analisadas pela busca
            ArrayList<Integer> keys = new ArrayList<>();
            keys.add(KeyEvent.VK_SPACE);
            keys.add(KeyEvent.VK_BACK_SPACE);
            keys.add(KeyEvent.VK_MINUS);
//                keys.add(KeyEvent.VK_);
            
            // Se for um das teclas permitidas
            if ((a > 47 && a < 59) || (a > 64 && a < 91) || keys.contains(a)) {
                DefaultListModel m = new DefaultListModel();
                // Se for a tecla backspace
                if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (search.length() != 0) {
                        this.search = search.substring(0, search.length() - 1);
                        if (search.length() == 0) {
                            searchList = null;
                            listOfMusics.setModel(modelListMusics);
                        }
                    }
                } else {
                    searchList = null;
                    this.search += ke.getKeyChar();
                    searchList = TreeForSearch.search(search);
                }

                searchList = TreeForSearch.search(search);

                if (searchList != null) {
                    for (String s : searchList) {
                        m.addElement(s);
                    }

                    listOfMusics.setModel(m);
                } else {
                    if (search.length() != 0) {
                        m.addElement("No results found...");
                        listOfMusics.setModel(m);
                    }
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }

        public String getSearch() {
            return search;
        }
    }
}
