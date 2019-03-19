package com.lms.util;

public class Constants {
	
	// COMMON COLUMNS IN ALL TABLES
	public final static String COL_ACTIVE = "active";
	public final static String COL_CREATED_BY = "created_by";
	public final static String COL_CREATED_DATE = "created_date";
	public final static String COL_MODIFIED_BY = "modified_by";
	public final static String COL_MODIFIED_DATE = "modified_date";
	
	// USER TABLE Column Names
	public final static String COL_USER_USERNAME = "username";
	public final static String COL_USER_PASSWORD = "password";
	public final static String COL_USER_USERID = "user_id";
	public final static String COL_USER_FK_USERTYPE_ID = "fk_user_type_id";
	public final static String COL_USER_FK_SUSCRIBER_ID = "fk_suscriber_id";
	
	// USER_TYPE TABLE Column Names
	public final static String COL_USERTYPE_USERTYPE_ID = "user_type_id";
	public final static String COL_USERTYPE_TYPE = "type";
	
	// BOOK TABLE Column Names
	public final static String COL_BOOK_BOOKID = "book_id";
	public final static String COL_BOOK_CONTENT = "content";
	public final static String COL_BOOK_TITLE = "title";
	public final static String COL_BOOK_MAX_BORROW = "max_borrow";
	public final static String COL_BOOK_AUTHOR = "author";
	public final static String COL_BOOK_QUANTITY = "quantity";
	public final static String COL_BOOK_PICTURE = "picture";
	
	
	// SUSCRIBER TABLE Column Names
	public final static String COL_SUSCRIBER_SUSCRIBER_ID = "suscriber_id";
	public final static String COL_SUSCRIBER_NAME = "name";
	public final static String COL_SUSCRIBER_CONTACT = "contact";
	public final static String COL_SUSCRIBER_ADDRESS = "address";
	public final static String COL_SUSCRIBER_EMAIL = "email";
	public final static String COL_SUSCRIBER_PASSWORD = "password";
	public final static String COL_SUSCRIBER_QOUTA = "qouta";
	public final static String COL_SUSCRIBER_APPROVAL_STATUS = "approval_status";
	public final static String COL_SUSCRIBER_STATUS = "status";
	
	// BOOK_RESERVE TABLE Column Names
	public final static String COL_BOOKASSIGN_BOOKRESERVE_ID = "book_reserve_id";
	public final static String COL_BOOKASSIGN_FK_BOOK_ID = "fk_book_id";
	public final static String COL_BOOKASSIGN_FK_SUSCRIBER_ID = "fk_suscriber_id";
	public final static String COL_BOOKASSIGN_WARNINGS = "warnings";
	public final static String COL_BOOKASSIGN_RESERVE_DATE = "reserve_date";
	public final static String COL_BOOKASSIGN_RETURN_DATE = "return_date";
	public final static String COL_BOOKASSIGN_BOOK_RETURN = "book_return";
}
