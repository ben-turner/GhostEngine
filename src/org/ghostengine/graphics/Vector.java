package org.ghostengine.graphics;

/**
 * Represents a vector in three-dimensional space using values <code>(a, b, c)</code>.
 * Uses floating-point precision.
 * 
 * @author Ben Turner
 * @version %I% %G%
 * @since 1.0
 */
public class Vector {

	/**
	 * Contains the <code>[a, b, c]</code> values of the vector in floating-point
	 * precision.
	 */
	float[] tuple;

	/**
	 * Creates a new <code>Vector</code> with the specified values.
	 * 
	 * @param tuple
	 *            the <code>[a, b, c]</code> values of the Vector.
	 */
	public Vector(float[] tuple) {
		super();
		this.tuple = tuple;
	}
	
	/**
	 * Creates a new <code>Vector</code> with the specified values.
	 * 
	 * @param a the A value of the vector.
	 * @param b the B value of the vector.
	 * @param c the C value of the vector.
	 */
	public Vector(float a, float b, float c) {
		tuple = new float[] { a, b, c };
	}

	/**
	 * Gets the value of the tuple.</p>
	 * Tuple stores the <code>[a, b, c]</code> values of this <code>Vector</code>.
	 *
	 * @return the tuple.
	 */
	public float[] getTuple() {
		return tuple;
	}

	/**
	 * Sets the value of the tuple.</p>
	 * Tuple stores the <code>[a, b, c]</code> values of this <code>Vector</code>.
	 *
	 * @param tuple the new value of the tuple.
	 */
	public void setTuple(float[] tuple) {
		this.tuple = tuple;
	}
	
	/**
	 * Gets the <code>a</code> value stored in <code>tuple</code>.
	 * 
	 * @return the a value; the first value of <code>tuple</code>.
	 */
	public float getA() {
		return tuple[0];
	}
	
	/**
	 * Sets the <code>a</code> value stored in <code>tuple</code>.
	 * @param a the new <code>a</code> value; the first value of <code>tuple</code>.
	 */
	public void setA(float a) {
		tuple[0] = a;
	}
	
	/**
	 * Gets the <code>b</code> value stored in <code>tuple</code>.
	 * 
	 * @return the b value; the second value of <code>tuple</code>.
	 */
	public float getB() {
		return tuple[1];
	}
	
	/**
	 * Sets the <code>b</code> value stored in <code>tuple</code>.
	 * @param b the new <code>b</code> value; the second value of <code>tuple</code>.
	 */
	public void setB(float b) {
		tuple[1] = b;
	}
	
	/**
	 * Gets the <code>c</code> value stored in <code>tuple</code>.
	 * 
	 * @return the c value; the third value of <code>tuple</code>.
	 */
	public float getC() {
		return tuple[2];
	}
	
	/**
	 * Sets the <code>c</code> value stored in <code>tuple</code>.
	 * @param c the new <code>c</code> value; the third value of <code>tuple</code>.
	 */
	public void setC(float c) {
		tuple[2] = c;
	}
	
	public void addVector(Vector v) {
		tuple[0] += v.getA();
		tuple[1] += v.getB();
		tuple[2] += v.getC();
	}
	
	public void subtractVector(Vector v) {
		tuple[0] -= v.getA();
		tuple[1] -= v.getB();
		tuple[2] -= v.getC();
	}
}
