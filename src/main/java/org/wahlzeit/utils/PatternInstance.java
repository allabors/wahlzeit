package org.wahlzeit.utils;

public @interface PatternInstance {
	String patternName() default "N/A";
	String[] participants() default {"N/A"};
}
