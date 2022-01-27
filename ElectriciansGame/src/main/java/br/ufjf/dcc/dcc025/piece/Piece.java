/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.piece;

/**
 *
 * @author savio
 *  ---- TYPES OF PIECE ----
 * Piece Cross - 4 output and 1 solution
 * Piece Knee - 2 output (90°) and 4 solution
 * Piece Link - 2 output (180°) and 2 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 */

import java.util.List;
import java.util.ArrayList;

public abstract class Piece {
    
    /* ---------- Attr --------------*/
    private List<Character> currentOutputs = new ArrayList<>();
    public int position = 0;
    
     /* --------- Constructor --------- 
    
    /* ---------- Setters ------------- */   
    protected void setCurrentOutputs(List<Character> newCurrentOutputs){
           this.currentOutputs = newCurrentOutputs;
    }
    
    public abstract void setPosition(int position);
    
    /*protected void setPosition(int newPosition){
        if(newPosition > 0 && newPosition < 5) this.position = newPosition;
    }*/

    /* ----------- Getters ------------- */
    
     public List<Character> getCurrentOutputs(){
        return this.currentOutputs;
    }
     
     public int getPosition(){
        return this.position;
    }
    
    
    /* ----------- Others Methods ---------- */
     
     public boolean areConnected(Piece otherPiece){
         /* -- FALTA VERIFICAR SE AS PEÇAS ESTÃO PRÓXIMAS, PRECISA DA IMPLEMENTAÇÃO DA "TABULEIRO" PARA ISSO -- */
         
         // Check if two pieces have same output
         
         boolean conected = false;
         
         for(char direction : otherPiece.currentOutputs){
             if(this.currentOutputs.contains(direction)) conected = true;
         }
         
         return conected;
     }

}
