 
package assignment1;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) throws Exception {
        File input_Data_File = new File("input.txt");
        File output_Data_File = new File("print.txt");
        //check files if exists or no 
        if (input_Data_File.exists()) {
            System.out.println("The file exists");
        } else {
            System.out.println("The file does not exists ");
            System.exit(0);
        }
        if (output_Data_File.exists()) {
            System.out.println("The Output File Exists");
        } else {
            System.out.println("The Input File Exists");
            System.exit(0);
        }
        //Create Scanner to start read input file 
        Scanner readInputFile$ = new Scanner(input_Data_File);
        //Create PrintWriter to write in output file 
        PrintWriter readOutputFile$ = new PrintWriter(output_Data_File);
        //read the data from input file 
        while (readInputFile$.hasNext()) {
            int num$University = readInputFile$.nextInt();
            String[] $UniversityArray = new String[num$University];

            int num$DayDates = readInputFile$.nextInt();
            String[] $daysArray = new String[num$DayDates];
            String[] $datesArray = new String[num$DayDates];

            int num$StudentsAbdulaziz = readInputFile$.nextInt();

            int num$StudentsSaud = readInputFile$.nextInt();

            int num$StudentsKhalid = readInputFile$.nextInt();

            int num$StudentsFahed = readInputFile$.nextInt();

            //create 1D array to store univarsetis students name 
            String[] k_Abdulaziz_u = new String[num$StudentsAbdulaziz];
            String[] k_Saud_u = new String[num$StudentsSaud];
            String[] k_Khaled_u = new String[num$StudentsKhalid];
            String[] k_Fahad_u = new String[num$StudentsFahed];
            //create 2D array to store all studens name in 2D array
            String[][] nameofStudent = new String[num$University][];
            //store each array in spacfic index in array 2D to create ragged array 2D 
            nameofStudent[0] = k_Abdulaziz_u;
            nameofStudent[1] = k_Khaled_u;
            nameofStudent[2] = k_Khaled_u;
            nameofStudent[3] = k_Fahad_u;

            int num$contesciriteria = readInputFile$.nextInt();
            String[] Criteria = new String[num$contesciriteria];
            //crate 3D array to sore scores of student 
            int[][][] Students_Scores = new int[num$University][][];
            //create ragged 3D array and add size foe each row 
            Students_Scores[0] = new int[num$StudentsAbdulaziz][num$contesciriteria];
            Students_Scores[1] = new int[num$StudentsSaud][num$contesciriteria];
            Students_Scores[2] = new int[num$StudentsKhalid][num$contesciriteria];
            Students_Scores[3] = new int[num$StudentsFahed][num$contesciriteria];

            //reading commands 
            if (readInputFile$.next().equalsIgnoreCase("addUniversity")) {
                $UniversityArray = addUniversitysNamesToArray(readInputFile$, $UniversityArray);
            }
            if (readInputFile$.next().equalsIgnoreCase("addDays")) {
                $daysArray = addDaysNamestoArray(readInputFile$, $daysArray);
            }
            if (readInputFile$.next().equalsIgnoreCase("addDates")) {
                $datesArray = addDatesToArray(readInputFile$, $datesArray);
            }
            if (readInputFile$.next().equalsIgnoreCase("addStudentsName")) {
                nameofStudent = StoreStudentsName(readInputFile$, num$University, num$StudentsAbdulaziz, num$StudentsSaud, num$StudentsKhalid, num$StudentsFahed);
            }
            if (readInputFile$.next().equalsIgnoreCase("addAwardCriteria")) {
                Criteria = StoreAwardCriteria(readInputFile$, Criteria);
            }
            if (readInputFile$.next().equalsIgnoreCase("addScore")) {
                Students_Scores = StoreScoreToArray2D(readInputFile$, $UniversityArray, nameofStudent, Criteria);
            }
            if (readInputFile$.next().equalsIgnoreCase("printcontestDetails")) {
                writeDatesDayUnivarsites(readOutputFile$, $UniversityArray, $daysArray, $datesArray);
            }
            if (readInputFile$.next().equalsIgnoreCase("printcontestdetailResults")) {
                print_Detailes(readOutputFile$, $UniversityArray, nameofStudent, Criteria, Students_Scores);
            }
            if (readInputFile$.next().equalsIgnoreCase("printwinnerAwardByEachCriteria")) {
                print_winnerAward(readOutputFile$, $UniversityArray, nameofStudent, Criteria, Students_Scores);
            }
            if (readInputFile$.next().equalsIgnoreCase("Quit")) {
                readOutputFile$.println(" Thank you for using FCIT, Contest App System, Good Bye!");
                break;
            }
        }
        //closing scanner and printWriter
        readInputFile$.close();
        readOutputFile$.close();

    }//end main method--------------------------------------------------------------------------------------

    public static String[] addUniversitysNamesToArray(Scanner readInputFile$, String[] $UniversityArray) {
        //reads and store data in array 
        for (int UA = 0; UA< $UniversityArray.length; UA++) {
            String un = readInputFile$.next();
            $UniversityArray[UA] = textSplit(un);

        }
        return $UniversityArray;
    } //end addUniversitysNamesToArray method--------------------------------------------------------------------------

    public static String[] addDaysNamestoArray(Scanner readInputFile$, String[] $daysArray) {
        //reads and store data in array 
        for (int i = 0; i < $daysArray.length; i++) {
            $daysArray[i] = readInputFile$.next();
             
        }
        return $daysArray;
    }//end addDaysNamestoArray method--------------------------------------------------------------------------

    public static String[] addDatesToArray(Scanner readInputFile$, String[] $datesArray) {
        for (int i = 0; i < $datesArray.length; i++) {
            String dat = readInputFile$.next();
            $datesArray[i] = dat.replaceAll("_", "/");
             
        }
        return $datesArray;
    }//end addDatesToArray method--------------------------------------------------------------------------

    public static String textSplit(String text) {
        String word = text.replaceAll("_", " ");
        return word;
    }//end textSplit method--------------------------------------------------------------------------

    public static String[][] StoreStudentsName(Scanner readInputFile$, int num$University, int kauArraySize, int ksaArraySize, int kkuArraySize, int kfuArraySize) {
        String[] k_Abdulaziz_u = new String[kauArraySize];
        String[] k_Saud_u = new String[ksaArraySize];
        String[] k_Khaled_u = new String[kkuArraySize];
        String[] k_Fahad_u = new String[kfuArraySize];
 
        for (int i = 0; i < k_Abdulaziz_u.length; i++) {
            k_Abdulaziz_u[i] = textSplit(readInputFile$.next());
             
        }
        for (int i = 0; i < k_Saud_u.length; i++) {
            k_Saud_u[i] = textSplit(readInputFile$.next());
             
        }
        for (int i = 0; i < k_Khaled_u.length; i++) {
            k_Khaled_u[i] = textSplit(readInputFile$.next());
            
        }
        
        for (int i = 0; i < k_Fahad_u.length; i++) {
            k_Fahad_u[i] = textSplit(readInputFile$.next());
           
        }
        String[][] nameofStudent = new String[num$University][];
        nameofStudent[0] = k_Abdulaziz_u;
        nameofStudent[1] = k_Saud_u;
        nameofStudent[2] = k_Khaled_u;
        nameofStudent[3] = k_Fahad_u;
        return nameofStudent;
    }//end StoreStudentsName method--------------------------------------------------------------------------

    public static String[] StoreAwardCriteria(Scanner readInputFile$, String[] addAwardCriteria) {
        
        for (int i = 0; i < addAwardCriteria.length; i++) {
            String dat = readInputFile$.next();
            addAwardCriteria[i] = textSplit(dat);
             
        }
        return addAwardCriteria;
    }//end StoreAwardCriteria method--------------------------------------------------------------------------

    public static int[][][] StoreScoreToArray2D(Scanner readInputFile$, String[] $UniversityArray, String[][] studentName, String[] addAwardCriteria) {
        int[][][] $ScoStudents = new int[$UniversityArray.length][][];
        $ScoStudents[0] = new int[studentName[0].length][addAwardCriteria.length];
        $ScoStudents[1] = new int[studentName[1].length][addAwardCriteria.length];
        $ScoStudents[2] = new int[studentName[2].length][addAwardCriteria.length];
        $ScoStudents[3] = new int[studentName[3].length][addAwardCriteria.length];
         
        for (int $u  = 0; $u < $UniversityArray.length; $u++) {
            for (int $s  = 0; $s < $ScoStudents[$u].length; $s++) {
                for (int $p = 0; $p < $ScoStudents[$u][$s].length; $p++) {
                    $ScoStudents[$u][$s][$p] = readInputFile$.nextInt();
                     
                }
            }
        }
        return $ScoStudents;
    }//end StoreScoreToArray2D method--------------------------------------------------------------------------

    public static void writeDatesDayUnivarsites(PrintWriter readOutputFile$, String[] $UniversityArray, String[] days, String[] dates) {
        readOutputFile$.println("------------ Contest App details are as follows ------");
        readOutputFile$.println("University Name Contest Day Contest Date ");
        readOutputFile$.println("- -----------------------------------------------------------------------------");
         
        for (int $i = 0; $i < days.length; $i++) {
            readOutputFile$.printf("%-40s%-25s%-15s%n", $UniversityArray[$i], days[$i], dates[$i]);
           
        }
    }//end writeDatesDayUnivarsites method--------------------------------------------------------------------------

    public static void print_Detailes(PrintWriter readOutputFile$, String[] $UniversityArray, String[][] studentName, String[] addAwardCriteria, int[][][] Scores) {
        for (int $u = 0; $u < Scores.length; $u++) {
            readOutputFile$.println("---Contest Results of " + $UniversityArray[$u] + " is as Follows ---\n");
            
            for (int $s = 0; $s < Scores[$u].length; $s++) {
                readOutputFile$.println("---Student Name " + studentName[$u][$s] + " points are as Follows ---");
                
                for (int $sc = 0; $sc < Scores[$u][$s].length; $sc++) {
                    readOutputFile$.println(addAwardCriteria[$sc] + " : " + Scores[$u][$s][$sc]);
                    
                }
            }
        }
    }//end print_Detailes method--------------------------------------------------------------------------

    public static void print_winnerAward(PrintWriter readOutputFile$, String[] $UniversityArray, String[][] studentName, String[] addAwardCriteria, int[][][] Scores) {
        for (int $c  = 0; $c  < addAwardCriteria.length; $c ++) {
            for (int $u  = 0; $u  < $UniversityArray.length; $u ++) {
                readOutputFile$.println("--- Results of " + $UniversityArray[$u] + " is as Follows ---");
                
                readOutputFile$.println("Contest Winner name in Category: " + addAwardCriteria[$c] + " : ");
                 
                int max = 0;
                int index = 0;
                int univers = 0;
                for (int $so = 0; $so < Scores[$u].length; $so++) {
                    if (max < Scores[$u][$so][$c]) {
                        max = Scores[$u][$so][$c];
                        index = $so;
                        univers = $u;
                    }
                }
                readOutputFile$.println(studentName[$u][index]);
                
            }
        }
    }//end print_winnerAward method--------------------------------------------------------------------------

}//end class
