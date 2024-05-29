package com.library.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class BarrowAndReturn {

	private Book barrowBook;
	private LibMember member;
	private LocalDate barrowdate;
	private LocalDate returndate;
	private Map<LibMember,Book> barrowmap = new HashMap<>();
}
