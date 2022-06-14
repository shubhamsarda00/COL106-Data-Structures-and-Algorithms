package Assignment5.src;

interface ItemInterface{

	int getItemId();
	String getItemName();
	int getStockLeft();

	Node<PurchaseNode> getPurchaseHead();

}
