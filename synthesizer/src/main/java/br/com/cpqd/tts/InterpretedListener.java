package br.com.cpqd.tts;

public interface InterpretedListener
{

	public abstract String callback(String input, Object data);
	
	//public abstract void callback(Object context, String input, InterpretedOutputListener output, Object data);

	public abstract String getName();
	
	public abstract String getFormat();
	
	public abstract Object getData();
	
	public abstract boolean isNormalized();
	
}
