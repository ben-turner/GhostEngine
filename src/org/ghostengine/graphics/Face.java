/**
 * 
 */
package org.ghostengine.graphics;

/**
 * @author Ben Turner
 * @version 
 * @since 
 */
public class Face {

	Vertex[] verts = new Vertex[3];
	
	public Face(Vertex[] verts) {
		this.verts = verts;
	}
	
	public Vertex[] getInnerVerts() {
		return verts;
	}
}
