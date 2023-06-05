package com.comparator;

import java.util.Comparator;

import com.model.UserDetails;

public class SortUserDetailsById implements Comparator<UserDetails> {

	@Override
	public int compare(UserDetails o1, UserDetails o2) {
		return o1.getId() - o2.getId();
	}

}
