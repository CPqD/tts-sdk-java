package br.com.cpqd.tts;

public abstract class SynthesisListener
{

	public enum Order
	{
		FIRST,
		INTERMEDIATE,
		LAST
	};
	
	public abstract boolean receivedAudio(byte[] buffer, Order order,
			Object object);

}
