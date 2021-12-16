package br.com.cpqd.tts;

public abstract class InterpretedListener
{
	private InterpretedListenerData listenerData;	
	
	
	public InterpretedListener() {
		listenerData = null;
	}
	
	public InterpretedListener (String name, boolean normalize, Object data) {
		listenerData = new InterpretedListenerData(name, normalize, data);
	}
	
	public InterpretedListenerData getListenerData() {
		return listenerData;
	}
	
	public abstract String callback(String input, Object data);

}
