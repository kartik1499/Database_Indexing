

/**
 *  Course: CS-6360 - Database Design
 *  Date: 18 April 2015
 *  Project 2
 *
 *  Author: Kartik Nayankumar Kapadia
 *  Email: kartik.kapadia@utdallas.edu
 *  University of Texas at Dallas
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.opencsv.CSVReader;


public class MyDatabase {


	static byte double_blind_mask      = 8;    // binary 0000 1000
	static byte controlled_study_mask  = 4;    // binary 0000 0100
	static byte govt_funded_mask       = 2;    // binary 0000 0010
	static byte fda_approved_mask      = 1;    // binary 0000 0001

	public static void main(String[] args)
	{


		System.out.println("Please enter a number from below options : ");
		System.out.println("1. Parse Input CSV file to Binary & Create Indexes");
		System.out.println("2. Choose a field to query");

		Scanner scanner = new Scanner(System.in);
		int selection = scanner.nextInt();

		scanner.nextLine();
		if(selection == 1)
		{
			System.out.println("Please enter absolute path of the CSV file");
			String filePath=scanner.next();
			parseCSVToBinary("C:\\MS_CS_UTDallas\\Spring_2015\\Database Design\\Project\\Project 2\\PHARMA_TRIALS_1000B.csv");

			//parseCSVToBinary(filePath);
		}
		else if(selection ==2)
		{
			System.out.println("Please choose a field to query from below options");
			System.out.println("1. ID");
			System.out.println("2. Company");

			System.out.println("3. Drug ID");
			System.out.println("4. Trials");
			System.out.println("5. Patients");
			System.out.println("6. Dosage");
			System.out.println("7. Reading");


			System.out.println("8. Double Blind");
			System.out.println("9. Controlled Study");
			System.out.println("10. Government Funded");
			System.out.println("11. FDA Approved");


			int queryField = scanner.nextInt();

			scanner.nextLine();

			if(queryField==1 || (queryField>3 && queryField<=7))
			{
				System.out.println("Please choose an operator from : >,<,>=,<=,=,!=");
				String operator = scanner.next();
				operator=operator.trim();
				scanner.nextLine();
				System.out.println("Please enter a value");
				String queryVal = scanner.next();
				scanner.nextLine();

				if(queryField==1)
				{

					try
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						int queryValue = Integer.parseInt(queryVal);
						if(operator.equals("="))
						{
							queryUsingID(queryValue);
						}

						else if(operator.equals(">"))
						{

							for(int i=queryValue+1;i<=1000;i++)
							{
								queryUsingID(i);
							}

						}

						else if(operator.equals(">="))
						{

							for(int i=queryValue;i<=1000;i++)
							{
								queryUsingID(i);
							}

						}

						else if(operator.equals("<"))
						{

							for(int i=1;i<queryValue;i++)
							{
								queryUsingID(i);
							}

						}

						else if(operator.equals("<="))
						{

							for(int i=1;i<=queryValue;i++)
							{
								queryUsingID(i);
							}

						}

						else if(operator.equals("!="))
						{

							for(int i=1;i<=1000 && i!=queryValue;i++)
							{
								queryUsingID(i);
							}

						}

						System.out.println("=========================================================================================================================================================");

					}
					catch(Exception e)
					{
						System.out.println("Please create binary database and index files before querying data");
					}
				}

				else if(queryField==4)
				{

					try
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						int queryValue = Integer.parseInt(queryVal);
						if(operator.equals("="))
						{
							queryByTrials(queryValue);
						}

						else if(operator.equals(">"))
						{

							for(int i=queryValue+1;i<=100;i++)
							{
								queryByTrials(i);
							}

						}

						else if(operator.equals(">="))
						{

							for(int i=queryValue;i<=100;i++)
							{
								queryByTrials(i);
							}

						}

						else if(operator.equals("<"))
						{

							for(int i=10;i<queryValue;i++)
							{
								queryByTrials(i);
							}

						}

						else if(operator.equals("<="))
						{

							for(int i=10;i<=queryValue;i++)
							{
								queryByTrials(i);
							}

						}

						else if(operator.equals("!="))
						{

							for(int i=10;i<=100 && i!=queryValue;i++)
							{
								queryByTrials(i);
							}

						}

						System.out.println("=========================================================================================================================================================");

					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}

				}

				else if(queryField==5)
				{


					try
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						int queryValue = Integer.parseInt(queryVal);
						if(operator.equals("="))
						{
							queryByPatients(queryValue);
						}

						else if(operator.equals(">"))
						{

							for(int i=queryValue+1;i<=2500;i++)
							{
								queryByPatients(i);
							}

						}

						else if(operator.equals(">="))
						{

							for(int i=queryValue;i<=2500;i++)
							{
								queryByPatients(i);
							}

						}

						else if(operator.equals("<"))
						{

							for(int i=1000;i<queryValue;i++)
							{
								queryByPatients(i);
							}

						}

						else if(operator.equals("<="))
						{

							for(int i=1000;i<=queryValue;i++)
							{
								queryByPatients(i);
							}

						}

						else if(operator.equals("!="))
						{

							for(int i=1000;i<=2500 && i!=queryValue;i++)
							{
								queryByPatients(i);
							}

						}

						System.out.println("=========================================================================================================================================================");

					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}


				}

				else if(queryField==6)
				{



					try
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						int queryValue = Integer.parseInt(queryVal);
						if(operator.equals("="))
						{
							queryByDosage(queryValue);
						}

						else if(operator.equals(">"))
						{

							for(int i=queryValue+1;i<=500;i++)
							{
								queryByDosage(i);
							}

						}

						else if(operator.equals(">="))
						{

							for(int i=queryValue;i<=500;i++)
							{
								queryByDosage(i);
							}

						}

						else if(operator.equals("<"))
						{

							for(int i=6;i<queryValue;i++)
							{
								queryByDosage(i);
							}

						}

						else if(operator.equals("<="))
						{

							for(int i=6;i<=queryValue;i++)
							{
								queryByDosage(i);
							}

						}

						else if(operator.equals("!="))
						{

							for(int i=6;i<=500 && i!=queryValue;i++)
							{
								queryByDosage(i);
							}

						}

						System.out.println("=========================================================================================================================================================");

					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}



				}

				else if(queryField==7)
				{




					try
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						float queryValue = Float.parseFloat(queryVal);

						queryByReading(queryValue,operator);

						System.out.println("=========================================================================================================================================================");

					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}




				}

			}





			else if(queryField==2)
			{

				System.out.println("Please enter a Company name to query for");
				String companyName=null;

				companyName=scanner.nextLine();

				try
				{
					if(companyName!=null)
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						queryByCompanyName(companyName);
						System.out.println("=========================================================================================================================================================");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Please create binary database and index files before querying data");
				}

			}

			else if(queryField==3)
			{

				System.out.println("Please enter a drug name to query for");
				String drugName=null;

				drugName=scanner.nextLine();

				try
				{
					if(drugName!=null)
					{
						System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
						queryByDrugName(drugName);
						System.out.println("=========================================================================================================================================================");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Please create binary database and index files before querying data");
				}

			}

			else  {

				System.out.println("Please enter either true or false");
				String tf=scanner.next();
				scanner.nextLine();

				if(queryField==8)
				{

					try
					{
						if(tf!=null)
						{
							System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
							queryByDoubleBlind(tf);
							System.out.println("=========================================================================================================================================================");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}
					
				}

				
				
				else if(queryField==9)
				{

					try
					{
						if(tf!=null)
						{
							System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
							queryByControlledStudy(tf);
							System.out.println("=========================================================================================================================================================");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}
					
				}

				
				
				else if(queryField==10)
				{

					try
					{
						if(tf!=null)
						{
							System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
							queryBygovtFunded(tf);
							System.out.println("=========================================================================================================================================================");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}
					
				}

				
				
				else if(queryField==11)
				{

					try
					{
						if(tf!=null)
						{
							System.out.println("ID   Company                                      Drug-Id Trials  Patients  Dosage  Reading  Double-Blind Controlled-Study Govt-Funded FDA-Approved");
							queryByFDAApproved(tf);
							System.out.println("=========================================================================================================================================================");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Please create binary database and index files before querying data");
					}
					
				}


			}
		}



	}





	public static void parseCSVToBinary(String filePath)
	{
		//Input CSV file which needs to be parsed
		//String fileToParse = "C:\\MS_CS_UTDallas\\Spring_2015\\Database Design\\Project\\Project 2\\PHARMA_TRIALS_1000B.csv";

		String fileToParse = filePath;

		int count=0;
		StringBuffer strBuff = new StringBuffer();
		DataOutputStream idIndexOut=null;
		DataOutputStream companyIndexOut=null;
		DataOutputStream drugIndexOut=null;
		DataOutputStream trialsIndexOut=null;
		DataOutputStream patientsIndexOut=null;
		DataOutputStream dosageIndexOut=null;
		DataOutputStream readingIndexOut=null;
		DataOutputStream doubleBlindIndexOut=null;
		DataOutputStream csIndexOut=null;
		DataOutputStream gfIndexOut=null;
		DataOutputStream fdaIndexOut=null;

		Map<Integer,Integer> idIndexMap = new TreeMap<Integer,Integer>();
		Map<String,String> companyIndexMap = new TreeMap<String,String>();
		Map<String,String> drugIndexMap = new TreeMap<String,String>();		
		Map<Integer,String> trialsIndexMap = new TreeMap<Integer,String>();
		Map<Integer,String> patientsIndexMap = new TreeMap<Integer,String>();
		Map<Integer,String> dosageIndexMap = new TreeMap<Integer,String>();
		Map<Float,String> readingIndexMap = new TreeMap<Float,String>();

		Map<String,String> doubleBlindIndexMap = new TreeMap<String,String>();
		Map<String,String> csIndexMap = new TreeMap<String,String>();
		Map<String,String> gfIndexMap = new TreeMap<String,String>();
		Map<String,String> fdaIndexMap = new TreeMap<String,String>();



		int size=0;

		RandomAccessFile file = null;

		try
		{

			file = new RandomAccessFile("data.db", "rw");

			//out = new DataOutputStream(new FileOutputStream("data.db"));

			idIndexOut = new DataOutputStream(new FileOutputStream("id.ndx"));
			companyIndexOut = new DataOutputStream(new FileOutputStream("company.ndx"));
			drugIndexOut = new DataOutputStream(new FileOutputStream("drug.ndx"));
			trialsIndexOut = new DataOutputStream(new FileOutputStream("trials.ndx"));
			patientsIndexOut = new DataOutputStream(new FileOutputStream("patients.ndx"));
			dosageIndexOut = new DataOutputStream(new FileOutputStream("dosage.ndx"));
			readingIndexOut = new DataOutputStream(new FileOutputStream("reading.ndx"));
			doubleBlindIndexOut = new DataOutputStream(new FileOutputStream("doubleBlind.ndx"));
			csIndexOut = new DataOutputStream(new FileOutputStream("controlledStudy.ndx"));
			gfIndexOut = new DataOutputStream(new FileOutputStream("govtFunded.ndx"));
			fdaIndexOut = new DataOutputStream(new FileOutputStream("fdaApproved.ndx"));
			

			//Create the file reader
			//fileReader = new BufferedReader(new FileReader(fileToParse));
			CSVReader reader = new CSVReader(new FileReader(fileToParse));

			String [] tokens;
			//Read the file line by line
			while ((tokens = reader.readNext()) != null)
			{
				if(count==0)
				{
					++count;
					continue;
				}
				//Get all tokens available in line
				//String[] tokens = line.split(DELIMITER);

				//Print all tokens
				//System.out.println(tokens[i]);


				int id=Integer.parseInt(tokens[0]);
				if(idIndexMap.get(id)==null)
					idIndexMap.put(id, size);

				if(companyIndexMap.get(tokens[1])==null)
					companyIndexMap.put(tokens[1], id+"");
				else
					companyIndexMap.put(tokens[1],companyIndexMap.get(tokens[1])+"%"+id+"");


				/*byte[] bytesBigEndianId = convertToBytes(id, ByteOrder.BIG_ENDIAN);         	        

         	        for(int k=0;k<bytesBigEndianId.length;k++)
         	        {
         	        	strBuff.append(byte2bits(bytesBigEndianId[k]));
         	        }*/

				//strBuff.append(String.format("%32s", Integer.toBinaryString(id)).replace(' ', '0'));

				file.writeInt(id);

				size+=4;

				int companyStrLen = tokens[1].length();
				//strBuff.append(String.format("%8s", Integer.toBinaryString(companyStrLen)).replace(' ', '0'));

				file.writeByte(companyStrLen);

				size+=1;

				char[] companyChars = tokens[1].toCharArray();

				for (int j = 0; j < companyChars.length; j++)
				{	      	            	  


					file.writeByte(companyChars[j]);  
					strBuff.append(String.format("%8s", Integer.toBinaryString((int) companyChars[j])).replace(' ', '0'));
				}

				size+=companyStrLen;

				char[] drugIdChars = tokens[2].toCharArray();

				for (int j = 0; j < drugIdChars.length; j++)
				{	  

					file.writeByte(drugIdChars[j]);  
					strBuff.append(String.format("%8s", Integer.toBinaryString((int) drugIdChars[j])).replace(' ', '0'));
				}


				if(drugIndexMap.get(tokens[2])==null)
					drugIndexMap.put(tokens[2], id+"");
				else
					drugIndexMap.put(tokens[2],drugIndexMap.get(tokens[2])+"%"+id+"");


				size+=6;

				int trials = Integer.parseInt(tokens[3]);
				//strBuff.append(String.format("%16s", Integer.toBinaryString(trials)).replace(' ', '0'));
				file.writeShort(trials);
				size+=2;

				if(trialsIndexMap.get(trials)==null)
					trialsIndexMap.put(trials, id+"");
				else
					trialsIndexMap.put(trials,trialsIndexMap.get(trials)+"%"+id+"");



				int patients = Integer.parseInt(tokens[4]);
				//strBuff.append(String.format("%16s", Integer.toBinaryString(patients)).replace(' ', '0'));
				file.writeShort(patients);
				size+=2;

				if(patientsIndexMap.get(patients)==null)
					patientsIndexMap.put(patients, id+"");
				else
					patientsIndexMap.put(patients,patientsIndexMap.get(patients)+"%"+id+"");



				int dosage = Integer.parseInt(tokens[5]);
				//strBuff.append(String.format("%16s", Integer.toBinaryString(dosage)).replace(' ', '0'));
				file.writeShort(dosage);
				size+=2;
				//double reading = Float.parseFloat(tokens[6]);

				if(dosageIndexMap.get(dosage)==null)
					dosageIndexMap.put(dosage, id+"");
				else
					dosageIndexMap.put(dosage,dosageIndexMap.get(dosage)+"%"+id+"");





				String reading = tokens[6];

				//strBuff.append(floatToBinary(reading));

				float f = Float.valueOf(reading).floatValue();
				file.writeFloat(f);


				if(readingIndexMap.get(f)==null)
					readingIndexMap.put(f, id+"");
				else
					readingIndexMap.put(f,readingIndexMap.get(f)+"%"+id+"");

				size+=4;

				byte commonByte = 0x00; 



				if("true".equalsIgnoreCase(tokens[7]))
					double_blind_mask=8;
				else
					double_blind_mask=0;



				if(doubleBlindIndexMap.get(tokens[7])==null)
					doubleBlindIndexMap.put(tokens[7], id+"");
				else
					doubleBlindIndexMap.put(tokens[7],doubleBlindIndexMap.get(tokens[7])+"%"+id+"");


				if("true".equalsIgnoreCase(tokens[8]))
					controlled_study_mask=4;
				else
					controlled_study_mask=0;

				if(csIndexMap.get(tokens[8])==null)
					csIndexMap.put(tokens[8], id+"");
				else
					csIndexMap.put(tokens[8],csIndexMap.get(tokens[8])+"%"+id+"");

				

				if("true".equalsIgnoreCase(tokens[9]))
					govt_funded_mask=2;
				else
					govt_funded_mask=0;

				if(gfIndexMap.get(tokens[9])==null)
					gfIndexMap.put(tokens[9], id+"");
				else
					gfIndexMap.put(tokens[9],gfIndexMap.get(tokens[9])+"%"+id+"");

				

				if("true".equalsIgnoreCase(tokens[10]))
					fda_approved_mask=1;
				else
					fda_approved_mask=0;

				if(fdaIndexMap.get(tokens[10])==null)
					fdaIndexMap.put(tokens[10], id+"");
				else
					fdaIndexMap.put(tokens[10],fdaIndexMap.get(tokens[10])+"%"+id+"");

				
				commonByte = (byte)(commonByte | double_blind_mask);
				commonByte = (byte)(commonByte | controlled_study_mask);
				commonByte = (byte)(commonByte | govt_funded_mask);
				commonByte = (byte)(commonByte | fda_approved_mask);



				/*if("true".equalsIgnoreCase(tokens[7]))
					{
					double_blind_mask=8;
					file.writeBoolean(true);
					}
				else
					{
					double_blind_mask=0;
					file.writeBoolean(false);
					}


				if("true".equalsIgnoreCase(tokens[8]))
					{
					controlled_study_mask=4;
					file.writeBoolean(true);
					}
				else
					{
					controlled_study_mask=0;
					file.writeBoolean(false);
					}


				if("true".equalsIgnoreCase(tokens[9]))
					{
					govt_funded_mask=2;
					file.writeBoolean(true);
					}
				else
					{
					govt_funded_mask=0;
					file.writeBoolean(false);
					}


				if("true".equalsIgnoreCase(tokens[10]))
					{
					fda_approved_mask=1;
					file.writeBoolean(true);
					}
				else
					{
					fda_approved_mask=0;
					file.writeBoolean(false);
					}
				 */


				//strBuff.append(String.format("%8s", Integer.toBinaryString(intVal)).replace(' ', '0'));



				file.writeByte(commonByte);
				size+=1;


				++count;

			}

			//out.writeBytes(strBuff.toString());

			Iterator it = idIndexMap.entrySet().iterator();
			StringBuffer buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+","+pair.getValue());
				buff.append("\n");


			}

			idIndexOut.writeBytes(buff.toString());

			it = companyIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			companyIndexOut.writeBytes(buff.toString());


			it = drugIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			drugIndexOut.writeBytes(buff.toString());


			it = trialsIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			trialsIndexOut.writeBytes(buff.toString());



			it = patientsIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			patientsIndexOut.writeBytes(buff.toString());



			it = dosageIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			dosageIndexOut.writeBytes(buff.toString());







			it = readingIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			readingIndexOut.writeBytes(buff.toString());


			it = doubleBlindIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			doubleBlindIndexOut.writeBytes(buff.toString());
			
			
			
			
			
			it = csIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			csIndexOut.writeBytes(buff.toString());
			
			
			it = gfIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			gfIndexOut.writeBytes(buff.toString());
			
			
			it = fdaIndexMap.entrySet().iterator();
			buff = new StringBuffer();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				buff.append(pair.getKey()+"="+pair.getValue());
				buff.append("\n");


			}

			fdaIndexOut.writeBytes(buff.toString());
			
			




			System.out.println("count is: "+count);
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				companyIndexOut.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		finally
		{
			try {
				//fileReader.close();
				//out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}







	public static String queryUsingID(int id) throws Exception
	{

		StringBuffer result = new StringBuffer();

		String filePath="id.ndx";
		try {
			RandomAccessFile file = new RandomAccessFile("data.db", "r");

			FileInputStream fs= new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));

			for(int i = 0; i < id-1; ++i)
				br.readLine();

			String reqdLine = br.readLine();

			String[] arr = reqdLine.split(",");

			int bytesToSkip = Integer.parseInt(arr[1]);

			file.seek(bytesToSkip);



			int a=file.readInt();
			int size = file.read();
			System.out.print(a);
			System.out.print("  ");

			//System.out.println("size is:"+size);



			byte[] companyNames = new byte[size];
			for(int i=0;i<size;i++)
				companyNames[i]=(byte) file.read();

			String companyName = new String(companyNames);
			//System.out.println("Company name is: "+companyName);
			System.out.print(companyName);
			//System.out.print(String.format("%42s", Integer.toBinaryString(42-size)));

			for(int i=0;i<45-size;i++)
				System.out.print(" ");

			byte[] drugId = new byte[6];
			for(int i=0;i<6;i++)
				drugId[i]=(byte) file.read();

			String drugName = new String(drugId);
			//System.out.println("Drug name is: "+drugName);

			System.out.print(drugName);
			System.out.print("   ");

			int trials = file.readShort();

			int patients = file.readShort();

			int dosage = file.readShort();

			float reading = file.readFloat();

			/*	System.out.println("Trials : "+trials);

			System.out.println("patients : "+patients);

			System.out.println("Dosage : "+dosage);

			System.out.println("Reading : "+reading);*/


			System.out.print(trials);
			System.out.print("      ");
			System.out.print(patients);
			System.out.print("      ");
			System.out.print(dosage);
			System.out.print("      ");
			System.out.print(reading);
			System.out.print("      ");
			byte commonByte = file.readByte();

			/*
			boolean db = file.readBoolean();
			boolean cs = file.readBoolean();
			boolean gf = file.readBoolean();
			boolean fda = file.readBoolean();


			if(!db)
			{
				System.out.print("FALSE");
				System.out.print("        ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("         ");

			}

			if(!cs)
			{
				System.out.print("FALSE");
				System.out.print("             ");

			}
			else
			{
				System.out.print("TRUE");
				System.out.print("              ");

			}

			if(!gf)
			{
				System.out.print("FALSE");
				System.out.print("       ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("        ");
			}

			if(!fda)
				System.out.print("FALSE");
			else
				System.out.print("TRUE");*/




			if((commonByte & double_blind_mask)==0)
			{
				System.out.print("FALSE");
				System.out.print("        ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("         ");

			}

			if((commonByte & controlled_study_mask)==0)
			{
				System.out.print("FALSE");
				System.out.print("             ");

			}
			else
			{
				System.out.print("TRUE");
				System.out.print("              ");

			}

			if((commonByte & govt_funded_mask)==0)
			{
				System.out.print("FALSE");
				System.out.print("       ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("        ");
			}

			if((commonByte & fda_approved_mask)==0)
				System.out.print("FALSE");
			else
				System.out.print("TRUE");




			System.out.println("");
			//System.out.println("==================================================");

			//System.out.println("file length is : "+file.length());


		} 
		finally{

		}



		return result.toString();

	}




	public static void queryByCompanyName(String companyName) throws Exception
	{
		RandomAccessFile file = null;
		FileInputStream fs= null;
		BufferedReader br =null;
		companyName=companyName.trim();
		try
		{
			String filePath="company.ndx";
			file = new RandomAccessFile("data.db", "r");
			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(companyName.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			String[] data = reqdLine.split("=");

			String[] id = data[1].split("%");

			for(int j=0;j<id.length;j++)
			{
				queryUsingID(Integer.parseInt(id[j]));
			}




		}

		finally
		{
			file.close();
			fs.close();
			br.close();
		}

	}


	public static void queryByDrugName(String drugName) throws Exception
	{
		RandomAccessFile file = null;
		FileInputStream fs= null;
		BufferedReader br =null;
		drugName=drugName.trim();
		try
		{
			String filePath="drug.ndx";
			file = new RandomAccessFile("data.db", "r");
			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(drugName.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			String[] data = reqdLine.split("=");

			String[] id = data[1].split("%");

			for(int j=0;j<id.length;j++)
			{
				queryUsingID(Integer.parseInt(id[j]));
			}




		}

		finally
		{
			file.close();
			fs.close();
			br.close();
		}

	}



	public static void queryByTrials(int trials) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="trials.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(trials == Integer.parseInt(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			String[] data = reqdLine.split("=");

			String[] id = data[1].split("%");

			for(int j=0;j<id.length;j++)
			{
				queryUsingID(Integer.parseInt(id[j]));
			}




		}

		finally
		{

			fs.close();
			br.close();
		}

	}







	public static void queryByPatients(int patients) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="patients.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(patients == Integer.parseInt(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}











	public static void queryByDosage(int dosage) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="dosage.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(dosage == Integer.parseInt(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}





	public static void queryByReading(float reading, String operator) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="reading.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(operator.equals("="))
				{
					if(reading == Float.parseFloat(nextLineArr[0]))
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
						break;
					}


				}

				else if(operator.equals(">"))
				{

					if(Float.parseFloat(nextLineArr[0])>reading)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
					}

				}

				else if(operator.equals(">="))
				{

					if(Float.parseFloat(nextLineArr[0])>=reading)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
					}


				}

				else if(operator.equals("<"))
				{

					if(Float.parseFloat(nextLineArr[0])<reading)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
					}


				}

				else if(operator.equals("<="))
				{

					if(Float.parseFloat(nextLineArr[0])<=reading)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
					}


				}

				else if(operator.equals("!="))
				{

					if(Float.parseFloat(nextLineArr[0])!=reading)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split("=");

						String[] id = data[1].split("%");

						for(int j=0;j<id.length;j++)
						{
							queryUsingID(Integer.parseInt(id[j]));
						}
					}



				}


			}

		}

		finally
		{

			fs.close();
			br.close();
		}

	}




	
	
	
	public static void queryByDoubleBlind(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="doubleBlind.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}

	
	
	
	
	
	
	
	
	
	public static void queryByControlledStudy(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="controlledStudy.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}


	
	
	
	public static void queryBygovtFunded(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="govtFunded.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}

	
	
	public static void queryByFDAApproved(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="fdaApproved.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split("=");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;
					
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split("=");

				String[] id = data[1].split("%");

				for(int j=0;j<id.length;j++)
				{
					queryUsingID(Integer.parseInt(id[j]));
				}
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}

	
	
}
