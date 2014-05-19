package org.ghostengine.graphics;

/**
 * Represents a position in three-dimensional space using values <code>(x, y, x)</code>.
 * Uses floating-point precision.
 * 
 * @author Ben Turner
 * @version %I% %G%
 * @since 1.0
 */
public class Vertex {

	/**
	 * Contains the <code>[x, y, z]</code> coordinates of the point in floating-point
	 * precision.
	 */
	float[] tuple;

	/**
	 * Creates a new <code>Point</code> with the specified values.
	 * 
	 * @param tuple
	 *            the <code>[x, y, z]</code> coordinates of the Point.
	 */
	public Vertex(float[] tuple) {
		super();
		this.tuple = tuple;
	}
	
	/**
	 * Creates a new <code>Point</code> with the specified coordinates.
	 * 
	 * @param x the X value of the point.
	 * @param y the Y value of the point.
	 * @param z the Z value of the point.
	 */
	public Vertex(float x, float y, float z) {
		tuple = new float[] { x, y, z };
	}

	/**
	 * Gets the value of the tuple.</p>
	 * Tuple stores the Cartesian coordinates of this <code>Point</code>.
	 *
	 * @return the tuple.
	 */
	public float[] getTuple() {
		return tuple;
	}

	/**
	 * Sets the value of the tuple.</p>
	 * Tuple stores the Cartesian coordinates of this <code>Point</code>.
	 *
	 * @param tuple the new value of the tuple.
	 */
	public void setTuple(float[] tuple) {
		this.tuple = tuple;
	}
	
	/**
	 * Gets the <code>X</code> value stored in <code>tuple</code>.
	 * 
	 * @return the first value in <code>tuple</code>; the <code>X</code> coordinate.
	 */
	public float getX() {
		return tuple[0];
	}
	
	/**
	 * Sets the <code>X</code> value stored in <code>tuple</code>.
	 * @param x the new <code>X</code> value; the first value in <code>tuple</code>.
	 */
	public void setX(float x) {
		tuple[0] = x;
	}
	
	/**
	 * Gets the <code>Y</code> value stored in <code>tuple</code>.
	 * 
	 * @return the second value in <code>tuple</code>; the <code>Y</code> coordinate.
	 */
	public float getY() {
		return tuple[1];
	}
	
	/**
	 * Sets the <code>Y</code> value stored in <code>tuple</code>.
	 * @param y the new <code>Y</code> value; the second value in <code>tuple</code>.
	 */
	public void setY(float y) {
		tuple[1] = y;
	}
	
	/**
	 * Gets the <code>Z</code> value stored in <code>tuple</code>.
	 * 
	 * @return the third value in <code>tuple</code>; the <code>Z</code> coordinate.
	 */
	public float getZ() {
		return tuple[2];
	}
	
	/**
	 * Sets the <code>Z</code> value stored in <code>tuple</code>.
	 * @param z the new <code>Z</code> value; the third value in <code>tuple</code>.
	 */
	public void setZ(float z) {
		tuple[2] = z;
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
	
	public Vector subtractPoint(Vertex p) {
		return new Vector(getX() - p.getX(), getY() - p.getY(), getZ() - p.getZ());
	}
}
