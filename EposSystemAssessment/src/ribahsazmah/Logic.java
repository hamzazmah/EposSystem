/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ribahsazmah;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Hamza
 */
public class Logic 
{
    Sales_Data_Handler mySalesDataHandler = new Sales_Data_Handler();
    //KeyListner for Price text fields
    public void txtFieldPriceKeyListners(ArrayList<JTextField> textFieldsPrice)
    {
        textFieldsPrice.forEach((var i) ->
        {
            i.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                char c = e.getKeyChar();
                if((Character.isDigit(c))||(c==KeyEvent.VK_PERIOD)||(c==KeyEvent.VK_BACK_SPACE))
                {
                    if(c==KeyEvent.VK_PERIOD)
                    {
                        String str = i.getText();
                        int dot = str.indexOf('.');
                        if(dot != -1)
                        {
                            e.consume();
                        }
                    }
                }
                else
                {
                    e.consume();
                }
            }
                @Override
                public void keyPressed(KeyEvent e) {     
                }
                @Override
                public void keyReleased(KeyEvent e) {     
                }
        }); 
            });
    }
    
    
    //key listner for number textfields
    public void txtFieldNumberKeyListners(ArrayList<JTextField> textFieldsNumber)
    {
        textFieldsNumber.forEach((var i) ->
        {    
            i.addKeyListener(new KeyListener() 
            {
                @Override
                public void keyTyped(KeyEvent e) 
                {
                    char c = e.getKeyChar();
                    if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE )
                    {
                        e.consume();
                    }
                }
                @Override
                public void keyPressed(KeyEvent e) {     
                }
                @Override
                public void keyReleased(KeyEvent e) {     
                }
            }); 
        });
    }
        
    
}
