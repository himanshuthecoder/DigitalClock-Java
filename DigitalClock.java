/*

	Author
			Himanshu Sharma
			himanshusharma2972@gmail.com
			www.blaregroup.com
			


	===============================================================
				Digital clock on terminal
	===============================================================


	About 
			This is a simple java program for practice purpose 
			This program shows you Digital Clock on terminal

*/
import java.time.LocalDateTime;   //importing module for time
class DigitalClock
{
	
	//method to create digit pattern 
	void repeat(int top,int bottom,int middle,int upperleft,int lowerleft,int upperright,int lowerright,int height,int i)
	{
				if(i%2==0 && i!=0)
				{	if(height==4 || height==6)
					{
						System.out.print("  :  ");
					}
					else
					{
						System.out.print("     ");
					}
				}
				else
				{

					
						System.out.print("     ");
					

				}
		
				if((height==1 || height==2 || height==3 || height==4 || height==5) && upperleft==1)
				{
					System.out.print("*");
				}
				else if((height==1 || height==2 || height==3 || height==4 || height==5 ) && upperleft==0)
				{
					System.out.print(" ");
				}

				if((height==6 || height==7 || height==8 || height==9 || height==10) && lowerleft==1)
				{
					System.out.print("*");
				}
				else if((height==6 || height==7 || height==8 || height==9 || height==10 ) && lowerleft==0)
				{
					System.out.print(" ");
				}				


				
				for(int width=1;width<=5;width++)
				{
					if(height==1 && top==1)
					{
						System.out.print("*");
					}
					else if(height==5 && middle==1)
					{
						System.out.print("*");
					}
					else if(height==10 && bottom==1)
					{
						System.out.print("*");
					}
					else 
					{
						System.out.print(" ");
					}

				}

				if((height==1 || height==2 || height==3 || height==4 || height==5) && upperright==1)
				{
					System.out.print("*");
				}
				else if((height==1 || height==2 || height==3 || height==4 || height==5) && upperright==0)
				{
					System.out.print(" ");
				}

				if((height==6 || height==7 || height==8 || height==9 || height==10 ) && lowerright==1)
				{
					System.out.print("*");
				}
				else if((height==6 || height==7 || height==8 || height==9 || height==10) && lowerright==0)
				{
					System.out.print(" ");
				}	

				

		

	}


	public static void main(String args[])
	{

		DigitalClock obj = new DigitalClock();


		// useful variables to design pattern
		int top = 1;
		int lowerleft = 1;
		int upperleft = 1;
		int upperright = 1;
		int lowerright = 1;
		int bottom = 1;
		int middle = 1;
		int loop=0;
		

		//useful  variable for taking time from system and store it in a string
		int hour,minute,second;
		String hourzero ="";
		String minutezero = "";
		String secondzero = "";
		String time="";
		
		LocalDateTime now;		 //class object

		//main process
		while(loop!=1)
		{
				try{
					Thread.sleep(70);                   //for holding screen
					System.out.print("\033[H\033[2J");  //for clearing screen
					System.out.flush();

 				   }
				catch(Exception e)
				  {
				  }

			    now= LocalDateTime.now();   //for taking time from system
				hour = now.getHour(); 		//for separating hours from time
				minute = now.getMinute();	//for separating minutes from time
				second = now.getSecond();	//for separating seconds from time
				
				
				//adjusting number of zero in time
				if(hour<10){
					hourzero="0";
				}
				else{
					hourzero="";
				}
				
				if(minute<9){
					minutezero="0";
				}
				else{
					minutezero="";
				}
				if(second<9){
					secondzero="0";
				}
				else{
					secondzero="";
				}
				

				//storing time in string for manupulation
				time =String.format(("%s"+Integer.toString(hour) + "%s"+Integer.toString(minute) + "%s"+Integer.toString(second)),hourzero,minutezero,secondzero);
	
					//creation of pattern
					for(int height=1;height<=10;height++)
					{		System.out.println();
							for(int i=0;i<time.length();i++)
							{
								switch(time.charAt(i))
								{
									case '0':top=1;middle=0;bottom=1;upperleft=1;lowerleft=1;upperright=1;lowerright=1;break;
									case '1':top=0;middle=0;bottom=0;upperleft=0;lowerleft=0;upperright=1;lowerright=1;break;
									case '2':top=1;middle=1;bottom=1;upperleft=0;lowerleft=1;upperright=1;lowerright=0;break;
									case '3':top=1;middle=1;bottom=1;upperleft=0;lowerleft=0;upperright=1;lowerright=1;break;
									case '4':top=0;middle=1;bottom=0;upperleft=1;lowerleft=0;upperright=1;lowerright=1;break;
									case '5':top=1;middle=1;bottom=1;upperleft=1;lowerleft=0;upperright=0;lowerright=1;break;
									case '6':top=1;middle=1;bottom=1;upperleft=1;lowerleft=1;upperright=0;lowerright=1;break;
									case '7':top=1;middle=0;bottom=0;upperleft=0;lowerleft=0;upperright=1;lowerright=1;break;
									case '8':top=1;middle=1;bottom=1;upperleft=1;lowerleft=1;upperright=1;lowerright=1;break;
									case '9':top=1;middle=1;bottom=1;upperleft=1;lowerleft=0;upperright=1;lowerright=1;break;
									
								}
					
								obj.repeat(top,bottom,middle,upperleft,lowerleft,upperright,lowerright,height,i);	
							}
					}

		}
		
		System.out.println("");

	}
}
