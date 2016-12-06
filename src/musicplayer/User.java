package musicplayer;

import DAO.UserDAO;
import exceptions.UserNameWithSpaceException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import musicplayer.persistence.UsersPersistence;

/**
 * Classe abstrata que determina um usuário da aplicação.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
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
     * Obter nome do usuário.
     * @return Nome do usuário.
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Definir nome do usuário.
     * @param userName Novo nome do usuário.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Obter senha do usuário.
     * @return Senha do usuário.
     */
    public String getPwd() {
        return pwd;
    }
    
    /**
     * Definir senha do usuário.
     * @param pwd Nova senha do usuário.
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    /**
     * Obter id do usuário.
     * @return Id do usuário.
     */
    public long getId() {
        return id;
    }
    
    /**
     * Definir id do usuário.
     * @param id Novo id do usuário.
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
     * Armazenar usuário em um arquivo de texto (persistência do usuário).
     * @param file  Arquivo onde se deseja armazenar o usuário.
     */
    private void writeUserInFile(FileWriter file){
        PrintWriter printUsers = new PrintWriter(file);
        
        printUsers.printf(this.getUserName() + " " + this.getPwd());
        
        if(this instanceof UserVIP){
            printUsers.printf(" true%n");
        }else printUsers.printf(" false%n");
            
    }
    
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
