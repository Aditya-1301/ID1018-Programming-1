import java . util .*; // Scanner , Locale
class Temperatures
{
    public static void main ( String [] args )
    {
        System .out . println (" TEMPERATURES \n");
// input tools
        Scanner in = new Scanner ( System .in );
        in. useLocale ( Locale .US );
        // enter the number of weeks and measurements
        System .out . print (" number of weeks : ");
        int nofWeeks = in. nextInt ();
        System .out . print (" number of measurements per week : ");
        int nofMeasurementsPerWeek = in. nextInt ();
// storage space for temperature data
        double [][] t = new double [ nofWeeks + 1][ nofMeasurementsPerWeek + 1];
// read the temperatures
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            System . out. println (" temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                t[ week ][ reading ] = in. nextDouble ();
        }
        System .out . println ();
// show the temperatures
        System .out . println (" the temperatures :");
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                System . out. print (t[ week ][ reading ] + " ");
            System . out. println ();
        }
        System .out . println ();
// the least , greatest and average temperature - weekly
        double [] minT = new double [ nofWeeks + 1];
        double [] maxT = new double [ nofWeeks + 1];
        double [] sumT = new double [ nofWeeks + 1];
        double [] avgT = new double [ nofWeeks + 1];


// compute and store the least , greatest and average
// temperature for each week .
// *** WRITE YOUR CODE HERE ***
        for (int week = 1; week <=nofWeeks ; week++) {
            minT[week]=t[week][1];
            maxT[week]=t[week][1];
            sumT[week]=0;
            avgT[week]=0;
            for (int reading = 1; reading <=nofMeasurementsPerWeek ; reading++) {
                if(minT[week]>t[week][reading]){
                    minT[week]=t[week][reading];
                }
                if(maxT[week]<t[week][reading]){
                    maxT[week]=t[week][reading];
                }
                sumT[week]+=t[week][reading];
            }
            avgT[week]=sumT[week]/nofMeasurementsPerWeek;
        }
// show the least , greatest and average temperature for
// each week
// *** WRITE YOUR CODE HERE ***
        for (int week = 1; week <=nofWeeks ; week++) {
            System.out.print("the least temperature of the week" + " "+ week +"=");
            System.out.println(minT[week]);
            System.out.print("the greatest temperature of the week"+ " "+ week + "=");
            System.out.println(maxT[week]);
            System.out.print("the average temperature of the week"+ " "+ week + "=");
            System.out.println(avgT[week]);
            System.out.println("___________________________________________");
        }
// the least , greatest and average temperature - whole period
        double minTemp = minT [1];
        double maxTemp = maxT [1];
        double sumTemp = sumT [1];
        double avgTemp = 0;
// compute and store the least , greatest and average
// temperature for the whole period
// *** WRITE YOUR CODE HERE ***
        for (int week = 2; week <=nofWeeks ; week++) {
            if(minTemp>minT[week]){
                    minTemp = minT[week];
                }
                if(maxTemp<maxT[week]){
                    maxTemp=maxT[week];
                }
                sumTemp+=sumT[week];

        }
        avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek);
// show the least , greatest and average temperature for
// the whole period
// *** WRITE YOUR CODE HERE ***
        System.out.print("the least temperature of the whole period=");
        System.out.println(minTemp);
        System.out.print("the greatest temperature of the whole period=");
        System.out.println(maxTemp);
        System.out.print("the sum temperature of the whole period=");
        System.out.println(sumTemp);
        System.out.print("the average temperature of the whole period=");
        System.out.println(avgTemp);
        System.out.println("___________________________________________");
    }
}
