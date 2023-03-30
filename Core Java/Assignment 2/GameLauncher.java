class GuessGame{
    Player p1=new Player();
    Player p2=new Player();
    Player p3=new Player();

    public void startGame(){
        
        System.out.println("I am thinking of a number between 0 and 9");
        
        int target=(int)(Math.random()*10);
        System.out.println("Number to guess "+target);

        boolean p1_right=false;
        boolean p2_right=false;
        boolean p3_right=false;        

        while(true){

            p1.guess();
            p2.guess();
            p3.guess();

            System.out.println("Player 1 guessed: "+p1.number);
            System.out.println("Player 2 guessed: "+p2.number);
            System.out.println("Player 3 guessed: "+p3.number);
            
            if(target==p1.number){
                p1_right=true;
            }
            
            if(target==p2.number){
                p2_right=true;
            }
            
            if(target==p3.number){
                p3_right=true;
            }

            if(p1_right||p2_right||p3_right){
                System.out.println("\nWe have winner!!");
                System.out.println("Player 1 guessed it right?: "+p1_right);
                System.out.println("Player 2 guessed it right?: "+p2_right);
                System.out.println("Player 3 guessed it right?: "+p3_right);
                System.out.println("Game over.");
                break;
            }
            
            else
            System.out.println("Players have to guess again\n");
        }
    }
}

class Player{
    int number;
    void guess(){
        number=(int)(Math.random()*10);
    }
}

public class GameLauncher{
    public static void main(String[] args){
        GuessGame round=new GuessGame();
        round.startGame();
    }
}