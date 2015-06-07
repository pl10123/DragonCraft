package com.pl10123.dragoncraft.api.guide;

import java.util.ArrayList;

public class GuideHelper {
	
	public static ArrayList<EntryCategory> categoryList = new ArrayList<EntryCategory>();
	
	
	
	
	
	
	/**
	 * required method to register in the guide. Call in preInit or init
	 * @param ec The EntryCategory to register in the list of categories.
	 */
	public static void registerCattoList(EntryCategory ec){
		categoryList.add(ec);
	}
	
	public static ArrayList<EntryCategory> getCategoryList(){
		return categoryList;
	}
	
	


}
