
import java.util.Scanner;


class BookInfo {
  String bookName;
  String authorName;
  int price;
  String press;      //出版社
}




public class Main {
  public static int MAXSIZE = 100;
  public static int flag = 0;
  public static BookInfo book[] = new BookInfo[100];
  
  public static void printMenu() {
	System.out.println("********图书管理系统********");
	System.out.println("   1.打印所有书本信息");
    System.out.println("   2.输入一本新书");
  	System.out.println("   3.删除一本旧书");
  	System.out.println("   4.查找");
  	System.out.println("   5.更新一本旧书信息");
  	System.out.println("   6.离开程序");
  }
  
  public static void printAllBookInfo() {
	  System.out.println("-----以下是所有书籍信息-----");
	  for(int i = 0; i < flag; i++) {
		  System.out.println(i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "元    " + book[i].press);
	  }
	  System.out.println("-----以上是所有书籍信息-----\n");
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
	  System.out.print("请输入待删除书籍编号:");
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  for(int i=n; i < flag; i++) {
		  book[i] = book[i + 1];
	  }
	  flag--;
	  System.out.println("删除成功！\n");
  }
  
  public static void queryBookInfo() {

	  System.out.println("请输入待查找的书籍名字:");
	  Scanner in = new Scanner(System.in);
	  String name = in.next();
	  for(int i = 0; i < flag; i++) {
		  if(name.equals(book[i].bookName)) {
			  System.out.println("以下是此书籍信息:");
			  System.out.println(i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "元    " + book[i].press);
			  break;
		  }
		  if(i == flag-1 && !name.equals(book[i].bookName)) 
			  System.out.println("没有该书籍信息!");
	  }
  }
  
  public static void updateOldBook() {
	  System.out.println("请输入待更新的书籍名字:");
	  Scanner in = new Scanner(System.in);
	  String name = in.next();
	  int num = 0;
	  for(int i = 0; i < flag; i++) {
		  if(name.equals(book[i].bookName)) {
			  System.out.println("原书籍信息:\n" + i + ". " + book[i].bookName + "\t " + book[i].authorName + "\t" + book[i].price + "   " + book[i].press);
			  num = i;
			  break;
		  }
		  if(i == flag-1 && !name.equals(book[i].bookName)) 
			  System.out.println("没有该书籍信息!");
	  }
	  System.out.println("\n1.修改名字  2.修改作者  3.修改单价  4.修改出版社\n");
	  System.out.print("请输入功能编号:");
	  int n = in.nextInt();
	  switch(n) {
	  	case 1:
	  		System.out.print("请输入修改后的名字:");
	  		String newName = in.next();
	  		book[num].bookName = newName;
	  		break;
	  	case 2:
	  		System.out.print("请输入修改后的作者:");
	  		String newAuthorName = in.next();
	  		book[num].authorName = newAuthorName;
	  		break;
	  	case 3:
	  		System.out.print("请输入修改后的单价:");
	  		int newPrice = in.nextInt();
	  		book[num].price = newPrice;
	  		break;
	  	case 4:
	  		System.out.print("请输入修改后的出版社:");
	  		String newPress = in.next();
	  		book[num].press = newPress;
	  		break;		
	  }
	  System.out.println("修改成功!");
  }
  
  public static void main(String[] args) {
 
  	int n;

  	for(int i=0; i < MAXSIZE; i ++) {
  		book[i] = new BookInfo();
  	}
  	newBookInfo("语文","李阳",20,"长江出版社");
  	newBookInfo("数学","王后雄",20,"长江出版社");
  	newBookInfo("英语","朱军",20,"长江出版社");
  	
  	Scanner in = new Scanner(System.in);
  	
  	printMenu();
  	
  	while(true) {
  		System.out.print("\n请输入菜单功能编号:");
  		n = in.nextInt();
  		switch(n) {
  		    case 1:
  		    	printAllBookInfo();
  		    	break;
  			case 2:
  				System.out.println("请输入书名(按回车继续):");
  				String bName = in.next();
  				System.out.println("请输入作者名(按回车继续):");
  				String aName = in.next();
  				System.out.println("请输入书本单价(按回车继续):");
  				int bPrice = in.nextInt();
  				System.out.println("请输入书本出版社(按回车继续):");
  				String bPress = in.next();
  				newBookInfo(bName,aName,bPrice,bPress);
  				System.out.println("新增成功！");
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
