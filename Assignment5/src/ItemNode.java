package Assignment5.src;

public class ItemNode implements ItemInterface, Comparable<ItemNode>{
	int num_of_trans=0;
	int key=1;
	float key2=0;
	int itemId;
	String itemName;
	int stock;
	LinkedList<PurchaseNode> purchaseTransactions;
	DateNode latest;
	public ItemNode(int itemId, String itemName, int stock){
		this.itemId = itemId;
		this.itemName = itemName;
		this.stock = stock;
		this.purchaseTransactions=new LinkedList<PurchaseNode>();
		this.latest=new DateNode(1, 8, 1970);
		//this.purchaseTransactions.add(new PurchaseNode(0, 1, 8, 1970));
	}

	public int getItemId(){
		//Enter your code here
		return this.itemId;
	}

	public  String getItemName(){
		//Enter your code here
		return this.itemName;
	}

	public int getStockLeft(){
		//Enter your code here
		return this.stock;
	}

	public void addTransaction(PurchaseNode purchaseT){
		//Enter your code here
		/*
		if(num_of_trans==0) {
			this.purchaseTransactions=new LinkedList<PurchaseNode>();
		}
		*/
		purchaseTransactions.add(purchaseT);
		this.stock-=purchaseT.numItemPurchased;		
		this.num_of_trans+=1;
		if(num_of_trans==1) {
			latest=purchaseT.dateobj;
		}
		else {
			if(purchaseT.dateobj.compareTo(latest)>0) {
				latest=purchaseT.dateobj;
			}
		}
	}

	public Node<PurchaseNode> getPurchaseHead(){
		//Enter your code here
		return purchaseTransactions.getHead();
	}

	@Override
	public int compareTo(ItemNode o) {
		// TODO Auto-generated method stub
		if(this.key==1) {
			int temp=this.latest.compareTo(o.latest);
			if(temp==0) {
				temp=o.itemName.compareTo(this.itemName);
			}
			return temp;
		}
		else if(this.key==2) {
			if(this.key2>o.key2) {
				return 1;
			}
			else if (this.key2<o.key2) {
				return -1;		
			}
			else {
				int temp= o.itemName.compareTo(this.itemName);
				return temp;
			}
		}
		else if(this.key==3) {
			
			if(this.stock>o.stock) {
				return -1;
			}
			else if (this.stock<o.stock) {
				return 1;
					
			}
			else {
				return o.itemName.compareTo(this.itemName);
				
			}
			
		}
		else if(this.key==4) {
			int temp=-this.latest.compareTo(o.latest);
			if(temp==0) {
				temp=o.itemName.compareTo(this.itemName);
			}
			return temp;
		}
		return 0;
	}

}
