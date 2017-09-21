package br.com.cpqd.tts;

public class EncoderInfo
{

	String name;
	
	String description;
	
	String codec;

	int sampleRate;
	
	int bitsPerSample;
	
	int channels;
	
	int flags;

	protected EncoderInfo()
	{
	}

	/**
	 * Returns the encoder name.
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the encoder description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Returns the name of the algorithm used by the encoder.
	 */
	public String getCodec()
	{
		return codec;
	}
	
	/**
	 * Returns the sample rate used by the encoder.
	 */
	public int getSampleRate()
	{
		return sampleRate;
	}

	/**
	 * Returns the bits per sample used by the encoder.
	 */
	public int getBitsPerSample()
	{
		return bitsPerSample;
	}

	/**
	 * Returns the number of channels used by the encoder.
	 */
	public int getChannels()
	{
		return channels;
	}

	public int getFlags()
	{
		return flags;
	}

}
