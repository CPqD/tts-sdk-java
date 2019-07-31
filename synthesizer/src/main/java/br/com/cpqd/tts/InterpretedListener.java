package br.com.cpqd.tts;

public abstract class InterpretedListener
{
	private InterpretedListenerData listenerData;	
	
	
	public InterpretedListener() {
		listenerData = null;
	}
	
	public InterpretedListener (String name, boolean toNormalize, Object data) {
		listenerData = new InterpretedListenerData(name, toNormalize, data);
	}
	
	public InterpretedListenerData getListenerData() {
		return listenerData;
	}
	
	public abstract String callback(String input, Object data);

}
