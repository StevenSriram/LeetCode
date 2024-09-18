import java.util.Scanner;

public class TimeDifference{
    
    public static void timeDifference(int totalSec1, int totalSec2)
    {
        // calculate Difference in Seconds
		int differenceSeconds = Math.abs(totalSec1 - totalSec2);
		
		// 1 Hour = 3600 Seconds
        int hourDiff = differenceSeconds / 3600;
        // 1 Minute = 60 Seconds
        int minDiff = (differenceSeconds % 3600) / 60;
        // 1 Seconds = 1 Seconds
        int secDiff = differenceSeconds % 60;
        
        System.out.printf("\n %d : %d : %d ", hourDiff, minDiff, secDiff);
        		
    }
    
	public static void main(String[] args) 
	{
	    Scanner s = new Scanner(System.in);

        // Time 1 = "14:30:00"
		String[] t1 = s.nextLine().split(":");
		int h1 = Integer.parseInt(t1[0]);
		int m1 = Integer.parseInt(t1[1]);
		int s1 = Integer.parseInt(t1[2]);
		
		// Time 2 = "16:45:30"
		String[] t2 = s.nextLine().split(":");
		int h2 = Integer.parseInt(t2[0]);
		int m2 = Integer.parseInt(t2[1]);
		int s2 = Integer.parseInt(t2[2]);
		
		// turn Hours, Minutes, Seconds to totalSeconds
		int totalSec1 = h1*3600 + m1*60 + s1;
		int totalSec2 = h2*3600 + m2*60 + s2;
		
		
		timeDifference(totalSec1, totalSec2);
		
	}
}