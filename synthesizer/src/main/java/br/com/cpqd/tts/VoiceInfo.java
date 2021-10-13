package br.com.cpqd.tts;

public class VoiceInfo
{

	enum VoiceAge
	{

		/**
		 * Match with any age. This value can be used while searching for
		 * a voice.
		 */
		ANY,
		
		/**
		 * Age roughly up to 12 years.
		 */
		CHILD,
		
		/**
		 * Age roughly 13 to 19 years.
		 */
		TEENAGER,
		
		/**
		 * @ingroup GRP_VOICE_INFO
		 * @brief Age roughly 20 to 40 years.
		 */
		YOUNG_ADULT,
		
		/**
		 * Age roughly 40 to 60 years.
		 */
		MIDDLE_ADULT,
		
		/**
		 * Age roughly 60 years and up.
		 */
		OLDER_ADULT,
		
		/**
		 * Neutral voice which the age is indeterminate (e.g artificial voice).
		 */
		NEUTRAL
	}
	
	enum VoiceGender
	{
		
		/**
		 * Match with any gender. This value can be used while searching for
		 * a voice.
		 */
		ANY,
		
		/**
		 * Female voice.
		 */
		FEMALE,
		
		/**
		 * Male voice.
		 */
		MALE,
		
		/**
		 * Neutral voice that is neither male or female (e.g. artificial voice).
		 */
		NEUTRAL
	}
	
	private String name;

	private String fileName;

	private int fileSize;

	private int memorySize;

	private int age;

	private int gender;

	private int flags;
	
	private String language;

	protected VoiceInfo()
	{
	}
	
	/**
	 * Returns the voice name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the path to the voice file.
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * Returns the number of bytes occupied by the voice file.
	 */
	public int getFileSize()
	{
		return fileSize;
	}

	/**
	 * Returns the number of bytes occupied by the voice in memory.
	 */
	public int getMemorySize()
	{
		return memorySize;
	}

	/**
	 * Returns the age of the voice.
	 */
	public VoiceAge getAge()
	{
		if (age < 0 || age >= VoiceAge.values().length)
			return VoiceAge.ANY;
		return VoiceAge.values()[age];
	}

	/**
	 * Return the voice gender.
	 */
	public VoiceGender getGender()
	{
		if (gender < 0 || gender >= VoiceGender.values().length)
			return VoiceGender.ANY;
		return VoiceGender.values()[gender];
	}

	/**
	 * Returns flags that indicate voice characteristics.
	 */
	public int getFlags()
	{
		return flags;
	}
	
	/**
	 * Return the voice language.
	 */
	public String getLanguage()
	{
		return language;
	}
	
	

	@Override
	public String toString()
	{
		return "VoiceInfo [name=" + name + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", memorySize=" + memorySize
				+ ", age=" + getAge() + ", gender=" + getGender() + ", flags=" + flags
				+ ", language=" + language + "]";
	}

}
