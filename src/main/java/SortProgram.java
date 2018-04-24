/* Java implementation Radix Sort */
import sorting.HeapSort;
import sorting.ISorting;
import sorting.RadixSort;
import timestamp.TimeStamp;

import java.util.*;

public class SortProgram {

    public static void main(String arg[]){

        while(true) {

            ISorting rs;
            System.out.println("Press 'r' to use RadixSort or 'h' for HeapSort");
            Scanner in = new Scanner(System.in);
            if(in.next().equals("h")){
                rs = new HeapSort();

            } else {
                rs = new RadixSort();
            }

            System.out.println("Enter amount of numbers:");

            ArrayList<Integer> arraySortableNumbers = new ArrayList<Integer>();
            for (int i = in.nextInt(); 0 < i; i--) {
                arraySortableNumbers.add((int) (Math.random() * 100 * i));
            }

            int a[] = convertIntegers(arraySortableNumbers);
            //print unsorted array using Arrays.toString()

            System.out.println("Using " + rs.getName());
            System.out.print("Unsorted array: ");
            System.out.println(Arrays.toString(a));


            TimeStamp tsCalc = new TimeStamp();
            tsCalc.init();
            tsCalc.setBegin("Begin calculating");
            a = rs.sort(a);
            tsCalc.setEnd("End calculating");

            System.out.print("Sorted array: ");
            //print sorted array
            System.out.println(Arrays.toString(a));
            System.out.println(tsCalc.toString());

            System.out.println("Press 'a' if you'd like to restart the program");
            if(!in.next().equals("a")){
                break;
            }

        }
    }

    private static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

}

