/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.IOException;

/**
 *
 * @author yurialessandro
 */
public class UserCommom extends User{

    public UserCommom(String userName, String pwd, boolean isSave) throws IOException {
        super(userName, pwd, isSave);
    }

}
