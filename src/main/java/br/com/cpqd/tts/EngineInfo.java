package br.com.cpqd.tts;

public class EngineInfo
{

	private VersionInfo version;

	private int maxSessions;

	private String customerName;

	private int capabilities;

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

	@Override
	public String toString()
	{
		return "TTS_ENGINE_INFO [version='" + version + "', maxSessions='"
				+ maxSessions + "', customerName='" + customerName
				+ "', capabilities='" + capabilities + "']";
	}

}
