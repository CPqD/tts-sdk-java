package br.com.cpqd.tts;

public class InterpretedListenerData
{
	private String name;
	
	private boolean normalize;
	
	private Object data;
	
	
	public InterpretedListenerData(String name, boolean normalize, Object data)
	{
		this.name = name;
		this.normalize = normalize;
		this.data = data;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isNormalize() {
		return normalize;
	}


	public void setNormalize(boolean normalize) {
		this.normalize = normalize;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
