package br.com.cpqd.tts;


public class AudioInfo
{

	private int duration;

	private int length;

	private int bitsPerSample;

	private int channels;

	private int sampleRate;

	protected AudioInfo()
	{
	}

	/**
	 * Returns the amount of speech (in miliseconds).
	 *
	 * The audio duration is given by the following equation:
	 *
	 * Duration = Length / (BitsPerSample / 8 * Channels * SampleRate / 1000);
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * Returns the number of bytes occupied by the synthesized speech.
	 *
	 * This is the same value returned by {@link SynthesisSession.getAudioLength} function.
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * Returns the number of bits per sample.
	 */
	public int getBitsPerSample()
	{
		return bitsPerSample;
	}

	/**
	 * Returns the number of channels.
	 */
	public int getChannels()
	{
		return channels;
	}

	/**
	 * Returns the sample rate.
	 */
	public int getSampleRate()
	{
		return sampleRate;
	}

	@Override
	public String toString()
	{
		return "AudioInfo [duration=" + duration + ", length=" + length
				+ ", bitsPerSample=" + bitsPerSample + ", channels=" + channels
				+ ", sampleRate=" + sampleRate + "]";
	}
}
