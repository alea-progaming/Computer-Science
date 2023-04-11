package datastructandalgo;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * 
 * 
 * 	NUMBER 3 OF LAB ACTIVITY 2!!!
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class StudentGrades_CRUD {
	public static void main(String[] args) {
				Scanner input1 = new Scanner (System.in);
					DecimalFormat df=new DecimalFormat("#.00");
					int stud, quiz, students[], snum, pass=0, fail=0, totstud=0, totquiz=0, option;	
					double  qui, records[], quizzes[][], sum1=0, ave [], aver; 
					String[] remark;
					
					System.out.print("Number of students: ");
					stud = input1.nextInt();
					System.out.print("Number of quizzes: ");
					quiz = input1.nextInt();
					System.out.println();
					
					totstud+=stud;
					totquiz+=quiz;
					
					remark = new String [10000];
				    students = new int [10000];
				    quizzes = new double [10000][10000];
				    ave = new double [100000]; 
				    int av=quiz;
				    
				    for (int i=0; i<stud; i++ )
				    {
				    	System.out.print("Enter student number: ");
				    	snum = input1.nextInt();
				    	students[i]=snum;
				    	int a1=1;
				        for (int c=0; c<quiz; c++)
				        {
				        	System.out.print("Enter student's quiz " + a1 +": ");
					    	qui = input1.nextDouble();
					    	quizzes[i][c]=qui;
					    	a1++;
				        }
				        System.out.println();
				    	
				    }
				   
				    for (int i=0; i<stud; i++ )
				    {
				    	for (int c=0; c<quiz; c++)
				    	{
				    	   sum1= sum1 + quizzes[i][c];
				    	  
				    	}
				    	aver = sum1/quiz;
				    	ave[i]=aver;
				    	
				 		   if (ave[i]<=75)
				 		   {
				 			   remark[i]="Fail";
				 			   fail++;
				 		   }
				 		   else
				 		   {
				 			   remark[i]="Pass";
				 			   pass++;
				 		   }
				 	   
				    	System.out.println("Student \t" + students[i] + " average is:\t" +df.format(ave[i]) + "\t"+ remark[i]);
				    	sum1=0;
				    	
				    }
				    
				   System.out.println();
				   System.out.println("Number of student(s) passed: "+ pass);
				   System.out.println("Number of student(s) failed: "+ fail);
				   System.out.println();
				   System.out.println();
				 
				   
				   for (int i=0; i<stud; i++ )
				    {
				    	System.out.print("Student number: "+ students[i]);
				    	int a1=1;
				        for (int c=0; c<quiz; c++)
				        {
				        	System.out.print("\nQuiz " + a1 +": " + quizzes[i][c]);
					    	a1++;
				        }
				        System.out.print("\nAverage:  " +df.format(ave[i]) + "\nRemarks:"+ remark[i]);
				        System.out.println();
				        System.out.println();
				    	
				    }
				   System.out.println();
				   
				   do
				   {
					   System.out.println("Do you want to : ");
					   System.out.println("1. Create ");
					   System.out.println("2. Update ");
					   System.out.println("3. Exit ");
					   option = input1.nextInt();
					   
					   switch (option)
					   {
					   		case 1:
					   			
					   			System.out.print("Number of students: ");
					    		stud = input1.nextInt();
					    		System.out.print("Number of quizzes: ");
					    		quiz = input1.nextInt();
					    		System.out.println();		    		
					    		
					    		totstud+=stud;
					    		totquiz+=quiz;
					    		
					    	
					    		
					    		for (int i=stud; i<totstud; i++)
					    	    {
					    	    	System.out.print("Enter student number: ");
					    	    	snum = input1.nextInt();
					    	    	students [i] = snum;
					    	    	int b=1;
					    	    	
					    	    	for (int j=0; j<quiz; j++)
					    	    	{
					    	    		System.out.print("Enter student's quiz " + b +": ");
					    	    		qui = input1.nextDouble();
					    	    		quizzes [i][j] = qui;
					    	    		b++;
					    	    		
					    	    	}
					    	    	System.out.println();
					    	    	
					    	    }
					    		
					    		for (int i=stud; i<totstud; i++)
					    	    {
					    	    	for (int j=0; j<quiz; j++)
					    	    	{
					    	    		sum1 = sum1 + quizzes[i][j];
					    	    	}
					    	    	aver = sum1/quiz;
					    	    	ave[i]=aver;
					    	    	
					    	    	System.out.print(ave[i] + " ");
					    	    	if (ave[i]<=75)
					 	 		   {
					 	 			   remark[i]="Fail";
					 	 			   fail++;
					 	 		   }
					 	 		   else
					 	 		   {
					 	 			   remark[i]="Pass";
					 	 			   pass++;
					 	 		   }
					    	    	
					    	    	System.out.println("Student \t" + students[i] + " average is:\t" +df.format(ave[i]) + "\t"+ remark[i]);
					    	    	sum1=0;
					    	    }
					    
					    	   System.out.println();
					    	   
					    	   System.out.println();
					    	   System.out.println("Number of student(s) passed: "+ pass);
					    	   System.out.println("Number of student(s) failed: "+ fail);
					    	   System.out.println();
					    	   
					    	   for (int i=0; i<totstud; i++ )
					    	    {
					    	    	System.out.print("Student number: "+ students[i]);
					    	    	int a1=1;
					    	        for (int c=0; c<quiz; c++)
					    	        {
					    	        	System.out.print("\nQuiz " + a1 +": " + quizzes[i][c]);
					    		    	a1++;
					    	        }
					    	        System.out.print("\nAverage:  " +df.format(ave[i]) + "\nRemarks:"+ remark[i]);
					    	        System.out.println();
					    	        System.out.println();
					    	    	
					    	    }
					    	   
					   			
					   			break;
					   		case 2:
					   			
					   		 int ssnum, d=1;
				        	 System.out.print("Input Student Number to update: ");
				        	 ssnum=input1.nextInt();
				        	 for (int i =0 ; i<stud; i++)
				        	 {
				        		 if (ssnum == students[i])
				        		 {
				        			 System.out.println("Update Quiz ");
				        			 for (int c=0; c<quiz; c++)
				    	        	 {
				    	        		 System.out.print("Enter student's quiz " + d +": ");
				    	        		 qui = input1.nextDouble();
				    	        		 quizzes[i][c] = qui;
				    	        		 d++;
				    	        		 
				    	        	 }
				        			 for (int c=0; c<quiz; c++)
				    	        	 {
				    	        		  sum1= sum1 + quizzes[i][c];
				    	        			    	   	    	     
				    	        	 }
				        			 aver = sum1/quiz;
				    	 	    	 ave[i]=aver;
				    	 	    	 
				    	 	    	 if (ave[i]<=75)
				    		 		   {
				    		 			   remark[i]="Fail";
				    		 			   fail++;
				    		 			   pass--;
				    		 		   }
				    		 		   else
				    		 		   {
				    		 			   remark[i]="Pass";
				    		 			   pass++;
				    		 			   fail--;
				    		 		   }
				    	 	    	 
				    	 	    	 System.out.println("Student \t" + students[i] + " average is:\t" +df.format(ave[i]) + "\t"+ remark[i]);
				    	        	 
				        			 
				        		 }
				        	 }
				        	 
				        	 	System.out.println();
				        	    System.out.println("Number of student(s) passed: "+ pass);
				        	    System.out.println("Number of student(s) failed: "+ fail);
				        	    System.out.println();
				        	    System.out.println();
				       	 
				        	 
				        	 System.out.println();
					   			
				        	 for (int i=0; i<totstud; i++ )
					    	    {
					    	    	System.out.print("Student number: "+ students[i]);
					    	    	int a1=1;
					    	        for (int c=0; c<totquiz; c++)
					    	        {
					    	        	System.out.print("\nQuiz " + a1 +": " + quizzes[i][c]);
					    		    	a1++;
					    	        }
					    	        System.out.print("\nAverage:  " +df.format(ave[i]) + "\nRemarks:"+ remark[i]);
					    	        System.out.println();
					    	        System.out.println();
					    	    	
					    	    }
					    	   System.out.println();
				        	 
					   			break;
					   		case 3:
					   			break;
					   		default:
					   			System.out.print("Please input valid choice");
					   		
					   }
				   }
				   while (option!=3);

				//break;
		
	}
}