import java.util.Scanner;1233
import java.util.Random;
public class test1 {
jkkklkgojijh56655565665
	public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	
	 System.out.println("=========================================");
	 System.out.println("欢迎使用密码管理系统");
	 System.out.println("=========================================");
	 System.out.println("1.加密");
	 System.out.println("2.解密");
	 System.out.println("3.判断密码强度");
	 System.out.println("4.密码生成");
	 System.out.println("5.退出");

	 
	 while(true) {
		 System.out.println("请输入选项序号:");
		 int b= sc.nextInt();

	 switch(b) { 
	 
	 case 1: System.out.println("请输入要加密的数字密码");
		 String password=sc.next();
		 System.out.println("加密后的密码"+encrypt(password));
	 break;
	 case 2:  System.out.println("请输入要解密的数字密码");
		      String password1=sc.next();
	 System.out.println("解密后的密码"+decrypt(password1));
	 break;
	 case 3:  System.out.println("请输入要判断的数字密码");
		 String password2=sc.next();
		 System.out.println(judge(password2));
	 case 4: System.out.println("请输入密码的长度");
	     int number=sc.nextInt();
	     System.out.println(RandomCode(number));
	 case 5: ;
	 
	  }
	 if(b==5) {
		 System.out.println("退出");
	 }else if(b>5||b<1) {
		 System.out.println("输入不合法");
	 }
	 
	 }
	
	}	
    static String encrypt(String password){
    String word = "";
    char []Staging = new char[password.length()];
    for (int i = 0; i < password.length(); i++) {
        Staging[i]= (char) ((int)password.charAt(i)+i+4);
    }
    char a = Staging[0];
    Staging[0] = Staging[Staging.length-1];
    Staging[Staging.length-1] = a;


    for (int i = Staging.length-1; i >=0 ; i--) {
        word += Staging[i];
    }
    return word;

}

	public static String decrypt(String password){
	    String word = "";
	    char []Staging = new char[password.length()];
	    for (int i = 0; i < password.length(); i++) {
	        Staging[i]= (char) ((int)password.charAt(Staging.length-1-i));
	    }
	    char a = Staging[0];
	    Staging[0] = Staging[Staging.length-1];
	    Staging[Staging.length-1] = a;


	    for (int i = 0; i < password.length(); i++) {
	        word += (char)((int)Staging[i]-i-4);
	    }
	    return word;
	}
	public static String judge(String password) {
		String jpassword="";
		if(password.length()<8||password.length()>=8&&password.matches("\\d{8,}")||password.length()>=8&&password.matches("[a-zA-Z]{8,}")) {
			jpassword="弱";
		}
		else if(password.length()>=8&&(password.matches(".*\\d+.*")&&password.matches(".*[a-z]+.*"))&&password.matches(".*[A-Z]+.*")){
			jpassword="强";
		}
		else if(password.length()>=8&&(password.matches(".*\\d+.*")&&password.matches(".*[a-zA-Z]+.*"))){
			jpassword="中";
		}
		return jpassword ;
	}
	public static String RandomCode(int number) {
		 
		Random r=new Random();
		int randomNumber=r.nextInt(3);
		char randomNumber1=(char)(r.nextInt(10)+48);
		char randomNumber2=(char)(r.nextInt(26)+65);
		char randomNumber3=(char)(r.nextInt(26)+97);
		String word="";
		word=word+randomNumber1+randomNumber2+randomNumber3;
		while(number-3>0) {			
			if(randomNumber==0) {
				word+=(char)(r.nextInt(10)+48);
				number--;
			}else if(randomNumber==1){
				word+=(char)(r.nextInt(26)+65);
				number--;
			}else if(randomNumber==2) {
				word+=(char)(r.nextInt(26)+97);
				number--;
			}
			 randomNumber=r.nextInt(3);
		}
		 
		
		return word;
	}
   
}
