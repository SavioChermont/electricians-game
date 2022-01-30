/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author savio
 * 


/**
 *
 * @author savio
 * 
 * Piece Knee - 2 output (90°) and 4 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 * 
 * ---- POSITIONS (4) ----
 * 1 - Up and Left, like : ⅃ 
 * 2 - Up and Right, like : L
 * 3 - Down and Left, like : ⅂
 * 4 - Down and Right, like ℾ
 */

public class PieceKnee extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceKnee(int position){
         setPosition(position);
         typeId = "knee";
         
         Random random = new Random();
         id = random.nextInt(100);
    }
    
    /* ---------- Setters ------------- */
     
     @Override
     public void setPosition(int pos){
         if(pos < 1 || pos > 4){
            System.out.println("Can't init piece Knee because invalid position was given.");
            return;
        }
         
         if(position != pos){
            this.position = pos;
            
            List<Character> currentOutputs = new ArrayList<>();
            // Piece of type B have 4 positions
            switch (pos) {
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
            setCurrentOutputs(currentOutputs);
         }
        
     }
  
     
}
