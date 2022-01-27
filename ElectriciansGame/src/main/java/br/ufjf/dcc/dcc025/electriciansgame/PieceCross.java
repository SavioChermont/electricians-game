/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.List;
import java.util.ArrayList;
import br.ufjf.dcc.dcc025.piece.Piece;

/**
 *
 * @author savio
 * 
 * Piece Cross - 4 output and 1 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 * 
 * POSITIONS
 * 1 - Only one position, like a plus sign : + 
 * 
 */

public class PieceCross extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceCross(int position){
         initPieceCross(position);
    }
    
    /* ---------- Setters ------------- */
     
      @Override
     public void setPosition(int position){
         if(position != 1){
            System.out.println("Can't init piece Cross because invalid position was given.");
        }else this.position = position;
     }
     
    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
     
    public void initPieceCross(int position){
        // add all directions (left,right,down,up) to output
        List<Character> currentOutputs = new ArrayList<>();
        currentOutputs.add('u');
        currentOutputs.add('d');
        currentOutputs.add('r');
        currentOutputs.add('l');
        setCurrentOutputs(currentOutputs);
        setPosition(position);
    }
     
}
