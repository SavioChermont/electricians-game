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
 * POSITIONS (2)
 * 1 - Up and Down, like : -
 * 2 - Left and Right, like : I
 */

public class PieceC extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceC(int position){
         initPieceC(position);
    }
    
    /* ---------- Setters ------------- */

    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
     
    public void initPieceC(int position){
        if(position < 0 && position > 2){
            System.out.println("Can't init piece B because invalid position was given.");
            return;
        }
        
        setPieceCPosition(position);
    }
    
    public void setPieceCPosition(int position){
        List<Character> currentOutputs = new ArrayList<>();
         // Piece of type B have 4 positions
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
                 System.out.print("Invalid Position to Piece B.");
                 return;
             }
         }
        
        setPosition(position);
        setCurrentOutputs(currentOutputs);
    }
     
}
