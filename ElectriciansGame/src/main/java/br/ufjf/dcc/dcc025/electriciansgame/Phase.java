/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

/**
 *
 * @author savio
 */
import java.util.Random;
public class Phase {
     public static final int tableSize = 10;
     private int exitPosition;
     private int initPosition;
     // --------- Constructor ---------
     public Phase() {
       Random rand = new Random();
       exitPosition = rand.nextInt(10);
       initPosition = rand.nextInt(10);
       createGame();
     }
     // --------- Getters ---------
     public int getExitPosition(){
       return exitPosition;
     }
     public int getInitPosition(){
       return initPosition;
     }
     // --------- Setters ---------
     public boolean setExitPosition(int position){
       if(position >= 0 && position < tableSize)
         exitPosition = position;
       else
         return false;
       return true;
     }
     public boolean setInitPosition(int position){
       if(position >= 0 && position < tableSize)
         initPosition = position;
       else
         return false;
       return true;
     }
     /* ----------- Others Methods ---------- */
     private void createGame(){
       //MÉTODO PARA CRIAR O CAMINHO E SORTEAR AS PEÇAS
     }
}
