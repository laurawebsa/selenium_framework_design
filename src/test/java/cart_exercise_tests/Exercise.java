package cart_exercise_tests;

public class Exercise {
    public static void main(String[] args) {

      /* for(int i=1; i<=10; i++ ) {
            for(int j=1; j<=10; j++ ) {
                if(j==i) {
                    System.out.print("x ");
                }else  {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

        String s1 = "QA";
        String s2 = new String("QA");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

    }*/
        int k = 1;
        for(int i = 0; i<4;i++){
            for(int j=1;j<=4-i;j++){
                System.out.print( k);
                System.out.print("\t");
                k++;
            }
            System.out.println( "");
        }
    }
}
