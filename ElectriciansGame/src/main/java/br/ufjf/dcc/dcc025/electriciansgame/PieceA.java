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
 * POSITIONS
 * 1 - Only one position, like a plus sign : + 
 */

public class PieceA extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceA(int position){
         initPieceA(position);
    }
    
    /* ---------- Setters ------------- */

    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
     
    public void initPieceA(int position){
        if(position != 1){
            System.out.println("Can't init piece A because invalid position was given.");
            return;
        }
        
        setPieceAPosition(position);
        
        // add all directions (left,right,down,up) to output
        List<Character> currentOutputs = new ArrayList<>();
        currentOutputs.add('u');
        currentOutputs.add('d');
        currentOutputs.add('r');
        currentOutputs.add('l');
        setCurrentOutputs(currentOutputs);
    }
    
    public void setPieceAPosition(int position){
        // Piece of type A only have 1 position
        if(position != 1) { 
            System.out.print("Invalid Position to Piece A.");
            return;
        }
        
        setPosition(position);
    }
     
}
