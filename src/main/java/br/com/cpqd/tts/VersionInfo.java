package br.com.cpqd.tts;

public class VersionInfo
{

	private int major;

	private int minor;

	private int patch;

	public VersionInfo()
	{
	}

	public int getMajor()
	{
		return major;
	}

	public int getMinor()
	{
		return minor;
	}

	public int getPatch()
	{
		return patch;
	}

	@Override
	public String toString()
	{
		return major + "." + minor + "." + patch;
	}

}
