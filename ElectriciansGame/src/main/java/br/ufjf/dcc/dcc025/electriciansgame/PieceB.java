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
 * POSITIONS (4)
 * 1 - Up and Left, like : L
 * 2 - Up and Right, like : ⅃
 * 3 - Down and Left, like : ℾ 
 * 4 - Down and Right, like ⅂
 */

public class PieceB extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceB(int position){
         initPieceB(position);
    }
    
    /* ---------- Setters ------------- */

    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
     
    public void initPieceB(int position){
        if(position < 0 && position > 4){
            System.out.println("Can't init piece B because invalid position was given.");
            return;
        }
        
        setPieceBPosition(position);
    }
    
    public void setPieceBPosition(int position){
        List<Character> currentOutputs = new ArrayList<>();
        
        // Piece of type B have 4 positions
        switch (position) {
             case 1 -> {
                currentOutputs.add('u');
                currentOutputs.add('l');
             }
             case 2 -> {
                currentOutputs.add('u');
                currentOutputs.add('r');
             }
             case 3 -> {
                 currentOutputs.add('d');
                 currentOutputs.add('l');
             }
             case 4 -> {
                currentOutputs.add('d');
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
