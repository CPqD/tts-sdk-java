package br.com.cpqd.tts;

public class EngineInfo
{

	private VersionInfo version;

	private int maxSessions;

	private String customerName;

	private int capabilities;
	
	private int currentSessions;

	protected EngineInfo()
	{
		version = new VersionInfo();
	}

	/**
	 * Returns the product version.
	 */
	public VersionInfo getVersion()
	{
		return version;
	}

	/**
	 * Returns the maximum number of synthesis sessions that could exist simultaneously.
	 */
	public int getMaxSessions()
	{
		return maxSessions;
	}

	/**
	 * Returns the name of the customer for which the TTS engine was built.
	 */
	public String getCustomerName()
	{
		return customerName;
	}

	public int getCapabilities()
	{
		return capabilities;
	}
	
	public int getCurrentSessions()
	{
		return currentSessions;
	}

	@Override
	public String toString() {
		return "EngineInfo [version=" + version + ", maxSessions=" + maxSessions + ", customerName=" + customerName
				+ ", capabilities=" + capabilities + ", currentSessions=" + currentSessions + "]";
	}

}
