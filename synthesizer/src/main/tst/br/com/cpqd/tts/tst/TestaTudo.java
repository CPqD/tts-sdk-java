package br.com.cpqd.tts.tst;

import java.io.File;
import java.io.IOException;

import br.com.cpqd.tts.AudioInfo;
import br.com.cpqd.tts.EncoderInfo;
import br.com.cpqd.tts.EngineInfo;
import br.com.cpqd.tts.SessionInfo;
import br.com.cpqd.tts.SynthesisEngine;
import br.com.cpqd.tts.SynthesisException;
import br.com.cpqd.tts.SynthesisListener;
import br.com.cpqd.tts.SynthesisSession;
import br.com.cpqd.tts.VoiceInfo;

public class TestaTudo
{
	public static void main( String[] args ) throws SynthesisException, IOException
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java -jar libcpqdtts-4.1.0.jar <product path>");
			return;
		}

		boolean isWindows = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;

		String libraryPath = args[0] + File.separator + "libcpqdtts.";
		if (isWindows)
			libraryPath += "dll";
		else
			libraryPath += "so";

		// initialize the CPqD TTS engine
		SynthesisEngine engine = new SynthesisEngine(libraryPath, args[0], null);

		// print some engine information
		EngineInfo engineInfo = engine.getEngineInfo();
		System.out.println("CPqD Texto Fala " + engineInfo.getVersion());
		System.out.println("Max sessions: " + engineInfo.getMaxSessions());
		System.out.println("    Customer: " + engineInfo.getCustomerName());
		System.out.println();
		
		// load plugin
		boolean loadPlugin = false;
		String pluginPath = args[0] + File.separator + "libusel.";
		if (isWindows)
			pluginPath += "dll";
		else
			pluginPath += "so";
		try
		{
			engine.loadPlugin(pluginPath);
			loadPlugin = true;
			
			//if you could load the plugin, load a voice
			engine.loadVoice("rosana-highquality.voice");
		} 
		catch (SynthesisException e) 
		{
			System.out.println("Error load plugin: " + e);
		}
		
		// create a synthesis session using the default voice
		SynthesisSession session = engine.createSession(null);
		// make sure we're using "wav/16000/16/1" encoder (Waveform 16kHz 16bps mono)
		session.setEncoderName("wav/16000/16/1");
		
		// synthesize the example text
		System.out.print("Synthesizing text...");
		session.textToSpeech("teste normal");
		session.saveAudio("teste1.wav");
		System.out.println("done!");
		
		// show some information about the generated audio
		AudioInfo audioInfo = session.getAudioInfo();
		System.out.println();
		System.out.println( "    Sample rate: " + audioInfo.getSampleRate());
		System.out.println( "Bits per sample: " + audioInfo.getBitsPerSample());
		System.out.println( "       Channels: " + audioInfo.getChannels());
		System.out.println( " Audio duration: " + audioInfo.getDuration() + " ms");
		System.out.println( "    Data length: " + audioInfo.getLength() + " bytes");

		// load voice		
		System.out.print("Load voice...");
		engine.loadVoice("carlos-highquality.voice");
		session.setVoiceName("carlos-highquality.voice");
		session.textToSpeech("teste com o Carlos");
		session.saveAudio("teste2.wav");
		System.out.println("done!");
		System.out.println();
		
		// unload voice
		System.out.print("Unload voice...");
		engine.unloadVoice("carlos-highquality.voice");
		session.setVoiceName("rosana-highquality.voice");
		session.textToSpeech("teste com a Rosana");
		session.saveAudio("teste3.wav");
		System.out.println("done!");
		System.out.println();
		
		// get audio
		System.out.print("Get audio...");
		byte audio[] = session.getAudio();
		System.out.println("Tamanho do ultimo audio: " + audio.length);
		System.out.println();
		
		// session info
		System.out.print("Session info...");
		SessionInfo sessionInfo = session.getSessionInfo();
		System.out.println("         Nome da voz: " + sessionInfo.getVoiceName());
		System.out.println(" Contador da sintese: " + sessionInfo.getSynthesisCount());
		System.out.println("    Tempo de sintese: " + sessionInfo.getSynthesisTime());
		System.out.println("    Silencio inicial: " + session.getBeginSilence());
		System.out.println("              Volume: " + session.getVolume());
		System.out.println("               Pitch: " + session.getPitch());
		System.out.println("                Rate: " + session.getRate());
		session.setVolume(2F);
		System.out.println("     Volume alterado: " + session.getVolume());
		System.out.println();
		
		// voices info
		System.out.print("Enumerate voices ...");
		VoiceInfo[] voiceInfoList = engine.enumerateVoices();
		for (VoiceInfo v: voiceInfoList) {
			System.out.println(" Arquivo da voz: " + v.getFileName());
			System.out.println("    Nome da voz: " + v.getName());
			System.out.println("  Genero da voz: " + v.getGender());
			System.out.println("   Idade da voz: " + v.getAge());
			System.out.println(" Tamanho da voz: " + v.getFileSize());
			System.out.println();
		}

		// encoders info
		System.out.print("Enumerate encoders ...");
		EncoderInfo[] enconderInfoList = engine.enumerateEncoders();
		for (EncoderInfo e: enconderInfoList) {
			System.out.println("     Codec: " + e.getCodec());
			System.out.println(" Descrição: " + e.getDescription());
			System.out.println("      Nome: " + e.getName());
			System.out.println("     Canal: " + e.getChannels());
			System.out.println("  Amostras: " + e.getSampleRate());
			System.out.println();
		}
		
		// streaming synthesize
		System.out.println();
		System.out.println("Synthesizing text...");
		MyListener listener = new MyListener();
		session.textToSpeechStream("teste de streaming", listener, null);
		session.saveAudio("teste4.wav");
		System.out.println("done!");
		
		// unload plugin
		if (loadPlugin)
		{
			System.out.println();
			System.out.println("Unload plugin...");
			engine.unLoadPlugin(pluginPath);
			System.out.println("done!");
			System.out.println();
		}
		
		// always release the session when it was no longer necessary
		System.out.println();
		System.out.println("Release session...");
		session.release();
		System.out.println("done!");
	}
	
	
	public static class MyListener implements SynthesisListener
	{

		private long total = 0;

		@Override
		public boolean receivedAudio(byte[] buffer, Order order, Object object)
		{
			if (order == Order.FIRST)
				System.out.println("First call!");
			else
				if (order == Order.LAST)
					System.out.println("Last call!");

			if (buffer.length > 0)
			{
				total += buffer.length;
				System.out.println("Received: " + buffer.length + " bytes");
				System.out.println("   Total: " + total + " bytes");
				System.out.println();
			}

			// Note: we're discarding the audio here!

			// return 'true' to keep synthesizing or 'false' to abort
			return true;
		}

	}

}
