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
 * Piece Link - 2 output (180°) and 2 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 * 
 * ---- POSITIONS ----
 * 1 - Up and Down, like : -
 * 2 - Left and Right, like : I
 */

public class PieceLink extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceLink(int position){
         initPieceLink(position);
    }
    
    /* ---------- Setters ------------- */
     
     @Override
     public void setPosition(int position){
         if(position < 1 || position > 2){
            System.out.println("Can't init piece Link because invalid position was given.");
        }else this.position = position;
     }

    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
     
    public void initPieceLink(int position){
        List<Character> currentOutputs = new ArrayList<>();
         // Piece Link have 2 positions
         switch (position) {
             case 1 -> {
                 currentOutputs.add('u');
                 currentOutputs.add('d');
             }
             case 2 -> {
                 currentOutputs.add('l');
                 currentOutputs.add('r');
             }
             default -> {
                 System.out.print("Invalid Position to Piece Link.");
                 return;
             }
         }
        
        setPosition(position);
        setCurrentOutputs(currentOutputs);
    }
     
}
