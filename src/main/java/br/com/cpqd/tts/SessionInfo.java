package br.com.cpqd.tts;

public class SessionInfo
{

	private String voiceName;

	private int synthesisCount;

	private int synthesisTime;

	protected SessionInfo()
	{
	}
	
	/**
	 * Returns the name of the voice in use.
	 */
	public String getVoiceName()
	{
		return voiceName;
	}

	/**
	 * Returns the number speech synthesis performed with the session.
	 */
	public int getSynthesisCount()
	{
		return synthesisCount;
	}

	/**
	 * Returns the number of milliseconds of speech generated with the session.
	 */
	public int getSynthesisTime()
	{
		return synthesisTime;
	}

	@Override
	public String toString()
	{
		return "SessionInfo [voiceName='" + voiceName + "', synthesisCount='" + synthesisCount
				+ "', synthesisTime='" + synthesisTime + "']";
	}

}
