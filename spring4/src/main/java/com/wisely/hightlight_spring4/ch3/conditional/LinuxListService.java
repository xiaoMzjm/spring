package com.wisely.hightlight_spring4.ch3.conditional;

public class LinuxListService implements ListService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
