/**
 * Demonstration of Compostion with Interfaces
 * 
 */

package inheri_composition;

interface Taxable {

	public double calcTax();
}

class Asset {

	private double value;

	// This method will be completed according to the taxrate

	public Asset(double value) {
		this.value = value;
	}

	public double calcTax() {
		return value * 1.0;
	}

}

class SaleItem {

	private double price;

	public SaleItem(double price) {
		this.price = price;
	}

	// This method will be completed according to the taxrate

	public double calcTax() {
		return price * 0.08;
	}
}

class Property implements Taxable {

	//has-a relation
	private Asset asset;
	//has-a relation
	public Property(Asset asset) {
		this.asset = asset;
	}

	public double calcTax() {
		return asset.calcTax();
	}

}

class Commodity implements Taxable {

	//has-a relation
	private SaleItem item;
	//has-a relation
	public Commodity(SaleItem item) {
		this.item = item;
	}

	public double calcTax() {
		return item.calcTax();
	}

}

public class CompositionWithInterfaces {
	public static void main(String args[]) {

		Taxable[] items = new Taxable[2];

		Asset stocks = new Asset(10000);
		SaleItem sitem = new SaleItem(500.00);

		items[0] = new Property(stocks);
		items[1] = new Commodity(sitem);
		
		for (int i = 0; i < items.length; ++i)
            System.out.println (items[i].calcTax());

	}
}