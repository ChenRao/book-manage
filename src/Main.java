
import java.util.Scanner;


class BookInfo {
  String bookName;
  String authorName;
  int price;
  String press;      //������
}




public class Main {
  public static int MAXSIZE = 100;
  public static int flag = 0;
  public static BookInfo book[] = new BookInfo[100];
  
  public static void printMenu() {
	System.out.println("********ͼ�����ϵͳ********");
	System.out.println("   1.��ӡ�����鱾��Ϣ");
    System.out.println("   2.����һ������");
  	System.out.println("   3.ɾ��һ������");
  	System.out.println("   4.����");
  	System.out.println("   5.����һ��������Ϣ");
  	System.out.println("   6.�뿪����");
  }
  
  public static void printAllBookInfo() {
	  System.out.println("-----�����������鼮��Ϣ-----");
	  for(int i = 0; i < flag; i++) {
		  System.out.println(i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "Ԫ    " + book[i].press);
	  }
	  System.out.println("-----�����������鼮��Ϣ-----\n");
  }
  
  public static void newBookInfo(String bName, String aName, int bPrice, String bPress) {
	  book[flag].bookName = bName;
	  book[flag].authorName = aName;
	  book[flag].price = bPrice;
	  book[flag].press = bPress;
	  flag++;
  }
  
  public static void deleteOldBook() {
	  printAllBookInfo();
	  System.out.print("�������ɾ���鼮���:");
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  for(int i=n; i < flag; i++) {
		  book[i] = book[i + 1];
	  }
	  flag--;
	  System.out.println("ɾ���ɹ���\n");
  }
  
  public static void queryBookInfo() {

	  System.out.println("����������ҵ��鼮����:");
	  Scanner in = new Scanner(System.in);
	  String name = in.next();
	  for(int i = 0; i < flag; i++) {
		  if(name.equals(book[i].bookName)) {
			  System.out.println("�����Ǵ��鼮��Ϣ:");
			  System.out.println(i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "Ԫ    " + book[i].press);
			  break;
		  }
		  if(i == flag-1 && !name.equals(book[i].bookName)) 
			  System.out.println("û�и��鼮��Ϣ!");
	  }
  }
  
  public static void updateOldBook() {
	  System.out.println("����������µ��鼮����:");
	  Scanner in = new Scanner(System.in);
	  String name = in.next();
	  int num = 0;
	  for(int i = 0; i < flag; i++) {
		  if(name.equals(book[i].bookName)) {
			  System.out.println("ԭ�鼮��Ϣ:\n" + i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "   " + book[i].press);
			  num = i;
			  break;
		  }
		  if(i == flag-1 && !name.equals(book[i].bookName)) 
			  System.out.println("û�и��鼮��Ϣ!");
	  }
	  System.out.println("\n1.�޸�����  2.�޸�����  3.�޸ĵ���  4.�޸ĳ�����\n");
	  System.out.print("�����빦�ܱ��:");
	  int n = in.nextInt();
	  switch(n) {
	  	case 1:
	  		System.out.print("�������޸ĺ������:");
	  		String newName = in.next();
	  		book[num].bookName = newName;
	  		break;
	  	case 2:
	  		System.out.print("�������޸ĺ������:");
	  		String newAuthorName = in.next();
	  		book[num].authorName = newAuthorName;
	  		break;
	  	case 3:
	  		System.out.print("�������޸ĺ�ĵ���:");
	  		int newPrice = in.nextInt();
	  		book[num].price = newPrice;
	  		break;
	  	case 4:
	  		System.out.print("�������޸ĺ�ĳ�����:");
	  		String newPress = in.next();
	  		book[num].press = newPress;
	  		break;		
	  }
	  System.out.println("�޸ĳɹ�!");
  }
  
  public static void main(String[] args) {
 
  	int n;

  	for(int i=0; i < MAXSIZE; i ++) {
  		book[i] = new BookInfo();
  	}
  	newBookInfo("����","����",20,"����������");
  	newBookInfo("��ѧ","������",20,"����������");
  	newBookInfo("Ӣ��","���",20,"����������");
  	
  	Scanner in = new Scanner(System.in);
  	
  	printMenu();
  	
  	while(true) {
  		System.out.print("\n������˵����ܱ��:");
  		n = in.nextInt();
  		switch(n) {
  		    case 1:
  		    	printAllBookInfo();
  		    	break;
  			case 2:
  				System.out.println("����������(���س�����):");
  				String bName = in.next();
  				System.out.println("������������(���س�����):");
  				String aName = in.next();
  				System.out.println("�������鱾����(���س�����):");
  				int bPrice = in.nextInt();
  				System.out.println("�������鱾������(���س�����):");
  				String bPress = in.next();
  				newBookInfo(bName,aName,bPrice,bPress);
  				System.out.println("�����ɹ���");
  				break;
  			case 3:
  				deleteOldBook();
  				break;
  			case 4:
  				queryBookInfo();
  				break;
  			case 5:
  				updateOldBook();
  				break;
  			case 6:
  				System.exit(0);
  				break;
  			
  		}
  		printMenu();
  	}
  
  }
}
