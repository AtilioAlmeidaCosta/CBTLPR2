/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author João Victor Crivoi Cesar Souza
 *         Atilio Almeida Costa
 */
import java.awt.event.*;

class FechaJanela extends WindowAdapter
{
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}