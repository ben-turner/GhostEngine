package org.ghostengine.base;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GameInfo {
	String Name();
	String Description();
	double Version() default 1.0;
	String Author();
	String Website() default "";
}
