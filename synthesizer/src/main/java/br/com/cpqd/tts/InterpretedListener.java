package br.com.cpqd.tts;

public interface InterpretedListener
{

	public abstract void callback(Object context, String input,
			InterpretedOutputListener listener, Object data);

}
