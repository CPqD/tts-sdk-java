package br.com.cpqd.tts;

public abstract class SynthesisListener
{

	public enum Order
	{
		FIRST,
		INTERMEDIATE,
		LAST
	};

	//private static final int ORDER_FIRST = 0x01;
	//private static final int ORDER_INTERMEDIATE = 0x02;
	//private static final int ORDER_LAST = 0x03;
	
	/*protected boolean receivedAudio(byte[] buffer, Order order,
			Object object)
	{
		Order temp = Order.INTERMEDIATE;
		
		if (order == ORDER_FIRST)
			temp = Order.FIRST;
		else if (order == ORDER_LAST)
			temp = Order.LAST;
		else
			temp = Order.INTERMEDIATE;
		
		return receivedAudio(buffer, temp, object);
	}*/
	
	public abstract boolean receivedAudio(byte[] buffer, Order order,
			Object object);

}
