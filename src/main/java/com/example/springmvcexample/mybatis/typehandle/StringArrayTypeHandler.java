package com.example.springmvcexample.mybatis.typehandle;


public class StringArrayTypeHandler extends StringTokenizerTypeHandler<String>{
    public StringArrayTypeHandler() {
        super(String.class);
    }
//	public StringArrayTypeHandler(Class<String> clazz) {
//		super(clazz);
//	}

    @Override
    public String parseString(String value) {
        return value;
    }

}
