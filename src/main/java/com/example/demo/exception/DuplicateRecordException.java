package com.example.demo.exception;

public class DuplicateRecordException   extends RuntimeException
{
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}

