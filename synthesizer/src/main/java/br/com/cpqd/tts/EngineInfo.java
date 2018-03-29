package br.com.cpqd.tts;

public class EngineInfo
{

	private VersionInfo version;

	private int maxSessions;

	private String customerName;

	private int capabilities;

	private int currentSessions;

	private int operationState;

	private long remainingTime;

	private int communicationErrors;

	private long synthesisCount;

	private long synthesisTime;

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

	/**
     * Maximum number of synthesis sessions that currently exists.
     */
	public int getCurrentSessions()
	{
		return currentSessions;
	}

    /**
     * State in which the TTS engine is operating.
     */
	public OperationState getOperationState()
	{
		return OperationState.from(operationState);
	}

	/**
	 * Remaining time until the product is blocked.
	 *
	 * Time in milliseconds if in ONLINE or OFFLINE state; zero if in BLOCKED state.
	 * In ONLINE state the time never decrease.
	 */
	public long getRemainingTime()
	{
		return remainingTime;
	}

	/**
     * Number of communication errors.
     */
	public int getCommunicationErrors()
	{
		return communicationErrors;
	}

    /**
    * Amount of speech synthesis performed.
    */
	public long getSynthesisCount()
	{
		return synthesisCount;
	}

	/**
     * Amount of milliseconds of speech synthesized.
     */
	public long getSynthesisTime()
	{
		return synthesisTime;
	}

	@Override
	public String toString()
	{
		return "EngineInfo [version=" + version + ", maxSessions=" + maxSessions + ", customerName=" + customerName
				+ ", capabilities=" + capabilities + ", currentSessions=" + currentSessions + "]";
	}

	public static enum OperationState
	{

		ONLINE(1),

		OFFLINE(2),

		BLOCKED(3),

		UNKNOWN(4);

		private int value;

		private OperationState( int value )
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}

		public static OperationState from( int value )
		{
			switch (value)
			{
				case 1  : return ONLINE;
				case 2  : return OFFLINE;
				case 3  : return BLOCKED;
				default : return UNKNOWN;
			}
		}

	}

}
