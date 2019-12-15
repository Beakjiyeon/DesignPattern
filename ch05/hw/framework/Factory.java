package ch05.hw.framework;

public abstract class Factory {
	public final Product create(String name){
		Product p = createProduct(name);
		registerProduct(p);
		return p;
	}
	
	protected abstract Product createProduct(String owner); //추상화 방법
    protected abstract void registerProduct(Product product);
}
