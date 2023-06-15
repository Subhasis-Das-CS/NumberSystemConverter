import java.util.*;
class Converter{
   int b,k;
   int n;
   String nn;
   long bn;

   Converter(String n, int b, int k){
      
      if(b==2 && k==16) bn=Long.parseLong(n);
      else if(b!=16)this.n=Integer.parseInt(n);
      
      this.b=b;
      this.k=k;
      nn=n;
   }

   String decToAny(){
      String s="";
      while(n!=0){
      
         int r=n%k;
         char ch=(char)(48+r);
         if((48+r)>=48 && (48+r)<=57){
            s+=ch;
         }else{
           
            switch(48+r){
               case 58: s+='A';
                  break;
               case 59: s+='B';
                  break;
               case 60: s+='C';
                  break;
               case 61: s+='D';
                  break;
               case 62: s+='E';
                  break;
               case 63: s+='F';
                  break;
            }
         }
         n/=k;
      
      }
      String sr="";
      for(int i=s.length()-1; i>=0;i--){
         sr+=s.charAt(i);
      }
   
      return sr;
   
   }
   
   int anyToDec(){
   
      int p=0;
      int s=0;
      int l=nn.length();
      int v=0;
      for(int i=l-1; i>=0; i--){
      
         if(Character.isDigit(nn.charAt(i))){
            int cha=(int)nn.charAt(i);
         
            s+= (cha-48)*Math.pow(b,p);
         }else{
            switch(nn.charAt(i)){
               case 'A': v=10;
                  break;
               case 'B': v=11;
                  break;
               case 'C': v=12;
                  break;
               case 'D': v=13;
                  break;
               case 'E': v=14;
                  break;
               case 'F': v=15;
                  break;
            
            }
           
            s+= v*Math.pow(b,p);
         
         }
         n/=10;
         p++;
        
      }
   
      return s;
   }
   
   String octToBin(){
      String bin[]={"000","001","010","011","100","101","110","111"};
      char oct[]={'0','1','2','3','4','5','6','7'};
   
      String s="";
      String number=Integer.toString(n);
   
      for(int i=0; i<number.length();i++){
      
         char ch=number.charAt(i);
       
      
         for(int j=0; j<oct.length;j++){
            if(oct[j]==ch){
            
               s+=bin[j];
             
            }
         }
      
      }
   
      return s;
   
   
   }
   
   String hexToBin(){
      String bin[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001", "1010", "1011", "1100", "1101", "1110","1111"};
      char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
   
      String s="";
      String number=nn;
   
      for(int i=0; i<number.length();i++){
      
         char ch=number.charAt(i);
       
      
         for(int j=0; j<hex.length;j++){
            if(hex[j]==ch){
            
               s+=bin[j];
             
            }
         }
      
      }
   
      return s;
   
   
   }
   
   String binToOct(){
      String bin[]={"000","001","010","011","100","101","110","111"};
      char oct[]={'0','1','2','3','4','5','6','7'};
   
      String nstring=Integer.toString(n);
      int l=nstring.length();
   
      String bstring="";
   
      if(l%3==0){
         bstring=nstring;
      }else if(l%3==1){
         bstring="00"+nstring;
      
      }else if(l%3==2){
         bstring="0"+nstring;
      }
      String os="";
      for(int i=bstring.length(); i>=3; i-=3){
         String part=bstring.substring((i-3), i);
         for(int j=0; j<bin.length;j++){
            if(bin[j].equals(part)){
               os=oct[j]+os;
            }
         }
      
      }
   
      return os;
   }

   String binToHex(){
      String bin[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001", "1010", "1011", "1100", "1101", "1110","1111"};
      char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
      String nstring=Long.toString(bn);
      int l=nstring.length();
   
      String bstring="";
   
      if(l%4==0){
         bstring=nstring;
      }else if(l%4==1){
         bstring="000"+nstring;
      
      }else if(l%4==2){
         bstring="00"+nstring;
      }else if(l%4==3){
         bstring="0"+nstring;
      }
      String os="";
      for(int i=bstring.length(); i>=4; i-=4){
         String part=bstring.substring((i-4), i);
         for(int j=0; j<bin.length;j++){
            if(bin[j].equals(part)){
               os=hex[j]+os;
            }
         }
      
      }
   
      return os;
   }



   public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the number");
      String n=sc.nextLine();
      System.out.println("Enter the base");
      int b=sc.nextInt();
      System.out.println("Enter the destination number");
      int k=sc.nextInt();
   
      Converter obj=new Converter(n,b,k);
      
      if(b==10)System.out.println(obj.decToAny());
      
      if(k==10)System.out.println(obj.anyToDec());
      if(b==8 && k==2)System.out.println(obj.octToBin());
      if(b==16 && k==2)System.out.println(obj.hexToBin());
      if(b==2 && k==8)System.out.println(obj.binToOct());
      if(b==2 && k==16)System.out.println(obj.binToHex());
   
   
   
   }

}
