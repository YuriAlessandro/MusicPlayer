package musicplayer;

import DAO.UserDAO;
import banco.BancoUser;
import exceptions.UserNameWithSpaceException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import musicplayer.persistence.UsersPersistence;

/**
 * Classe que determina um usuário da aplicação.
 * @author Yuri Alessandro Martins
 * @author Thiago
 */
public abstract class User {
    private String userName;
    private String pwd;
    private long id;
    private boolean isSave;
    private UserDAO userDAO = new UserDAO();
    
    /**
     * Construtor da classe
     * @param userName Nome do usuário
     * @param pwd Senha do usuário
     * @param isSave True, se está salvo na persistência
     * @throws IOException Erro na leitura/escrita de arquivos
     * @throws exceptions.UserNameWithSpaceException
     */
    public User(String userName, String pwd, boolean isSave) throws IOException, UserNameWithSpaceException{
        if(userName.contains(" ")){
            System.out.println("ENTROU");
            throw new UserNameWithSpaceException("User name cannot have spaces on its name!");

        }
        this.userName = userName;
        this.pwd = pwd;
        this.isSave = isSave;
        this.generateId();
        this.addOnDataBase();
        if(!isSave) this.addOnPersistence();
    }
    
    /**
     * 
     * @return 
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * 
     * @return 
     */
    public String getPwd() {
        return pwd;
    }
    
    /**
     * 
     * @param pwd 
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    /**
     * 
     * @return 
     */
    public long getId() {
        return id;
    }
    
    /**
     * 
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Gera um ID único para o usuário
     */
    private void generateId(){
        UUID uid = UUID.randomUUID();
        this.id = Math.abs(uid.getLeastSignificantBits());
    }
    
    /**
     * 
     * @param file  
     */
    private void writeUserInFile(FileWriter file){
        PrintWriter printUsers = new PrintWriter(file);
        
        printUsers.printf(this.getUserName() + " " + this.getPwd());
        
        if(this instanceof UserVIP){
            printUsers.printf(" true%n");
        }else printUsers.printf(" false%n");
            
    }
    
    // Retirar daqui pelo amor de Deus.
    /**
     * Adiciona um Usuário no Banco
     */
    private void addOnDataBase(){
        userDAO.insert(this);
    }
    
    /**
     * Adiciona usuário na persistência de dados.
     * @throws IOException Erro na leitura/escrita de arquivos. 
     */
    private void addOnPersistence() throws IOException {
        UsersPersistence.saveUser(this);
    }
}
