
import java.util.Scanner;
public class problemSolving {
    public static void main(String []arg){
       Scanner in = new Scanner(System.in); 
      int []arr=new int[in.nextInt()];
       int []ar= new int[arr.length];
       int sum =0;
       
        for (int i = 0; i < arr.length; i++) {
              arr[i]=in.nextInt();
              if(arr[i]>0){
              ar[i]=(int)Math.ceil(arr[i]/2.0);
              }else{
               ar[i]=(int)Math.floor(arr[i]/2.0);
              }
              sum+=ar[i];
         }
          
            int sum2 =0;
         if(sum != 0){
             for (int i = 0; i < ar.length; i++) {
                 
                  if(ar[i]<0){
                      ar[i]+=1;
                      sum+=1;
                     
                  }else{
                      ar[i]-=1;
                      sum-=1;
                     
                  }
                 
                   if(sum==0){
                       break;
                   }
                }
                }
         
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
