import java.util.Random;

public class RecursiveDiscrete {

    public static int BOOTOS = 4;
    public static String FLIPS;
    public static String STEPS;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] answer = new int[BOOTOS];
        for (int i = 0; i < BOOTOS; i++) {
            answer[i] = rand.nextInt(2);
            System.out.print(answer[i]);
        }
        STEPS = "";
        findSolution(answer);
        System.out.println();
        if (STEPS.equals("")) {
            STEPS = "Initail start was solution";
        }
        System.out.println("Steps to solution: " + STEPS);
    }

    public static void findSolution(int[] answer) {
        int[] search = new int[BOOTOS];
        int n = 0;
        int t = 0;
        System.out.println("");
        FLIPS = "";
        if (!isAnswer(answer, search)) {
            System.out.println("\nSolution found at " + (t));
            for (int l = 0; l < BOOTOS; l++) {
                System.out.print(search[l]);
            }
        } else {
            while (n < BOOTOS) {
                if (search[n] == 0) {
                    search[n] = 1;
                } else if (search[n] == 1) {
                    search[n] = 0;
                }
                STEPS += "" + n;
                t++;
                if (!isAnswer(answer, search)) {
                    System.out.println("\nSolution found at " + (t));
                    for (int l = 0; l < BOOTOS; l++) {
                        System.out.print(search[l]);
                    }
                    return;
                }
                if (n != 0) {
                    for (int i = 0; i < FLIPS.length(); i++) {
                        t++;
                        int b = FLIPS.charAt(i) - 48;
                        STEPS += "" + b;
                        if (search[b] == 0) {
                            search[b] = 1;
                        } else if (search[b] == 1) {
                            search[b] = 0;
                        }
                        if (!isAnswer(answer, search)) {
                            System.out.println("\nSolution found at " + (t));
                            for (int l = 0; l < BOOTOS; l++) {
                                System.out.print(search[l]);
                            }
                            return;
                        }
                    }
                }
                FLIPS = "" + FLIPS + n + FLIPS;
                n++;
            }
            System.out.println("\nSolution found at " + (t));
            for (int i = 0; i < BOOTOS; i++) {
                System.out.print(search[i]);
            }
        }
    }

    public static boolean isAnswer(int[] answer, int[] search) {
        int y = 0;
        for (int i = 0; i < BOOTOS; i++) {
            if (answer[i] == search[i]) {
                y++;
            }
        }
        if (y == BOOTOS) {
            return false;
        }
        return true;
    }
}



