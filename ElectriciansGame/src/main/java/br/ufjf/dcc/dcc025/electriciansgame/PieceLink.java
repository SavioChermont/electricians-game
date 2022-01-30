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
 * Piece Link - 2 output (180°) and 2 solution
 * 
 * ---- TYPES OF DIRECTION ----
 * u - up (cima)
 * d - down (baixo)
 * l - left (esquerda)
 * r - right (right)
 * 
 * ---- POSITIONS ----
 * 1 - Up and Down, like : I
 * 2 - Left and Right, like : -
 * 
 */



public class PieceLink extends Piece {
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceLink(int position){
         setPosition(position);
         typeId = "link";
         
         Random random = new Random();
         id = random.nextInt(100);
    }
    
    /* ---------- Setters ------------- */
     
     @Override
     public void setPosition(int pos){
         if(pos < 1 || pos > 2){
            System.out.println("Can't init piece Link because invalid position was given.");
            return;
        }
         
        if(pos != position){
            position = pos;
            List<Character> currentOutputs = new ArrayList<>();
            // Piece Link have 2 positions
            switch (pos) {
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
            setCurrentOutputs(currentOutputs);
        }
         
     }
     
     
}
