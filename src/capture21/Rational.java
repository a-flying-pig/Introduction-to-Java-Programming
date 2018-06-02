package capture21;import javax.security.auth.x500.X500Principal;

public class Rational extends Number {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double value;
	int a;
	int b;
	
	public Rational(int a, int b) {
		// TODO Auto-generated constructor stub
		if (b == 0) {
			System.out.println("b can not be 0");
			return;
		}
		//  
		
		this.a = a;
		this.b = b;
		
		value = a / b;
	}
	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float)value;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return (int)value;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long)value;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	@Override
	public String toString() {
		return a + "/" + b;
	}
	
	public Rational add (Rational rational) {
		int x;
		int y;
		x = a * rational.getB() + rational.getA() * b;
		y = b * rational.getB();
		return new Rational(x, y);
	}
	
	public Rational multiply(Rational rational) {
		return new Rational(a * rational.getA(), b * rational.getB());
	}

}
