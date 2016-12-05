/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.sun.xml.internal.ws.api.message.Message;


/**
 *
 * @author thiag
 */
public class UserNameWithSpaceException extends Exception{
    public UserNameWithSpaceException(String msg){
        super(msg);
    }
    
}
