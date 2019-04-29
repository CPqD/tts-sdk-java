package br.com.cpqd.tts;

public interface InterpretedListener
{

	public abstract String callback(String input, Object data);
	
	//public abstract void callback(Object context, String input, InterpretedOutputListener output, Object data);

}
