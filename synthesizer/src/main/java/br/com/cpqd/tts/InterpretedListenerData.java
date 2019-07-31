package br.com.cpqd.tts;

public class InterpretedListenerData
{
	private String name;
	
	private boolean toNormalize;
	
	private Object data;
	
	
	public InterpretedListenerData(String name, boolean toNormalize, Object data)
	{
		this.name = name;
		this.toNormalize = toNormalize;
		this.data = data;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isToNormalize() {
		return toNormalize;
	}


	public void setToNormalize(boolean toNormalize) {
		this.toNormalize = toNormalize;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
