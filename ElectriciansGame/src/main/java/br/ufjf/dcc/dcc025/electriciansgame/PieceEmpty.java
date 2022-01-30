/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;


/**
 *
 * @author savio
 */
public class PieceEmpty extends Piece{
    /* ---------- Attr --------------*/
    
     /* --------- Constructor --------- */
     public PieceEmpty(int position){
         setPosition(position);
         typeId = "empty";
    }
    
    /* ---------- Setters ------------- */
     
     @Override
     public void setPosition(int position){
         this.position = position;
     }

    /* ----------- Getters ------------- */
    
    /* ----------- Others Methods ---------- */
    
}
