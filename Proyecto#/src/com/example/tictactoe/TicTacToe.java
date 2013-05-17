package com.example.tictactoe;

import java.util.Arrays;  
import android.app.Activity;  
import android.os.Bundle;  
import android.view.Menu;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.ImageButton;  
import android.widget.TextView;  
  
public class TicTacToe extends Activity {  
 int contador;  
 int[][] gana={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};  
 
 int[] arrx = new int[5];  
 int contarx;  
 
 int[] arro = new int[5];  
 int contaro;
   
   
    @Override  
    public void onCreate(Bundle savedInstanceState)
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_tic_tac_toe);  
        inicializar();            
    }  
  
    public void inicializar()
    {  
	     contador=0;  
	     contarx=0;  
	     contaro=0;  
	     Arrays.fill(arrx,0);   
	     Arrays.fill(arro,0);  
	     
	    ImageButton x = (ImageButton) this.findViewById(R.id.btn1);  
	     x.setOnClickListener(listener);  	     
	     x = (ImageButton) this.findViewById(R.id.btn2);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn3);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn4);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn5);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn6);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn7);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn8);  
	     x.setOnClickListener(listener);  
	     x = (ImageButton) this.findViewById(R.id.btn9);  
	     x.setOnClickListener(listener);  
    }  
      
    public void stop()
    {  
	     ImageButton x = (ImageButton) this.findViewById(R.id.btn1);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn2);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn3);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn4);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn5);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn6);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn7);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn8);  
	     x.setClickable(false);  
	     x = (ImageButton) this.findViewById(R.id.btn9);  
	     x.setClickable(false);  
    }  
  
    private OnClickListener listener = new OnClickListener() {  
       
        public void onClick(View v) {  
         ImageButton b= (ImageButton) v;  
         TextView tv =(TextView)findViewById(R.id.indicador_turnos);  
         if(contador==9)
         {
        	 b.setBackgroundResource(R.drawable.x);  
	          arrx[contarx+1]=Integer.parseInt((String)b.getTag());  
	          b.setClickable(false);
        	 tv.setText("Empataron ;)");
         }
         if(contador%2==0 )
         {  
        	 if(contador!=8){
	          b.setBackgroundResource(R.drawable.x);  
	          arrx[contarx]=Integer.parseInt((String)b.getTag());  
	          b.setClickable(false);  
	          tv.setText("Turno del Jugador 2");  
	          contador++;  
	          contarx++;  
	          
		          if(contarx>=3)
		          {  
			          for(int i=0;i<8;i++)
			          {  
					          if(Arrays.toString(arrx).contains(String.valueOf(gana[i][0]))&&
					        	 Arrays.toString(arrx).contains(String.valueOf(gana[i][1]))&&
					        	 Arrays.toString(arrx).contains(String.valueOf(gana[i][2])))  
					            {  
					             stop();  
					             tv.setText("El jugador 1 ganó!!!");  
					            } 
			          }  
		          } 
        	 }else{
        		 tv.setText("Empataron!!!"); 
        	 }
         }  
         else         	 
         {  
        	 
	          b.setBackgroundResource(R.drawable.o);  
	          arro[contaro]=Integer.parseInt((String)b.getTag());  
	          b.setClickable(false);  
	          tv.setText("Turno del jugador 1");  
	          contador++;  
	          contaro++;  
	          if(contaro>=3)
	          {  
	              for(int i=0;i<8;i++)
	              {  
		              if(Arrays.toString(arro).contains(String.valueOf(gana[i][0]))&&
		            	 Arrays.toString(arro).contains(String.valueOf(gana[i][1]))&&
		            	 Arrays.toString(arro).contains(String.valueOf(gana[i][2])))  
		                {  
		                 stop();  
		                 tv.setText("El jugador 2 ganó!!!");  
		                } 
		              
		              
	              }  
	          }
          
                
                   
         } 
                  
         
        }  
    };  
  
    public void salir(View v){  
     finish();  
    }  
    
    public void reanudar(View v){  
     setContentView(R.layout.activity_tic_tac_toe);  
        inicializar();  
    }   
    
    public boolean onCreateOptionsMenu(Menu menu) {  
  
        return true;  
    }  
}  