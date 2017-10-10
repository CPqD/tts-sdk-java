package br.com.cpqd.tts;

import java.io.File;
import java.io.IOException;

/**
 * Provides access to the functions of a CPqD Texto Fala 4.x library.
 */
public class LibraryWrapper
{

	protected LibraryWrapper( String fileName ) throws IOException
	{
		if (fileName == null || fileName.isEmpty())
			throw new IllegalArgumentException("Library file name can not be empty or null");

		File library = new File(fileName);
		System.load( library.getCanonicalPath());
	}

	protected native void initialize( String productPath, String logPath, Object extra ) throws SynthesisException;

	protected native void terminate() throws SynthesisException;

	protected native void loadVoice( String fileName, long flags ) throws SynthesisException;

	protected native void unloadVoice( String voiceName ) throws SynthesisException;

	protected native long createSession( String voiceName ) throws SynthesisException;

	protected native void releaseSession( long handle ) throws SynthesisException;

	protected native void textToSpeech( long handle, String text ) throws SynthesisException;

	protected native void textToSpeechStream( long handle, String text, Object listener, Object object ) throws SynthesisException;

	protected native long getAudioLength( long handle ) throws SynthesisException;

	protected native void getAudioInfo( long handle, int flags, AudioInfo info ) throws SynthesisException;

	protected native byte[] copyAudio( long handle, long offset, long length ) throws SynthesisException;

	protected native void saveAudio( long handle, String fileName ) throws SynthesisException;

	protected native void getEngineInfo( EngineInfo info ) throws SynthesisException;

	protected native void getSessionInfo( long handle, SessionInfo info ) throws SynthesisException;

	protected native void setBooleanParameter( long handle, int option, boolean value ) throws SynthesisException;

	protected native boolean getBooleanParameter( long handle, int option ) throws SynthesisException;

	protected native void setFloatParameter( long handle, int option, float value ) throws SynthesisException;

	protected native float getFloatParameter( long handle, int option ) throws SynthesisException;

	protected native void setStringParameter( long handle, int option, String value ) throws SynthesisException;

	protected native String getStringParameter( long handle, int option ) throws SynthesisException;

	protected native void loadPlugin( String fileName ) throws SynthesisException;

	protected native void unloadPlugin( String fileName ) throws SynthesisException;

	protected native VoiceInfo[] enumerateVoices( ) throws SynthesisException;

	protected native EncoderInfo[] enumerateEncoders( ) throws SynthesisException;

}
