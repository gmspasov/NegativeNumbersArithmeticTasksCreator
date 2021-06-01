import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

/**
 *Class created by Geuorgi Spasov on 01.06.2021.
 * The class contains a single static function that prints the tasks to the screen.
 * The expressions are of the type -3 +5 =
 * It can be useful for teachers and students in the 6-th grade (Bulgarian Classification).
 */

public class NegativeNumberArithmeticTaskCreator {

    /**
     * This static function prints the tasks to the screen.
     * @param number_of_tasks The number of the tasks.
     * @param limit_of_coefficients The range of the coefficients.
     */
    static void Create_Tasks(int number_of_tasks, int limit_of_coefficients, int limit_of_expression_length, int minimum_expression_length)
            {
                if(number_of_tasks<0) number_of_tasks*=(-1);
                if(limit_of_coefficients<0) limit_of_coefficients*=(-1);
                if(limit_of_expression_length<0) limit_of_expression_length*=(-1);
                if(minimum_expression_length<0) minimum_expression_length*=(-1);

                while(number_of_tasks==0)
                   {
                       System.out.println("Enter new number of tasks. 0 is selected./n New number of tasks = ");
                       Scanner scan= new Scanner(System.in);
                       number_of_tasks=scan.nextInt();
                   }
                while (limit_of_coefficients ==0)
                    {
                        System.out.println("Enter new limit of numbers. 0 is selected./n New limit of numbers = ");
                        Scanner scan= new Scanner(System.in);
                        limit_of_coefficients=scan.nextInt();
                    }
                while (limit_of_expression_length <2)
                    {
                        System.out.println("Enter new number of limit of expressions length. It must be 2 at least./n New limit of expression length = ");
                        Scanner scan= new Scanner(System.in);
                        limit_of_expression_length=scan.nextInt();
                    }
                while (minimum_expression_length >limit_of_expression_length || minimum_expression_length<2)
                    {
                        System.out.println("Enter new minimum expression length. It must be larger than 2 and smaller than " +(limit_of_expression_length+1) + " ./n New limit of expression length = ");
                        Scanner scan= new Scanner(System.in);
                        minimum_expression_length=scan.nextInt();
                    }

                Random rand = new Random();

                for(int i=0;i<number_of_tasks;++i) {
                    StringBuilder expression = new StringBuilder();
                    int expressionLength = minimum_expression_length + rand.nextInt(1+limit_of_expression_length - minimum_expression_length);

                    for (int j = 0; j < expressionLength; ++j)
                    {
                        int coefficient = rand.nextInt(limit_of_coefficients);
                        int coefficient_sign = rand.nextInt(2);

                        if (coefficient_sign == 0 && coefficient != 0)
                            expression.append(coefficient*(-1) + " ");
                        else
                            expression.append("+" + coefficient + " ");
                    }
                    expression.append(" = ");
                    System.out.println(expression);
                }
                }

    public static void main(String[] args) {
            NegativeNumberArithmeticTaskCreator.Create_Tasks(20,20,5,3);
    }
            };

