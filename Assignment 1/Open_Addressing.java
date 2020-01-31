//Collaborated with: Kutay Kaygisiz

import java.io.*;
import java.util.*;

public class Open_Addressing {
     public int m; // number of SLOTS AVAILABLE
     public int A; // the default random number
     int w;
     int r;
     public int[] Table;

     protected Open_Addressing(int w, int seed, int A) {

         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
         }
        else{
            this.A = A;
        }
         this.Table = new int[m];
         for (int i =0; i<m; i++) {
             Table[i] = -1;
         }
         
     }
     
                 /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }
        /**Implements the hash function g(k)*/
        public int probe(int key, int i) {
            
    
        
        int h1 = ((A*key)%power2(w)) >> (w-r);			//h1(k)
        int h2 = 2*(Table.length) + 1;
        int hashValue = (h1 + i*h2)%Table.length;
        
        return hashValue;
     }
     
     
     /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int insertKey(int key){
        	if(this.m==0)						//checks if there are available slots
        	{
        		System.out.println("Table have reached its capacity. Please remove some keys or create a new table");
        		return 0;
        	}
        	
        	
        	int collision = 0;
        	int i = 0;
            int index = probe(key, i);
            while(Table[index] != -1)			//iterate over a probe till finding an empty spot
            {
            	i++;
            	index = probe(key, i);
            	collision++;
            	
            }
            Table[index] = key;
            this.m--;
           
            return collision;
        }
        
        /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
        public int insertKeyArray (int[] keyArray){
            //TODO
            int collision = 0;
            for (int key: keyArray) {
                collision += insertKey(key);
            }
            return collision;
        }
            
         /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int removeKey(int key){
            //TODO: implement this and change the return statement
        	
        	if(this.m == Table.length)
        	{
        		System.out.println("Table is empty.");
        		return 0;
        	}
        	
        	double loadFactor = (double) (Table.length - m) / (double) Table.length;			//Table.length - m = n(num of keys)
        	int collision = 0;														
        	int i = 0;
        	double maxCollision = 1/(1-loadFactor);
        	int index = probe(key, i);
        	while(Table[index] != key)
        	{
        		i++;
        		index = probe(key, i);
        		collision++;
        		if(collision >= maxCollision)			//Open-probing visits at most 1/(1-loadFactor) in a unsuccessful search by theorem.
        		{
        			System.out.print("key not found");
        			return collision;
        			
        		}
        	}
                
            Table[index] = -1;
            this.m++;
            return collision;
        }
        
       
}