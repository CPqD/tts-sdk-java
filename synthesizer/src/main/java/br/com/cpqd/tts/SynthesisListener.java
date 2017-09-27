package br.com.cpqd.tts;

public interface SynthesisListener
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
