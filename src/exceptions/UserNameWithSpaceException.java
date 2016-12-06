/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;


/**
 *
 * @author thiag
 */
public class UserNameWithSpaceException extends Exception{
    public UserNameWithSpaceException(String msg){
        super(msg);
    }
    
}
