import java.util.Random;
import java.math.*;

public class ModularDivisionDsicrete {
    public static int BOOTOS= 4;
    public static String STEPS;
    public static void main(String[] args) {
        STEPS="";
        Random rand = new Random();
        int [] answer= new int[BOOTOS];
        for(int i=0; i<BOOTOS; i++){
            answer[i]=rand.nextInt(2);
            System.out.print(answer[i]);
        }
        findSolution(answer);
        System.out.println();
        if(STEPS.equals("")){
            STEPS="Initail start was solution";
        }
        System.out.println("Steps to solution: " + STEPS);
    }

    public static void findSolution(int[] answer){
        int [] search = new int[BOOTOS];
        int t=1;
        double y=Math.pow(answer.length, 2);
        while (isAnswer(answer, search)){
            int g=t+1;
            int n=0;
            while (g!=t) {
                if ((t - Math.pow(2, n)) % Math.pow(2, n + 1) == 0) {
                    if (search[n] == 0) {
                        search[n] = 1;
                    } else if (search[n] == 1) {
                        search[n] = 0;
                    }
                    t++;
                    STEPS+="" + n;
                }
                n++;
            }
        }
        System.out.println("\nSolution found at " + (t-1));
        for(int i=0; i<BOOTOS; i++){
            System.out.print(search[i]);
        }
    }

    public static boolean isAnswer(int[] answer, int [] search){
        int y=0;
        for(int i=0; i<BOOTOS; i++){
            if(answer[i]==search[i]){
                y++;
            }
        }
        if(y==BOOTOS){
            return false;
        }
        return true;
    }
}
