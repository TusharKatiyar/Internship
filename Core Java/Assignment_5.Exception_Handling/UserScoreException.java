import javax.swing.*;


public class UserScoreException{
    public static void main(String[] args){

        JFrame f = new JFrame();
        String scoreString = JOptionPane.showInputDialog(f,"Enter your test score: ");
        
        try{
            int score = Integer.parseInt(scoreString);

            try{
                
                if(score > 100 || score < 0){
                    throw new ScoreException("The score must be >= 0 and <= 100!");
                }
                else{
                    JOptionPane.showMessageDialog(f, "That is a valid score.");
                }
            } catch (ScoreException e){
                JOptionPane.showMessageDialog(f, e.getMessage());                
            }

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(f, "You must enter a number for the score!");
        } finally {
            String answer = JOptionPane.showInputDialog(f,"Do you want to enter another score? (Yes or Y)");
                if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")){
                    main(args);
                }
        }
    }
}
