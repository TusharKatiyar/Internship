public class sample{
    public static void main(String[] args){
        
        double pi=0;
        for(int i=1;i<=200000;i++){
            pi=pi+Math.pow(-1,i-1)*4/(2*i-1);

            if(pi==3.14159){
                System.out.println(i);
                break;
            }
        }
        //System.out.println(pi);
    }
}