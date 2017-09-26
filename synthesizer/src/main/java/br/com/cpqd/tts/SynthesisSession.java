package br.com.cpqd.tts;



public class SynthesisSession
{
	
	/**
	 * @brief Name of the audio encoder in use by session.
	 *
	 * This parameter expects an @b string value.
	 */
	private static final int TTS_PARAM_ENCODER = 0x01;
	
	/**
	 * @brief Volume of the shynthesized speech.
	 *
	 * This parameter should be an @b integer value from 1 to 100. The default value is 50.
	 */
	private static final int TTS_PARAM_VOLUME = 0x04;
	
	/**
	 * @brief Rate of the shynthesized speech.
	 *
	 * This parameter should be an @b integer value from 1 to 100 (linear scale). The default value is 50.
	 */
	private static final int TTS_PARAM_RATE = 0x05;
	
	/**
	 * @brief Amount of silence at the begin of synthesized speech.
	 *
	 * This parameter should be a positive @b integer value in miliseconds.
	 */
	private static final int TTS_PARAM_BEGIN_SILENCE = 0x07;
	
	/**
	 * @brief Amount of silence at the end of synthesized speech.
	 *
	 * This parameter should be a positive @b integer value in miliseconds.
	 */
	private static final int TTS_PARAM_END_SILENCE = 0x08;
	
	/**
	 * @brief Name of the default voice.
	 *
	 * This parameter expects an @b string value. Valid values depends on the loaded voices.
	 */
	private static final int TTS_PARAM_VOICE = 0x0B;
	
	/**
	 * @brief Pitch of the synthesized speech.
	 *
	 * This parameter should be an @b integer value from 1 to 100 (linear scale). The default value is 50.
	 */
	private static final int TTS_PARAM_PITCH = 0x0C;
		
	/**
	 * @brief Define the text is in SSML format.
	 *
	 * This parameter should be the @b interger value '1' (is true) or '0' (is false). The default value is 0.
	 */
	private static final int TTS_PARAM_SSML_TEXT = 0x0D;
		
	long handle;

	SynthesisEngine engine;

	protected SynthesisSession( SynthesisEngine engine, long handle )
	{
		this.handle = handle;
		this.engine = engine;
	}

	protected void validate() throws SynthesisException
	{
		if (handle <= 0) throw new SynthesisException(0, "Invalid session");
	}
	
	public long getHandle()
	{
		return handle;
	}

	public void setRate( float value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setFloatParameter(handle, TTS_PARAM_RATE, value);
	}

	public float getRate() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getFloatParameter(handle, TTS_PARAM_RATE);
	}

	public void setVolume( float value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setFloatParameter(handle, TTS_PARAM_VOLUME, value);
	}

	public float getVolume() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getFloatParameter(handle, TTS_PARAM_VOLUME);
	}
	
	public void setPitch( float value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setFloatParameter(handle, TTS_PARAM_PITCH, value);
	}

	public float getPitch() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getFloatParameter(handle, TTS_PARAM_PITCH);
	}
	
	public String getEncoderName() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getStringParameter(handle, TTS_PARAM_ENCODER);
	}
	
	
	public void setEnableSSML (boolean value) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setBooleanParameter(handle, TTS_PARAM_SSML_TEXT, value);
	}
	
	public boolean getEnableSSML() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getBooleanParameter(handle, TTS_PARAM_SSML_TEXT);
	}
		
	public void setEncoderName( String value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setStringParameter(handle, TTS_PARAM_ENCODER, value);
	}

	public void textToSpeech( String text ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.textToSpeech(handle, text);
	}

	public void textToSpeechStream( String text, SynthesisListener listener, Object object ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.textToSpeechStream(handle, text, listener, object);
	}
	
	/**
	 * @brief Returns a copy of the audio buffer.
	 * 
	 * @return
	 * @throws SpeechSynthesisException
	 */
	public byte[] getAudio() throws SynthesisException
	{
		validate();
		
		long length = engine.wrapper.getAudioLength(handle);
		return engine.wrapper.copyAudio(handle, 0, length);
	}

	public byte[] getAudio( int offset, int length) throws SynthesisException
	{
		validate();
		
		return engine.wrapper.copyAudio(handle, offset, length);
	}
	
	public void saveAudio( String fileName ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.saveAudio(handle, fileName);
	}
	
	public AudioInfo getAudioInfo() 
			throws SynthesisException
	{
		validate();
		
		AudioInfo info = new AudioInfo();
		engine.wrapper.getAudioInfo(handle, 0, info);
		return info;
	}
		
	public void release() throws SynthesisException
	{
		validate();
		
		engine.wrapper.releaseSession(handle);
		handle = -1;
	}
	
	public SessionInfo getSessionInfo() 
			throws SynthesisException
	{
		validate();

		return engine.wrapper.getSessionInfo(handle);
	}
	
	public String getVoiceName() throws SynthesisException
	{
		validate();
		
		return engine.wrapper.getStringParameter(handle, TTS_PARAM_VOICE);
	}

	public void setVoiceName( String value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setStringParameter(handle, TTS_PARAM_VOICE, value);
	}
	
	public long getBeginSilence() throws SynthesisException
	{
		validate();
		
		return (long) engine.wrapper.getFloatParameter(handle, TTS_PARAM_BEGIN_SILENCE);
	}
	
	public void setBeginSilence( long value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setFloatParameter(handle, TTS_PARAM_BEGIN_SILENCE, (float) value);
	}

	public long getEndSilence() throws SynthesisException
	{
		validate();
		
		return (long) engine.wrapper.getFloatParameter(handle, TTS_PARAM_END_SILENCE);
	}
	
	public void setEndSilence( long value ) throws SynthesisException
	{
		validate();
		
		engine.wrapper.setFloatParameter(handle, TTS_PARAM_END_SILENCE, (float) value);
	}
	
}
