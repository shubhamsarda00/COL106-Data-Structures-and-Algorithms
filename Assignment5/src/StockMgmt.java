package Assignment5.src;


public class StockMgmt implements StockMgmtInterface {
	//!!!!!!!*********DON'T CREATE YOUR OWN OBJECTS OF LLMergeSort*********!!!!!!!
	//use these only this object to sort
	LLMergeSort mergeSortobj;

	LinkedList<CategoryNode> categories;
	/*public static void main(String[] args) {
		
		/*
		DateNode d1= new DateNode(1,1,2000);
		DateNode d2= new DateNode(1,1,2000);
		ItemNode i1= new ItemNode(11,"item21",20);
		ItemNode i2= new ItemNode(12,"item21",20);
		i1.addTransaction(new PurchaseNode(1,1,1,2000));
		i1.addTransaction(new PurchaseNode(1,1,1,2001));
		i2.addTransaction(new PurchaseNode(1,1,1,2000));
		i2.addTransaction(new PurchaseNode(1,1,1,2008));
		i2.addTransaction(new PurchaseNode(1,1,1,2038));
		System.out.println(i2.latest.year);
		
		System.out.println(i1.compareTo(i2));
		*/
	
		/*
		StockMgmt s = new StockMgmt();
		s.addItem(1, 1, "item11", 100);
		s.addItem(1, 1, "item12", 100);
		s.addItem(2, 1, "item21", 100);
		s.addItemTransaction(1, 1, "item11", 10, 10, 3, 2006);
		s.addItemTransaction(1, 1, "item11", 10, 25, 1, 1998);
		s.addItemTransaction(1, 2, "item12", 10, 10, 3, 2006);
		s.addItemTransaction(2, 1, "item21", 10, 25, 1, 2008);
		LinkedList<ItemNode> sort=s.sortByPurchasePeriod(10, 3, 2006, 10, 3, 2006);
		Node<ItemNode> current = sort.getHead();
	    
	    while (current != null) {
	      System.out.println(current.data.itemId+" " +current.data.itemName+" " +current.data.stock);
	      current = current.getNext();
	    }
		*/
		/*
		StockMgmt s = new StockMgmt();
		s.addItem(1, 1, "item11", 100);
		s.addItem(1, 1, "item12", 250);
		s.addItem(2, 1, "item21", 100);
		s.addItem(2, 2, "item22", 300);
		s.addItem(3, 1, "item31", 200);
		s.addItem(3, 2, "item32", 260);
		s.addItem(3, 3, "item33", 500);
		s.addItem(4, 1, "item41", 1000);
		s.addItem(4, 2, "item42", 400);
		s.addItem(5, 1, "item51", 300);
		s.addItemTransaction(1, 1, "item11", 10, 10, 3, 2000);
		s.addItemTransaction(1, 2, "item12", 20, 20, 6, 2005);
		s.addItemTransaction(2, 1, "item21", 15, 25, 1, 1998);
		s.addItemTransaction(2, 2, "item22", 35, 16, 10, 1997);
		s.addItemTransaction(3, 1, "item31", 20, 9, 12, 1996);
		s.addItemTransaction(3, 3, "item33", 30, 16, 2, 1998);
		s.addItemTransaction(3, 2, "item32", 5, 2, 5, 2010);
		s.addItemTransaction(4, 1, "item41", 6, 18, 7, 1997);
		s.addItemTransaction(4, 2, "item42", 10, 26, 9, 2009);
		s.addItemTransaction(5, 1, "item51", 25, 6, 11, 2006);
		s.addItemTransaction(1, 2, "item12", 15, 1, 10, 2000);
		s.addItemTransaction(3, 3, "item33", 50, 26, 5, 2016);
		s.addItemTransaction(4, 1, "item41", 8, 10, 7, 1998);
		s.addItemTransaction(4, 2, "item42", 12, 26, 8, 1999);
		s.addItemTransaction(5, 1, "item51", 21, 6, 10, 2008);
		s.addItemTransaction(3, 2, "item32", 5, 28, 8, 2011);
		s.addItemTransaction(2, 2, "item22", 5, 16, 1, 2010);
		s.addItemTransaction(1, 1, "item11", 16, 10, 5, 1995);
		//LinkedList<ItemNode> sort=s.sortByLastDate();
		LinkedList<ItemNode> sort=s.sortByPurchasePeriod(1, 1, 2000, 11, 6, 2020);
		Node<ItemNode> current = sort.getHead();
	    
	    while (current != null) {
	      System.out.println(current.data.itemId+" " +current.data.itemName+" " +current.data.stock);
	      current = current.getNext();
	    }
	    */
	    /*
	    
	    LinkedList<ItemNode> l= s.checkMergeSort();
	    Node<ItemNode> curr = l.getHead();
	    
	    while (curr != null) {
	      System.out.println(curr.data.itemId+" " +curr.data.itemName+" " +curr.data.stock);
	      curr = curr.getNext();
	    }
		*/
		
		
		
	//}
	//DO NOT MNODIFY THIS CONSTRUCTOR
	public StockMgmt() {

		mergeSortobj = new LLMergeSort();
		categories = new LinkedList<CategoryNode>();
		
		categories.add(new CategoryNode(1, "mobile"));
		categories.add(new CategoryNode(2, "utensils"));
		categories.add(new CategoryNode(3, "sanitary"));
		categories.add(new CategoryNode(4, "medicalEquipment"));
		categories.add(new CategoryNode(5, "clothes"));
		
	}

	public void addItem(int categoryId, int itemId, String itemName, int stock) {
		//Your code goes here
		ItemNode n = new ItemNode(itemId, itemName, stock);
		Node<CategoryNode> head= categories.getHead();
		
		for(int i=0;i<categoryId-1;i++) {
			head=head.getNext();				
		}
		
		/*while(head.getData().categoryId!=categoryId ) {
			head=head.next;
		}
		*/
		head.getData().getLinkedListOfCategory().add(n);
		
		
				
				
	}

	public void addItemTransaction(int categoryId, int itemId, String itemName, int numItemPurchased, int day, int month, int year) {
		//Your code goes here
		Node<CategoryNode> head= categories.getHead();
		
		for(int i=0;i<categoryId-1;i++) {
			head=head.getNext();				
		}
		Node<ItemNode> n= head.getData().getLinkedListOfCategory().getHead();
		ItemNode i= n.getData();
				
		while(n!=null && i.getItemId()!=itemId && i.getItemName()!=itemName) {
			n=n.getNext();
			i=n.getData();
		}
		i.addTransaction(new PurchaseNode(numItemPurchased, day, month, year));
		
	}

	//Query 1
	public LinkedList<ItemNode> sortByLastDate() {
		//Your code goes here
		
		LinkedList<ItemNode> l = new LinkedList<ItemNode>();
		Node<CategoryNode> c=this.categories.getHead();
			
		while(c!=null) {
			
			Node<ItemNode> in = c.getData().itemList.getHead();
			while(in!=null) {
				ItemNode i=new ItemNode(in.data.itemId,in.getData().itemName,in.getData().stock);
				i.key=1;
				i.purchaseTransactions=in.getData().purchaseTransactions;
				i.latest=in.data.latest;
				i.num_of_trans=in.data.num_of_trans;
				l.add(i);
				in=in.getNext();
			}
			c=c.getNext();
		}
		l=mergeSortobj.MergeSort(l);
		return l;
		
	}

	//Query 2
	public LinkedList<ItemNode> sortByPurchasePeriod(int day1, int month1, int year1, int day2, int month2, int year2) {
		//Your code goes here
		DateNode start=new DateNode(day1,month1,year1);
		DateNode end=new DateNode(day2,month2,year2);
		LinkedList<ItemNode> l = new LinkedList<ItemNode>();
		Node<CategoryNode> c=this.categories.getHead();
			
		while(c!=null) {
			
			Node<ItemNode> in = c.getData().itemList.getHead();
			while(in!=null) {
				ItemNode i=new ItemNode(in.data.itemId,in.getData().itemName,in.getData().stock);
				i.key=2;
				i.purchaseTransactions=in.getData().purchaseTransactions;
				
				if(in.data.num_of_trans==0) {
					i.key2=0;
				}
				else {
					Node<PurchaseNode> pn = i.purchaseTransactions.getHead();
					PurchaseNode p=pn.getData();
					float numpurchases=0;
					int firstyear=Integer.MAX_VALUE;
					int lastyear=Integer.MIN_VALUE;
					boolean b=false;		
					while(pn!=null) {
						p=pn.getData();
						DateNode d=p.dateobj;
						if(d.compareTo(start)>=0 && d.compareTo(end)<=0) {
							b=true;
							numpurchases+=p.numItemPurchased;
							if(d.year>lastyear) {
								lastyear=d.year;
							}
							if(d.year<firstyear) {
								firstyear=d.year;
							}
							
						}
						pn=pn.getNext();
					}
					if(b) {
					i.key2=numpurchases/(lastyear-firstyear+1);
					}
					else {
						i.key2=0;
					}
				}
				
				i.latest=in.data.latest;
				i.num_of_trans=in.data.num_of_trans;
				l.add(i);
				in=in.getNext();
			}
			c=c.getNext();
		}
		l=mergeSortobj.MergeSort(l);
		return l;
		
		
	}

	//Query 3
	public LinkedList<ItemNode> sortByStockForCategory(int category) {
		//Your code goes here
		LinkedList<ItemNode> l = new LinkedList<ItemNode>();
		Node<CategoryNode> c=this.categories.getHead();
		for(int i=0;i<category-1;i++) {
			c=c.getNext();				
		}
		Node<ItemNode> in = c.getData().itemList.getHead();
		while(in!=null) {
			ItemNode i=new ItemNode(in.data.itemId,in.getData().itemName,in.getData().stock);
			i.key=3;
			i.purchaseTransactions=in.getData().purchaseTransactions;
			i.latest=in.data.latest;
			i.num_of_trans=in.data.num_of_trans;
			l.add(i);
			in=in.getNext();
		}
		
		l=mergeSortobj.MergeSort(l);
		return l;
	}

	//Query 4
	public LinkedList<ItemNode> filterByCategorySortByDate(int category) {
		//Your code goes here
		LinkedList<ItemNode> l = new LinkedList<ItemNode>();
		Node<CategoryNode> c=this.categories.getHead();
		for(int i=0;i<category-1;i++) {
			c=c.getNext();				
		}
		Node<ItemNode> in = c.getData().itemList.getHead();
		while(in!=null) {
			ItemNode i=new ItemNode(in.data.itemId,in.getData().itemName,in.getData().stock);
			i.key=4;
			i.purchaseTransactions=in.getData().purchaseTransactions;
			i.latest=in.data.latest;
			i.num_of_trans=in.data.num_of_trans;
			l.add(i);
			in=in.getNext();
		}
		
		l=mergeSortobj.MergeSort(l);
		return l;
	}

	//!!!!!*****DO NOT MODIFY THIS METHOD*****!!!!!//
	public LinkedList<ItemNode> checkMergeSort() {
		LinkedList<ItemNode> retLst = mergeSortobj.getGlobalList();
		mergeSortobj.clearGlobalList();
		return retLst;
	}
}
