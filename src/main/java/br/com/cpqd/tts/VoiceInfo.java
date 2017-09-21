package br.com.cpqd.tts;

public class VoiceInfo
{

	/**
	 * Unique voice name.
	 */
	private String name;

	/**
	 * Path to the voice file.
	 */
	private String fileName;

	/**
	 * Number of bytes occupied by the voice file.
	 */
	private int fileSize;

	/**
	 * Number of bytes occupied by the voice in memory.
	 */
	private int memorySize;

	/**
	 * Age of the voice. Valid values are defined by @c TTS_VOICE_AGE_ prefixed
	 * macros in @ref GRP_VOICE_INFO.
	 */
	private int age;

	/**
	 * Gender of the voice. Valid values are defined by @c TTS_VOICE_GENDER_
	 * prefixed macros in @ref GRP_VOICE_INFO.
	 */
	private int gender;

	/**
	 * Specifies flags that indicate voice characteristics. Valid flags are
	 * defined by
	 * 
	 * @c TTS_VOICE_FLAG_ prefixed macros in @ref GRP_VOICE_INFO.
	 */
	private int flags;

	/**
	 * Query used by the voice to find it's corresponding synthesis plugin.
	 */
	private String query;

	public String getName()
	{
		return name;
	}

	public String getFileName()
	{
		return fileName;
	}

	public int getFileSize()
	{
		return fileSize;
	}

	public int getMemorySize()
	{
		return memorySize;
	}

	public int getAge()
	{
		return age;
	}

	public int getGender()
	{
		return gender;
	}

	public int getFlags()
	{
		return flags;
	}

	public String getQuery()
	{
		return query;
	}

	@Override
	public String toString()
	{
		return "TTS_VOICE_INFO [name=" + name + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", memorySize=" + memorySize
				+ ", age=" + age + ", gender=" + gender + ", flags=" + flags
				+ ", query=" + query + "]";
	}

}
