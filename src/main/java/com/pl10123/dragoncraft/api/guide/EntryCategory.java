package com.pl10123.dragoncraft.api.guide;

import java.util.ArrayList;

public class EntryCategory implements Comparable<EntryCategory> {
	
	public static String categoryName;
	public static int priority;
	private static int count = 0;
	public static int loadedNumber;
	
	
	
	
	/**
	 * Create a new EntryCategory like this. It must have a priority for load order. Higher priorities come first.
	 * If two priorities are equal, vanilla ones go first, then the rest depend on load order.
	 * @param categoryName The unlocalized name for the category.
	 * @param Priority The category's priority.
	 */
	public EntryCategory(String categoryName, int Priority){
		this.categoryName = categoryName;
		this.priority = Priority;
		this.loadedNumber = count;
		count++;
	}
	
	
	

	public static String getCategoryName() {
		return categoryName;
	}




	public static void setCategoryName(String categoryName) {
		EntryCategory.categoryName = categoryName;
	}




	public static int getPriority() {
		return priority;
	}




	public static void setPriority(int priority) {
		EntryCategory.priority = priority;
	}




	@Override
	public int compareTo(EntryCategory ec) {
		return priority == ec.priority ? loadedNumber - ec.loadedNumber : ec.priority - priority;
	}
	
	

	
}
