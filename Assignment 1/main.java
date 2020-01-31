//Collaborated with: Kutay Kaygisiz


import java.io.*;
import java.util.*;


public class main {     

     
    public static void main(String[] args) {
    //TODO:build the hash table and insert keys using the insertKeyArray function.
    	
    	int[] listX = {86, 85, 6, 97, 19, 66, 26, 14, 15, 49, 75, 64, 35, 54, 31, 9, 82, 29, 81, 13};		//A=554
    	int[] listY = {52, 71, 34, 95, 68, 25, 44, 38, 47, 77, 92, 84, 94, 12, 61, 9, 89, 56, 28, 75};		//A=1018
    	
    	Chaining x_chain = new Chaining(10, 0, 551);
    	Chaining y_chain = new Chaining(10, 0, 1018);		
    	
    	int collision_x = x_chain.insertKeyArray(listX);
    	int collision_y = y_chain.insertKeyArray(listY);
    	
    	System.out.println("Collision in listX: " + collision_x );
    	System.out.println("Collision in listY: " + collision_y );
    	System.out.println("For chaining, Collision x is greater then collision y is an assumption that is " + (collision_x>collision_y));
    	
    	Open_Addressing x_Adress = new Open_Addressing(10, 0, 551);
    	Open_Addressing y_Adress = new Open_Addressing(10, 0, 1018);
    	
    	int x_OpenCollision = x_Adress.insertKeyArray(listX);
    	int y_OpenCollision = y_Adress.insertKeyArray(listY);
    	
    	System.out.println("Collision in listX for Open Adressing: " + x_OpenCollision );
    	System.out.println("Collision in listY for Open Adressing: " + y_OpenCollision );
    	System.out.println("For OpenAdressing, Collision x is greater then collision y is an assumption that is " + (x_OpenCollision>y_OpenCollision));

    }
}
