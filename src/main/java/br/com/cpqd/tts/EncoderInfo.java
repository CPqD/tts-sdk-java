package br.com.cpqd.tts;

public class EncoderInfo
{

	private String name;

	private String description;

	private String codec;

	private int sampleRate;

	private int bitsPerSample;

	private int channels;

	private int flags;

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

	@Override
	public String toString()
	{
		return "EncoderInfo [name=" + name
				+ ", description=" + description
				+ ", codec=" + codec
				+ ", sampleRate=" + sampleRate
				+ ", bitsPerSample=" + bitsPerSample
				+ ", channels=" + channels
				+ ", flags=" + flags + "]";
	}
}
