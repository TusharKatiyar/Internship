public class pattern{
    public static void main(String[] args){
        // for(int i=1;i<=10;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }



        // for(int i=1;i<=10;i++){
        //     for(int j=10;j>=i;j--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }



    //     for(int i=1;i<=10;i++){
    //         for(int j=1;j<i;j++){
    //             System.out.print(" ");
    //         }
    //         for(int k=10;k>=i;k--){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }



        // for(int i=1;i<=10;i++){
        //     for(int j=10;j>=i;j--){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=i;j++){
        //         System.out.print("*");
        //     }        
        //     System.out.println();
        // }


        for(int i=1;i<=10;i++){
                for(int j=10;j>=i;j--){
                    System.out.print("*");
                }
                for(int j=2*1;j<2*i;j++){
                    System.out.print(" ");
                }
                for(int k=10;k>=i;k--){
                    System.out.print("*");
                }
                System.out.println();
            }

        for(int i=1;i<=10;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=2*10;j>=2*i+1;j--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }        
            System.out.println();
        }
    }

}