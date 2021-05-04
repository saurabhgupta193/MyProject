import java.util.*;

class ExemptCategory
{
	double ExemptCategory(String xyz, double price)
	{
		String q="Y";
		double salestax;
		if(xyz.equalsIgnoreCase(q))	//checks whether exempted product is imported or not
			salestax=5*price/100;
		else
			salestax=0.0;
		return salestax;
	}

}

public class Goods extends ExemptCategory
{
	public static void main(String []args)
	{
		System.out.println("No. of inputs:");
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();			//reads the no. of input items
		
		String[] str= new String[a]; 		//string to take item name		
		double[] num= new double[a];		//array to take item price
		String[] str1= new String[a]; 		// string to take whether product is imported
		double[] SaleTax= new double[a];	//array to store sale tax
		double[] finalprice= new double[a];	//array to store final price of the items
		int[] index=new int[a];			//array to take item's category book or food or medical products or none
		
		for(int i=0; i<str.length; i++)
		{	
			System.out.print("Item "+i+":");
			str[i]=sc.nextLine();   		//reads name of the item
			sc.nextLine();
			System.out.print("Price "+i+":");
			num[i]=sc.nextDouble();			//reads price of the item
			sc.nextLine();
			System.out.print("Is this item an imported product?(Y/N): ");
			str1[i]=sc.nextLine();			//reads user input Y/N: Y for imported product and N for the others	
			sc.nextLine();
			System.out.println("Press 1 if input is book"+'\n'+"Press 2 if input is food"+'\n'+"Press 3 if input is a medical product"+'\n'+
				   "Press 4 if None of the above category");
			index[i]=sc.nextInt();			//reads item category 
		}
		
		double x=0.0, z=0.0;
		String p="Y";
		for(int i=0; i<a; i++)
		if(index[i]==1 || index[i]==2 || index[i]==3)		//checks if item belongs to exempted category
		{
			Goods gd = new Goods();
			SaleTax[i]=gd.ExemptCategory(str1[i], num[i]);
			finalprice[i]=num[i]+SaleTax[i];
		}
		else if(str1[i].equalsIgnoreCase(p))	//check whether category 4 is imported or not
		{
			SaleTax[i]=15*num[i]/100;
			finalprice[i]=num[i]+SaleTax[i];
		}
		else
		{
			SaleTax[i]=10*num[i]/100;
			finalprice[i]=num[i]+SaleTax[i];
		}
		for(int i=0;i<a;i++)
		{
			System.out.println("Sale Tax"+i+":"+SaleTax[i]+" and final price"+i+":"+(float)Math.ceil(finalprice[i]/.05f)*.05f);
			x=x+SaleTax[i];
			z=z+finalprice[i];
		}
		System.out.println("Sales Taxes- "+(float)Math.ceil(x/.05f)*.05f+'\n'+"Total- "+(float)Math.ceil(z/.05f)*.05f);


	}
}
