package br.com.cpqd.tts;

import java.io.IOException;

public class SynthesisEngine
{

	protected LibraryWrapper wrapper;

	public SynthesisEngine(String fileName, String productPath, String logPath)
			throws SynthesisException, IOException
	{
		this(fileName, productPath, logPath, null);
	}

	public SynthesisEngine(String fileName, String productPath, String logPath, Object extra)
			throws SynthesisException, IOException
	{
		wrapper = new LibraryWrapper(fileName);
		wrapper.initialize(productPath, logPath, extra);
	}

	public SynthesisSession createSession(String voiceName)
			throws SynthesisException
	{
		long handle = wrapper.createSession(voiceName);
		return new SynthesisSession(this, handle);
	}

	public void loadVoice(String fileName)
			throws SynthesisException
	{
		wrapper.loadVoice(fileName, 0);
	}

	public void unloadVoice(String name) throws SynthesisException
	{
		wrapper.unloadVoice(name);
	}

	public void loadPlugin (String fileName) throws SynthesisException
	{
		wrapper.loadPlugin(fileName);
	}

	public void unLoadPlugin (String fileName) throws SynthesisException
	{
		wrapper.unloadPlugin(fileName);
	}

	public EngineInfo getEngineInfo() throws SynthesisException
	{
		EngineInfo info = new EngineInfo();
		wrapper.getEngineInfo(info);
		return info;
	}

	public VoiceInfo[] enumerateVoices() throws SynthesisException
	{
		return wrapper.enumerateVoices();
	}

	public EncoderInfo[] enumerateEncoders() throws SynthesisException
	{
		return wrapper.enumerateEncoders();
	}
	
	public void registerTemplate (String name, String content) throws SynthesisException
	{
		wrapper.registerTemplate(name, content);
	}
	
	public void loadTemplate (String fileName) throws SynthesisException
	{
		wrapper.loadTemplate(fileName);
	}
	
	public void unloadTemplate (String fileName) throws SynthesisException
	{
		wrapper.unloadTemplate(fileName);
	}
	
	public void registerInterpretation( String name, String format, InterpretedListener listener, Object data, boolean isNormalized ) throws SynthesisException
	{
		wrapper.registerInterpretation(name, format, listener, data, isNormalized);
	}
	
	public String processMessage (String message, int flags) throws SynthesisException
	{
		return wrapper.processMessage(message, flags);
	}
	
	public void validateSSML (String ssml) throws SynthesisException
	{
		wrapper.validateSSML(ssml);
	}

	public void terminate() throws SynthesisException
	{
		wrapper.terminate();
	}
}
