import java.util.*;
	class AccountDetails {  
	    public String accno;  
	    public String name;  
	    public String acc_type;  
	    public long balance;  
	    public long amt;
	    Scanner sc = new Scanner(System.in);  
	    public void openAccount() {  
	        System.out.print("Enter Account No: ");  
	        accno = sc.next();  
	        System.out.print("Enter Account type: ");  
	        acc_type = sc.next();  
	        System.out.print("Enter Name: ");  
	        name = sc.next();  
	        System.out.print("Enter Balance: ");  
	        balance = sc.nextLong();  
	    }  
	    public void showAccount() {  
	        System.out.println("Name of account holder: " + name);  
	        System.out.println("Account no: " + accno);  
	        System.out.println("Account type: " + acc_type);  
	        System.out.println("Balance: " + balance);  
	    }  
	    public void deposit() {  
	        long amt;  
	        System.out.println("Enter the amount to deposit: ");  
	        amt = sc.nextLong();  
	        balance = balance + amt;  
	    }  
	    public void withdrawal() {  
	        long amt;  
	        System.out.println("Enter the amount to withdraw: ");  
	        amt = sc.nextLong();  
	        if (balance >= amt) 
	        {  
	            balance = balance - amt;  
	            System.out.println("Balance after withdrawal: " + balance);  
	        } 
	        else 
	        {  
	            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
	        }  
	    }  
	   public long transferMoney()
	    {
	    	System.out.println("Enter the amount to transfer: ");  
	        amt = sc.nextLong();  
	        if (balance >= amt) 
	        {  
	            balance = balance - amt;  
	            System.out.println("Balance after transfer: " + balance);  
	        } 
	        else 
	        {  
	            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
	        }  
	    	return amt;
	    }
	    public void transferMoney1(long amt)
	    {
	    	balance=balance+amt;
	        System.out.println("Balance in transfer account: " + balance);
	    	
	    }
	    public boolean search(String ac_no) {  
	        if (accno.equals(ac_no))
	        {  
	            showAccount();  
	            return (true);  
	        }  
	        return (false);  
	    }  
	}  
	public class Simple_Banking_Application {
	    public static void main(String arg[]) {  
	        Scanner sc = new Scanner(System.in);  
	        System.out.print("How many number of customers you want to input? ");  
	        int n = sc.nextInt();  
	        AccountDetails C[] = new AccountDetails[n];  
	        for (int i = 0; i < C.length; i++) 
	        {  		           
	        	System.out.println("Enter account details: "+" "+(i+1));
	            C[i] = new AccountDetails ();  
	            C[i].openAccount();  
	        }  
	        int ch;  
	        do {  
	            System.out.println("\n ***Banking Application***");  
	            System.out.println("1. Account details \n 2. Search by Account number \n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Transfer the amount \n 6.Exit ");  
	            System.out.println("Enter your choice: ");  
	            ch = sc.nextInt();  
	                switch (ch) {  
	                    case 1:  
	                        for (int i = 0; i < C.length; i++) 
	                        {  
	                            C[i].showAccount();  
	                        }  
	                        break; 
	                        
	                    case 2:  
	                        System.out.print("Enter account no. you want to search: ");  
	                        String ac_no = sc.next();  
	                        boolean found = false;  
	                        for (int i = 0; i < C.length; i++)
	                        {  
	                            found = C[i].search(ac_no);  
	                            if (found)
	                            {  
	                            	C[i].showAccount();
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break;  
	                        
	                    case 3:  
	                        System.out.print("Enter Account no. : ");  
	                        ac_no = sc.next();  
	                        found = false;  
	                        for (int i = 0; i < C.length; i++)
	                        {  
	                            found = C[i].search(ac_no);  
	                            if (found) 
	                            {  
	                                C[i].deposit();  
	                                break;  
	                            }  
	                        }  
	                        if (!found) {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break;  
	                        
	                    case 4:  
	                        System.out.print("Enter Account No : ");  
	                        ac_no = sc.next();  
	                        found = false;  
	                        for (int i = 0; i < C.length; i++) 
	                        {  
	                            found = C[i].search(ac_no);  
	                            if (found)
	                            {  
	                                C[i].withdrawal();  
	                                break;  
	                            }  
	                        }  
	                        if (!found)
	                        {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break; 
	                        
	                    case 5:  
	                        System.out.print("Enter Account No : ");  
	                        ac_no = sc.next();  
	                        long amt = 0;
	                        found = false;  
	                        for (int i = 0; i < C.length; i++) 
	                        {  
	                            found = C[i].search(ac_no);  
	                            if (found)
	                            {  
	                                amt = C[i].transferMoney();  
	                                
	                                break;  
	                            }  
	                        }  
	                        if (!found)
	                        {  
	                            System.out.println("Search failed! Account doesn't exist..!!");
	                            break;
	                        }  
	                        
	                        System.out.print("Enter Transfer Account No : "); 
	    	                String ac1_no=sc.next();
	    	                found= false;
	    	                for (int j = 0; j < C.length; j++) 
		                        {  
		                            found = C[j].search(ac1_no);  
		                            
		                            if (found)
		                            {  
		                                C[j].transferMoney1(amt); 
		                                break;
		                            } 
		                        }
	    	                if (!found)
	                        {  
	                            System.out.println("Search failed! Account doesn't exist..!!");  
	                        }  
	                        break;
	                        
	                    case 6:  
	                        System.out.println("Thank you visit again....");  
	                        break;  
	                }  
	            }  
	            while (ch != 6);  
	        }  
	    
}


